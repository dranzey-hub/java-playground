package udemy.java8.section7;

import java.util.Comparator;

public class Lambda_ComparatorImplementation {

    public static void main(String[] args) {

        /**
         * Prior to Java 8:
         */
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);    //compareTo returns 0 if equals, 1 if o1 > o2, -1 else
            }
        };

        System.out.println(""+comparator.compare(1,2));

        //---

        /**
         * lambda
         */
        //Comparator<Integer> comparator2 = (Integer o1, Integer o2) -> {return o1.compareTo(o2);}; //or even better v v
        //Comparator<Integer> comparator2 = (Integer o1, Integer o2) -> o1.compareTo(o2); //[!] we don't use return here
        Comparator<Integer> comparator2 = (o1, o2) -> o1.compareTo(o2); //not even types needed

        System.out.println(""+comparator2.compare(1,2));
    }
}
