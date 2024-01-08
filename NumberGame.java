/* This code is a Java program for a simple number guessing game between the user and the computer. 
The game has a set of rules, and the user has to guess a randomly chosen number within a specified range
*/

import java.util.*;
public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("------Welcome to the Number Guessing Game!------");
        System.out.println("I am thinking a number between 1 and 100, which is you have to guess it");
        System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");

        while (true) {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println(" You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Guess the number: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations!!! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println(" It's Too low! Try again.");
                } else {
                    System.out.println("It's Too high! Try again.");
                }

                if (attempts == maxAttempts) {
                    System.out.println("You've run out of attempts. The correct number was " + numberToGuess + ".");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Game over!!! You are " + score + " rounds won.");
        sc.close();
    }
    
}