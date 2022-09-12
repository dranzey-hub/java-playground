package leet.linkedlist;

public class DeleteNode {
    public static void main(String[] args)
    {
        DeleteNode dn = new DeleteNode();
        ListNode root = dn.new ListNode(1);

        root.next = dn.new ListNode(2);
        root.next.next = dn.new ListNode(3);
        root.next.next.next = dn.new ListNode(4);

        dn.deleteNode(root.next.next);
    }

    /**
     * Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.
     *
     * It is guaranteed that the node to be deleted is not a tail node in the list.
     */
    public void deleteNode(ListNode node)
    {
        /**
         * We cannot go back, but we can convert the given node to the next node and delete that one instead.
         */
        //next
        ListNode tmp = node.next;

        //convert node to be deleted into next
        node.value = node.next.value;
        node.next = node.next.next;

        //delete next
        tmp.next = null;
    }



    class ListNode
    {
        Integer value = null;
        ListNode next = null;

        ListNode (int value)
        {
            this.value = value;
        }
    }
}
