package program;

public class Employee extends Person {
	
	private float Salary;
	private String PhoneNum;
	
	public Employee(String name, int age, int iD, String gender, float salary, String phoneNum) {
		super(name, age, iD, gender);
		Salary = salary;
		PhoneNum = phoneNum;
	}
	

	public float getSalary() {
		return Salary;
	}

	public void setSalary(float Salary) {
		this.Salary = Salary;
	}
	
	public float calculateSalary(int dayNo, int multiply) {
		return (dayNo*multiply);
	}

	public String getPhoneNum() {
		return PhoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}
	
}
