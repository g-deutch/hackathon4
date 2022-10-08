import java.util.LinkedList;

public class Book {
    String title;
    String genre;
    int copiesAvailable;
    boolean isAvailable;
    LinkedList<String> locations;

    public Book(String title, String genre, LinkedList<String> locations) {
        this.title = title;
        this.genre = genre;
        this.locations = locations;
        this.copiesAvailable = locations.size();
        
    }
    boolean isAvailable(){
        return isAvailable;
    }
    int copiesAvailable(){
        return copiesAvailable;
    }
    String getTitle(){
        return title;
    }
    String getGenre(){
        return genre;
    }
    boolean checkout(String location){
        for (int x = 0; x < locations.size(); x++){
            if (location.equals(locations.get(x))){
                copiesAvailable--;
                if(copiesAvailable <= 0){
                    isAvailable = false;
                }
                return true;
            }
        }
        return false;
        
    }
    void checkin(){
        copiesAvailable++;
    }

}

