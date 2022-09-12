package udemy.java8.section8.FunctionalInterfaces;

import udemy.java8.data.Student;
import udemy.java8.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args)
    {
        /**
         * 1st example
         */
        Consumer<String> consumer = (s) -> System.out.println(s.toUpperCase());

        consumer.accept("hola");

        //---

        /**
         * .. now a bit more
         */
        //printStudents();

        //printNameAndActivities();

        printNameAndActivitiesConditional();
    }





    public static void printStudents()
    {
        //we're given an student to consume, we simply print out that student:
        Consumer<Student> consumer = (s) -> System.out.println(s);

        //now just process the consume
        List<Student> list = StudentDataBase.getAllStudents();
        //not sure, but I guess forEach grabs each student on list and activates the consumer
        list.forEach(consumer);
    }

    public static void printNameAndActivities()
    {
        Consumer<Student> consumeName =     (s) -> System.out.print(s.getName());
        Consumer<Student> consumeActivity = (s) -> System.out.println(s.getActivities());

        List<Student> list = StudentDataBase.getAllStudents();
        //we use consumer chaining with the .andThen consumer method (we can continue chaining: andThen().andThen()...)
        list.forEach(consumeName.andThen(consumeActivity));
    }

    public static void printNameAndActivitiesConditional()
    {
        Consumer<Student> consumeName =     (s) -> System.out.print(s.getName());
        Consumer<Student> consumeActivity = (s) -> System.out.println(s.getActivities());

        List<Student> list = StudentDataBase.getAllStudents();

        list.forEach( (s -> {
            if(s.getGradeLevel()>=3) {
                consumeName.andThen(consumeActivity).accept(s); //not sure why the .accept but without it it doesn't print. i think it's because the forEach in previous method activates the .accept, but here we need to activate it manually
            }
        }) );
    }
}
