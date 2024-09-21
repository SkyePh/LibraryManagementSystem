import java.util.ArrayList;
import java.util.List;

public class BookManager {

    private List<Book> books;

    //constructor
    public BookManager() {
        books = new ArrayList<>(); //initialize the book list
    }

    //method to add a book
    public void addBook(String title, String author, String publisher, String isbn) {
        books.add(new Book(title, author, publisher, isbn));
        System.out.println("Added Book: " + title);
    }

    //remove book by iisbn
    public boolean removeBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                System.out.println("Removed Book: " + isbn); //debugging
                return true; //book found n removed
            }
        }
        System.out.println("Book Not Found: " + isbn); //debugging
        return false; //book not found
    }

    //search for a book by title
    public List<Book> searchByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundBooks.add(book); //add found books in the new found books array
            }
        }
        if (!foundBooks.isEmpty()) {
            System.out.println("BooksFound");
        }
        else {
            System.out.println("Book Not Found: " + title);
        }
        return foundBooks;
    }

    //search by author
    public List<Book> searchByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        if (!foundBooks.isEmpty()) {
            System.out.println("BooksFound");
        }
        else {
            System.out.println("Book Not Found: " + author);
        }
        return foundBooks;
    }

    //search by publisher
    public List<Book> searchByPublisher(String publisher) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublisher().toLowerCase().contains(publisher.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        if (!foundBooks.isEmpty()) {
            System.out.println("BooksFound");
        }
        else {
            System.out.println("Book Not Found: " + publisher);
        }
        return foundBooks;
    }

    //search by isbn
    public List<Book> searchByIsbn(String isbn) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                foundBooks.add(book);
            }
        }
        if (!foundBooks.isEmpty()) {
            System.out.println("BooksFound");
        }
        else {
            System.out.println("Book Not Found: " + isbn);
        }
        return foundBooks;
    }

    //list all books
    public List<Book> listAllBooks() {
        return books; //return all the books
    }
}
