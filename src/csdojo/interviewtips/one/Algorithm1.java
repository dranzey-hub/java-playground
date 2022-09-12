package csdojo.interviewtips.one;

/*
    Brute Force

    Given 2 arrays and a target number, retrieve the 2 numbers (one of each array) that sums closest to target
*/
public class Algorithm1
{
    private int[] array1, array2;
    private int target;

    public Algorithm1(int[] a1, int[] a2, int target)
    {
        array1 = a1;    //assume same length a1 and a2
        array2 = a2;
        this.target = target;
    }


    public void exe()
    {
        //best result so far
        int bestResult = 2147483647;
        //index pair (a1, a2) of the best sum
        int[] pair = new int[2];
        boolean found = false;

        for(int i=0; i< array1.length; i++)
        {
            for(int j=0; j< array2.length; j++)
            {
                int sum = array1[i]+array2[j];
                int dif = Math.abs(sum - target);
                //found it
                if(dif == 0){
                    //return i,j pair
                    System.out.println("Found a pair that adds up to "+target+": ("+array1[i]+", "+array2[j]+")");
                    found = true;
                }
                else if(!found && bestResult > dif){
                    //best result beat
                    bestResult = dif;
                    pair[0] = i;
                    pair[1] = j;
                }
            }
        }
        //didn't find perfect match but..
        if(!found)
            System.out.println("No pair adds up to "+target+", but one closest is ("+array1[pair[0]]+", "+array2[pair[1]]+") adding up to "+(array1[pair[0]]+array2[pair[1]]));
    }
}