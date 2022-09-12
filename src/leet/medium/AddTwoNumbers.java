package leet.medium;

public class AddTwoNumbers {

    public static void main(String[] args) {

    }



    /*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.


            Your runtime beats 80.72%!!
            Your memory usage beats 87.15%!!!
     */




      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }



    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode total    = null;
        ListNode lastNode = null;
        boolean carr = false;
        while(l1!=null || l2!=null)
        {
            //int local_sum = (l1!=null?l1.val:0) + (l2!=null?l2.val:0);
            int x1 = 0;
            int x2 = 0;
            if(l1!=null){
                x1 = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                x2 = l2.val;
                l2 = l2.next;
            }
            int local_sum = x1 + x2;
            if(carr)
            { local_sum++; carr = false; }
            if(local_sum > 9)
            { local_sum -= 10; carr = true; }


            if(total == null)
            {
                total = new ListNode(local_sum);
                lastNode = total;
            }else{
                lastNode.next = new ListNode(local_sum);
                lastNode = lastNode.next;
            }
        }
        if(carr)
            lastNode.next = new ListNode(1);
        return total;
    }


}
