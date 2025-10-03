// FileHandlingExample.java
// Demonstrates basic file handling operations in Java

import java.io.*;
import java.nio.file.*;

public class FileHandlingExample {
    public static void main(String[] args) {
        String fileName = "example.txt";

        // 1. Write to a file
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello, this is the first line.\n");
            writer.write("This file demonstrates file handling in Java.\n");
            System.out.println("File created and content written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }

        // 2. Read from a file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("\nReading from file:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        // 3. Append to a file
        try (FileWriter writer = new FileWriter(fileName, true)) { // true = append mode
            writer.write("This is an appended line.\n");
            System.out.println("\nContent appended successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending to the file.");
            e.printStackTrace();
        }

        // 4. Delete the file
        try {
            Files.deleteIfExists(Paths.get(fileName));
            System.out.println("\nFile deleted successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while deleting the file.");
            e.printStackTrace();
        }
    }
}
