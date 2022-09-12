package udemy.java8.streams;

import udemy.java8.data.Student;
import udemy.java8.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Streams are lazily constructed (e.g. below, the stream and filter only applies after the .collect method executes)
 * Cannot be modified (like add or remove or modify elements), but we can do filtering etc. to effectively work them
 * Elements can be accessed only in sequence
 * Can be traversed only 1 time
 */
public class StreamsExample {

    public static void main(String[] args)
    {
        Map<String, List<String>> map = StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGradeLevel()>2)
                .collect(Collectors.toMap(Student::getName,Student::getActivities));

        System.out.println(map);


        List<String> fruits_list = Arrays.asList("mango","pitaya","kiwi","orange");
        //can only be traversed once
        Stream<String> fruits_stream = fruits_list.stream();
        fruits_stream.forEach(System.out::println);
        fruits_stream.forEach(fruit -> System.out.println(fruit));
    }
}
