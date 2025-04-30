package com.team46.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;

    @BeforeEach
    public void setUp() {

        library = new Library();
        

        book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        book2 = new Book("Animal Farm", "George Orwell", 1945);
        book3 = new Book("Dune", "Frank Herbert", 1965);
        book4 = new Book("Brave New World", "Aldous Huxley", 1932);
        
        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
    }

    @Test
    public void testAddBook() {
        Library testLibrary = new Library();
        Book newBook = new Book("Test Book", "Test Author", 2000);
        
        testLibrary.addBook(newBook);
        
        // Check if the book was added
        List<Book> books = testLibrary.getBooks();
        assertEquals(1, books.size());
        assertEquals(newBook, books.get(0));
    }

    @Test
    public void testGetBooks() {
        List<Book> books = library.getBooks();
        
        // Check if we get all books
        assertEquals(4, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
        assertTrue(books.contains(book3));
        assertTrue(books.contains(book4));
        
        books.add(new Book("New Book", "New Author", 2022));
        assertEquals(4, library.getBooks().size()); // Original list should remain unchanged
    }

    @Test
    public void testFindBooksByAuthor() {
        Book anotherTolkienBook = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        library.addBook(anotherTolkienBook);
        
        // Find books by Tolkien
        List<Book> tolkienBooks = library.findBooksByAuthor("J.R.R. Tolkien");
        
        // Check if we get two books from Tolkien
        assertEquals(2, tolkienBooks.size());
        assertTrue(tolkienBooks.contains(book1));
        assertTrue(tolkienBooks.contains(anotherTolkienBook));
        
        // Test the "ignoreCase" functionality
        List<Book> orwellBooks = library.findBooksByAuthor("george ORWELL");
        assertEquals(1, orwellBooks.size());
        assertTrue(orwellBooks.contains(book2));
    }

    @Test
    public void testSortBooksByTitle() {
        List<Book> sortedBooks = library.sortBooksByTitle();
        
        // Check if the order is correct
        assertEquals(4, sortedBooks.size());
        assertEquals(book2, sortedBooks.get(0)); 
        assertEquals(book4, sortedBooks.get(1)); 
        assertEquals(book3, sortedBooks.get(2)); 
        assertEquals(book1, sortedBooks.get(3));
    }

    @Test
    public void testSortBooksByYear() {
        // Get books sorted by year
        List<Book> sortedBooks = library.sortBooksByYear();
        
        // Check if the order is correct
        assertEquals(4, sortedBooks.size());
        assertEquals(book4, sortedBooks.get(0)); 
        assertEquals(book1, sortedBooks.get(1)); 
        assertEquals(book2, sortedBooks.get(2)); 
        assertEquals(book3, sortedBooks.get(3));
    }

    @Test
    public void testSortBooksByYearDescending() {
        // Get books sorted by year descending
        List<Book> sortedBooks = library.sortBooksByYearDescending();
        
        // Check if the order is correct
        assertEquals(4, sortedBooks.size());
        assertEquals(book3, sortedBooks.get(0)); 
        assertEquals(book2, sortedBooks.get(1)); 
        assertEquals(book1, sortedBooks.get(2)); 
        assertEquals(book4, sortedBooks.get(3));
    }

    @Test
    public void testFindBooksPublishedBefore() {
        // Find books published before 1940
        List<Book> oldBooks = library.findBooksPublishedBefore(1940);
        
        assertEquals(2, oldBooks.size());
        assertTrue(oldBooks.contains(book1)); // from 1937
        assertTrue(oldBooks.contains(book4)); // from 1932
        
        // Test with a year that should not return a any book
        List<Book> noBooks = library.findBooksPublishedBefore(1930);
        assertTrue(noBooks.isEmpty());
        
        // Test with a year that should return all books
        List<Book> allBooks = library.findBooksPublishedBefore(2000);
        assertEquals(4, allBooks.size());
    }

    @Test
    public void testFindBooksByTitleContaining() {
        // Find books with "The" in the title
        List<Book> theBooks = library.findBooksByTitleContaining("The");
        
        assertEquals(1, theBooks.size());
        assertTrue(theBooks.contains(book1)); // Book1 = book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        
        // Test the "loweCase" functionality
        List<Book> worldBooks = library.findBooksByTitleContaining("woRLd");
        assertEquals(1, worldBooks.size());
        assertTrue(worldBooks.contains(book4)); // Brave New World
        
        // Test with a substring that doesnot exist
        List<Book> noBooks = library.findBooksByTitleContaining("xyz");
        assertTrue(noBooks.isEmpty());
    }
}
