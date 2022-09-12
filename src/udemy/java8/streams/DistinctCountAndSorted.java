package udemy.java8.streams;

import udemy.java8.data.Student;
import udemy.java8.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class DistinctCountAndSorted {

    public static void main(String[] args)
    {
        System.out.println("Distinct set of Activities>  \t"+activities());
        System.out.println("Sorted in alpha>  \t\t\t\t"+sorted());
        System.out.println("\nTotal is :  "+countActivities());
    }


    /**
     *  Distinct returns only distinct elements (removes duplicates)
     */
    public static List<String> activities()
    {
        return StudentDataBase.getAllStudents().stream().map(Student::getActivities)    //stream of List<String>s
                .flatMap(List::stream)              //stream<List<String>> => stream<String>
                .distinct()                         //remove duplicates
                .collect(Collectors.toList());      //collect as list
    }


    public static long countActivities()
    {
        return StudentDataBase.getAllStudents().stream().map(Student::getActivities)    //stream of List<String>s
                .flatMap(List::stream)              //stream<List<String>> => stream<String>
                .distinct()                         //remove duplicates
                .count();                           //return count of elements as a long
    }

    public static List<String> sorted()
    {
        return StudentDataBase.getAllStudents().stream().map(Student::getActivities)    //stream of List<String>s
                .flatMap(List::stream)              //stream<List<String>> => stream<String>
                .distinct()                         //remove duplicates
                .sorted()                           //sort in alphabetical order
                .collect(Collectors.toList());      //collect as list
    }
}
