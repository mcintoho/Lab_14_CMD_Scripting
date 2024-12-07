import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        System.out.println("Welcome to the Data Saver Program!");

        boolean continueInput = true;
        int idCounter = 1; // Starts the ID numbering at 1

        while (continueInput) {
            // Collect data from the user
            String firstName = SafeInput.getNonZeroLenString(scanner, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Enter Last Name");
            String idNumber = SafeInput.getNonZeroLenString(scanner, "Enter ID Number");
            String email = SafeInput.getNonZeroLenString(scanner, "Enter Email");
            int yearOfBirth = SafeInput.getInt(scanner, "Enter Year of Birth");

            // Format the data as a CSV record
            String record = String.format("%s, %s, %s, %s, %d", firstName, lastName, idNumber, email, yearOfBirth);
            records.add(record);

            // Ask the user if they want to add another record
            System.out.print("Do you want to add another record? (yes/no): ");
            String response = scanner.nextLine();
            continueInput = response.equalsIgnoreCase("yes");
        }

        // Prompt for the file name
        String fileName = SafeInput.getNonZeroLenString(scanner, "Enter the file name (add .csv extension)");

        // Write the records to the specified file
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/" + fileName))) {
            for (String record : records) {
                writer.println(record);
            }
            System.out.println("Data has been saved to: src/" + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file: " + e.getMessage());
        }

        scanner.close();
    }
}
