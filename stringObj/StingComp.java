public class StingComp
{
    public static void main(String[] args)
    {
        String s1="Hello";
        String s2="World";
        System.out.println(s1.equals(s2)); // false
        
        String s3=new String();

        s3 = s2.concat(s1);
        System.out.println(s3.equals(s2.concat(s1))); // true

        System.out.println(s2.concat(s1)); // WorldHello

        System.out.println(s3.equals((s2 + s1))); // true
    }
}
