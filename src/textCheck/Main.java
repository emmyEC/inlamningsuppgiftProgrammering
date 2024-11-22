package textCheck;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initierar Scanner och TextCheck
        Scanner scan = new Scanner(System.in);
        TextCheck check = new TextCheck();

        //Kör programmet så länge checkInput inte returnerar false (sker om användaren skriver stop)
        boolean running = true;
        while (running) {
            System.out.println("Type anything (stop = exit): ");
            String input = scan.nextLine();
            running = check.checkInput(input);
        }
        System.out.println("Exiting...");

        //Skriver ut resultat
        System.out.println("Number of characters: " + check.getNumOfCharacters());
        System.out.println("Number of lines: " + check.getNumOfLines());
        System.out.println("Number of words: " + check.getNumOfWords());
        if (check.getLongestWord().isEmpty()) {
            System.out.println("Type some words next time!");
        } else {
            System.out.println("Longest word: " + check.getLongestWord());
        }
    }
}
