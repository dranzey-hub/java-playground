package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class A1OptimizeBoxWeights
{
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        //list.add(5);list.add(3);list.add(2);list.add(4);list.add(1);list.add(2);    //output: [4,5]
        list.add(3);list.add(7);list.add(5);list.add(6);list.add(2);                //output: [5,7] [6,7]  by ascending weight order

        minimalHeaviestSetA(list);
    }


    /**
     *

     */
    public static List<Integer> minimalHeaviestSetA(List<Integer> arr)
    {
        //edge cases
        if(arr.size() < 3){
            if(arr.size() == 1)
                return null;    //not enough items to divide
            else{
                if(arr.get(0) == arr.get(1))
                    return null;    //A cannot be > B
                else if(arr.get(0) < arr.get(1))   //return both weights as A, B such that A > B
                    return new ArrayList<Integer>(Arrays.asList(arr.get(1),arr.get(0)));
                else
                    return new ArrayList<Integer>(Arrays.asList(arr.get(0),arr.get(1)));
            }
        }

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        arr.sort(comparator);

        //sum bigger 2 and see if > rest, keep going until A > B
        int sumA = 0; int sumB = 0;
        int ia = arr.size();
        do
        {
            sumA = sumB = 0;
            //add a heavy weight to A
            ia --;
            //if we added all weights but the lightest, that means all 0s in the array
            if(ia < 1){
                return null;    //no splitting can be done such that A > B
            }
            //sum weights for subset A
            for(int i=0; i<ia; i++){
                sumB += arr.get(i);
            }
            //sum weights for subset B
            for(int i=ia; i<arr.size(); i++){
                sumA += arr.get(i);
            }
        } while(sumA<sumB);

        //minimal number items for A
        int minA = arr.size() - ia;

        //now we have our first A and B, which set the minimum subset A (adding heaviest elements)
        //... pending to find if any other min subset A exists



        return null;
    }
}
