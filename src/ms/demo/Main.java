package ms.demo;

public class Main {

    public static void main(String[] args) {
        int[] a = {1,3,6,4,1,2};    //5
        int[] b = {-1,-3};          //1
        int[] c = {1,2,3};          //4

        System.out.println(solution(a));
    }

    /**
     * returns the smallest positive integer (> 0) not in the array
     */
    static int solution(int[] a)
    {
        int x = 1; boolean b = false;

        java.util.Arrays.sort(a);
        //for(int j=0; j<a.length; j++) System.out.print(a[j]+", ");
        for(int i=0; i<a.length; i++)
        {
            if(!b)
            {
                if(a[i] <= 0)   continue;
                else            {b = true; i--;}
            }
            //past non positive numbers
            else
            {
                if(a[i] == x)
                {
                    //if it's not last item
                    if(i < a.length-1)
                    {   //check next item for duplicates
                        if(a[i+1] == x) continue;
                        else x++;
                    }
                    else x++;//last item
                }
                else
                    break;
            }
        }
        return x;
    }
}
