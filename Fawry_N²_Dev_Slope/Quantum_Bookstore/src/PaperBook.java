import java.time.LocalDate;

public class PaperBook extends Book {

    private long Quantity;

    public PaperBook(String isbn , LocalDate publishyear , String title , double price , String author , long quantity){
        super(isbn, publishyear, title, price, author);
        this.Quantity = quantity;
    }

    // setter
    public void setQuantity(long q){
        this.Quantity = q;
    }

    // getter
    public long getQuantity(){
        return Quantity;
    }
     
    public void reduceQuantity(long quant){
        this.Quantity -= quant;
    }

}
