package CodeSignal.hashTables;

import java.text.Collator;
import java.util.*;

public class GroupingDishes
{
    public static void main(String[] args) {
        String[][] dishes = {
                {"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
                {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
                {"Quesadilla", "Chicken", "Cheese", "Sauce"},
                {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}
        };

        groupingDishes(dishes);
    }

    /**
     You are given a list dishes, where each element consists of a list of strings beginning with the name of the dish,
     followed by all the ingredients used in preparing it. You want to group the dishes by ingredients, so that for each
     ingredient you'll be able to find all the dishes that contain it (if there are at least 2 such dishes).

     Return an array where each element is a list beginning with the ingredient name, followed by the names of all the
     dishes that contain this ingredient. The dishes inside each list should be sorted lexicographically, and the result
     array should be sorted lexicographically by the names of the ingredients.

     Example

     For
     dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
     ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
     ["Quesadilla", "Chicken", "Cheese", "Sauce"],
     ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]

     output:
     groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
     ["Salad", "Salad", "Sandwich"],
     ["Sauce", "Pizza", "Quesadilla", "Salad"],
     ["Tomato", "Pizza", "Salad", "Sandwich"]]

     Both the dish name and the ingredient names consist of English letters and spaces. It is guaranteed that all dish
     names are different. It is also guaranteed that the ingredient names for any one dish are also pairwise distinct.

     Guaranteed constraints:
     1 ≤ dishes.length ≤ 500,
     2 ≤ dishes[i].length ≤ 10,
     1 ≤ dishes[i][j].length ≤ 50.
     */
    static String[][] groupingDishes(String[][] dishes)
    {
        /**
         * sol1> map dishes vs ingredients
         */
        //map <dish, ingredients>
        Hashtable<String, List<String>> map = new Hashtable<>(dishes.length);
/*
        for(int i = 0; i<dishes.length; i++)
        {
            //create new list of ingredients per each dish
            ArrayList<String> list = new ArrayList();
            //map <dish,list>
            map.put(dishes[i][0], list);
            //add ingredients to the list
            for(int j = 1; j<dishes[i].length; j++)
            {
                list.add(dishes[i][j]);
            }
        }
        //remap to ingredient>[list of dishes]
        for(Map.Entry e : map.entrySet())
        {

        }
*/
        /**
         *  [!] NOT WORKING IN CodeSignal
         */
        //put into a map the ingredient and a list of dishes
        for(int i=0; i< dishes.length; i++) //dish (at pos 0)
        {
            for(int j=1; j< dishes[i].length; j++)  //ingredients (from pos 1)
            {
                if(!map.containsKey(dishes[i][j])){         //if new ingredient appears
                    ArrayList<String> a = new ArrayList<>();
                    a.add(dishes[i][0]);                    //add dish to the new list
                    map.put(dishes[i][j], a);               //map ingredient with its dish list
                }else{
                    if( !map.get(dishes[i][j]).contains(dishes[i][0]) ){    //add dish to an existing list
                        map.get(dishes[i][j]).add(dishes[i][0]);
                    }
                }
            }
        }
        //delete ingredients with no more than 1 dish on its list
        /*for(Map.Entry e : map.entrySet())
        {
            if( ((List<String>)e.getValue()).size() == 1 ){
                map.remove(e.getKey());                         //[!] this causes concurrentmodification ex [!]
            }
        }*/
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, List<String>> e = (Map.Entry<String, List<String>>)iterator.next();
            if( ((List<String>)e.getValue()).size() == 1 ) iterator.remove();   //[!] remove through iterator instead
        }

        //put back as a String[][]
        String[][] grouped = new String[map.size()][];
        int index = 0;
        for(Map.Entry e : map.entrySet())
        {
            List<String> list = ((List<String>)e.getValue());
            String[] a = new String[list.size()+1];
            list.sort(Collator.getInstance());      //this should sort the dishes list
            //add ingredient first
            a[0] = (String)e.getKey();
            //add list of dishes
            for(int i = 1; i<a.length; i++){
                a[i] = list.get(i-1);
            }
            grouped[index] = a;
            index++;
        }

        //sort ingredients
        Arrays.sort(grouped, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });

        for(int i = 0; i<grouped.length; i++)
            System.out.println(Arrays.toString(grouped[i]));

        return grouped;
    }
}
