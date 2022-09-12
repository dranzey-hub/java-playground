package CodeSignal.linkedLists;

public class RemoveKFromList
{
    public static void main(String[] args)
    {
        ListNode<Integer> l = new ListNode<Integer>(3);
        l.next = new ListNode<>(1);
        l.next.next = new ListNode<>(2);
        l.next.next.next = new ListNode<>(3);
        l.next.next.next.next = new ListNode<>(3);
        l.next.next.next.next.next = new ListNode<>(5);
        //ListNode<Integer> l = new ListNode<Integer>(100);
        //l.next = new ListNode<Integer>(100);

        print(l);

        l = removeKFromList(l, 3);

        print(l);

    }

    static void print(ListNode<Integer> l){
        ListNode<Integer> p = l;
        do
        {
            System.out.print(p.value+"->");
            p = p.next;
        }while(p != null);
        System.out.println();
    }


    /**
     Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value equal to k.

                Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in the list,
            since this is what you'll be asked to do during an interview.
     */
    static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k)
    {
        /**
                Solving with 0(n) time and O(1) memory
         */
        //pointer
        ListNode<Integer> node = l;

        //remove header nulls first
        while(node!= null && node.value == k)
        {
            node = node.next;
        }
        //we just advanced all k's and set the root at next non k node
        l = node;

        //remove the rest
        //something similar but each time we find a k value, we set a pointer at the good node
        //and advance until no more k and point good node link to next non k node
        while(node != null)
        {
            if(node.next != null && node.next.value == k)
            {
                //advance all k values while standing on our good node
                ListNode<Integer> tmp = node;
                while(node.next!= null && node.next.value == k){
                    node = node.next;
                }
                //if node.next ended in null
                if(node.next == null)
                    tmp.next = null;
                else
                    tmp.next = node.next;
                //set current node
                node = tmp;
            }
            //if(node!=null)
            node = node.next;
        }

        return l;
    }




    static class ListNode<T>
    {
        T value;
        ListNode<T> next;

        ListNode(){}

        ListNode(T x){
            value = x;
        }
    }
}
