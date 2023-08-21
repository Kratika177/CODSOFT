/*
1. Prompt the user to enter a text or provide a file to count the words.
2. Read the input text or file and store it in a string.
3. Split the string into an array of words using space or punctuation as delimiters.
4. Initialize a counter variable to keep track of the number of words.
5. Iterate through the array of words and increment the counter for each word encountered.
6. Display the total count of words to the user.
  */

package WordCounter;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Word Counting Program");
        System.out.print("Enter 'text' to input text manually or 'file' to read from a file: ");
        String inputChoice = scanner.nextLine().trim().toLowerCase();

        String text = "";

        if (inputChoice.equals("text")) {
            System.out.print("Enter your text: ");
            text = scanner.nextLine();
        } else if (inputChoice.equals("file")) {
            System.out.print("Enter the file name: ");
            String fileName = scanner.nextLine();
            // Implement file reading logic here
            // You can use FileReader, BufferedReader, etc. to read the file and store its content in 'text'
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        // Split the text into an array of words using space and punctuation as delimiters
        String[] words = text.split("[\\s\\p{Punct}]+");
        int wordCount = words.length;

        System.out.println("Total number of words: " + wordCount);

        scanner.close();
    }
}
