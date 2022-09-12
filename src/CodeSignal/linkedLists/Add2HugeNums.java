package CodeSignal.linkedLists;

import CodeSignal.linkedLists.RemoveKFromList.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Add2HugeNums
{
    public static void main(String[] args)
    {
        ListNode<Integer> a = new ListNode<>(9876);
        a.next = new ListNode<>(5432);
        a.next.next = new ListNode<>(1999);

        ListNode<Integer> b = new ListNode<>(1);
        b.next = new ListNode<>(8001);

        addTwoHugeNumbers(a, b);
    }

    /**
     You're given 2 huge integers represented by linked lists. Each linked list element is a number from 0 to 9999
     that represents a number with exactly 4 digits. The represented number might have leading zeros. Your task is to
     add up these huge integers and return the result in the same format.

        Ex
     For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
     addTwoHugeNumbers(a, b) = [9876, 5434, 0].

     Explanation: 987654321999 + 18001 = 987654340000.

     For a = [123, 4, 5] and b = [100, 100, 100], the output should be
     addTwoHugeNumbers(a, b) = [223, 104, 105].

     Explanation: 12300040005 + 10001000100 = 22301040105.
     */
    static ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b)
    {
        /**
         * Reverse lists by putting them into stacks, iterate through each pair of numbers adding them
         * and pushing the result into another stack. Finally just convert the stack back to a list of nodes
         */

        Stack<Integer> stackA = reversedListStack(a);
        Stack<Integer> stackB = reversedListStack(b);
        Stack<Integer> stackR = new Stack<>();

        boolean isABigger = stackA.size() > stackB.size()? true : false;

        Stack<Integer> biggerStack = isABigger? stackA : stackB;

        boolean carr = false;

        while(!biggerStack.empty() || carr){
            int A = stackA.empty()? 0 : stackA.pop();
            int B = stackB.empty()? 0 : stackB.pop();

            int sum = A + B;
            if(carr) {
                sum++;
                carr = false;
            }
            if( sum > 9999 ){
                sum -= 10000;
                carr = true;
            }

            stackR.push(sum);
        }


        ListNode<Integer> ret = new ListNode<>();
        ListNode<Integer> node = ret;

        while(!stackR.empty()){
            node.value = stackR.pop();
            if(!stackR.empty()){
                node.next = new ListNode<>();
                node = node.next;
            }
        }

        return ret;
    }

    static Stack<Integer> reversedListStack (ListNode<Integer> l){
        Stack<Integer> stack = new Stack<>();
        ListNode<Integer> node = l;
        while(node != null){
            stack.push(node.value);
            node = node.next;
        }
        return stack;
    }

}
