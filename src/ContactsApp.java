import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

    public class ContactsApp {
        public static void initializeFiles(){
//        Check directory. If it doesn't exist, create it. //
            Path pathToData = Paths.get("src/data");
            try {
                if (Files.notExists(pathToData)){
                    System.out.println("Creating directory...");
                    Files.createDirectories(pathToData);
                    System.out.println("Directory created!");
                } else {
                    System.out.println("The " + pathToData + " directory already exists!");
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            Path pathToContacts = Paths.get("src/data", "contacts.txt");
            try {
                System.out.println("Checking file system...");
                if (Files.notExists(pathToContacts)){
                    Files.createFile(pathToContacts);
                    System.out.println("Your file is created!");
                } else {
                    System.out.println("The " + pathToContacts + " file already exists!");
                }
            } catch (IOException ioe) {
                System.out.println("There was a problem!");
                ioe.printStackTrace();
            }
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");
        String userInput = sc.nextLine();

    }




    public static void printData(Path filePath) throws IOException {
        System.out.println();
        List<String> fileContents = Files.readAllLines(filePath); // we need List as .readAllLines returns List datatype
        for (int i = 0; i < fileContents.size(); i++) {
            System.out.printf("%d: %s\n", i + 1, fileContents.get(i));
        }
    }
}