package leet.linkedlist;

public class RemoveNthFromEnd
{
    public static void main(String[] args)
    {
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);

        removeNthFromEnd(root, 4);
    }

    /**
      Given the head of a linked list, remove the nth node from the end of the list and return its head.

      Follow up: Could you do this in one pass?

     Constraints:
     The number of nodes in the list is sz.
     1 <= sz <= 30
     0 <= Node.val <= 100
     1 <= n <= sz
     */
    public static ListNode removeNthFromEnd(ListNode head, int n)
    {
        if(head.next == null) { //only head, remove
            head = null;
            return head;
        }
        //index             //delayed index     //counter of steps
        ListNode i = head;  ListNode d = head;  int c = 0;

        while(i.next != null)
        {
            i = i.next;
            c++;
            if(c > n){  //d is behind i n steps
                d = d.next;
            }
        }// at this point d.next is the node to be removed
        //except if n is same size of list:
        if(c<n){
            head = d.next;   //remove head
        }
        else{
            d.next = d.next.next;
        }

        return head;
    }
}
