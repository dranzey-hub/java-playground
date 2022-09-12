package leet.arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSorted
{

    public static void main(String[] args) {

        //int[] nums = {-100, -100, -1, -1, 0, 0, 0, 1, 1, 1000, 1000};
        int[] nums = {1, 1, 2};
        //int[] nums = {1, 1};
        //int[] nums = {1, 1, 1, 1};

        int ans = removeDuplicates(nums);

        System.out.println("\n\n\narray length: "+ans+" and new array> "+ Arrays.toString(nums));
    }

    /**
     *
     *  Poor time performance. Another way without doing a manual shift?
     */
    public static int removeDuplicates(int[] nums)
    {
        int len = nums.length; int dups = 0;
        boolean noShift = false;

        for(int i = 0; i < len-1; i++)
        {
            //next is duplicate
            if(nums[i] == nums[i+1] /*&& i+1 < len*/)
            {
                do{
                    dups++;
                    if(i+dups+1 == len){    //reached the end of array and all remaining are dups
                        noShift = true;
                        break;
                    }

                } while(nums[i+dups] == nums[i+dups+1]);  //continue duplicates?

                //shift left duplicates
                if(!noShift){
                    for(int j=i+dups+1; j < len; j++)
                    {
                        nums[j-dups] = nums[j];
                    }
                }

                len -= dups;
                dups = 0;
            }
            System.out.println("index: "+i+" > "+Arrays.toString(nums)+"  length: "+len);
        }

        return len;
    }
}
