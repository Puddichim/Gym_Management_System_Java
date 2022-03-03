package program;

public class Person {
	
	private String Name;
	private int Age;
	private int ID;
	private String Gender;
	//Constructor
	
	public Person(String name, int age, int iD, String gender) {
		super();
		Name = name;
		Age = age;
		ID = iD;
		Gender = gender;
	}

	//getters and setters functions
	public String getName() {
		return Name;
	}
	
	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	

	public void setName(String Name) {
		this.Name = Name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int Age) {
		this.Age = Age;
	}



	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
		
	
}
