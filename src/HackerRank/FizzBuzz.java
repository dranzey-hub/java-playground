package HackerRank;

public class FizzBuzz
{
    public static void main(String[] args)
    {
        fizzBuzz(15);
    }


    /**
     if i multiple of both 3 and 5 print FizzBuzz
     if multiple of 3 but not 5 print Fizz
     if multiple of 5 but not 3 print Buzz
     if multiple of neither print i

     Ex: 15
     1
     2
     Fizz
     4
     Buzz
     Fizz
     7
     8
     Fizz
     Buzz
     11
     Fizz
     13
     14
     FizzBuzz
     */
    static void fizzBuzz(int n)
    {
        for(int i=1; i<n+1; i++)
        {
            //System.out.println(i);

            if(i%3 == 0 && i%5 == 0){
                System.out.println("FizzBuzz");
            }
            else if(i%3 == 0)
                System.out.println("Fizz");
            else if(i%5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }

    }
}
