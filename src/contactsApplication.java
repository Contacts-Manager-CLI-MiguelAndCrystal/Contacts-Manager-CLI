import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class contactsApplication {
//    static HashMap<String, Contact> contacts = new HashMap<>();

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
    static void writeFile() {
        List<String> contactsList = new ArrayList<>();

        contactsList.add("sdfghv");contactsList.add("adg");contactsList.add("afdg");contactsList.add("aefg");
        for (String contact : contactsList){
            System.out.println(contact);
        }
        try {
            Path contacts = Paths.get("data", "contacts.txt");
            Files.write(contacts, contactsList);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
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
        writeFile();
//        readWriteFile();


//        Contact person1 = new Contact("Miguel", "775-313-5602");
//        Contact person2 = new Contact("Crystal", "676-678-7854");
//
//        writeFile(person1);
    }

}