import com.clt.ArrayList;
import com.clt.Person;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> arrayList = new ArrayList<>();
        for ( int i = 0 ; i < 5 ; i++){
            Person person = new Person("机器人"+i+"号","2"+i,"17"+i);
            arrayList.add(person);
        }
        Person person = new Person("机器人号","2","17");
        arrayList.set(1,person);
        System.out.println(arrayList);
        arrayList.remove(2);
        System.out.println(arrayList);
        System.out.println(arrayList.get(2));



    }
}
