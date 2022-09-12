package udemy.java8.streams;

import udemy.java8.data.Student;
import udemy.java8.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SortedUsingComparator {

    public static void main(String[] args) {

        System.out.println("Students sorted by name> \t"+sortedByName());
        System.out.println("...reversed> \t\t\t\t"+sortedByNameR());
    }


    public static List<String> sortedByName()
    {
        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .map(Student::getName)
                .collect(toList());
    }

    public static List<String> sortedByNameR()
    {
        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getName).reversed())
                .map(Student::getName)
                .collect(toList());
    }
}
