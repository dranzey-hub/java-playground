package leet.easy;

public class TwoSum {

    public static void main(String[] args) {



    }

    /*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].


            your memory usage beats 99.48% of java submissions!!!
     */
    public static int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];

        for(int i=0; i<nums.length; i++)
        {
            int complement = target-nums[i];

            for(int j=0; j<nums.length; j++)
            {
                if(j==i)
                    continue;

                if(nums[j] == complement)
                {
                    result[0]=i; result[1]=j;
                }
            }
        }
        return result;
    }
}
