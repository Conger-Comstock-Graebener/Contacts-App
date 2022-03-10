import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

    public class ContactsApp
    {
        static Path pathToContacts = Paths.get("src/data", "contacts.txt");

        public static Scanner sc = new Scanner(System.in);

        public static void printAllContacts(Path filePath) throws IOException
        {
            System.out.println();
            List<String> fileContents = Files.readAllLines(filePath); // we need List as .readAllLines returns List datatype
            for (int i = 0; i < fileContents.size(); i++)
            {
                System.out.printf("%d: %s\n", i + 1, fileContents.get(i));
            }
        }

        public static String appStart()
        {

            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");
            System.out.println("Enter an option (1, 2, 3, 4 or 5):");

            return sc.nextLine();
        }

        public static void addContact() throws IOException {
            System.out.println("Enter Contact's full name: ");
            String userName = sc.next();
            System.out.println("Enter Contact's phone number: ");
            String userNumber = sc.next();
            String contact = userName + " " + userNumber;
            List<String> newContact = Arrays.asList(contact);
            Files.write(pathToContacts, newContact, StandardOpenOption.APPEND);

        }

        public static void runConditionals(String s) throws IOException
        {
            switch (s)
            {
                case "1":
                    printAllContacts(pathToContacts);
                    break;
                case "2":
//                    todo add new contact
                    addContact();
                    System.out.println("Your contact was added!");
                    break;
                case "3":
//                    todo seatch by name
                    break;
                case "4":
//                    todo delete contact
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("Pick a number from 1 - 5 please");
                    break;
            }
        }

    public static void main(String[] args) throws IOException {


       runConditionals(appStart());

    }





}