package udemy.java8.streams;

import udemy.java8.data.Student;
import udemy.java8.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        System.out.println("Female>  "+filterStudents());
    }

    public static List<String> filterStudents()
    {
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGender().equals("female"))
                .map(Student::getName)
                .collect(Collectors.toList());
    }
}
