package leet.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2,2,1,0,0,0};

        System.out.print(singleNumber(nums));
    }


    /**
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     *
     * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
     */

    static int singleNumber(int[] nums)
    {
        /**
         * Sorting (better performance than mapping)
         */
        Arrays.sort(nums);

        boolean dup = false;
        for(int i=0; i<nums.length; i++){
            if(i == nums.length-1 && !dup) return nums[i];
            if(nums[i] == nums[i+1]) {
                dup = true;
            }
            else{   //a change
                if(dup)
                    dup = false;    //prev was a duplicate, it's ok
                else
                    return nums[i];   //prev was not duplicate, this is the one
            }
        }
        return Integer.MAX_VALUE;   //should not get here


        /**
         * mapping (not so great performance)
         */
 /*       HashMap<Integer, Integer> hm = new HashMap<>(nums.length);
        for(int n : nums)
        {
            if(hm.containsKey(n)){
                hm.put(n, hm.get(n)+1);
            }else   hm.put(n, 1);
        }
        if(hm.containsValue(1)){
            Integer ans = null;
            for(Map.Entry e : hm.entrySet()){
                if((Integer)e.getValue() == 1)
                    ans = (Integer)e.getKey();
            }
            return ans;
        }else {/*throw an exception*//*return Integer.MAX_VALUE;}
*/
    }
}
