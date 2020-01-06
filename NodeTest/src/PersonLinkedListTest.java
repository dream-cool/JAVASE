import com.LinkedList;
import com.Person;

import java.util.Arrays;
import java.util.List;

public class PersonLinkedListTest {


    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        List<Person> personLinkedList = new java.util.LinkedList<>();
        for ( int i = 0 ; i<10 ; i++){
            Person person = new Person();
            person.name="机器人"+i+"号";
            person.age="2"+i;
            person.tall="17"+i;
            personLinkedList.add(person);
            personLinkedList.add(person);
            linkedList.add(person);
            linkedList.add(person);
            linkedList.remove(person);
            personLinkedList.remove(person);
        }




//        Person person = new Person("陈留涛", "22", "178");
//        linkedList.addFirst(person);
//        linkedList.addLast(person);

//        Person person = new Person("陈留涛", "22", "178");
//        linkedList.add(3,person);
//        Person person = new Person("陈留涛", "22", "178");
//        linkedList.set(1,person);

//        Person person = new Person("陈留涛", "22", "178");
//        System.out.println(linkedList.contains(person));
//        linkedList.addFirst(person);
//        System.out.println(linkedList.contains(person));

//        Person p1 = new Person( "陈留涛1", "22", "178");
//        Person p2 = new Person( "陈留涛2", "23", "178");
//
//        LinkedList linkedList1 = new LinkedList();
//        linkedList1.add(p1);
//        linkedList1.add(p2);
//
//        linkedList.addAll(linkedList1);

        Object[] objects = linkedList.toArrays();
        System.out.println(Arrays.toString(objects));
//        for (Object person: objects) {
//            System.out.println(person);
//        }
//        Person p1 = (Person) linkedList.removeFirst();
//        Person p2 = (Person) linkedList.removeLast();
//        System.out.println(p1);
//        System.out.println(p2);


//        linkedList.clear();
//        System.out.println(linkedList);


//        System.out.println(personLinkedList);

//        System.out.println(linkedList);

    }

}
