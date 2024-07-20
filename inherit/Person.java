@SuppressWarnings("unused")
public class Person
{
    protected String name;
    private int age;
    private String gender;
    private float weight;

    public Person(String name, int age,String gender,float weight) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
    }

    void cantalk()
	{
		System.out.println("Can talk");
	}
	void caneat()
	{
		System.out.println("Can eat");
	}

}