package leet.trees;

import CodeSignal.trees.HasPathWithGivenSum;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthBinTree
{
    /**
     Given the root of a binary tree, return its maximum depth.
     */
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        maxDepth(root);
    }


    static public int maxDepth(TreeNode root)
    {
        if(root == null) return 0;

        int depth = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            //how many nodes in this level
            int size = q.size();
            //for each one of them add their children to the back of the q so they can conform the next level deep
            for(int i=0; i<size; i++)
            {
                TreeNode node = q.poll();

                if(node.left != null)   q.offer(node.left);
                if(node.right != null)  q.offer(node.right);
            }
             depth++;
        }

        return depth;
    }
}
