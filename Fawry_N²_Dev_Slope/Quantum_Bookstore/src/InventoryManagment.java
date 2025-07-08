import java.time.LocalDate;
import java.util.*;

public class InventoryManagment {
    
    private Map<String,Book> inventory;

    public InventoryManagment(){
       inventory = new HashMap<>();
    }

    public Map<String, Book> getInventory() {
        return inventory;
    }

    public void addBook(String isbn , LocalDate publishyear , String title , double price , String author , String BookType , Integer quan , String fileT){
        
        Book newbook = null;

        switch(BookType.toLowerCase()){
            case "paper":
                if(quan == 0){
                    System.out.println("Quantity required for paper book");
                    return;
                }
                newbook = new PaperBook(isbn, publishyear, title, price, author, quan);
                break;
            case "ebook":
                if(fileT == null){
                    System.out.println("File Type required for EBook");
                    return;
                }
                newbook = new EBook(isbn, publishyear, title, price, author, fileT);
                break;
            case "showcase":
                newbook = new DemoBook(isbn, publishyear, title, price, author);
                break; 
            case "democase":
                newbook = new DemoBook(isbn, publishyear, title, price, author);
                break; 
            default:
            System.out.println("Unknown book type");
            return;   
        }

        inventory.put(isbn,newbook);
        System.out.println(newbook.getTitle() + " added succesfully\n");
        return;
    }

    public Map<String,Book> removeOutdatedBooks(int years){
        Map<String,Book> OutdatedBooks = new HashMap<>();
        int currentyear = LocalDate.now().getYear();

        Iterator<Map.Entry<String,Book>> iterator = inventory.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String,Book> entry = iterator.next();
            Book book = entry.getValue();
            int bookYear = book.getPublishYear().getYear();

            if(currentyear - bookYear > years){
                OutdatedBooks.put(book.getISBN(),book);
                iterator.remove();
                System.out.println("Removed outdated book - " + book.getTitle());
            }
        }
        return OutdatedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        Book book = inventory.get(isbn);

        if(book == null){
            throw new Exception("book with ISBN " + isbn + " not found.");
        }

        if(book instanceof DemoBook){
            throw new Exception("book with ISBN " + isbn + " not for sale.");
        }

        double totalprice = book.getPrice() * quantity;

        if( book instanceof PaperBook){
            PaperBook paperbook = (PaperBook) book;

            if(quantity > paperbook.getQuantity()){
                throw new Exception("Not enough stock for \"" + paperbook.getTitle() + "\".");
            }

            paperbook.reduceQuantity(quantity);
            System.out.println("Shipping \"" + paperbook.getTitle() + "\" x" + quantity + " to address: " + address);
        }else if (book instanceof EBook) {
          EBook ebook = (EBook) book;

         System.out.println("Sending eBook \"" + ebook.getTitle() + "\" to email: " + email); 
        }

        System.out.println("Customer paid $" + totalprice + " for \"" + book.getTitle() + "\"");
        return totalprice;
    }

}
