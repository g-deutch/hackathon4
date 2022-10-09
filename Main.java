import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<Book> books = new LinkedList<Book>();
        // columbus, cincinnati, cleavland
        books.add(new Book("A Tale of Two Cities", "Historical Fiction", new LinkedList<String>(Arrays.asList("Cincinnati", "Cincinnati", "Cincinnati", "Columbus", "Cleveland"))));
        books.add(new Book("The Hobbit", "Fantasy", new LinkedList<String>(Arrays.asList())));
        books.add(new Book("The Da Vinci Code", "Mystery Thriller", new LinkedList<String>(Arrays.asList("Columbus", "Columbus", "Columbus", "Colombus"))));
        books.add(new Book("The Catcher in the Rye", "Coming-of-age", new LinkedList<String>(Arrays.asList("Cleveland", "Cleveland", "Cleveland", "Cleveland", "Cleveland"))));
        books.add(new Book("Anne of Green Gables", "Children's Novel", new LinkedList<String>(Arrays.asList( "Columbus", "Cleveland", "Cleveland"))));
        books.add(new Book("Charlotte's Web", "Children's Novel", new LinkedList<String>(Arrays.asList("Cincinnati", "Cincinnati"))));
        books.add(new Book("The Very Hungry Caterpillar", "Children's Novel", new LinkedList<String>(Arrays.asList("Cincinnati", "Columbus"))));
        books.add(new Book("To Kill a Mockingbird", "Historical Fiction", new LinkedList<String>(Arrays.asList("Columbus", "Columbus", "Cincinnati", "Cleveland", "Cincinnati"))));
        makeIndexPage(books);
    }

    public static void makeIndexPage(LinkedList<Book> books) throws FileNotFoundException {
        File test = new File("pages/index.html");
        PrintWriter out = new PrintWriter(test);
            for(int i = 0; i < books.size(); i++) {
                printBook(books.get(i), out);
                bookPages(books.get(i));
                checkoutBook(books.get(i));
            }
        out.close();
    }

    public static void checkoutBook(Book book) throws FileNotFoundException{
        PrintWriter out = new PrintWriter(new File("pages/checkout" + book.href + ".html"));
        out.println("<h1>Checkout</h1>");
        out.println("<p>" + book.title + "</p>");
        out.println("<button alert(`Checkedout`) </button>");
        out.close();
    }

    public static void bookPages(Book book) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("pages/" + book.href + ".html"));
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel=\"stylesheet\" href=\"style.css\">");
        out.println("</head>");
        out.println("<h1>" + book.title + "</h1>");
        out.println("<img id = \"book_images\"src=\"../Images/" + book.img + ".jpg\"></img>");

        if(!book.isAvailable()) {
            out.println("<p id=\"notAvailable\"> not available </p>");
        } else {
            out.println("<p id=\"isAvailable\"> available </p>");
            out.println("<button onClick=\"location.href=\'checkout"+ book.href +".html\';\"> Checkout </button>");
        }

        out.println("<ul>");
        for(int i = 0; i < book.locations.size(); i++) {
            out.println("<li>" + book.locations.get(i) + "</li>");
        }
        out.println("</ul>");
        out.println("</html>");
        out.close();
    }

    public static void printBook(Book book, PrintWriter out) {
        out.println("<h1><a href=\"" + book.href + ".html\">" + book.title + "</a></h1>");
    }
}