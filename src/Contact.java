import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Contact {
    private String name;
    private String number;
    private Scanner scanner = new Scanner(System.in);


    public Contact(String name, String number){
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return String.format("%-8s |", this.name + "");
    }

    public String getNumber() {
        return String.format("%-12s |", this.number + "");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getInt(int min, int max){

        int answer;

        do{
            System.out.println("\nEnter choice: ");
            answer = this.scanner.nextInt();
            if(answer < min || answer > max) {
                System.out.println("\nInvalid option go again.\n");
            }

        }while (answer < min || answer > max);
        return answer;
    }

    public boolean yesNo(String prompt){
        String confirm;
        System.out.println(prompt);
        confirm = this.scanner.next();
        return confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes");
    }
}
