package udemy.java8.streams;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Numerics
{
    public static void main(String[] args)
    {
        IntStream stream = streamOfInts(9);
        stream.forEach(System.out::println);
        //System.out.println(stream.sum());

        int sumUntil = 6;
        System.out.println("sum [1 -> "+sumUntil+"]: "+sum(sumUntil));

        OptionalDouble avg = avg(sumUntil);
        System.out.println("average: "+(avg.isPresent()? avg.getAsDouble() : "err"));

    }

    /**
     *  returns a stream of ints (primitives) from 1 to n
     *  we can also use LongStream and DoubleStream (the latter doesn't have .range)
     */
    public static IntStream streamOfInts(int n)
    {
        return IntStream.rangeClosed(1,n);
    }

    public static int sum(int until) { return IntStream.rangeClosed(1,until).sum(); }

    public static OptionalDouble avg(int n) { return LongStream.rangeClosed(1,n).average(); }

    /**
     * wrap int into Integer so we can put them in a List
     */
    public static List<Integer> box(int n) { return IntStream.rangeClosed(1,n).boxed().collect(Collectors.toList()); }
                                    //or { return IntStream.rangeClosed(1,n).mapToObj(i -> new Integer(i)).collect(Collectors.toList());}
}
