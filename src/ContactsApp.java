import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
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

        public static void appStart() throws IOException {

            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");
            System.out.println("Enter an option (1, 2, 3, 4 or 5):");

            String userInput = sc.nextLine();
            switch (userInput)
            {
                case "1":
                    printAllContacts(pathToContacts);
                    System.out.println();
                    appStart();
                    break;
                case "2":
//                    todo add new contact
                    addContact();
                    System.out.println("Your contact was added!");
                    System.out.println();
                    appStart();
                    break;

                case "3":
//                    todo seatch by name
                    System.out.println();
                    break;
                case "4":
//                    todo delete contact
                    System.out.println();
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


        public static void addContact() throws IOException {
            System.out.println("Enter Contact's full name: ");
            String userName = sc.nextLine();
            System.out.println("Enter Contact's phone number: ");
            String userNumber = sc.nextLine();
            String person = userName + " " + userNumber;
            List<String> newContact = Arrays.asList(person);
//            Contacts contact =  new Contacts(userName, userNumber);

            Files.write(pathToContacts, newContact, StandardOpenOption.APPEND);

        }



    public static void main(String[] args) throws IOException {


       appStart();

    }





}