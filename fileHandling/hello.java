public class hello {
    public static void main(String[] args){
        try {
            System.out.println(Double.valueOf("420.00"));
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException occured.");
        } catch(Exception e) {
            System.out.println("Some exception occured");
        } 
    }
}