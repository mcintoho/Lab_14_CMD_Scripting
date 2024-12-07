import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileInspector {
    public static void main(String[] args) {
        try {
            // Step 1: Create JFileChooser and set directory to the 'src' folder
            JFileChooser fileChooser = new JFileChooser("src");
            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Processing file: " + selectedFile.getName());

                // Step 2: Initialize counters
                int lineCount = 0;
                int wordCount = 0;
                int charCount = 0;

                // Step 3: Read file line by line
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                String line;
                while ((line = reader.readLine()) != null) {
                    lineCount++; // Count lines
                    wordCount += line.split("\\s+").length; // Count words
                    charCount += line.length(); // Count characters
                    System.out.println(line); // Echo the line to the console
                }
                reader.close();

                // Step 4: Print the summary report
                System.out.println("\n--- Summary Report ---");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);
            } else {
                System.out.println("No file was selected.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
