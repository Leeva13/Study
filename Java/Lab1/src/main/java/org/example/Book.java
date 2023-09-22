package org.example;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private final int yearOfPublication;

    public Book(String title, String author, String isbn, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public int getYearOfPublication() {
        return this.yearOfPublication;
    }

}