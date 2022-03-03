package program;

public class Security extends Employee implements IEmployee2 {

	private Places[] respPlace = new Places[100];

	int i = 0;

	public Security(String name, int age, int iD, String gender, float salary, String phoneNum) {
		super(name, age, iD, gender, salary, phoneNum);
	}
	public Security(String name, int age, int iD, String gender, float salary, String phoneNum, Places[] respPlace) {
		super(name, age, iD, gender, salary, phoneNum);
		this.respPlace = respPlace;
	}


	public Places[] getRespPlace() {
		return respPlace;
	}

	public void setRespPlace(Places[] respPlace) {
		this.respPlace = respPlace;
	}

	public void addNewPlace(Places a) {
		respPlace[i] = a;
		i++;
	}

	public float calculateSalary(int dayNo, float multiply) {

		return (dayNo * multiply);
	}
	public  void checkEntryCart(int ID_No) {
		int i;
		for(i=0;i<100;i++){
			try {
			if(ID_No == OfficeService.getCustomer()[i].getID()) {
				
				System.out.println("Giris Basarili");
				break;
			}	
			}catch(Exception e) {
				System.out.println("Basarisiz");
				break;
				
			}
			
		}
		
	}

}
