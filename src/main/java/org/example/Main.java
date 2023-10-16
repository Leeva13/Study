package org.example;

import java.util.ArrayList;
import java.util.List;

abstract class Item {
    private final String title;
    private final String uniqueID;
    private boolean isBorrowed;

    public Item(String title, String uniqueID) {
        this.title = title;
        this.uniqueID = uniqueID;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public boolean isBorrowed() {
        return !isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public abstract void borrowItem();

    public abstract void returnItem();
}

class Book extends Item {

    public Book(String title, String uniqueID, String author) {
        super(title, uniqueID);
    }

    @Override
    public void borrowItem() {
        setBorrowed(true);
    }

    @Override
    public void returnItem() {
        setBorrowed(false);
    }
}

class DVD extends Item {

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
    }

    @Override
    public void borrowItem() {
        setBorrowed(true);
    }

    @Override
    public void returnItem() {
        setBorrowed(false);
    }
}

class Patron {
    private final String name;
    private final String ID;
    private final List<Item> borrowedItems;

    public Patron(String name, String ID) {
        this.name = name;
        this.ID = ID;
        borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public List<Item> getBorrowedItems() {
        return borrowedItems;
    }

    public void borrow(Item item) {
        borrowedItems.add(item);
    }

    public void returnItem(Item item) {
        borrowedItems.remove(item);
    }
}

interface IManageable {
    void add(Item item);
    void remove(Item item);
    void listAvailable();
    void listBorrowed();
}

class Library implements IManageable {
    private List<Item> items;
    private final List<Patron> patrons;

    public Library() {
        items = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }

    @Override
    public void listAvailable() {
        System.out.println("Available Items:");
        for (Item item : items) {
            if (item.isBorrowed()) {
                System.out.println(item.getTitle());
            }
        }
    }

    @Override
    public void listBorrowed() {
        System.out.println("Borrowed Items:");
        for (Patron patron : patrons) {
            for (Item item : patron.getBorrowedItems()) {
                System.out.println(patron.getName() + " - " + item.getTitle());
            }
        }
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item) {
        if (item.isBorrowed()) {
            patron.borrow(item);
            item.borrowItem();
        } else {
            System.out.println("Item is already borrowed.");
        }
    }

    public void returnItem(Patron patron, Item item) {
        if (patron.getBorrowedItems().contains(item)) {
            patron.returnItem(item);
            item.returnItem();
        } else {
            System.out.println("Patron did not borrow this item.");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The Great Gatsby", "B001", "F. Scott Fitzgerald");
        Book book2 = new Book("To Kill a Mockingbird", "B002", "Harper Lee");
        DVD dvd1 = new DVD("Inception", "D001", 148);

        library.add(book1);
        library.add(book2);
        library.add(dvd1);

        Patron patron1 = new Patron("Alice", "P001");
        Patron patron2 = new Patron("Bob", "P002");

        library.registerPatron(patron1);
        library.registerPatron(patron2);

        library.lendItem(patron1, book1);
        library.lendItem(patron2, dvd1);

        library.listAvailable();
        library.listBorrowed();
    }
}