import java.util.LinkedList;


public class Book {
    String title;
    String href;
    String img;
    String genre;
    int copiesAvailable;
    LinkedList<String> locations;

    public Book(String title, String genre, LinkedList<String> locations) {
        this.title = title;
        this.href = title.replaceAll(" ", "");
        this.img = title.replaceAll(" ", "_");
        this.genre = genre;
        this.locations = locations;
        this.copiesAvailable = locations.size();
    }

    boolean isAvailable() {
        return copiesAvailable > 0;
    }

    int copiesAvailable() {
        return copiesAvailable;
    }

    String getTitle() {
        return title;
    }

    String getGenre() {
        return genre;
    }

    boolean checkout(String location){
        for (int x = 0; x < locations.size(); x++){
            if (location.equals(locations.get(x))){
                copiesAvailable--;
                return true;
            }
        }
        return false;
        
    }
    void checkin(String location){
        copiesAvailable++;
        locations.add(location);
    }

}

