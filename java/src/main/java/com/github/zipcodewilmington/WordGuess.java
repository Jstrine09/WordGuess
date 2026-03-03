package com.github.zipcodewilmington;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */

import java.util.ArrayList;
import java.util.Scanner;

public class WordGuess {

    static String[] words = {"apple", "pears", "cakes", "dates", "berry", "grape", "melon", "mango", "lemon", "plums", "peach", "guava", "prune", "kiwis", "juice", "cocoa", "olive", "cider", "sugar", "spice"};
    static int MAX_TRIES = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain = "";

        do { 
            String secret = words[(int) (Math.random() * words.length)];
            ArrayList<Character> wrongGuesses = new ArrayList<>();
            
            System.out.println("Welcome to Word Guess! Guess the secret word. You have " + MAX_TRIES + " tries.");
            
            for (int attempt = 1; attempt <= MAX_TRIES; attempt++) {
                System.out.print("Attempt " + attempt + "/" + MAX_TRIES +  ": ");
                String guess = scanner.nextLine().toLowerCase();
                
                if (guess.equals(secret)) {
                    System.out.println("Congratulations! You've guessed the secret word: " + secret + " in " + attempt + " attempts!");
                    break;
                }
                for (char c : guess.toCharArray()) {
                    if (secret.indexOf(c) == -1 && !wrongGuesses.contains(c)) {
                        wrongGuesses.add(c);
                    }
                }
                StringBuilder progress = new StringBuilder();
                for (int i = 0; i < 5; i++) {
                    if (guess.charAt(i) == secret.charAt(i)) {
                        progress.append(secret.charAt(i));
                    } else {
                        progress.append("_");
                    }
                }
                System.out.println("Word: " + progress);
                System.out.println("Wrong guesses: " + wrongGuesses + "\n");
                if (attempt == MAX_TRIES) {
                    System.out.println("Game over! The secret word was: " + secret.toUpperCase());
                }
        }
        System.out.print("\nPlay again? (yes/no): ");
        playAgain = scanner.nextLine().toLowerCase();
        if (!playAgain.equals("yes")) {
            break;
        }
    } 
        while (playAgain.equals("yes"));
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
