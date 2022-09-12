package leet.medium;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {

        String s = "abcabcbb";
        System.out.print(lengthOfLongestSubstring(s));
    }

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     *
     *           ...a bit better than the other algorithm, but still very poor runtime compared to other submissions of leetcode
     */
    public static int lengthOfLongestSubstring(String s)
    {
        if(s.length() == 0 || s.length() == 1)
            return s.length();

        HashMap<Character, Boolean> hm = new HashMap<>();
        if(mapSymbols(s, hm))
            return s.length();

        int longest = 1;

        for(int i=0; i<s.length()-1; i++)
        {
            String sub = s.substring(i);
            int local_max = 0;
            for(int j=0; j<sub.length(); j++)
            {
                if(hm.get(sub.charAt(j))){
                    break;
                }else{
                    hm.put(sub.charAt(j), Boolean.TRUE);
                    local_max++;
                }
            }
            if(local_max > longest)
            {
                longest = local_max;
            }
            if(i != s.length()-1)
                cleanHashMap(hm);
        }

        return longest;
    }

    public static void cleanHashMap(HashMap<Character, Boolean> map)
    {
        for(java.util.Map.Entry e : map.entrySet()){
            e.setValue(Boolean.FALSE);
        }
    }

    public static boolean mapSymbols(String s, HashMap<Character, Boolean> map)
    {
        boolean allUnique = true;

        for(int i=0; i<s.length(); i++)
        {
            if(map.containsKey(s.charAt(i)))
                allUnique = false;
            else
                map.put(s.charAt(i), new Boolean(false));
        }
        return allUnique;
    }


    /**
     *
     * 1st attempt (poor runtime and memory usage)
     *
     */

    public static int lengthOfLongestSubstring0(String s)
    {
        if(s.length() == 0 || s.length() == 1)
            return s.length();

        int longest = 1;
        for(int h=0; h<s.length(); h++)
        {
            for(int i=h; i<s.length()-1; i++)
            {//System.out.println("i "+i);
                int local_max = 1;
                int j = i;
                boolean flag = false;
                while(j>h-1)
                {//System.out.println(s.charAt(j)+" = "+s.charAt(i+1)+"? ");
                    if(s.charAt(j) == s.charAt(i+1)){
                        flag = true; System.out.println("break!");
                        break;
                    }
                    local_max++;//System.out.println("local max "+local_max);
                    j--;
                }
             /* if(!flag)
                  local_max = i+2;*/
                if(local_max > longest)
                    longest = local_max;	// #eficiencia i0> if longest == s.length stop , i1> if longest == s.length-1 stop ...
                if(flag)
                    break;
            }
        }

        return longest;
    }
}
