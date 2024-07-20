import java.sql.*;
import java.io.*;
import java.util.*;

public class employee {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/javatest"; 
        String username = "root"; 
        String password = "root"; 

        try (
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // SQL statements to create the tables
            String createTableCust = "CREATE TABLE IF NOT EXISTS customer (" +
                                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                                    "name VARCHAR(100) NOT NULL," +
                                    "email VARCHAR(100) NOT NULL," +
                                    "phone VARCHAR(20) NOT NULL)";
            String createTableEmp = "CREATE TABLE IF NOT EXISTS employee (" +
                                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                                    "emp_name VARCHAR(100) NOT NULL," +
                                    "emp_email VARCHAR(100) NOT NULL," +
                                    "emp_phone VARCHAR(20) NOT NULL)";

            // Execute the create table statements
            statement.executeUpdate(createTableCust);
            statement.executeUpdate(createTableEmp);
            System.out.println("Tables created or already exist");

            // Create updatable statements for further operations
            try (
                Statement updatableStatementCust = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                Statement updatableStatementEmp = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet cust = updatableStatementCust.executeQuery("SELECT * FROM customer");
                ResultSet emp = updatableStatementEmp.executeQuery("SELECT * FROM employee");
                Scanner sc = new Scanner(System.in)
            ) {
                List<Savepoint> saveList = new ArrayList<>();
                connection.setAutoCommit(false); // Disable auto-commit

                String inp = "";
                while (!inp.equalsIgnoreCase("E")) {
                    System.out.println("o\t[IE]nsert: new record into employee\r\n" + //
                                       "o\t[IC]nsert: new record into customers\r\n" + //
                                       "o\t[DE]elete: Delete the record from employees.\r\n" + //
                                       "o\t[DC]elete: Delete the record from customers.\r\n" + //
                                       "o\t[UE]pdate: Update the record of employees.\r\n" + //
                                       "o\t[UC]pdate: Update the record of customers.\r\n" + //
                                       "o\t[PE]rint: print table data of employees.\r\n" + //
                                       "o\t[PC]rint: print table data of customers.\r\n" + //
                                       "o\t[C]ommit: Commit changes in both tables.\r\n" + //
                                       "o\t[S]ave: Add a save point.\r\n" + //
                                       "o\t[R]ollback: Rollback to a save point.\r\n" + //
                                       "o\t[E]xit: Exit the application.");

                    inp = sc.next().toUpperCase();
                    System.out.println("----------------------------------------");

                    switch (inp) {
                        case "IC":
                            System.out.println("Modifying customers table:\n");
                            cust.moveToInsertRow();
                            System.out.print("Enter name: ");
                            cust.updateString("name", sc.next()); 
                            System.out.print("Enter email: ");
                            cust.updateString("email", sc.next()); 
                            System.out.print("Enter Phone Number: ");
                            cust.updateString("phone", sc.next()); 
                            cust.insertRow();
                            cust.moveToCurrentRow();
                            System.out.println("Data added.\n");
                            break;
                        case "IE":
                            System.out.println("Modifying employees table:\n");
                            emp.moveToInsertRow();
                            System.out.print("Enter name: ");
                            emp.updateString("emp_name", sc.next()); 
                            System.out.print("Enter email: ");
                            emp.updateString("emp_email", sc.next()); 
                            System.out.print("Enter Phone Number: ");
                            emp.updateString("emp_phone", sc.next()); 
                            emp.insertRow();
                            emp.moveToCurrentRow();
                            System.out.println("Data added.\n");
                            break;
                        case "DC":
                            System.out.print("Enter record id to delete: ");
                            int custId = sc.nextInt();
                            if (cust.absolute(custId)) {
                                cust.deleteRow();
                                System.out.println("Deleted record with id " + custId + "\n");
                            } else {
                                System.out.println("Customer id out of range.");
                            }
                            break;
                        case "DE":
                            System.out.print("Enter record id to delete: ");
                            int empId = sc.nextInt();
                            if (emp.absolute(empId)) {
                                emp.deleteRow();
                                System.out.println("Deleted record with id " + empId + "\n");
                            } else {
                                System.out.println("Employee id out of range.");
                            }
                            break;
                        case "UE":
                            System.out.print("Enter employee id to update: ");
                            int empUpdateId = sc.nextInt();
                            if (emp.absolute(empUpdateId)) {
                                System.out.print("Enter new name: ");
                                emp.updateString("emp_name", sc.next());
                                System.out.print("Enter new email: ");
                                emp.updateString("emp_email", sc.next());
                                System.out.print("Enter new Phone Number: ");
                                emp.updateString("emp_phone", sc.next());
                                emp.updateRow();
                                System.out.println("Updated employee with id " + empUpdateId);
                            } else {
                                System.out.println("Employee id out of range.");
                            }
                            break;
                        case "UC":
                            System.out.print("Enter customer id to update: ");
                            int custUpdateId = sc.nextInt();
                            if (cust.absolute(custUpdateId)) {
                                System.out.print("Enter new name: ");
                                cust.updateString("name", sc.next());
                                System.out.print("Enter new email: ");
                                cust.updateString("email", sc.next());
                                System.out.print("Enter new Phone Number: ");
                                cust.updateString("phone", sc.next());
                                cust.updateRow();
                                System.out.println("Updated customer with id " + custUpdateId);
                            } else {
                                System.out.println("Customer id out of range.");
                            }
                            break;
                        case "C":
                            connection.commit();
                            System.out.println("Committed Customer and Employee changes");
                            saveList.clear();
                            break;
                        case "S":
                            System.out.print("Enter name for savepoint: ");
                            String name = sc.next();
                            Savepoint sv = (name.isEmpty()) ? connection.setSavepoint() : connection.setSavepoint(name);
                            saveList.add(sv);
                            System.out.println("Save Point created.");
                            break;
                        case "R":
                            if (saveList.size() > 0) {
                                System.out.println("Select which save point to rollback:");
                                for (int i = 0; i < saveList.size(); i++) {
                                    System.out.println(i + " -> Savepoint " + saveList.get(i).getSavepointName());
                                }
                                int index = sc.nextInt(); // Assuming the user enters a valid integer
                                if (index >= 0 && index < saveList.size()) {
                                    connection.rollback(saveList.get(index));
                                    System.out.println("Rolled back to " + saveList.get(index).getSavepointName());
                                } else {
                                    System.out.println("Invalid index selected.");
                                }
                            } else {
                                System.out.println("No savepoints or data got commited. ");
                            }
                            break;
                        case "PE":
                            printTableData(emp);
                            emp.absolute(0);
                            break;
                        case "PC":
                            printTableData(cust);
                            cust.absolute(0);
                            break;
                        case "E":
                            System.out.println("Bye Bye !!");
                            break;
                    }
                    System.out.println("----------------------------------------");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printTableData(ResultSet rs) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i) + "\t");
            }
            System.out.println();
            
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
            rs.moveToCurrentRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
