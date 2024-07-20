@SuppressWarnings("unused")
public class Student extends Person
{
    private byte year;
    private String section;
    private String department;
    private int subjects;
    private int[] marks;
    private float cgpa;

    public Student(String name, byte age, String gender, float weight, byte year, String section, String department,int subjects ,int[] marks, float cgpa) {
        super(name, age, gender, weight);
        // parameterized constructor//
        this.year = year;
        this.section = section;
        this.subjects = subjects;
        this.marks = marks;
        this.cgpa = cgpa;
    }

    public void printName() {
        System.out.println("Name: " + name); // Accessing the inherited 'name' variable
    }


    void calculatecgpa() {
        float avg = 0.0f; // Initialize avg to 0.0
        for (int mark : marks) {
            avg += mark;
        }
        avg /= marks.length;
    
        // Determine CGPA based on average
        float temp_cgpa;
        if (avg >= 90) {
            temp_cgpa = 10.0f;
        } else if (avg >= 80) {
            temp_cgpa = 9.0f;
        } else if (avg >= 70) {
            temp_cgpa = 8.0f;
        } else if (avg >= 60) {
            temp_cgpa = 7.0f;
        } else if (avg >= 50) {
            temp_cgpa = 6.0f;
        } else if (avg >= 40) {
            temp_cgpa = 5.0f;
        } else if (avg >= 30) {
            temp_cgpa = 4.0f;
        } else {
            temp_cgpa = 3.0f;
        }
        
        cgpa = (cgpa + temp_cgpa) / 2; // Updating cgpa
        System.out.println("Your CGPA is " + cgpa);
    }
    

	void postgraduateapplication()
	{
		if(year==4 && cgpa>=8.0)
		{
			System.out.println("you are eligible to apply for post graduation");
		}
		else
		{
			System.out.println("you cannot apply for post graduation");
		}
	}
}