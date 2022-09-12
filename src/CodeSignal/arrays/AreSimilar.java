package CodeSignal.arrays;

public class AreSimilar
{
    public static void main(String[] args) {
        int[] a = {1,2,2};
        int[] b = {2,1,1};

        System.out.print(areSimilar(a,b));
    }

    /**
     *
        Two arrays are called 'similar' when one can be obtained from the other by swapping at most 1 pair in one of them.
     example
     a = [1,2,3]  b = [2,1,3] are similar
     a = [1,2,2]  b = [2,1,1] are not

     constraints: same length, length > 2

     [!]    HAVEN'T CONFIRMED THIS ONE  [!]
     */
    static boolean areSimilar(int[]a, int[]b)
    {
        /**
         * sol1> check each match, if not matching by >2 then not similar. If ==2 try swapping the non matching.
         * If only 1 not matching also false
         */
        int nonMatches = 0;
        int[] pair = {-1,-1};
        //check all the matches
        for(int i=0; i<a.length; i++)
        {
            if( a[i] != b[i] )
            {
                nonMatches++;
                if(nonMatches > 2)  return false;
                //store the indexes to be swapped in case nonMatches is 2
                if(pair[0]==-1) pair[0] = i;
                else            pair[1] = i;
            }
        }

        if(nonMatches == 0) return true;    //identical

        if(nonMatches == 1) return false;   //swapping will alter one of the correct elements with a wrong element

        if(nonMatches == 2){
            if( a[ pair[0] ] == b[ pair[1] ] && a[ pair[1] ] == b[ pair[0] ])
            {
                return true;
            }
        }

        return false;
    }
}
