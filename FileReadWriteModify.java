import java.io.*;
import java.util.Scanner;

public class FileReadWriteModify {

    // code for write data to a file
    public static void writeToFile(String filename, String data) {
        try (FileWriter fw = new FileWriter(filename, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(data);
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
    }

    // code for read data from a file
    public static void readFromFile(String filename) {
        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            System.out.println("File contents:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from file.");
            e.printStackTrace();
        }
    }

    // code for modify a file (replace all content)
    public static void modifyFile(String filename, String newData) {
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(newData);
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while modifying the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = "example.txt";

        while (true) {
            System.out.println("\n--- Select any one operation ---");
            System.out.println("1. Write to file");
            System.out.println("2. Read from file");
            System.out.println("3. Modify file");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter text to write (append): ");
                    String dataToWrite = sc.nextLine();
                    writeToFile(filename, dataToWrite);
                    break;

                case 2:
                    readFromFile(filename);
                    break;

                case 3:
                    System.out.print("Enter new text to replace existing content: ");
                    String newData = sc.nextLine();
                    modifyFile(filename, newData);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}