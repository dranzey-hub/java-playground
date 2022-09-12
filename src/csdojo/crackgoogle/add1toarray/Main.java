package csdojo.crackgoogle.add1toarray;

import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
        int[] x = add1(new int[]{9,9,9});

        int[] z = add1(new int[]{2,1,9});

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(z));
    }

    /**
     * Time complexity: O(n)
     */
    static int[] add1(int[] a)
    {
        for(int i=a.length-1; i>=0; i--)
        {
            //add 1
            a[i]++;
            //keep carrying?
            if(a[i]==10)
            {   //if carry goes all the way, that means [9,9,9,...]
                if(i==0){
                    //for this case we need to create new array of length a.length+1
                    int[] b = new int[a.length+1];
                    b[0] = 1;
                    for(int j=1; j<b.length; j++)
                        b[j] = 0;
                    return b;
                }
                else{
                    //else just keep carry on next iteration
                    a[i] = 0;
                }
            }
            else    //stop carry, stop adding, we're done
                break;
        }
        return a;
    }
}
