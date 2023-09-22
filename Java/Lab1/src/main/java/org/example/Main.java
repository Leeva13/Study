package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("1984", "George Orwell", "978-0451524935", 1950);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0446310789", 1960);
        Book book3 = new Book("Pride and Prejudice", "Jane Austen", "978-1503290563", 1813);
        Book book4 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565", 1925);
        Book book5 = new Book("Moby Dick", "Herman Melville", "978-1503286404", 1851);

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        // Виведення всіх книг у бібліотеці
        System.out.println("Усі книги в бібліотеці:\n");
        library.displayBook();


        // Пошук книг за назвою
        String searchTitle = book2.getTitle();
        System.out.println("\nПошук книги за назвою '" + searchTitle + "':");
        List<Book> searchResult = library.searchByTitle(searchTitle);
        for (Book book : searchResult) {
            System.out.println("\nНазва: " + book.getTitle() + "\nАвтор: " + book.getAuthor() +
                    "\nISBN: " + book.getIsbn() + "\nРік видачі: " + book.getYearOfPublication() + "\n");
        }
        // Видалення книги за номером ISBN
        String isbnToDelete = book4.getIsbn();
        System.out.println("\nВидалення книги з ISBN '" + isbnToDelete + "':");
        library.removeBookByISBN(isbnToDelete);

        // Виведення оновленого списку книг
        System.out.println("\nСписок книг після видалення:");
        library.displayBook();



    }
}