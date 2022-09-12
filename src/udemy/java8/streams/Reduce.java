package udemy.java8.streams;

import udemy.java8.data.Student;
import udemy.java8.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1,2,3);
        System.out.println(ints+": Multiplication>  "+multiplicate(ints));

        Optional<Student> highestGPAStudent = highestGPA();
        System.out.println("Highest GPA student>  "+(highestGPAStudent.isPresent()?highestGPAStudent.get():"err"));
    }

    public static int multiplicate(List<Integer> list)
    {
        //Perform the reduce operation for all elements in stream such that:
        //1*1 -> 1*2 -> 2*3
        return list.stream().reduce(1, (a,b) -> a*b);
    }

    public static Optional<Student> highestGPA()
    {
        return StudentDataBase.getAllStudents().stream()
                .reduce( (student1,student2) -> student1.getGpa()>student2.getGpa()? student1 : student2 );
    }

}
