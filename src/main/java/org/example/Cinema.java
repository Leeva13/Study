package org.example;


import java.util.ArrayList;
import java.util.List;

public class Cinema {

    // Розмір кінозалу
    private static final int NUM_HALLS = 5;
    private static final int NUM_ROWS = 10;
    private static final int NUM_SEATS_PER_ROW = 20;

    // 3D масив для представлення кінотеатру
    final int[][][] seatingArrangement;

    // Конструктор для ініціалізації кінотеатру
    public Cinema() {
        this.seatingArrangement = new int[NUM_HALLS][NUM_ROWS][NUM_SEATS_PER_ROW];
        initializeSeatingArrangement();
    }

    // Ініціалізація масиву нулями (всі місця вільні)
    private void initializeSeatingArrangement() {
        for (int hall = 0; hall < NUM_HALLS; hall++) {
            for (int row = 0; row < NUM_ROWS; row++) {
                for (int seat = 0; seat < NUM_SEATS_PER_ROW; seat++) {
                    seatingArrangement[hall][row][seat] = 0;
                }
            }
        }
    }

    // Бронювання місць
    public void bookSeats(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (seatingArrangement[hallNumber][row][seat] == 1) {
                System.out.println("Місце " + seat + " у ряду " + row + " залу " + hallNumber + " вже заброньоване.");
            } else {
                seatingArrangement[hallNumber][row][seat] = 1;
                System.out.println("Місце " + seat + " у ряду " + row + " залу " + hallNumber + " успішно заброньоване.");
            }
        }
    }

    // Скасування бронювання місць
    public void cancelBooking(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (seatingArrangement[hallNumber][row][seat] == 0) {
                System.out.println("Місце " + seat + " у ряду " + row + " залу " + hallNumber + " вже вільне.");
            } else {
                seatingArrangement[hallNumber][row][seat] = 0;
                System.out.println("Бронювання місця " + seat + " у ряду " + row + " залу " + hallNumber + " скасовано.");
            }
        }
    }

    // Перевірка наявності заданої кількості послідовних місць
    public boolean checkAvailability(int hallNumber, int numSeats) {
        for (int row = 0; row < NUM_ROWS; row++) {
            int consecutiveSeats = 0;
            for (int seat = 0; seat < NUM_SEATS_PER_ROW; seat++) {
                if (seatingArrangement[hallNumber][row][seat] == 0) {
                    consecutiveSeats++;
                    if (consecutiveSeats == numSeats) {
                        return true;
                    }
                } else {
                    consecutiveSeats = 0;
                }
            }
        }
        return false;
    }

    // Друк схеми розміщення місць для заданого залу
    public void printSeatingArrangement(int hallNumber) {
        System.out.println("Схема розміщення місць для залу " + hallNumber + ":");
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int seat = 0; seat < NUM_SEATS_PER_ROW; seat++) {
                System.out.print(seatingArrangement[hallNumber][row][seat] + " ");
            }
            System.out.println();
        }
    }

    // Метод для знаходження найкращих доступних послідовних місць
    public List<Integer> findBestAvailable(int hallNumber, int startRow, int startColumn, int numSeats) {
        List<Integer> bestSeats = new ArrayList<>();
        int currentConsecutiveSeats = 0;
        int startSeatIndex = -1;

        for (int row = startRow; row < NUM_ROWS; row++) {
            for (int seat = (row == startRow) ? startColumn : 0; seat < NUM_SEATS_PER_ROW; seat++) {
                if (seatingArrangement[hallNumber][row][seat] == 0) {
                    if (currentConsecutiveSeats == 0) {
                        startSeatIndex = seat;
                    }
                    currentConsecutiveSeats++;

                    if (currentConsecutiveSeats == numSeats) {
                        for (int i = startSeatIndex; i < startSeatIndex + numSeats; i++) {
                            bestSeats.add(i);
                        }
                        return bestSeats;
                    }
                } else {
                    currentConsecutiveSeats = 0;
                }
            }
        }
        return bestSeats;
    }

    // Метод для автоматичного бронювання найкращих доступних послідовних місць
    public void autoBook(int hallNumber, int numSeats) {
        List<Integer> bestSeats = findBestAvailable(hallNumber, 4, 7, numSeats);
        if (bestSeats.isEmpty()) {
            System.out.println("Немає достатньо вільних послідовних місць для бронювання " + numSeats + " місць у залі " + hallNumber + ".");
        } else {
            int[] seatsArray = new int[bestSeats.size()];
            for (int i = 0; i < bestSeats.size(); i++) {
                seatsArray[i] = bestSeats.get(i);
            }
            bookSeats(hallNumber, 4, seatsArray); // Бронювання з першого ряду (можна змінити за потребою)
            System.out.println("Автоматичне бронювання " + numSeats + " місць у залі " + hallNumber + " успішно виконано.");
        }
    }
}

