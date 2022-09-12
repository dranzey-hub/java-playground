package udemy.java8.section8.FunctionalInterfaces;

import udemy.java8.data.StudentDataBase;
import udemy.java8.data.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionExample {

    //Simple example of Function where we accept 2 generics: first is the Input and then the Output
    static Function<String, String> simpleFunction = str -> str.toUpperCase();

    static Function<String, String> addFunction = str -> str.concat("-suffix");

    static Function<List<Student>, Map<String,Double>> simplifiedStudentList =
            students -> {
                Map<String,Double> map = new HashMap<>();
                students.forEach( student -> map.put(student.getName(),student.getGpa()) );
                return map;
            };

    public static void main(String[] args) {
        System.out.println(simpleFunction.apply("java"));

        System.out.println(simpleFunction.andThen(addFunction).apply("java"));
        System.out.println(simpleFunction.compose(addFunction).apply("java"));

        List<Student> students = StudentDataBase.getAllStudents();
        System.out.println(simplifiedStudentList.apply(students));

        System.out.println(Function.identity());
    }
}
