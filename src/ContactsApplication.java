import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import util.Input;


public class ContactsApplication {
    static private List<Contact> contactsList;
    static private Scanner scanner = new Scanner(System.in);

    static void newFile() {
        String directory = "data";

        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        System.out.println(dataDirectory.toAbsolutePath());
        Path dataFile = Paths.get(directory, filename);


        try {
            if (Files.notExists(dataDirectory)) {
                Files.createDirectories(dataDirectory);
                System.out.println("created directory");
            }
            if (!Files.exists(dataFile)) {
                Files.createFile(dataFile);
                System.out.println("Created file");
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    static void writeFile(Contact person) {
//        contactsList = new ArrayList<>();
//        contactsList.add(person);
//        for (Object contact : contactsList){
//            System.out.println(contact);
//        }
        try {
            Path contactsPATH = Paths.get("data", "contacts.txt");
            List<String> newPerson = Arrays.asList(person.getName() + " " + person.getNumber());
            Files.write(contactsPATH, newPerson, StandardOpenOption.APPEND);
//
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

//    public static String[] convertString(Contact person){
//        String[] array = new String[1];
//        return array;
//    }

    static void readWriteFile(){
        List<String> contactsList = null;

        try{
            Path contact = Paths.get("data", "contacts.txt");

            contactsList = Files.readAllLines(contact);
            for(String line : contactsList){
                System.out.println(line);
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        try{
            Path contact = Paths.get("data", "contact.txt");
            Files.write(contact, contactsList);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void searchString(String userInput){

        Path contact = Paths.get("data","contacts.txt");
        List<String> PersonList;
        try{
            PersonList = Files.readAllLines(contact);
            for(String person : PersonList){
                if(person.toLowerCase().contains(userInput.toLowerCase())){
                    System.out.println("Contact: " + person + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteString(String input){

        Path contact = Paths.get("data","contacts.txt");
        List<String> PersonList;
        try{
            PersonList = Files.readAllLines(contact);
            for(String person : PersonList){
                if(person.toLowerCase().contains(input.toLowerCase())){
                    int index = PersonList.indexOf(person);
                    System.out.println(index);
                        PersonList.remove(index);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        newFile();
//        Contact person1 = new Contact("Miguel", "775-313-5602");
//        Contact person2 = new Contact("Crystal", "676-678-7854");
//        writeFile(person1.getName() + " " + person1.getNumber());
//        writeFile(person2.getName() + " " + person2.getNumber());
        getContacts();
    }

    public static void getContacts(){
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        boolean decision = true;
        Input input = new Input();


        while(decision) {

            int choice = input.getInt(1,5);
            System.out.println("\n");

            switch (choice) {
                case(1):
                    readWriteFile();
                    System.out.println("\n");
                    getContacts();
                    break;
                case(2):
                    System.out.println("Enter a name");
                    String userInputName = scanner.nextLine();
                    System.out.println("Enter a number");
                    String userInputNumber = scanner.nextLine();
                    Contact person = new Contact(userInputName, userInputNumber);
                    writeFile(person);
                    System.out.println("\n");
                    getContacts();
                    break;
                case(3):
                    String name = input.getString("Enter a name to search:");
                    searchString(name);
                    getContacts();
                    break;
                case(4):
                    String nameDelete = input.getString("Enter a name to delete:");
                    deleteString(nameDelete);
                    getContacts();
                    break;
                case(5):
                    boolean confirm = input.yesNo("Are you sure you want to exit?");
                    if(confirm){
                        System.out.println("Goodbye!!!");
                        decision = false;
                        break;
                    }else{
                        System.out.println("Restarting....");
                        break;
                    }
            }

        }
    }

}
