package ms.ejercicio2;

public class Main {

    public static void main(String[] args) {

        System.out.print(solution(new int[]{1, 2, 3, 3}, new int[]{2, 3, 1, 4}, 4));
    }

    static int solution(int[] A, int[] B, int N)
    {
        //first get all possible pairs
        int[][] possibles = getAllCityCombinations(N);

        int total = 0;
        int highestTotal = 0;

        //then check each number of each pair, how many times we have a match against A[i] or B[i]
        for(int i=0; i<possibles.length; i++)
        {
            for(int k=0; k<N; k++)
            {
                System.out.print("Comparing possible city pair ("+possibles[i][0]+", "+possibles[i][1]+") against network "+A[k]+", "+B[k]);
                if(possibles[i][0]==A[k]||possibles[i][0]==B[k] || possibles[i][1]==A[k]||possibles[i][1]==B[k])
                    {total++; System.out.print("\tmatch!");}
                System.out.println();
            } System.out.println(total);
            if(total > highestTotal)
                highestTotal = total;
            total = 0;
        }
        return highestTotal;
    }


    static public int[][] getAllCityCombinations(int n)
    {
        int total = 0;
        for(int i=n-1; i>0; i--)
        {
            total += i;
        }   System.out.println("total combos: "+total);
        int[][] combos = new int[total][];
        System.out.println(java.util.Arrays.deepToString(combos));
        int t = 0;
        for(int i=0; i<n-1; i++)
        {
            for(int j=i+1; j<n; j++)
            {combos[t] = new int[]{i+1,j+1}; t++; System.out.println(combos[i][0]+", "+combos[i][1]);}

        }System.out.println(java.util.Arrays.deepToString(combos));
        return combos;
    }
}
