package util;

import java.util.Scanner;
import java.util.stream.DoubleStream;

public class Input {

    private Scanner scanner;

    public Input() {

        this.scanner = new Scanner(System.in);

    }

    public boolean yesNo(String prompt){
        String confirm;
        System.out.println(prompt);
        confirm = this.scanner.next();
        return confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes");
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

}

