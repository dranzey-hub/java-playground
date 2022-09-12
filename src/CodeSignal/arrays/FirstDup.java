package CodeSignal.arrays;

import java.util.HashMap;

public class FirstDup {

    public static void main(String[] args) {

    }

    /**
     Given an array a that contains only numbers in the range from 1 to a.length, find the first duplicate number
     for which the second occurrence has the minimal index. In other words, if there are more than 1 duplicated numbers,
     return the number for which the second occurrence has a smaller index than the second occurrence of the other number does.
     If there are no such elements, return -1.

     For a = [2, 1, 3, 5, 3, 2], the output should be firstDuplicate(a) = 3.
     */
    static int firstDuplicate(int[] a)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<a.length; i++)
        {
            if(map.containsKey(a[i])){
                return a[i];
                //not really needed if counter == 2
                /*int c = map.get(a[i]);
                c++;
                if(c == 2)  return a[i];
                map.put(a[i], c);*/
            }else{
                map.put(a[i], 1);
            }
        }

        return -1;
    }
}




