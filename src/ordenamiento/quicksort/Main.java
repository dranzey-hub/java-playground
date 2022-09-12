package ordenamiento.quicksort;
import java.util.Arrays;

//TODO: Use iterative approach instead to avoid memory problems

public class Main {

    public static void main(String[] args) {

        //int [] array = {64, 8, 0, 12, 100, 22, 56, 2, 1, 3, 45, 200, 38, 99, 44, 21, 95, 97, 5, 77, 7, 101, 103, 41};
        int n = 100000;
        int [] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = (int)Math.ceil(Math.random()*n);
        }

        long time = System.currentTimeMillis();
        //quicksort(array, 0, array.length-1);
        quicksort2(array, 0, array.length-1);
        time = System.currentTimeMillis() - time;


        System.out.println("t: "+time+" ms\n"+Arrays.toString(array));
    }

    /**
     *  chafa
     */
    static int[] quicksort(int[] a, int left, int right)
    {
        //pointers
        int l = left; int r = right;
        //size 1 set (or wrong input from the start)
        if(left >= right)
            return a;
        else
        {
            //set pivot  TODO: let's use a random pivot instead
            int pivot = left;
            int aux;
            //start quicksorting the set
            while(l != r) {
                //move right and left pointers to the left and right side of pivot accordingly
                while (a[r] >= a[pivot] && l < r)
                    r--;
                //cause of pivot choice??
                while (a[l] < a[pivot] && l < r)
                    l++;
                //need to swap?
                if (l != r) {
                    aux = a[r];
                    a[r] = a[l];
                    a[l] = aux;
                }
            }
            //pointers at pivot (l==r), do the same to the remaining subset
            quicksort(a, left, pivot-1);
            quicksort(a, pivot+1, right);
        }
        return a;
    }


    /**
     *  better
     */
    static void quicksort2(int a[], int lft, int rgt)
    {
        //TODO: use a random pivot
        int pivot = a[lft];
        //lft and rgt pointers
        int l = lft; int r = rgt;
        int aux;
        //start quicksorting around pivot
        while(l < r)
        {
            //advance pointers
            while(a[l] <= pivot && l<r)   l++;
            while(a[r] > pivot)           r--;
            //swap
            if (l < r)
            {
                aux  = a[l];
                a[l] = a[r];
                a[r] = aux;
            }
        }
        //pivot magically ends in place Ö
        a[lft] = a[r];
        a[r] = pivot;

        //if still subsets possible
        //left subset
        if(lft < r-1)
            quicksort2(a,lft,r-1);
        //right subset
        if(r+1 < rgt)
            quicksort2(a,r+1,rgt);
        //TODO: use an iterative algorithm instead to avoid memory problems with the stack calls (or at least a tail-recursive)
    }


}
