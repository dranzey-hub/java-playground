package udemy.java8.streams;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Of_iterate_generate {
    public static void main(String[] args)
    {
        //
        Stream<String> stream = Stream.of("fruits","things","yeah");
        stream.forEach(System.out::println);


        //Both 'iterate' and 'generate' create an infinite stream (limited here)
        Stream.iterate(2, x -> x*2).limit(6).forEach(System.out::println);

        Supplier<Integer> randomSupplier = new Random()::nextInt;
        Stream.generate(randomSupplier).limit(5).forEach(r -> System.out.println("r: "+r));
    }


}
