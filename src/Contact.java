import java.lang.reflect.Array;
import java.util.ArrayList;

public class Contact {
    private String name;
    private String number;
//    private ArrayList<String> info = newArrayList<>();


    public Contact(String name, String number){
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
