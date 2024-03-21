package leet.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate
{
    /**
     *
            Apparently it's always good to sort these kind of cases and then we can work over that preprocessed array
     */
    public static void main(String[] args)
    {
        int[] nums = {1,2,3,4,4};

        System.out.println(containsDuplicate(nums));
    }

    /**
     * Given an integer array nums, return true if any value appears at least twice in the array,
     * and return false if every element is distinct.
     */
    static boolean containsDuplicate(int[] nums)
    {
        /**
         * Brute force
         *      *didn't even run last couple of tests, ran out of allowed time
         */
        //i runs through the array
/*        for(int i=0; i<nums.length-1; i++)
        {   //j compares i to the rest
            for(int j=i+1; j<nums.length; j++)
            {
                if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
*/
        /**
         * streams
         *      not very efficient either but better than 1st approach
         */
        //return Arrays.stream(nums).distinct().count() == nums.length? false : true;

        /**
         * using map
         *
         */
/*        HashMap<Integer, Integer> hm = new HashMap<>(nums.length);
        //map the array, if in the process we encounter a match, return true for a duplicate
        for(int i=0; i<nums.length; i++)
        {
            if(hm.containsKey(nums[i]))
                return true;    //we could increase here the num of ocurrences to know how many we have of each and not return
            else{
                hm.put(nums[i], 1);
            }
        }
        return false;
*/
        /**
         *  similarly, using a set (these 2 seem to be the best performance)
         */
/*        HashSet<Integer> hs = new HashSet<>(nums.length);
        for(int x : nums)
        {
            if(hs.contains(x))
                return true;
            hs.add(x);
        }
        return false;
*/

        /**
         * Sorting first
         *      not as efficient as with maps
         */
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++)
        {
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }
}
