import java.util.*;

public class hello {
    public static void main(String[] args) {
        
        // Map p = new HashMap<Integer, String>();

        // p.put(922, "Sharmila");

        // p.put(22, "Priya");

        // p.put(21, "mila");

        // System.out.println(p.get(21));

        // p.put(12, "Lalitha");

        // System.out.println(p);

        // Set<Integer> x = p.keySet();

        // for (Integer integer : x) {
        //     System.out.println(p.get(integer));
        // }

        // // for (String j : p.values()) {
        // //     System.out.println(j.startsWith("S"));
        // // }
        
        // Set<HashSet<Integer>> s = new HashSet<HashSet<Integer>>();

        List<Integer> l = new Stack<Integer>();
        l.add(20);

        l.add(35);

        l.add(45);

        System.out.println(l);

        l.remove(0);

        l.remove(1);

        System.out.println(l + "\n");


        System.out.println("Stack Implemented: ");
        Stack<Integer> s = new Stack<Integer>();

        s.add(20);

        s.add(35);

        s.add(2, 100);

        s.push(15);

        s.remove(2);

        System.out.println(s);

        s.pop();

        System.out.println(s);

    }
}

