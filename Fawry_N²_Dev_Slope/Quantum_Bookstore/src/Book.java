import java.time.*;
public class Book {
    private String ISBN;
    private LocalDate PublishYear;
    private String Title;
    private double Price;
    private String Author;

    public Book(String isbn , LocalDate publishyear , String title , double price , String author){
        this.ISBN = isbn;
        this.PublishYear = publishyear;
        this.Title = title;
        this.Price = price;
        this.Author = author;
    }

    // setters

    public void setISBN(String isbn){
        this.ISBN = isbn;
    }
    public void setPublishYear(LocalDate pubyear){
        this.PublishYear = pubyear;
    }
    public void setTitle(String title){
        this.Title = title;
    }
    public void setPrice(double price){
        this.Price = price;
    }
    public void setAuthor(String author){
        this.Author = author;
    }

    // getters

    public String getISBN(){
        return ISBN;
    }
    public String getTitle(){
        return Title;
    }
    public LocalDate getPublishYear(){
        return PublishYear;
    }
    public double getPrice(){
        return Price;
    }
    public String getAuthor(){
        return Author;
    }

    
}
