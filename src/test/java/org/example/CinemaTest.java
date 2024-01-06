package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class CinemaTest {

    public Cinema cinema;
    @BeforeEach
    public void setUp() {
        cinema = new Cinema();
    }

    @Test
    void testBookSeats() {
        int hallNumber = 0;
        int row = 2;
        int[] seatsToBook = {3, 4, 5};

        cinema.bookSeats(hallNumber, row, seatsToBook);

        Assertions.assertEquals(1, cinema.seatingArrangement[hallNumber][row][3]);
        Assertions.assertEquals(1, cinema.seatingArrangement[hallNumber][row][4]);
        Assertions.assertEquals(1, cinema.seatingArrangement[hallNumber][row][5]);
    }

    @Test
    void testCancelBooking() {
        int hallNumber = 0;
        int row =2;
        int[] seatsToBook = {3, 4, 5};

        cinema.bookSeats(hallNumber, row, seatsToBook);
        cinema.cancelBooking(hallNumber, row, seatsToBook);

        Assertions.assertEquals(0, cinema.seatingArrangement[hallNumber][row][3]);
        Assertions.assertEquals(0, cinema.seatingArrangement[hallNumber][row][4]);
        Assertions.assertEquals(0, cinema.seatingArrangement[hallNumber][row][5]);

    }

    @Test
    void testCheckAvailability() {
        int hallNumber = 0;
        int numSeatsToCheck = 3;

        cinema.bookSeats(hallNumber, 0, new int[]{0, 1, 2});
        Assertions.assertTrue(cinema.checkAvailability(hallNumber, numSeatsToCheck));

        cinema.bookSeats(hallNumber, 1, new int[]{5, 6, 7});
        Assertions.assertTrue(cinema.checkAvailability(hallNumber, numSeatsToCheck));
    }

    void testFindBestAvailable() {
        Cinema cinema = new Cinema();
        int hallNumber = 0;
        int numSeatsToFind = 4;

        List<Integer> bestSeats = cinema.findBestAvailable(hallNumber, 4, 8, numSeatsToFind);

        Assertions.assertEquals(numSeatsToFind, bestSeats.size());
        for (int seat : bestSeats) {
            // Переконатися, що вибрані місця спочатку доступні (значення 0)
            Assertions.assertEquals(0, cinema.seatingArrangement[hallNumber][4][seat]);
        }
    }

    void testAutoBook() {
        int hallNumber = 0;
        int numSeatsToAutoBook = 4;

        cinema.autoBook(hallNumber, numSeatsToAutoBook);

        List<Integer> bestSeats = cinema.findBestAvailable(hallNumber, 4, 8, numSeatsToAutoBook);
        Assertions.assertEquals(numSeatsToAutoBook, bestSeats.size());

        for (int seat : bestSeats) {
            // Переконатися, що вибрані місця заброньовано (значення 1)
            Assertions.assertEquals(1, cinema.seatingArrangement[hallNumber][4][seat]);
        }
    }

}