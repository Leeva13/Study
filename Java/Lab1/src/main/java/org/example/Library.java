package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Library {
    private final List<Book> books;

    public Library () {
        this.books = new ArrayList<>();
    }

    public void addBook (Book book) {
        books.add(book);
    }

    public Collection<Object> getBooks() {
        return Collections.singleton(books);
    }

    public void displayBook () {
        for (Book book : books) {
            System.out.println("Назва: " + book.getTitle());
            System.out.println("Автор: " + book.getAuthor());
            System.out.println("ISNB: " + book.getIsbn());
            System.out.println("Рік видачі: " + book.getYearOfPublication() + "\n");
        }
    }

    public List<Book> searchByTitle (String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }
    public void removeBookByISBN (String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

}
