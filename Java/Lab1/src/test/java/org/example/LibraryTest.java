package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LibraryTest {

    @Test
    public void addBook() {
        Library library = new Library();
        Book book = new Book("Title", "Author", "1234567890", 2023);

        library.addBook(book);

        Assert.assertTrue(library.getBooks().contains(book));
    }

    @Test
    public void searchByTitle() {
        Library library = new Library();
        Book book1 = new Book("Title", "Author1", "1234567890", 2023);
        Book book2 = new Book("Title", "Author2", "0987654321", 2022);

        library.addBook(book1);
        library.addBook(book2);

        List<Book> result = library.searchByTitle("Title");

        Assert.assertEquals(2, result.size());
    }

    @Test
    public void removeBookByISBN() {
        Library library = new Library();
        Book book1 = new Book("Title1", "Author1", "1234567890", 2023);
        Book book2 = new Book("Title2", "Author2", "0987654321", 2022);

        library.addBook(book1);
        library.addBook(book2);

        library.removeBookByISBN("1234567890");

       Assert.assertFalse(library.getBooks().contains(book1));
    }
}