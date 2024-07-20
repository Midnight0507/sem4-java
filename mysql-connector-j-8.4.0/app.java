import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

// Parsing Array
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class app {
    public static void main(String[] args) throws Exception {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/test"; // Database URL
        String username = "root"; // Database username
        String password = "root"; // Database password

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

            // Execute a query
            statement.executeUpdate("Create table smartphones(Smartphone varchar(50) NOT NULL,Brand  varchar(20),Model varchar(10),RAM INT,Storage INT,Color varchar(20),Free varchar(10),Final_Price Double);");
            System.out.println("Table named smartphones created");


            // Process the result set
            int i = 5;
            while (resultSet.next() &&  i < 10) {
                i++;
                System.out.println("empno: " + resultSet.getString("city"));
                System.out.println("ename: " + resultSet.getString("Mobile"));
            }

            // Close the result set
            resultSet.close();
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


    public static String parseCSV(String filename) {
        String joinedString = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int col = 1;
            List<String> rows = new ArrayList<String>();
            while ((line = reader.readLine()) != null) {
                List<String> columns = new ArrayList<String>();    
                // Do something with the line
                try {
                    String[] values = line.split(",");
                    if (col==1) {
                        for (int i = 0; i < values.length; i++) {
                            columns.add(values[i]);
                        }
                    }             
                } catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("Ec");
                } finally {
                    if (col!=1) {
                        rows.add("(" + line + ")");
                    }
                    col += 1;
                    
                }
            }
            reader.close();

            joinedString = String.join(",", rows);
           
           
        }catch (IOException e) {
            e.printStackTrace();
        }
        return joinedString;
    }
}