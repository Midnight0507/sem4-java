import java.util.ArrayList;

public class boxing {
    public static void main(String[] args) {

        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        Employee e1 = new Employee("Dhanush", 123, "Electrical");

        Employee e2 = new Employee("Mahaan", 124, "Medical");

        Employee e3 = new Employee("Dhanush", 125, "Advocate");

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);

        for (Employee employee : employeeList) {
            employee.name();
        }

        System.out.println(e1.equals(e3));

        // int h = 10;

        // Integer I = new Integer(10);

        // String str = new String("93");

        // System.out.println(h + str);

        // System.out.println(I.toString(I.intValue()));
        // System.out.println("Maxmimum Integer " + Integer.MAX_VALUE);
        // System.out.println("Minimum Integer " + Integer.MIN_VALUE);

    }
}