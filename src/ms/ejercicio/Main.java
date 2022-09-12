package ms.ejercicio;

public class Main {
    public static void main(String[] args) {
        int [] A = {3,2,-2,5,-3};

        System.out.print(solution(A));
    }

    static int solution(int[] A)
    {
        //1st sort the array
        java.util.Arrays.sort(A);
        //if no negative numbers then there's no point in analyzing further, solution is trivial
        if(A[0] >= 0)
            return 0;

        //aux vars
        int left = A[0];

        //go through the array
        for(int i=0; i<A.length; i++)
        {
            for(int j=A.length-1; j>0; j--)
            {
                if(Math.abs(A[i]) == A[j])
                    return A[j];
            }
        }
        return 0;
    }
}
