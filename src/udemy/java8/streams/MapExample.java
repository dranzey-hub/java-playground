package udemy.java8.streams;

import udemy.java8.data.Student;
import udemy.java8.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class MapExample
{

    public static void main(String[] args)
    {
        System.out.println("Mapped Students to their names> \t"+namesList());

        System.out.println("Flattened list of activities> \t\t"+activities());
    }

    /**
     *  Map the stream of Student as a stream of String
     */
    public static List<String> namesList()
    {
                                                        //Student => String
        return StudentDataBase.getAllStudents().stream().map(Student::getName).collect(Collectors.toList());
    }

    /**
     *  Need to flatten the stream of List<String>s so we can get only Strings
     *
     *  i.e. [List<String>, List<String>, ...] => [String, String, String, String, ...]
     */
    public static List<String> activities()
    {
        return StudentDataBase.getAllStudents().stream().map(Student::getActivities)    //stream of List<String>s
                .flatMap(List::stream)              //stream<List<String>> => stream<String>
                .collect(Collectors.toList());
    }
}
