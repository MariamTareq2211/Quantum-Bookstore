import java.time.LocalDate;

public class EBook extends Book {

    private String FileType;

    public EBook(String isbn , LocalDate publishyear , String title , double price , String author, String fileT){
        super(isbn, publishyear, title, price, author);
        this.FileType = fileT;
    }

    // setter
    public void setFileType(String ft){
        this.FileType = ft;
    }

    // getter
    public String getFileType(){
        return FileType;
    }

}
