public class Employee{
    String name;
    int deptno;
    String department;

    Employee(String name, int deptno, String departmentName) {
        this.department = departmentName;
        this.name = name;
        this.deptno = deptno;
    }

    @Override
    public String toString() {

        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Employee e = (Employee)obj;
            if (this.name == e.name) {
                System.out.println("Employees have the same name : "+ this.name);
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            System.out.println("Exception: " + e);
            return false;
        }
    }
    public void name() {
        System.out.println(this.name);
    }
}
