package CodeSignal.trees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 *    --              --
 *   |      |    |     |
 *   |      |   |      |
 *   |      |  |       |
 *   |      | |        |
 *   |       |         |
 *   |      |          |
 *   |                 |
 *   |     O           |
 *   __               __
 *
 *          **USING RECURSION WITH STRINGS (which are immutable)
 */


public class HasPathWithGivenSum
{
    /**
     Given a binary tree t and an integer s, determine whether there is a root to leaf path in t such that the sum of vertex values equals s.

        Ex
           4
          / \
        1    3
       /    / \
     -2    1   2
       \      / \
        3   -2  -3

     s = 7 =>  true     (4+3+2-2)
     */
    public static void main(String[] args)
    {
        Tree<Integer> root = new Tree<>(4);
        root.left = new Tree<>(1);  root.right = new Tree<>(3);
        root.left.left = new Tree<>(-2); root.right.left = new Tree<>(1); root.right.right = new Tree<>(2);
        root.left.left.right = new Tree<>(3); root.right.right.left = new Tree<>(-2); root.right.right.right = new Tree<>(-3);

        hasPathWithGivenSum(root, 7);
    }


    static boolean hasPathWithGivenSum(Tree<Integer> t, int s)
    {
        //ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        List<String> paths = new ArrayList<>();

        if(t == null)   return false;

        /**[!] doesn't work with ArrayList or other object but it works with String
         * (returns a different string for each path (DESIRED); arraylist will have all paths together in each return) */
        dfs(t, paths, /*new ArrayList<Integer>()*/"");

        for(String str : paths){
            String[] arr = str.split(" ");

            int sum = 0;
            for(String c : arr){
                sum += Integer.parseInt(c);
            }
            if (sum == s)   return true;
        }

        return false;
    }

    static void dfs(Tree t, /*ArrayList<ArrayList<Integer>>*/List<String> paths, /*ArrayList<Integer>*/String path)
    {
        //path.add((Integer)t.value);
        path += t.value+" ";

        if(t.left == null && t.right == null){
            paths.add(path);
            return;
        }
        if(t.left != null){
            dfs(t.left, paths, path);
        }
        if(t.right != null){
            dfs(t.right, paths, path);
        }

    }

    public static class Tree<T> {
       Tree(T x) {
         value = x;
       }
       T value;
       public Tree<T> left;
       public Tree<T> right;
    }

}
