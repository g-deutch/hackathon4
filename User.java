import java.util.LinkedList;

public class User {
    String name;
    String location;
    LinkedList<Book> booksCheckedOut = new LinkedList<Book>();
    public User(String name, String location){
        this.name = name;
        this.location = location;
    }
    String getName(){
        return name;
    }
    String getLocation(){
        return location;
    }
    LinkedList<Book> getBooks(){
        return booksCheckedOut;
    }
    void checkoutBook(Book book){
        booksCheckedOut.add(book);
    }
    Boolean booksOut(){ 
        return (!(booksCheckedOut.size() == 0));
    }
    void returnBook(Book book){
        booksCheckedOut.remove(book);
    }
    boolean isCheckedOut(Book book){
        return (booksCheckedOut.indexOf(book) != -1);
    }

}
