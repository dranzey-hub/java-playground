package codewars.missingLetter;

/**
 * Write a method that takes an array of consecutive (increasing) letters as input and that returns the missing letter in the array.
 *
 * You will always get an valid array. And it will be always exactly one letter be missing. The length of the array will always be at least 2.
 * The array will always contain letters in only one case.
 *
 * Example:
 *
 * ['a','b','c','d','f'] -> 'e'
 * ['O','Q','R','S'] -> 'P'
 *
 * (Use the English alphabet with 26 letters)
 */
public class FindMissingLetter
{
    public static void main(String[] args)
    {
        String s = "abcdf";
        String s2 = "OQRS";

        System.out.println(findMissingLetter(s.toCharArray()));
        System.out.println(findMissingLetter(s2.toCharArray()));
    }


    public static char findMissingLetter(char[] chars)
    {
        char curr = chars[0];

        for(int i=1; i<chars.length; i++)
            if(++curr != chars[i]) return new Character(curr);

        return ' ';   //404
    }
}
