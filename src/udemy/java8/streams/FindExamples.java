package udemy.java8.streams;


import udemy.java8.data.Student;
import udemy.java8.data.StudentDataBase;

import java.util.Optional;

/**
 * findFirst(), findAny(): Both return type Optional
 */
public class FindExamples {
    public static void main(String[] args) {
        float gpa = 3.9f;
        Optional<Student> student = findAnyStudent();
        System.out.println("finding any student with grade >="+gpa+"... "+(student.isPresent()? student.get() : "404"));
    }

    /**
     *  findAny returns the first occurrence
     */
    public static Optional<Student> findAnyStudent()
    {
        return StudentDataBase.getAllStudents().stream().filter(student -> student.getGpa()>=3.9).findAny();
    }

    /**
     *  same behaviour here, the difference comes when working in parallel ( parallelStream )
     */
    public static Optional<Student> findFirstStudent()
    {
        return StudentDataBase.getAllStudents().stream().filter(student -> student.getGpa()>=3.9).findAny();
    }
}
