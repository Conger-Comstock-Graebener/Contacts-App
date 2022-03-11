import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactsApp {

    static Path pathToContacts = Paths.get("src/data", "contacts.txt");

    public static Scanner sc = new Scanner(System.in);
    public static Contacts[] contactsList;

    public static List<Contacts> createContactsObject() {
        List<Contacts> contacts = new ArrayList<>();
        try {
            Path pathToOurFile = Paths.get("src/data", "contacts.txt");
            List<String> contactsList = Files.readAllLines(pathToOurFile);

            for (String contact : contactsList) {
                Contacts contact1 = new Contacts(contact.substring(0, contact.lastIndexOf(" ")),
                        contact.substring(contact.lastIndexOf(" ") + 1));
                contacts.add(contact1);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return contacts;
    }

    public static void printAllContacts(Path pathToContacts) throws IOException {
        System.out.println();
        List<Contacts> contactsList = createContactsObject();
        System.out.println("");
        System.out.printf("%-19s%s%s\n", "Name", "| ", "Phone number");
        System.out.println("--------------------------------");
        for (Contacts contact : contactsList) {
            System.out.printf("%-19s%s%s\n", contact.getName(), "| ", contact.getNumber());
        }
    }

    public static void addContact() throws IOException {
        System.out.println("Enter Contact's full name: ");
        String userName = sc.nextLine();
        System.out.println("Enter Contact's phone number: ");
        String userNumber = sc.nextLine();
        String person = userName + " " + userNumber;
        List<String> newContact = Arrays.asList(person);
        Files.write(pathToContacts, newContact, StandardOpenOption.APPEND);
    }

    public static void parseFile() throws Exception {
        System.out.println("Enter the name of who you want to search for: ");
        String userInput = sc.nextLine();
        List<String> fileContents = Files.readAllLines(pathToContacts);
        try {
            for (String fileContent : fileContents) {
                if (fileContent.toLowerCase().contains(userInput.toLowerCase())) {
                    System.out.println(fileContent);
                }
            }
        } catch (Exception e) {
            System.out.println("You had a whoopsie " + e.getMessage());
        }
    }

    public static void deleteContact() throws IOException, NullPointerException {
        System.out.println("Enter the name of the contact you want to delete: ");
        String userInput = sc.nextLine();
        List<String> fileContents = Files.readAllLines(pathToContacts);
        try {
            for (String fileContent : fileContents) {
                if (fileContent.toLowerCase().contains(userInput.toLowerCase())) {
//                    Files.write(Path.of(fileContent.toLowerCase()), Collections.singleton(newContact));
                    Files.delete(Path.of(fileContent.toLowerCase()));
                    System.out.println("Your file was deleted.");
                }
            }
        } catch (IOException e) {
            System.out.println("You didn't delete the file..." + e.getMessage());
        } catch (NullPointerException e1) {
            System.out.println("There is no such user: " + e1.getMessage());
        }
    }

    public static void appStart() throws Exception {
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");

        String userInput = sc.nextLine();
        switch (userInput) {
            case "1":
                printAllContacts(pathToContacts);
                System.out.println();
                appStart();
                break;
            case "2":
                addContact();
                System.out.println("Your contact was added!");
                System.out.println();
                appStart();
                break;

            case "3":
                parseFile();
                System.out.println();
                appStart();
                break;
            case "4":
                deleteContact();
                System.out.println();
                appStart();
                break;
            case "5":
                System.exit(0);
                System.out.println();
            default:
                System.out.println("Pick a number from 1 - 5 please");
                System.out.println();
                break;
        }
    }

    public static void main(String[] args) throws Exception {


        appStart();

    }
}














