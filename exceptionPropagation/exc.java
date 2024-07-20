import java.util.Scanner;

class exc
{
	public static void main(String[] args) 
	{

		try {

            Scanner sc = new Scanner(System.in);
            
            System.out.println("Enter divisor");

            int x = sc.nextInt();

            System.out.println("Hello " + 150 / x);

            sc.close();

         
        }catch (ArithmeticException ArE ) {

            System.out.println("Arithmetic Error Occured");

        } catch (Exception e) {

            System.out.println(e);

        }

   	}
}