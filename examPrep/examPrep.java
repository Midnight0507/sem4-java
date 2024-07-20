import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class examPrep {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        enter("1. Write a Java program to create a new array list, add some elements (string) and print out the collection");

        func1();

        enter("2. Write a Java program to insert an element into the array list at the first position");

        func2();

        enter("3. Write a Java program to remove the fifth element from a array list");

        func3();

        enter("4. Write a Java program to sort a given array list");

        func4();

        enter("5. Write a Java program to shuffle elements in a array list");

        func5();

        enter("Write a Java program to increase the size of an array list");

        func6();

        enter("Write a Java program to reverse elements in a array listt");

        func7();

        enter("8.Write a Java program to compare two array lists");

        func8();

        enter("9. Write a Java program to swap two elements in an array list");

        func9();

        enter("10. Write a Java program to join two array lists");

        func10();
    }

    public static void func1() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        System.out.println(list);
    }

    
    public static void func2() {
        List<String> list = new ArrayList<>();
        list.add("World");
        list.add("!");
        list.add(0, "Hello");
        System.out.println(list);
    }

    
    public static void func3() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        list.add("Java");
        list.add("Programming");
        list.add("Language");  
        list.remove(4);
        System.out.println(list);
    }
    
    public static void func4() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("C");
        list.add("B");
        list.add("F");
        list.add("D");
        list.add("E");
        
        Collections.sort(list);
        System.out.println(list);
    }
    
    public static void func5() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        list.add("Java");
        list.add("Programming");
        list.add("Language");
        
        Collections.shuffle(list);
        System.out.println(list);
    }
    

    public static boolean enter(String text) {
        System.out.println(text);
        int input = sc.nextInt();
        if (text.charAt(0) == (char) (input + '0')) {
            return true;
        }
        return false;
    }

    
    public static void func6() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        ((ArrayList<Integer>) list1).ensureCapacity(list1.size() + 10);
        System.out.println(list1);
    }
    
    public static void func7() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        list.add("Java");
        list.add("Programming");
        list.add("Language");
        
        Collections.reverse(list);
        System.out.println(list);
    }
    
    public static void func8() {
        List<String> list1 = new ArrayList<>();
        list1.add("Hello");
        list1.add("World");
        
        List<String> list2 = new ArrayList<>();
        list2.add("World");
        list2.add("!");
        
        System.out.println(list1.equals(list2));
    }
    
    public static void func9() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        list.add("Java");
        list.add("Programming");
        list.add("Language");
        
        Collections.swap(list, 0, 4);
        System.out.println(list);
    }
    
    public static void func10() {
        List<String> list1 = new ArrayList<>();
        list1.add("Hello");
        list1.add("World");
        
        List<String> list2 = new ArrayList<>();
        list2.add("World");
        list2.add("!");
        
        list1.addAll(list2);
        System.out.println(list1);
    }
    

}
