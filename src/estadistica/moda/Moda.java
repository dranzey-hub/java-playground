package estadistica.moda;

public class Moda {

    //private int moda;

    public int find(int[] array){
        int moda = -1;
        int max_recurrencies = 0;

        for (int a:array)
        {
            int max_local_recurrency = 0;
            for(int i=0; i<array.length; i++)
            {
                if(a == array[i]){
                    max_local_recurrency++;
                }
                if(max_local_recurrency>max_recurrencies){
                    max_recurrencies = max_local_recurrency;
                    moda = a;
                }
            }
        }

        return moda;
    }

}
