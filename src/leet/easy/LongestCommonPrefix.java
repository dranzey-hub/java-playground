package leet.easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};

        System.out.print(longestCommonPrefix(strs2));
    }

    /**
     * Runtime: 1 ms, faster than 74.23% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 37.9 MB, less than 80.70% of Java online submissions for Longest Common Prefix.
     *
     */

    public static  String longestCommonPrefix(String[] strs)
    {
        if(strs.length == 0)
            return "";

        int min = findMinLenStr(strs);
        int common = 0;

        for(int x = 0; x<min; x++){
            for(int i=0; i<strs.length-1; i++)
            {
                if(strs[i].charAt(x) != strs[i+1].charAt(x))
                    return strs[0].substring(0, common);
            }
            common++;
        }
        return strs[0].substring(0,common);
    }



    public static int findMinLenStr(String[] strs){
        int min = strs[0].length();
        for(int i=1; i<strs.length; i++)
        {
            if(strs[i].length() < min)
                min = strs[i].length();
        }
        return min;
    }
}
