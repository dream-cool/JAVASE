import com.clt.it.BSTree;


public class Main {

    public static void main(String[] args) {

        BSTree tree = new BSTree();
        tree.addTreeNode(63);
        tree.addTreeNode(55);
        tree.addTreeNode(90);
        tree.addTreeNode(42);
        tree.addTreeNode(58);
        tree.addTreeNode(70);
        tree.addTreeNode(98);
        tree.addTreeNode(10);
        tree.addTreeNode(45);
        tree.addTreeNode(67);
        tree.addTreeNode(83);

        tree.printTree(tree.getRoot());
        System.out.println();

        tree.deleteTree(58);


        tree.printTree(tree.getRoot());

        System.out.println();


    }
}
