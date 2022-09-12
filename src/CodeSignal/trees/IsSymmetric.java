package CodeSignal.trees;

import CodeSignal.trees.HasPathWithGivenSum.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 Given a binary tree t, determine whether it is symmetric around its center, i.e. each side mirrors the other.
 */
public class IsSymmetric
{
    /**
        1
       / \
      2   2
     / \ / \
    3  4 4  3
     */
    public static void main(String[] args) {
        /*Tree<Integer> root = new Tree<>(1);
        root.left = new Tree<>(2); root.right = new Tree<>(2);
        root.left.left = new Tree<>(3); root.left.right = new Tree<>(4); root.right.left = new Tree<>(4); root.right.right = new Tree<>(3);*/

        Tree<Integer> root = new Tree<>(1);
        root.left = new Tree<>(2); root.right = new Tree<>(2);
        root.left.right = new Tree<>(3); root.right.right = new Tree<>(3);

        //root = null;
        isTreeSymmetric(root);
    }


    /**
     * Sol1> DFS.  Should use BFS
     */
    static boolean isTreeSymmetric(Tree<Integer> t)
    {
        if(t == null)   return false;

        List<String> paths = new ArrayList<>();

        dfs(t, paths, "");

        for(int i=0, j=paths.size()-1; i<j; i++, j--)
        {
            if(!paths.get(i).equals(paths.get(j)))  return false;
        }

        return true;
    }

    /**
     * Sol2> BFS TODO
     */
    static boolean isTreeSymmetric2(Tree<Integer> t)
    {
        return false;
    }


    /** Should use BFS to go level by level and stop when a level is not symmetric instead of dfs going through all the tree and then comparing */
    static void dfs(Tree t, List<String> paths, String path)
    {
        //path.add((Integer)t.value);
        if(t== null)  {path += " n"; paths.add(path); return;}
        else path += t.value+" ";

        if(t.left == null && t.right == null){
            paths.add(path);
            return;
        }
        //if(t.left != null){
            dfs(t.left, paths, path);
        //}
        //if(t.right != null){
            dfs(t.right, paths, path);
        //}

    }
}
