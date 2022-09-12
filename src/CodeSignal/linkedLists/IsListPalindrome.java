package CodeSignal.linkedLists;

import CodeSignal.linkedLists.RemoveKFromList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class IsListPalindrome
{
    public static void main(String[] args)
    {
        ListNode<Integer> l = new ListNode<>(1);
        l.next = new ListNode<Integer>(1000000000);
        l.next.next = new ListNode<Integer>(-1000000000);
        l.next.next.next = new ListNode<Integer>(-1000000000);
        l.next.next.next.next = new ListNode<Integer>(1000000000);
        l.next.next.next.next.next = new ListNode<Integer>(1);
        //l.next.next = new ListNode<Integer>(10);

        isListPalindrome(l);
    }


    /**
     Given a singly linked list of integers, determine whether or not it's a palindrome.


                Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in l,
        since this is what you'll be asked to do during an interview.
     */
    static boolean isListPalindrome(ListNode<Integer> l)
    {
        /**
            easy sol first
         */
        ListNode<Integer> node = l;
        List<Integer> a = new ArrayList<>();
        //put list into an array
        while(node != null){
            a.add(node.value);
            node = node.next;
        }
        //use 2 indices and compare to the center
        for(int i=0, j=a.size()-1; i<j; i++, j--){
            if(!a.get(i).equals(a.get(j)))
                return false;
        }

        return true;


        /**
            Kind of O(n) time and O(1) memory: 2 pointers, fast and slow, fast advances 2 steps, slow 1;
         This will position s at the middle of the list (if fast ends up in null we have an even list, otherwise
         s is positioned at very center (odd list)). While slowly going through the list we should reverse this first half,
         such that when we arrive at the center we can start comparing both halfves (from root node comparing as s advances 2nd half)
         */
    }

}
