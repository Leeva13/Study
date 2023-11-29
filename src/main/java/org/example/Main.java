package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть закодоване повідомлення:");
        String encodedMessage = scanner.nextLine();

        String[] words = encodedMessage.split("\\s+");

        System.out.println("Закодоване повідомлення: " + encodedMessage);
        System.out.println("Розкодоване повідомлення:");

        for (String word : words) {
            String decodedWord = Decoder.decodeWord(word);
            System.out.print(decodedWord + " ");
        }
    }
}




