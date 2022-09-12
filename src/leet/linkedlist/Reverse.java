package leet.linkedlist;

import java.util.Stack;

public class Reverse
{

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        for(int i = 1; i<10; i++){
            node.next = new ListNode(i);
            node = node.next;
        }

        printList(head);

        head = reverseList(head);

        printList(head);
    }

    static void printList(ListNode list)
    {
        ListNode n = list;
        System.out.print("\nList> "+n.val);
        while(n.next!=null){
            System.out.print(", "+n.next.val);
            n = n.next;
        }
    }


    /**
     Given the head of a singly linked list, reverse the list, and return the reversed list.
     */
    static ListNode reverseList(ListNode head)
    {
        if(head == null)    return null;

        Stack<Integer> stack = new Stack<>();
        ListNode pointer = head;
        stack.push(head.val);

        //iterate list and push values into stack
        while(pointer.next != null)
        {
            pointer = pointer.next;
            stack.push(pointer.val);
        }
        //go back to head and pop stack values into list
        pointer = head;
        pointer.val = stack.pop();
        while(pointer.next != null)
        {
            pointer = pointer.next;
            pointer.val = stack.pop();
        }

        return head;
    }

}
