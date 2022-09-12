package udemy.java8.section9;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Method reference or shortcut for lambdas
 *
 *      ClassName/Instance::instance method
 *      ClassName::static method
 *
 *      ex: s -> s.toUpperCase();
 *          String::toUpperCase;
 *
 *
 *  Do these (Constructor Reference also) apply only to Functional Interfaces?
 */
public class MethodReference
{

    public static void main(String[] args)
    {
        Function<String,String> toUpperFunction = String::toUpperCase;
        Consumer<String> printerConsumer = System.out::println;

        //System.out.println(toUpperFunction.apply("java 8"));
        printerConsumer.accept(toUpperFunction.apply("java 8"));
    }

}
