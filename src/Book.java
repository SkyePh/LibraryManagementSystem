public class Book {

    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String publisher, String isbn) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.isAvailable = true; //its available initially
    }

    //getters and setters
    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void isAvailable(boolean available) {
        isAvailable = available;
    }
}
