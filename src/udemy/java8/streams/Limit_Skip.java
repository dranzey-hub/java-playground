package udemy.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Limit_Skip {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);

        int n = 11;
        Optional<Integer> sum = sum(ints,n);
        System.out.println("Sum of "+ints.subList(0,n)+": "+(sum.isPresent()? sum.get() : "err"));

        int s = 3;
        Optional<Integer> sumSkipped = sumSkip(ints, s);
        System.out.println("Sum of "+ints.subList(s,ints.size())+": "+(sumSkipped.isPresent()? sumSkipped.get() : "err"));
    }


    public static Optional<Integer> sum(List<Integer> list, int n)
    {
        return list.stream().limit(n).reduce(Integer::sum);
    }

    /**
     *  skip is the opposite of limit -> skips the first n elements
     */
    public static Optional<Integer> sumSkip(List<Integer> list, int n)
    {
        return list.stream().skip(n).reduce(Integer::sum);
    }
}
