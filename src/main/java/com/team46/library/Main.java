package com.team46.library;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        initializeLibrary(library); // Add initial books
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            displayMenu();
            int choice = getChoice(scanner);
            
            switch (choice) {
                case 1:
                    addBook(library, scanner);
                    break;
                case 2:
                    displayAllBooks(library);
                    break;
                case 3:
                    findBooksByAuthor(library, scanner);
                    break;
                case 4:
                    sortBooksByTitle(library);
                    break;
                case 5:
                    findBooksPublishedBefore(library, scanner);
                    break;
                case 6:
                    findBooksByTitleContaining(library, scanner);
                    break;
                case 7:
                    sortBooksByYear(library, true);
                    break;
                case 8:
                    sortBooksByYear(library, false);
                    break;
                case 9:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    
    private static void initializeLibrary(Library library) {
        library.addBook(new Book("Can't hurt me", "David Goggins", 2017));
        library.addBook(new Book("Atomic Habits", "James Clear", 2019));
        library.addBook(new Book("Deep Work", "Cal Newport", 2016));
        library.addBook(new Book("How to Win Friends and Influence People", "Dale Carneige", 1936));
        library.addBook(new Book("The 7 Habits of Highly Effective People", "Stephen R. Covey", 1989));
        library.addBook(new Book("Grit", "Angela Duckworth", 2016));
        library.addBook(new Book("The Power of Now", "Eckhart Tolle", 1997));
        library.addBook(new Book("Mindset", "Carol S. Dweck", 2006));
        library.addBook(new Book("The Subtle Art of Not Giving a F*ck", "Mark Manson", 2016));
        library.addBook(new Book("Thinking, Fast and Slow", "Daniel Kahneman", 2011));
        library.addBook(new Book("The War of Art", "Steven Pressfield", 2002));
        library.addBook(new Book("Make Your Bed", "Admiral William H. McRaven", 2017));
        library.addBook(new Book("Start With Why", "Simon Sinek", 2009));
        library.addBook(new Book("The Obstacle Is the Way", "Ryan Holiday", 2014));
    }
    
    private static void displayMenu() {
        System.out.println("\n===== Library Management System =====");
        System.out.println("1. Add a new book");
        System.out.println("2. Display all books");
        System.out.println("3. Find books by author");
        System.out.println("4. Sort books by title");
        System.out.println("5. Find books published before year");
        System.out.println("6. Find books by title containing text");
        System.out.println("7. Sort books by year (ascending)");
        System.out.println("8. Sort books by year (descending)");
        System.out.println("9. Exit");
        System.out.print("Enter your choice (1-9): ");
    }
    
    private static int getChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number between 1-9");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    private static void addBook(Library library, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter publication year: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid year (number)");
            scanner.next();
        }
        int year = scanner.nextInt();
        
        library.addBook(new Book(title, author, year));
        System.out.println("Book added successfully!");
    }
    
    private static void displayAllBooks(Library library) {
        System.out.println("\n=== All Books in Library ===");
        library.printAllBooks();
    }
    
    private static void findBooksByAuthor(Library library, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter author name to search: ");
        String author = scanner.nextLine();
        
        List<Book> books = library.findBooksByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("No books found by author: " + author);
        } else {
            System.out.println("\n=== Books by " + author + " ===");
            books.forEach(System.out::println);
        }
    }
    
    private static void sortBooksByTitle(Library library) {
        System.out.println("\n=== Books Sorted by Title ===");
        library.sortBooksByTitle().forEach(System.out::println);
    }
    
    private static void findBooksPublishedBefore(Library library, Scanner scanner) {
        System.out.print("Enter year (find books published before this year): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid year (number)");
            scanner.next();
        }
        int year = scanner.nextInt();
        
        List<Book> books = library.findBooksPublishedBefore(year);
        if (books.isEmpty()) {
            System.out.println("No books found published before " + year);
        } else {
            System.out.println("\n=== Books Published Before " + year + " ===");
            books.forEach(System.out::println);
        }
    }
    
    private static void findBooksByTitleContaining(Library library, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter text to search in titles: ");
        String text = scanner.nextLine();
        
        List<Book> books = library.findBooksByTitleContaining(text);
        if (books.isEmpty()) {
            System.out.println("No books found containing: " + text);
        } else {
            System.out.println("\n=== Books Containing '" + text + "' in Title ===");
            books.forEach(System.out::println);
        }
    }
    
    private static void sortBooksByYear(Library library, boolean ascending) {
        if (ascending) {
            System.out.println("\n=== Books Sorted by Year (Ascending) ===");
            library.sortBooksByYear().forEach(System.out::println);
        } else {
            System.out.println("\n=== Books Sorted by Year (Descending) ===");
            library.sortBooksByYearDescending().forEach(System.out::println);
        }
    }
}
