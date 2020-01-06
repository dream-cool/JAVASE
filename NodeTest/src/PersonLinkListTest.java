import com.LinkList;
import com.LinkedList;
import com.Person;

import java.util.Arrays;
import java.util.List;

public class PersonLinkListTest {


    public static void main(String[] args) {

        LinkList<Person> linkList = new LinkList();

        for ( int i = 0 ; i<10 ; i++){
            Person person = new Person();
            person.name="机器人"+i+"号";
            person.age="2"+i;
            person.tall="17"+i;
            linkList.add(person);
            linkList.add(person);
            linkList.remove(person);
        }




//        Person person = new Person("陈留涛", "22", "178");
//        linkList.addFirst(person);
//        linkList.addLast(person);

//        Person person = new Person("陈留涛", "22", "178");
//        linkList.add(3,person);
//        Person person = new Person("陈留涛", "22", "178");
//        linkList.set(1,person);

//        Person person = new Person("陈留涛", "22", "178");
//        System.out.println(linkList.contains(person));
//        linkList.addFirst(person);
//        System.out.println(linkList.contains(person));

//        Person p1 = new Person( "陈留涛1", "22", "178");
//        Person p2 = new Person( "陈留涛2", "23", "178");
//
//        LinkList linkList1 = new LinkList();
//        linkList1.add(p1);
//        linkList1.add(p2);
//
//        linkList.addAll(linkList1);
//
//        Object[] objects = linkList.toArrays();
//        System.out.println(Arrays.toString(objects));
//        for (Object person: objects) {
//            System.out.println(person);
//        }
//        Person p1 = (Person) linkList.removeFirst();
//        Person p2 = (Person) linkList.removeLast();
//        System.out.println(p1);
//        System.out.println(p2);
//

//        linkList.clear();

        linkList.set(-1,new Person());

        System.out.println(linkList);

    }

}
