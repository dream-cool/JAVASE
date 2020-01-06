import com.clt.HashMap;
import com.clt.Person;

public class Main {

    public static void main(String[] args) {

        HashMap<String ,Person > map = new HashMap<>();
//        Map<String ,Person > map = new TreeMap<>();
        for (int i = 0 ; i < 5 ; i++){
            String number = "B"+i;
            Person person = new Person(i+"号","2"+i,"17"+i);
            map.put(number,person);
        }
        System.out.println(map+"-----"+map.size());
        Person person = new Person("号","2","17");
        map.put("B2",person);
        System.out.println(map+"-----"+map.size());
        System.out.println(map.get("B1"));
        System.out.println(map+"-----"+map.size());
//        Person person1 = new Person("1号","12","117");
//        System.out.println("#############");
//        map.put("11",person1);

//        java.util.HashMap map1 = new java.util.HashMap();
//        for (int i = 0 ; i < 30 ; i++){
//            map1.put(i+"号",i+"分");
//        }
//

//        System.out.println(map1);



    }
}
