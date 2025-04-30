package com.team46.library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library implements BookManager {
    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> sortBooksByTitle() {
        return books.stream()
                .sorted((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()))
                .collect(Collectors.toList());
    }
    
    public List<Book> sortBooksByYear() {
        return books.stream()
                .sorted((b1, b2) -> b1.getYear() - b2.getYear()) // -1(b1 first),0,1(b2 first)
                .collect(Collectors.toList());
    }
    
    public List<Book> sortBooksByYearDescending() {
        return books.stream()
                .sorted((b1, b2) -> b2.getYear() - b1.getYear())
                .collect(Collectors.toList());
    }
    
    public List<Book> findBooksPublishedBefore(int year) {
        return books.stream()
                .filter(book -> book.getYear() < year)
                .collect(Collectors.toList());
    }
    
    public List<Book> findBooksByTitleContaining(String substring) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(substring.toLowerCase()))
                .collect(Collectors.toList());
    }
}