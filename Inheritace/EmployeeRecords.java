public class EmployeeRecords {
    public static void main(String[] args) {
        PermanentEmployee permanentEmployee = new PermanentEmployee();
        permanentEmployee.setEmployeeeId(101);
        permanentEmployee.setEmployeeName("Anil");
        permanentEmployee.setBasicPay(10000);
        permanentEmployee.setHra(1500);
        permanentEmployee.setExperience(3);
        permanentEmployee.calculateSalary();

        ContractEmployee contractEmployee = new ContractEmployee();
        contractEmployee.setEmployeeeId(102);
        contractEmployee.setEmployeeName("Adi");
        contractEmployee.setWages(50);
        contractEmployee.setHours(20);
        contractEmployee.calculateSalary();
    }
}
