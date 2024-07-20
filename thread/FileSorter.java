import java.io.*;
import java.util.*;

class DataWriter {

  private String filePath;

  public DataWriter(String filePath) {
    this.filePath = filePath;
  }

  public void writeDataToFile(List<String> data) throws IOException {
    try (FileWriter writer = new FileWriter(filePath)) {
      for (String row : data) {
        // Remove parentheses and commas within quotes
        String cleanData = row.substring(1, row.length() - 1).replaceAll("\"", "");
        writer.write(cleanData + "\n");
      }
      writer.flush();
    }
  }
}


class WeightComparator implements Comparator<String> {

    @Override
    public int compare(String row1, String row2) {
        String[] data1 = row1.substring(1, row1.length() - 1).split(","); // Remove quotes and split
        String[] data2 = row2.substring(1, row2.length() - 1).split(",");
        try {
          // Assuming weight is the second column (index 1)
          return Double.compare(Double.parseDouble(data1[1]), Double.parseDouble(data2[1]));
        } catch (NumberFormatException e) {
          // Handle non-numeric weight values
          return 0;
        }
    }
}

class SalaryComparator implements Comparator<String> {

    @Override
    public int compare(String row1, String row2) {
        String[] data1 = row1.substring(1, row1.length() - 1).split(","); // Remove parentheses and commas within quotes
        String[] data2 = row2.substring(1, row2.length() - 1).split(",");
        try {
            // Assuming salary is the second column (index 1)
            return Double.compare(Double.parseDouble(data1[2]), Double.parseDouble(data2[2]));
        } catch (NumberFormatException e) {
        // Handle non-numeric salary values
        return 0;
        }
    }
}

class WeightSorter implements Runnable {

    private List<String> br;
    private DataWriter writer;

    public WeightSorter(List<String> br, DataWriter writer) {
        this.br = br;
        this.writer = writer;
    }

    @Override
    public void run() {
        Collections.sort(br, new WeightComparator());
        try {
          writer.writeDataToFile(br);
          System.out.println("Sorted based on Weights and written to file");
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
}


class SalarySorter implements Runnable {

  private List<String> br;
  private DataWriter writer;

  public SalarySorter(List<String> br, DataWriter writer) {
    this.br = br;
    this.writer = writer;
  }

  @Override
  public void run() {
    Collections.sort(br, new SalaryComparator());
    try {
      writer.writeDataToFile(br);
      System.out.println("Sorted based on Salary and written to file");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class WriteRecords implements Runnable {

    String FilePath;

    WriteRecords(String filepath) {
        this.FilePath = filepath;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new record details (Name, Age, Salary):");
        String name = scanner.nextLine();
        String age = scanner.nextLine();
        String salary = scanner.nextLine();
        String newRecord = String.join(",", name , age, salary);
        try (FileWriter writer = new FileWriter("info.csv", true)) {
            writer.write("\n" + newRecord);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Record Added");
    }
}



public class FileSorter {

    public static void main(String[] args) {
        String filePath = "info.csv";
        Scanner sc = new Scanner(System.in);
        String inp = "";

        List<String> columns = parseCSV(filePath);
        List<String> new_columns = parseCSV(filePath);
        DataWriter weightSort = new DataWriter("sorted_weight.csv"); // Specify output file
        DataWriter salarySort = new DataWriter("sorted_salary.csv"); // Specify output file
        DataWriter sort = new DataWriter("sorted.csv"); // Specify output file


        while (!inp.equalsIgnoreCase("E")) {
            System.out.println("o\t[A]dd: Add new records to data.\r\n" +
                "o\t[S]ort: Sort by weight and salary.\r\n" +
                "o\t[E]xit: Exit the application.");

            inp = sc.next().toUpperCase();
            System.out.println("----------------------------------------");
            switch (inp) {
                case "A":
                    Thread wr = new Thread(new WriteRecords(filePath));
                    wr.start();
                    try {
                        wr.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "S":
                    Thread ss = new Thread(new SalarySorter(columns, sort));
                    ss.start();

                    Thread ws = new Thread(new WeightSorter(new_columns, sort));
                    ws.start();
                    break;

                case "E":
                    System.out.println("Bye Bye!");
                    break;
            }
        }
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