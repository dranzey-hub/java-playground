package leet.trees;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree
{
    static boolean valid = true;

    /**
     Given the root of a binary tree, determine if it is a valid binary search tree (BST).

     A valid BST is defined as follows:

     - The left subtree of a node contains only nodes with keys less than the node's key.
     - The right subtree of a node contains only nodes with keys greater than the node's key.
     - Both the left and right subtrees must also be binary search trees.
     */
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        isValidBST(root);
    }



    static public boolean isValidBST(TreeNode root)
    {
        if( root == null ){ return true; }

        valid = true;

        recursive(root);


        //GET INORDER LIST, all subsequent numbers must be greater than the prev, i think...
        List<Integer> inord = new ArrayList<>();
        inorder(root, inord);
        //


        System.out.println(inord);
        return valid;
    }

    static void inorder(TreeNode node, List<Integer> list)
    {
        if(node.left != null){
            inorder(node.left, list);
        }

        if(node != null)
            list.add(node.val);

        if(node.right != null){
            inorder(node.right, list);
        }
    }


    //THIS DOESN'T WORK BECAUSE WE ALSO NEED TO KNOW THE CURRENT NODE IS GREATER OR SMALLER THAN ALL SUB TREES TO THE LEFT AND RIGHT
    static void recursive(TreeNode node)
    {
        if(node.left != null){
            if(node.left.val >= node.val)    {valid = false; return;}
            recursive(node.left);
        }
        if(node.right != null){
            if(node.right.val <= node.val)   {valid = false; return;}
            recursive(node.right);
        }
    }
}
