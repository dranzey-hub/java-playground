package udemy.java8.section8.FunctionalInterfaces;

import udemy.java8.data.Student;
import udemy.java8.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    //static{   //static block doesn't mean static members... :/
        static Predicate<Student> predicateGradeLevel3 = student -> student.getGradeLevel()==3;

        static List<Student> list = StudentDataBase.getAllStudents();
    //}

    public static void getStudentsGrade3(){
        list.forEach( (s -> {if(predicateGradeLevel3.test(s)) System.out.println(s);}) );
    }


    public static void main(String[] args) {
        getStudentsGrade3();
    }
}
