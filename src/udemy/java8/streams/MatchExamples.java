package udemy.java8.streams;

import udemy.java8.data.StudentDataBase;

/**
 * anyMatch(), allMatch(), noneMatch(): take a Predicate as input and return a boolean
 */
public class MatchExamples {
    public static void main(String[] args) {
        System.out.println(allMatch("male"));
        System.out.println(anyMatch("female"));
        System.out.println(noneMatch("trans"));
    }

    public static boolean allMatch(String gender)
    {
        return StudentDataBase.getAllStudents().stream().allMatch(student -> student.getGender().equals(gender));
    }

    public static boolean anyMatch(String gender)
    {
        return StudentDataBase.getAllStudents().stream().anyMatch(student -> student.getGender().equals(gender));
    }

    public static boolean noneMatch(String gender)
    {
        return StudentDataBase.getAllStudents().stream().noneMatch(student -> student.getGender().equals(gender));
    }
}
