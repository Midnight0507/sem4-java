import java.util.*;

public class DemoCollection {

    public static void main(String[] args) {   

        Set<Integer> s = new HashSet<Integer>();

        s.add(141);

        s.add(23);

        s.add(90);

        s.add(-23);

        s.add(56);

        s.add(101);

        System.out.println("Hash Set Values are :");

        Iterator<Integer> k = s.iterator();
        while(k.hasNext()) {
            System.out.println("Hello " + k.next());
        }

        Set<Integer> s1 = new TreeSet<Integer>(s);
        
        System.out.println("Tree Set sorted : " + s1);

        // for (int integer : s) {
        //     System.out.println(s);
        //     integer = integer + 1;
        // }

        System.out.println("HashSet Values are " + s);

        System.out.println("Size of HashSet is " + s.size());
      
    }
}