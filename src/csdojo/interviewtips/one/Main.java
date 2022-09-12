package csdojo.interviewtips.one;

public class Main {

    public static void main(String[] args)
    {
        int[] array1 = new int[]{-1,3,8,2,9,5};
        int[] array2 = new int[]{4,1,2,10,5,20};
        Algorithm1 a1;
        a1 = new Algorithm1(array1, array2, 24);
        //1.2
        Algorithm1 a1_2 = new Algorithm1(new int[]{-1,3,8,4,9,10}, new int[]{20,12,20,10,1,2},24);


        a1.exe();
        //a1_2.exe();
    }

}





