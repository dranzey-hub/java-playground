package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A2ItemsInContainers
{
    public static void main(String[] args)
    {
        String s = "|**|*|*||||";
        List<Integer> si = new ArrayList<>(Arrays.asList(1,1,1));
        List<Integer> ei = new ArrayList<>(Arrays.asList(5,6,10));

        numberOfItems(s, si, ei);
    }


    /**
     Amzn wants to know how many inventory it's in their closed compartments.

     Given a string consisting on items ('*') and closed compartments (denoted by '|'),
     an array of start and end indices, determine the number of items within closed compartments for each substring.

     Example:
     s = '|**|*|*'      startIndices = [1,1], endIndices = [5,6]

     sub1 = '|**|*'  => 2          sub2 = '|**|*|'  => 3

     output: [2, 3]
     */
    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices)
    {
        //for each pair of indices
        for(int i=0; i<startIndices.size(); i++)
        {
            String sub = s.substring(startIndices.get(i)-1, endIndices.get(i));
            System.out.print(sub);

            System.out.println("\t has "+checkHowManyItems(sub)+" items.");
        }


        return null;
    }


    public static int checkHowManyItems(String s)
    {
        /**
         * first off straight brute
         *                  ... we could improve since we're doing the same each pass, perhaps only do 1 pass
         *                  on the whole string and store item count at certain indices
         */

        boolean opening = false;
        //boolean closing = false;
        int count = 0; int tmpcount = 0;
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);

            if(c == 124){// |
                if(!opening)
                    opening = true;
                else
                    count = tmpcount;
            }

            else if(c == 42 && opening){// *
                tmpcount++;
            }
        }

        return count;
    }

}
