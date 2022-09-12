package leet.arrays;

import java.util.Arrays;

public class RotateKSteps
{
    public static void main(String[] args)
    {
        int[] nums = {1,2,3,4,5,6,7};

        rotate(nums, 8);


    }


    /**
     * Given an array, rotate (shift) the array to the right by k steps, where k is non-negative.
     *
     */
    static void rotate(int[] nums, int k)
    {
        if(k == 0)  return;

        if(nums.length < 2) return;

        //more steps than length? (or steps equal length)
        if(k > nums.length-1){
            //effective k
            k = k%nums.length;
            //no movement
            if(k == 0)  return;
        }


        int[] tmp = new int[k];
        tmp = Arrays.copyOfRange(nums, nums.length-k, nums.length);

        //shift to the right
        for(int i=nums.length-1; i>k-1; i--)
        {
            nums[i] = nums[i-k];
        }
        //paste the shifted nums to the beginning of the array
        for(int i=0; i<tmp.length; i++)
        {
            nums[i] = tmp[i];
        }
        System.out.println(Arrays.toString(nums));
    }
}
