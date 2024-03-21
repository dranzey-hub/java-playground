package CodeSignal.linkedLists;

import CodeSignal.linkedLists.RemoveKFromList.ListNode;

import java.util.List;

import static CodeSignal.linkedLists.RemoveKFromList.print;

public class MergeTwoLinkedLists
{
    public static void main(String[] args) {
        ListNode<Integer> l1 = new ListNode<>(1);
        l1.next = new ListNode<>(2);
        l1.next.next = new ListNode<>(3);

        ListNode<Integer> l2 = new ListNode<>(4);
        l2.next = new ListNode<>(5);
        l2.next.next = new ListNode<>(6);

        print(mergeTwoLinkedLists(l1,l2));

        ListNode<Integer> l3 = new ListNode<>(1);
        l3.next = new ListNode<>(1);
        l3.next.next = new ListNode<>(2);
        l3.next.next.next = new ListNode<>(4);

        ListNode<Integer> l4 = new ListNode<>(0);
        l4.next = new ListNode<>(3);
        l4.next.next = new ListNode<>(5);

        print(mergeTwoLinkedLists(l3,l4));
    }

    /**
     Given two singly linked lists sorted in non-decreasing order, your task is to merge them. In other words,
     return a singly linked list, also sorted in non-decreasing order, that contains the elements from both original lists.

     Note: Your solution should have O(l1.length + l2.length) time complexity

        Ex
     For l1 = [1, 2, 3] and l2 = [4, 5, 6], the output should be
     mergeTwoLinkedLists(l1, l2) = [1, 2, 3, 4, 5, 6];
     For l1 = [1, 1, 2, 4] and l2 = [0, 3, 5], the output should be
     mergeTwoLinkedLists(l1, l2) = [0, 1, 1, 2, 3, 4, 5].
     */
    static ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2)
    {
        ListNode<Integer> merged;
        ListNode<Integer> m_index;
        ListNode<Integer> l1_index = l1;
        ListNode<Integer> l2_index = l2;

        //init
        if(l1_index.value < l2_index.value){
            merged = new ListNode<>(l1_index.value);
            m_index = merged;
            l1_index = l1_index.next;
        } else{
            merged = new ListNode<>(l2_index.value);
            m_index = merged;
            l2_index = l2_index.next;
        }

        //traverse both lists and merge the lesser numbers first
        while(l1_index!=null && l2_index!=null){
            if(l1_index.value < l2_index.value){
                m_index.next = new ListNode<>(l1_index.value);
                m_index = m_index.next;
                l1_index = l1_index.next;
            } else{
                m_index.next = new ListNode<>(l2_index.value);
                m_index = m_index.next;
                l2_index = l2_index.next;
            }
        }
        //if only one of the lists finished
        if(l1_index!=null || l2_index!=null){
            ListNode<Integer> rem_index = l1_index!=null? l1_index : l2_index;
            while(rem_index!=null){
                m_index.next = new ListNode<>(rem_index.value);
                m_index = m_index.next;
                rem_index = rem_index.next;
            }
        }

        return merged;
    }


/*
    static class ListNode<T> //implements Comparable<T>
    {
        T value;
        ListNode<T> next;

        ListNode(){}

        ListNode(T x){
            value = x;
        }*/
      /*  
        @Override
        public int compareTo(T o){
            return this.value - o;
        }*/
    //}
}
