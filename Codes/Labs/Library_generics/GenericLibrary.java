import java.util.List;
import java.util.ArrayList;

public class GenericLibrary<E extends Media> {
    private List<E> resources = new ArrayList<E>();
    public void addMedia(E x) {
        resources.add(x);
    }
    public E retrieveLast() {
        int size = resources.size();
        if (size > 0) {
            return resources.get(size - 1);
        }
        return null;
    }
}

abstract class Media {
    private String author;
    private String title;

    public Media(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() { return title; }
    public void setTitle(String title) {
        this.title = title;
    }
}

class Book extends Media {
    public Book(String author, String title) {
        super(author, title);
    }
}

class Video extends Media {
    public Video(String author, String title) {
      super(author, title);
    }
}

class Newspaper extends Media {
    public Newspaper(String author, String title) {
        super(author, title);
    }
}