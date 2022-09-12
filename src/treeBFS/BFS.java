package treeBFS;

import CodeSignal.trees.HasPathWithGivenSum.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS
{
    public static void main(String[] args) {

    }

    static int findMaxDepth(Tree root)
    {
        int depth = 0;

        if(root == null) return depth;

        Queue<Tree> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            //current level
            for(int i=0; i<size; i++){
                Tree<Integer> currentNode = q.poll();
                //add all children of current node
                q.offer(currentNode.left);
                q.offer(currentNode.right);
            }

            depth++;
        }

        return depth;

    }

}
