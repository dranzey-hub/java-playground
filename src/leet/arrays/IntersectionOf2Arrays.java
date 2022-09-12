package leet.arrays;

import java.util.Arrays;

public class IntersectionOf2Arrays
{
    public static void main(String[] args)
    {
        int[] nums1 = {2,1};
        int[] nums2 = {1,1};

        intersect(nums1, nums2);
    }

    /**
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
     *
     * ex --
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [4,9]
     *          [9,4] is also accepted.
     *
     *
     *          Constraints:
     *
     * 1 <= nums1.length, nums2.length <= 1000
     * 0 <= nums1[i], nums2[i] <= 1000
     */
    static int[] intersect(int[] nums1, int[] nums2)
    {
        return  nums1.length <= nums2.length? algorithm(nums1, nums2) : algorithm(nums2, nums1);
    }

    /**
     *
        time's not great
     */
    static int[] algorithm(int[] numsLess, int[] numsMore)
    {
        //intersection at most the size of lesser array
        int[] intersection = new int[numsLess.length];

        //recorre, si coincide se agrega a interseccioon y se quema ese nuumero
        int size = 0;
        for(int i=0; i<numsLess.length; i++)
        {
            for(int j=0; j<numsMore.length; j++)
            {
                if( numsMore[j] > -1 ) {
                    if (numsLess[i] == numsMore[j]) {
                        intersection[size] = numsLess[i];      //intersect
                        size++;
                        numsMore[j] = -1;                   //remove
                        break;                              //i++
                    }
                } //else continue;            //j++
            }
        }
        //chop array
        intersection = Arrays.copyOfRange(intersection, 0, size);
        //System.out.print(Arrays.toString(intersection));
        return intersection;
    }
}
