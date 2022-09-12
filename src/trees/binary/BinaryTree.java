package trees.binary;

public class BinaryTree
{
    public Node root;
    public BinaryTree(Node n)
    {
        this.root = n;
    }

    public void add(int value)
    {
        root = insert(root, value);
    }

    public void substract(int value) { /*root = */remove(root, value); }    //??



    private Node insert(Node n, int value)
    {
        if(n == null)
        {
            return new Node(value);
        }

        if(n.value > value)
        {
            n.left = insert(n.left, value);
        }
        else if(n.value < value)
        {
            n.right = insert(n.right, value);
        }

        //else, already in tree
        return n;
    }


    private Node remove(Node n, int value)
    {   //not found
        if(n == null)
            return null;
        //found
        if(value == n.value)
        {
            //remove algorithm
            //case no children
            if(n.left == null && n.right == null)
            {
                return null;
            }
            //case 2 children
            else if(n.left != null && n.right != null)
            {
                int smallest = findSmallestValue(n.right);
                n.value = smallest;
                n.right = remove(n.right, smallest);
                //return n;       //??
            }
            //case 1 child
            else{
                if(n.left != null)
                    return n.left;
                else
                    return n.right;
            }
        }
        if(value > n.value)
        {
            n.right = remove(n.right, value);
            //return n;       //why??
        }
        else if(value < n.value)
        {
            n.left = remove(n.left, value);
            //return n;       //why?
        }
        //why??
        return n;
    }



    private int findSmallestValue(Node n)
    {
        return n.left == null ? n.value : findSmallestValue(n.left);
    }



    public void traverseInOrder(Node n)
    {
        if(n != null)
        {
            traverseInOrder(n.left);
            System.out.print(" "+n.value);
            traverseInOrder(n.right);
        }
    }

}