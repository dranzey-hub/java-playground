package udemy.java8.streams;

import udemy.java8.data.Student;
import udemy.java8.data.StudentDataBase;

import java.util.*;
import java.util.stream.Collectors;

import utils.ConsoleColor;

/**
 * A terminal operation is one like collect, sum, average, etc.
 *  that starts, collects and ends the stream
 */
public class TerminalOps
{
    public static void main(String[] args)
    {
        System.out.println("String of names: "+join());

        System.out.println("String of names, delimited: "+join(" | "));

        System.out.println("String of names, delimited and pre/suffixed: "+join(" | ", "[", "]"));


        System.out.println("\nCounting students: "+counting());

        System.out.println("\nList: "+mapAndList());

        System.out.println("\nA student with highest GPA (1st encountered): "+maxGPA().get());

        System.out.println("\nList of students grouped by gender: "+groupByGender());

        System.out.println("\nGroup GPAs: "+groupByGPA());

        System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT+"\nInception: "+groupByGradeAndGPA());

        System.out.println(ConsoleColor.RED+"\n# students per grade: "+ConsoleColor.RESET+studentsPerGrade());
    }


    public static String join()
    {
        return StudentDataBase.getAllStudents().stream().map(Student::getName).collect(Collectors.joining());
    }

    public static String join(String delimiter)
    {
        return StudentDataBase.getAllStudents().stream().map(Student::getName).collect(Collectors.joining(delimiter));
    }

    public static String join(String delimiter, String prefix, String suffix)
    {
        return StudentDataBase.getAllStudents().stream().map(Student::getName).collect(Collectors.joining(delimiter,prefix,suffix));
    }


    public static long counting()
    {
        return StudentDataBase.getAllStudents().stream().collect(Collectors.counting());
        //return StudentDataBase.getAllStudents().stream().count();
    }

    public static List<String> mapAndList()
    {
        return StudentDataBase.getAllStudents().stream().collect( Collectors.mapping(Student::getName,Collectors.toList()) );
    }

    public static Optional<Student> maxGPA()
    {
        return StudentDataBase.getAllStudents().stream().collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
    }

    //... and there's several like these, where collect() has a lot of duplication for other functions like max(), map(), sum() etc.




    public static String groupByGender()
    {
        Map<String, List<Student>> list = StudentDataBase.getAllStudents().stream().collect(Collectors.groupingBy(Student::getGender));

        //we can do the groupByGPA way instead of this to reduce the Student to its name:
        String ret = "";
        for(String key : list.keySet()){
            ret+=key+"=[ ";
            for(Student s : list.get(key)){
                ret+=s.getName()+" ";
            }
            ret+="] ";
        }
        return ret;
    }


    public static Map<String, List<String>> groupByGPA()
    {
        Map<String, List<Student>> list = StudentDataBase.getAllStudents().stream().collect(Collectors.groupingBy( s -> s.getGpa()>=3.9? "OUTSTANDING" : "NORMAL"));

        //Map the <String, List<Student>> -> <String, List<String>> to reduce the Students list to simply their names
        HashMap<String, List<String>> ret = new HashMap<>();
        for(Map.Entry<String, List<Student>> entry : list.entrySet()){
            ret.put( entry.getKey(), entry.getValue().stream().map(Student::getName).collect(Collectors.toList()) );
        }

        return ret;
    }

    /**
     * 2 level grouping
     */
    public static Map< Integer, Map<String,List<Student>> > groupByGradeAndGPA()
    {
        return StudentDataBase.getAllStudents().stream().collect( Collectors.groupingBy(Student::getGradeLevel, Collectors.groupingBy(s -> s.getGpa()>=3.9? "OUTSTANDING" : "NORMAL")) );
    }

    public static Map<String, Long> studentsPerGrade()
    {
        return StudentDataBase.getAllStudents().stream().collect( Collectors.groupingBy(s -> s.getGradeLevel()+"°", Collectors.counting()) );
    }
}
