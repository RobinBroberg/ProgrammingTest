package AnagramChecker;

import java.util.Scanner;

public class AnagramChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean run = true;
        while (run) {
            System.out.println("Please enter a word (letters only)");
            String stringOne = scan.nextLine().toLowerCase();
            if (isNotValidInput(stringOne)) {
                System.out.println("Invalid input. Please enter only letters.");
                return;
            }

            System.out.println("Please enter a second word (letters only)");
            String stringTwo = scan.nextLine().toLowerCase();
            if (isNotValidInput(stringTwo)) {
                System.out.println("Invalid input. Please enter only letters.");
                return;
            }

            if (isAnagram(stringOne, stringTwo)) {
                System.out.println("The words are anagrams");
            } else {
                System.out.println("The words are not anagrams");
            }
            System.out.println("Do you want to check more words? (Y/N)");
            String answer = scan.nextLine().toUpperCase();
            if (!answer.equals("Y")) {
                run = false;
            }
        }
    }

    private static boolean isNotValidInput(String input) {
        return !input.matches("[a-zA-Z]+"); // Will only work with english alphabet
    }

    public static boolean isAnagram(String stringOne, String stringTwo) {
        if (stringOne.length() != stringTwo.length()) {
            return false;
        }

        int[] charactersOne = new int[128];
        int[] charactersTwo = new int[128];

        for (int i = 0; i < stringOne.length(); i++) {
            charactersOne[stringOne.charAt(i)]++;
            charactersTwo[stringTwo.charAt(i)]++;
        }

        for (int i = 0; i < 128; i++) {
            if (charactersOne[i] != charactersTwo[i]) {
                return false;
            }
        }
        return true;
    }
}



