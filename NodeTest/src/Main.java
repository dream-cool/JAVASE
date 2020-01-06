import com.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        for ( int i = 1 ; i<10 ; i++ ){
            linkedList.add("爱国"+i);
        }

        linkedList.remove("爱国1");
        linkedList.remove("爱国9");
        linkedList.remove(null);
        linkedList.remove("");



        System.out.println(linkedList.getFirst()+"--"+linkedList.getLast());
        System.out.println(linkedList+"---size"+linkedList.getSize());

        linkedList.remove("爱国5");

        System.out.println(linkedList+"---size"+linkedList.getSize());

        System.out.println(linkedList.getIndex("爱国2"));

        System.out.println(linkedList.searchByIndex(5));
    }

}
