//Write a Java Program to count word in the given input or givem file.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class WordCounter {
    
    // Function to count words in a given string
    private static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+");
        return words.length;
    }

    // Function to count words in a given file
    private static int countWordsFromFile(File file) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(file);
        int wordCount = 0;
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            wordCount += countWords(line);
        }
        fileScanner.close();
        return wordCount;
    }

    public static void main(String[] args) {
        // Prompt user for input source
        System.out.println("Enter '1' to input from the console or '2' to input from a file:");

        // Read input source choice from the user
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice == 1) {
            // Input from the console
            System.out.println("Enter a sentence or phrase:");
            String input = scanner.nextLine();
            int wordCount = countWords(input);
            System.out.println("Number of words: " + wordCount);
        } else if (choice == 2) {
            // Input from a file
            System.out.println("Enter the path of the file:");
            String filePath = scanner.nextLine();
            try {
                File file = new File(filePath);
                if (!file.exists()) {
                    System.out.println("File not found: " + filePath);
                    return;
                }

                int wordCount = countWordsFromFile(file);
                System.out.println("Number of words in the file: " + wordCount);
            } catch (FileNotFoundException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid choice. Please enter '1' or '2'.");
        }
        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
