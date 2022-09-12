package udemy.java8.section9;

import udemy.java8.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 */
public class ConstructorReference
{
    static Supplier<Student> studentSupplier = Student::new;
    static Function<String,Student> studentConstructorFunction = Student::new;

    public static void main(String[] args) {
        System.out.println(studentSupplier.get());

        System.out.println(studentConstructorFunction.apply("NameHere"));
    }
}
