package program;

public class Dietician extends Employee implements IEmployee1 {
	
	private Customers[] respCustomer = new Customers[100];
	int i = 0;
		

	
		public Dietician(String name, int age, int iD, String gender, float salary, String phoneNum) {
		super(name, age, iD, gender, salary, phoneNum);
	}

		public Dietician(String name, int age, int iD, String gender, float salary, String phoneNum,
				Customers[] respCustomer) {
			super(name, age, iD, gender, salary, phoneNum);
			this.respCustomer = respCustomer;
		}


		public Customers[] getRespCustomer() {
			return respCustomer;
		}
	
		public void setRespCustomer(Customers[] respCustomer) {
			this.respCustomer = respCustomer;
		}
		
		public void addNewCustomer(Customers a) {
			respCustomer[i] = a;
			i++;
			
		}
		public float calculateSalary(int dayNo, int multiply) {
			
			return (dayNo*multiply);
		}	

}
