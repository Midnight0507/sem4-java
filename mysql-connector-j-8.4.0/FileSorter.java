import java.io.*;

public class YearSorter implements Runnable{
	BufferedReader FileReader;

	FileSorter(BufferedReader FileReader) {
		this.FileReader = FileReader;
	}

	@Override
	public void run(){
		for (int i = 0; i< 900; i++) {}

		System.out.println("Sorted based on Year");

	}
}

public class SalarySorter implements Runnable{
	BufferedReader FileReader;

	FileSorter(BufferedReader FileReader) {
		this.FileReader = FileReader;
	}

	@Override
	public void run(){
		for (int i = 0; i< 900; i++) {}

		System.out.println("Sorted based on Salary");

	}
}

public class WriteRecords implements Runnable{
	BufferedReader FileReader;

	FileSorter(BufferedReader FileReader) {
		this.FileReader = FileReader;
	}

	@Override
	public void run(){
		for (int i = 0; i< 900; i++) {}

		System.out.println("Records Written");

	}
}

public class FileSorter{
	public static void main(String[] args) {
		SalarySorter s = new SalarySorter();
		

		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
		}
		catch(IOException e) {

		}

	}
}