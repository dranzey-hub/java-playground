package leet.medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        //System.out.print(isPalindrom("cxaaxc"));
        longestPalindrome(s);
    }

    /**
     *  Return longest palindrome substring.
     *
     *  Idea is ok, just need a cleaner code and more efficient. (expand around center)
     *
     */
    public static String longestPalindrome(String s)
    {
        if(s.length() < 2)
            return s;

        int pivot = s.length()/2;

        String longest = "";
        boolean flag = true;    //flag to tell when it's over

        int longest_int = 0;
        for(int i=pivot,j=pivot+1; i>0 || j<s.length()-1; i--, j++)
        {
            boolean left_flag=true, left_flag2 = true, right_flag = true, right_flag2 = true;
            int l0=0,l1=0,ll0=0,ll1=0,r0=0,r1=0,rr0=0,rr1=0;
            int local_max = 0;
            for(int limits=1; /*i-limits>-1 || i+limits<s.length() || j-limits>-1 || j+limits<s.length()*/flag; limits++)
            {
                //get substring around pivot char (or chars, in palindroms we have 2 cases, when length is pair and odd),
                //make the selection grow upon every iteration, stop when no longer palindrom and store the longest.
                //repeat for other pivot (if we found a palindrom over the inner substrings that goes all the way without breaking,
                //return that substring since all subsequent strings would be of lesser length


                //case growing from single pivot
                if(left_flag)
                {
                    //String sub_lftcentered = s.substring(i-limits, i+limits);
                    if(!isPalindrom(s, i-limits, i+limits)) {
                        left_flag = false;
                        l0 = i-limits+1; l1 = i+limits-1;
                    }
                    else{
                        l0 = i-limits; l1 = i+limits;}
                }
                //case 2 char pivot (growing from center 2 chars)
                if(left_flag2)
                {
                    //String sub_lftcentered2 = s.substring(i-limits, i+limits -1);
                    if(!isPalindrom(s, i-limits, i+limits -1)){
                        left_flag2 = false;
                        ll0 = i-limits+1; ll1 = i+limits-2;
                    }else{
                        ll0 = i-limits; ll1 = i+limits-1;}

                }
                //same for the pivot that advances to the right
                //case growing from single pivot
                if(right_flag)
                {
                    //String sub_rgtcentered = s.substring(j-limits, j+limits);
                    if(!isPalindrom(s, j-limits, j+limits)){
                        right_flag = false;
                        r0 = j-limits+1; r1 = j+limits-1;
                    }else{
                        r0 = j-limits; r1 = j+limits;}
                }
                //case 2 char pivot (growing from center 2 chars)
                if(right_flag2)
                {
                    //String sub_rgtcentered2 = s.substring(j-limits, j+limits -1);
                    if(!isPalindrom(s, j-limits, j+limits -1)) {
                        right_flag2 = false;
                        rr0 = j-limits+1; rr1 = j+limits-2;
                    }else{
                        rr0 = j-limits; rr1 = j+limits -1;}
                }

                int length_left = l1-l0 +1; int length_left2 = ll1-ll0 +1;
                int length_right =r1-r0 +1; int length_right2= rr1-rr0 +1;
                if(length_left>local_max)
                    local_max = length_left;
                if(length_left2>local_max)
                    local_max = length_left2;
                if(length_right>local_max)
                    local_max = length_right;
                if(length_right2>local_max)
                    local_max = length_right2;

                if(local_max>longest_int)
                    longest_int = local_max;

                if(!left_flag && !left_flag2 && !right_flag && !right_flag2) {
                    flag = false;

                }


            }
        }

        System.out.println("LONGEST int "+longest_int);

        return longest;
    }

    public static boolean isPalindrom(String s, int l, int r)
    {
        String sub = s.substring(l,r+1);
        int pivot = sub.length()/2;

        for(int i=0; i<pivot; i++)
        {try{
            if(sub.charAt(i) != sub.charAt(sub.length()-1-i))
                return false;} catch(Exception e){return false;}
        }
        return true;
    }

/*
    public static boolean isPalindrom(String s)
    {
        int pivot = s.length()/2;

        for(int i=0; i<pivot; i++)
        {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }
*/
}
