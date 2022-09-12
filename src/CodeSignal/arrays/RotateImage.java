package CodeSignal.arrays;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args)
    {
        int [][] a = new int[2][];
        for(int i = 0, k=1; i< a.length; i++){
            a[i] = new int[a.length];
            for(int j=0; j<a[i].length; j++, k++){
                a[i][j] = k;
            }
        }
        for(int i=0; i<a.length; i++){
            System.out.println(Arrays.toString(a[i]));
        }

        System.out.println("\nRotated> "+Arrays.deepToString(rotateImage(a)));

        System.out.println(">>");
        for(int i=0; i<a.length; i++){
            System.out.println(Arrays.toString(a[i]));
        }
    }


    /**
     Note: Try to solve this task in-place (with O(1) additional memory), since this is what you'll be asked to do during an interview.

     You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).

     Example
     a = [[1, 2, 3],
         [4, 5, 6],
         [7, 8, 9]]

     rotateImage(a) =
     [[7, 4, 1],
     [8, 5, 2],
     [9, 6, 3]]
     */
    static int[][] rotateImage(int[][] a)
    {
        /**
         found pattern that spirals through the matrix
            (k layer going through row at pos i; n = length of layer (outer n = a.length-1), 1 level in: a.length-3, etc.)
            start: k,i      => +i,+n-i
                +i,+n-i    => +n-i,-i
                +n-i,-i    => -i,-n-i
                -i,-n-i    => -n-i,+i
            then go in 1 layer starting at 1,1 now adding/substracting i,(n-i) while n > 0 and n decreases by 2

         */

        //layer length
        int n = a.length-1;
        //pointer
        Point p = null;
        //current layer
        int layer = 0;
        while(n > 0)
        {
            //starting point in layer
            p = new Point(layer,layer);

            boolean flag = false;

            //recorre linea
            for(int i=0; i<(flag?n+1:n); i++)
            {
                Integer tmp = null;
                //espiral en los 4 cuadrantes  (cada linea de la capa)
                for(int z = 0; z<3; z++)
                {
                    if (z == 0) //start
                    {
                        tmp = a[p.x+i][p.y+n-i];
                        a[p.x+i][p.y+n-i] = a[p.x][p.y];
                        //next
                        p.x += i;
                        p.y += n-i;
                    }else if (z == 1)
                    {
                        //next
                        p.x += n-i;
                        p.y -= i;
                        int next = a[p.x][p.y];
                        a[p.x][p.y] = tmp;
                        tmp = next;
                        //next
                        p.x -= i;
                        p.y -= n-i;
                    }else if (z == 2)
                    {
                        int next = a[p.x][p.y];
                        a[p.x][p.y] = tmp;
                        //tmp = next;
                        //back to start
                        p.x -= n-i;
                        p.y += i;
                        a[p.x][p.y] = next;

                        //next in line
                        p.y++;
                    }
                }
            }
            //inner layer
            layer++;
            //update layer length;
            n -=2;
            //flag that tells we're going in (for loop fix)
            flag = true;
        }


        return a;
    }


    /**
     * Solution taken from another user
     *
     */
    int[][] rotateImage2(int[][] a) {
        int n = a.length;
        for(int i = 0; i < n / 2; i++){
            for(int j = i; j < n-i-1; j++){
                int temp = a[i][j];
                a[i][j] = a[n-j-1][i];
                a[n-j-1][i] = a[n-1-i][n-1-j];
                a[n-1-i][n-1-j] = a[j][n-1-i];
                a[j][n-1-i] = temp;
            }
        }
        return a;
    }






    static class Point{ //inverted x y (x = row, y = col)
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
