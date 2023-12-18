
This Java program simulates a simple library management system. Here's a brief overview:

Item Class (Abstract):

Abstract class representing library items.
Contains common attributes like title, unique ID, and a status indicating whether the item is borrowed.
Subclasses include Book and DVD, each implementing methods to borrow and return items.
Patron Class:

Represents a library patron (person).
Has a name, ID, and a list of borrowed items.
Provides methods to borrow and return items.
IManageable Interface:

Interface defining methods for managing library items, including adding, removing, and listing available or borrowed items.
Library Class:

Implements the IManageable interface.
Manages a list of library items and patrons.
Provides methods to add, remove, and list items, as well as register patrons.
Allows lending and returning items, updating their status accordingly.
Main Class:

Contains the main method to demonstrate the library system.
Creates a Library instance and adds books and a DVD to its collection.
Registers patrons and simulates lending and returning items.
Displays the list of available and borrowed items.
The program showcases a basic interaction between library items, patrons, and the library itself, demonstrating how items can be borrowed, returned, and managed within the system.
