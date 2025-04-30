package com.team46.library;

import java.util.List;

public interface BookManager {
    void addBook(Book book);
    List<Book> getBooks();
    List<Book> findBooksByAuthor(String author);
    List<Book> sortBooksByTitle();
    
    //Using method reference. 
    default void printAllBooks() {
        getBooks().forEach(System.out::println);
        //getBooks().forEach(book -> System.out.println(book)); this would be using lambda without method reference.
    }
}
