import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class csvP {
    public static void main(String[] args) {
        String filePath = "csv/smartphones.csv"; // Replace with the actual file path

        List<String> columns = parseCSV(filePath);

        System.out.println(columns.get(0));

        System.out.println(columns.get(3));

        // System.out.println(columns);
    }

    public static List<String> parseCSV(String filename) {

        List<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            List<String> data = new ArrayList<String>();
            int col = 1;
            while ((line = reader.readLine()) != null) {   
                // Do something with the line
                try {
                    String[] values = line.split(",");
                    for (int i = 0; i < values.length; i++) {
                        if (col == 1) {
                            data.add('"'+values[i]+'"');
                        } else {
                            try {
                                Integer.parseInt(values[i]);
                                data.add(values[i]);
                            } catch (NumberFormatException e) {
                                try {
                                    Double.parseDouble(values[i]);
                                    data.add(values[i]);
                                } catch (NumberFormatException ex) {
                                    data.add('"'+values[i]+'"');
                                }
                            }
                        }
                    }
                } catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("Ec");
                } finally {
                    result.add("(" + String.join(",", data) + ")");
                    data.clear();
                    col += 1;
                }
            }
            reader.close();
           
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
