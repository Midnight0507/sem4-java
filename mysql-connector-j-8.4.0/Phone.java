import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.io.*;
import java.util.*;

public class Phone {
    public static final String delimiter = ",";
    public static void readAndInsert(String csvFile, Connection connection) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            br.readLine();
            // Prepare SQL insert statement
            String insertSQL = "INSERT INTO customers (name, email, phone) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);

            while((line = br.readLine()) != null) {
                String[] tempArr = line.split(delimiter);

                // Assuming the CSV file has columns in the order:
                preparedStatement.setString(1, tempArr[0]);
                preparedStatement.setString(2, tempArr[1]);
                preparedStatement.setString(3, tempArr[2]);
                // Execute the insert statement
                preparedStatement.executeUpdate();
            }
            br.close();
            } catch(IOException ioe) {
                ioe.printStackTrace();
            } catch(SQLException ioe) {
                ioe.printStackTrace();
            }
    }
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/javatest"; 
        String username = "root"; 
        String password = "root"; 

        // Initialize the connection
        Connection connection = null;
        Statement statement = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // Create a statement object
            statement = connection.createStatement();

            // SQL statement to create the table
            String createTableSQL = "CREATE TABLE customers (" +
                                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                                    "name VARCHAR(100) NOT NULL," +
                                    "email VARCHAR(100) NOT NULL," +
                                    "phone VARCHAR(20) NOT NULL " +
                                    ")";

            try {
                // Execute the create table statement
                statement.executeUpdate(createTableSQL);

                // Close the statement
                statement.close();

                String csvFile = "csv/javaTest.csv";
                System.out.println("Inserting into customers table...");
                readAndInsert(csvFile,connection); 
                System.out.println("Insertion completed .");
                
            } catch (SQLException e) {
                System.out.println("Data already inserted .");
            }

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            // a. First Customer
            String firstCustomerSQL = "SELECT * FROM customers";
            ResultSet rs = statement.executeQuery(firstCustomerSQL);
            
            try (Scanner sc = new Scanner(System.in)) {
                String inp = "";

                while(!inp.contentEquals("E")) {
                    System.out.println("SELECT OPTIONS:\n");
                    System.out.println("o\t[N]ext: Move to the next record.\r\n" + //
                                        "o\t[P]revious: Move to the previous record.\r\n" + //
                                        "o\t[F]irst: Move to the first record.\r\n" + //
                                        "o\t[L]ast: Move to the last record.\r\n" + //
                                        "o\t[E]xit: Exit the application.\r\n" + //
                                        "o\t[I]nsert: Insert a new record\r\n" + //
                                        "o\t[D]elete: Delete the record");
                    inp = sc.next().toUpperCase();

                    if (inp.contentEquals("N")) {
                        if (rs.next()) {
                            System.out.println("Next Customer Record is\n" + "Name : " + rs.getString("name") + "\tEmail : " + rs.getString("email")+ "\tPhone : " + rs.getString("phone") + "\n");
                        } else {
                            System.out.println("You are in the last row .");
                            rs.moveToCurrentRow();
                        }
                    } else if (inp.contentEquals("P")) {
                        if (rs.previous()) {
                            System.out.println("Previous Customer Record is\n" + "Name : " + rs.getString("name") + "\tEmail : " + rs.getString("email")+ "\tPhone : " + rs.getString("phone") + "\n");
                        } else {
                            System.out.println("You are in the first row .");
                            rs.moveToCurrentRow();
                        }
                    } else if (inp.contentEquals("F")) {
                        if (rs.first()) {
                            System.out.println("First Customer Record is\n" + "Name : " + rs.getString("name") + "\tEmail : " + rs.getString("email")+ "\tPhone : " + rs.getString("phone") + "\n");
                        }
                    } else if (inp.contentEquals("L")) {
                        if (rs.last()) {
                            System.out.println("Last Customer Record is\n" + "Name : " + rs.getString("name") + "\tEmail : " + rs.getString("email")+ "\tPhone : " + rs.getString("phone") + "\n");
                        }
                    }  else if (inp.contentEquals("I")) {
                        // can you insert where ever you want
                        rs.moveToInsertRow();
                        System.out.println("Enter name : ");
                        rs.updateString(2, sc.next()); 
                        System.out.println("Enter email : ");
                        rs.updateString(3,sc.next()); 
                        System.out.println("Enter Phone Number : ");
                        rs.updateString(4, sc.next()); 
                        rs.insertRow();
                        rs.moveToCurrentRow();
                        System.out.println("Data added.\n");
                    } else if (inp.contentEquals("D")) {
                        if (rs.next()) {
                            System.out.println("Delete record id: ");
                            int id = rs.getInt("id");
                            rs.deleteRow();
                            System.out.println("Deleted record " + id + "\n");
                            rs.moveToCurrentRow();
                        } else {
                            System.out.println("You are in the end of table. ");
                            rs.moveToCurrentRow();
                        }
                    }
                }
            }
            // Close the result set
            rs.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and the connection
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
