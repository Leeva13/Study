package org.example;

public class Main {
        public static boolean isPalindrome (String word){
            // Видаляємо пробіли та переводимо слово в нижній регістр
            word = word.replaceAll("\\s", "").toLowerCase();

            // Порівнюємо слово з його реверсованим варіантом
            String reversedWord = new StringBuilder(word).reverse().toString();

            return word.equals(reversedWord);
        }

        public static void main (String[]args){
            String word = "A man a plan a canal Panama";
            if (isPalindrome(word)) {
                System.out.println(word + " є паліндромом.");
            } else {
                System.out.println(word + " не є паліндромом.");
            }
        }
}