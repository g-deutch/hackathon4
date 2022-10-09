import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<Book> books = new LinkedList<Book>();
        // columbus, cincinnati, cleveland
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
        File index = new File("pages/index.html");
        PrintWriter out = new PrintWriter(index);
        out.println("<body style=\"background-color:powderblue\">");
        out.println("<img src=\"../Images/syntax_terror.png\"style=\"width:64px;height:64px\"></img>");

        out.println("<div style=\"border:5px solid cornflowerblue; background-color:darkturquoise\">");
            for(int i = 0; i < books.size(); i++) {
                printBook(books.get(i), out);
                bookPages(books.get(i));
                checkoutBook(books.get(i));
            }
            out.println("</div>");
            orderBook();
        out.close();
    }

    public static void checkoutBook(Book book) throws FileNotFoundException{
        PrintWriter out = new PrintWriter(new File("pages/checkout" + book.href + ".html"));
        out.println("<body style=\"background-color:powderblue\">");
        out.println("<img src=\"../Images/syntax_terror.png\"style=\"width:64px;height:64px\"></img>");
        out.println("<h1>Checkout</h1>");
        out.println("<p>" + book.title + "</p>");
        out.println("<button onClick=\"location.href=\'orderComplete.html\';\">Check Out</button>");
        out.close();
    }

    public static void bookPages(Book book) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("pages/" + book.href + ".html"));
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel=\"stylesheet\" href=\"style.css\">");
        out.println("</head>");
        out.println("<body style=\"background-color:powderblue\">");
        out.println("<img src=\"../Images/syntax_terror.png\"style=\"width:64px;height:64px\"></img>");
        out.println("<h1>" + book.title + "</h1>");
        out.println("<img id = \"book_images\"src=\"../Images/" + book.img + ".jpg\"></img>");


        if(!book.isAvailable()) {
            out.println("<p id=\"notAvailable\"> not available </p>");
        } else {
            out.println("<p id=\"isAvailable\"> available </p>");
            out.println("<button onClick=\"location.href=\'checkout"+ book.href +".html\';\"> Checkout </button>");
        }
        out.println("<button onClick=\"location.href=\'index.html\';\"> Return </button>");

        out.println("<h2>Locations:</h2>");
        out.println("<ul>");
        out.println("<li> Books In Cincinnati: " + book.booksAtLocation("Cincinnati") + "</li>");
        out.println("<li> Books in Cleveland: " + book.booksAtLocation("Cleveland") + "</li>");
        out.println("<li> Books in Columbus: " + book.booksAtLocation("Columbus") + "</li>");
        out.println("</ul>");
        out.println("</html>");
        out.close();
    }

    public static void printBook(Book book, PrintWriter out) {
        out.println("<h1><a href=\"" + book.href + ".html\">" + book.title + "</a></h1>");
    }

    public static void orderBook() throws FileNotFoundException{
        PrintWriter out = new PrintWriter(new File("pages/orderComplete.html"));
        out.println("<body style=\"background-color:powderblue\">");
        out.println("<img src=\"../Images/syntax_terror.png\"style=\"width:64px;height:64px\"></img>");
        out.println("<h1>Thank you!</h1>");
        out.print("<p>Your order has been submitted, and a delivery truck will be here soon to send you the book. Shipping may take up to 2-3 business days, </p>");
        out.println("<button onClick=\"location.href=\'index.html\';\">Start Over</button>");
        out.close();
    }
}