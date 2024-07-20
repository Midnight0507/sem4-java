public class ContractEmployee extends Employee {
    private double wages;
    private int hours;

    double getWages() {
        return wages;
    }

    void setWages(double wages) {
        this.wages = wages;
    }

    int getHours() {
        return hours;
    }

    void setHours(int hours) {
        this.hours = hours;
    }

    void calculateSalary() {
        double salary = hours * wages;
        setSalary(salary);
        System.out.println("Contract Employee: Your salary is: "+ salary);
    }
}
