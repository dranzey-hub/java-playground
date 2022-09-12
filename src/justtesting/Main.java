package justtesting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main
{


    public static void main(String[] args)
    {
        final int A;
        A = 0;

        HashMap<String,Integer> hm = new HashMap<>();

        hm.put("a", 1);
        hm.put("b", 2);
        hm.put("c", 3);
        hm.put("a", 4);
        hm.put("x", 1);
        hm.put("y", 1);
        hm.put("z", null);

        System.out.println(hm);

        Iterator i = hm.entrySet().iterator();

        while(i.hasNext()){
            Map.Entry e = (Map.Entry) i.next();
            System.out.print("\n> key: "+e.getKey()+", value: "+e.getValue());
        }
        System.out.println("\n\n   For loop\n");
        for(Map.Entry e : hm.entrySet()){
            System.out.println("|| k: "+e.getKey()+", v: "+e.getValue());
        }
    }


}
