package leet.easy;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.print(reverse(9646324351l));
    }


    /**
     * Given a 32-bit signed integer, reverse digits of an integer.

     Example 1:

     Input: 123
     Output: 321
     Example 2:

     Input: -123
     Output: -321
     Example 3:

     Input: 120
     Output: 21
     Note:
     Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
     [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
     */
    public static int reverse(long x)
    {
        if(x>Integer.MAX_VALUE|| x<Integer.MIN_VALUE)
            return 0;

        Integer integer = new Integer((int)x);
        String s = integer.toString();

        boolean neg = s.charAt(0)=='-'?true:false;
        char [] reverseChars = new char[neg?s.length()-1:s.length()];
        for(int i=0; i<reverseChars.length; i++)
        {
            reverseChars[i] = s.charAt(s.length()-1-i);
        }

        s = new String(reverseChars);
        integer = new Integer(Integer.parseInt(s));
        if(neg)
            integer *= -1;


        return integer;
    }
}
