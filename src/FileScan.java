import javax.swing.*;
import java.io.File;

public class FileScan {
    public static void main(String[] args) {
        File fileToScan;

        if (args.length > 0) {
            // Get file from command line argument
            fileToScan = new File(args[0]);
            if (!fileToScan.exists() || !fileToScan.isFile()) {
                System.out.println("File does not exist: " + args[0]);
                return;
            }
        } else {
            // Launch JFileChooser if no argument is provided
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                fileToScan = fileChooser.getSelectedFile();
            } else {
                System.out.println("No file selected.");
                return;
            }
        }

        System.out.println("Scanning file: " + fileToScan.getAbsolutePath());
        // Implement your file scanning logic here
    }
}
