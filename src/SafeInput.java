import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int retInt = 0;
        boolean valid = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine(); // clear newline
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                pipe.nextLine(); // clear invalid input
            }
        } while (!valid);
        return retInt;
    }
}
