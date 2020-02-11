import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Input;


public class ContactsApplication {
    static private List<Object> contactsList;

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
    static void writeFile(Object person) {
        contactsList = new ArrayList<>();
        contactsList.add(person);
        for (Object contact : contactsList){
            System.out.println(contact);
        }
        try {
            Path contactsPATH = Paths.get("data", "contacts.txt");
            Files.write(contactsPATH, Arrays.asList(convertString(contactsList)), StandardOpenOption.APPEND);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static String[] convertString(List<Object> item){
        String[] array = new String[item.size()];
        int index = 0;
        for (Object value : item) {
            array[index] = (String) value;
            index++;
        }
        return array;
    }

//    static void readWriteFile(){
//        List<String> contactsList = null;
//
//        try{
//            Path contact = Paths.get("data", "contacts.txt");
//            contactsList = Files.readAllLines(contact);
//            for(String line : contactsList){
//                System.out.println(line);
//            }
//        }catch(IOException ioe){
//            ioe.printStackTrace();
//        }
//
//        contactsList.add("kiwi"); contactsList.add("jackfruit");
//
//        try{
//            Path contact = Paths.get("data", "contact.txt");
//            Files.write(contact, contactsList);
//        }catch(IOException ioe){
//            ioe.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        newFile();
//        readWriteFile();

        boolean decision = true;
        Input input = new Input();


        while(decision) {
            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");


//            Contact person1 = new Contact("Miguel", "775-313-5602");
//            Contact person2 = new Contact("Crystal", "676-678-7854");

//            writeFile(person1.getName() + " " + person1.getNumber());
//            writeFile(person2.getName() + " " + person2.getNumber());

            int choice = input.getInt(1,5);


            switch (choice) {
                case(1):
                    boolean confirm = input.yesNo("Are you sure you want to exit?");
                    if(confirm){
                        System.out.println("Goodbye!!!");
                        decision = false;
                    }else{
                        System.out.println("Restarting......");
                    }
                    break;
                case(2):
            }

        }

    }

}
