package org.example;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        int hallNumber = 0;
        int row = 2;
        int[] seatsToBook = {3, 4, 5};

        cinema.bookSeats(hallNumber, row, seatsToBook);
        cinema.printSeatingArrangement(hallNumber);

        cinema.cancelBooking(hallNumber, row, seatsToBook);
        cinema.printSeatingArrangement(hallNumber);

        int numSeatsToCheck = 3;
        if (cinema.checkAvailability(hallNumber, numSeatsToCheck)) {
            System.out.println("Доступні " + numSeatsToCheck + " послідовних місць.");
        } else {
            System.out.println("Недостатньо вільних місць для " + numSeatsToCheck + " послідовних місць.");
        }

        // Приклад використання методу autoBook
        int numSeatsToAutoBook = 4;

        cinema.autoBook(hallNumber, numSeatsToAutoBook);
        cinema.printSeatingArrangement(hallNumber);
    }
}