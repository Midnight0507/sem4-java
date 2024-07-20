class Test {
    public static void main(String[] args) 
    {
        // Person p = new Person("Suthi", 18, "Female", 50);
        // Person p1 = new Person("Malyam", 21, "Male", 80);


        Student s = new Student("Malyam", (byte)21, "Male", 80.0f, (byte)4, "B", "CSD",80,new int[] {80,80,80}, 7.3f);
        System.out.println("Protected key word used before variable declaration " + s.name);
        s.calculatecgpa();	
		s.postgraduateapplication();
    }
}