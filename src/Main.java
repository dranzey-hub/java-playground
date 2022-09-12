import trees.binary.Node;
import trees.binary.BinaryTree;

public class Main {

    public static void main(String[] args)
    {
        //System.out.println("Hello World!");

        BinaryTree tree = new BinaryTree(null);

        tree.add(5);
        tree.add(3);
        tree.add(6);
        tree.add(2);
        tree.add(4);
        tree.substract(3);

        tree.traverseInOrder(tree.root);
    }
}
