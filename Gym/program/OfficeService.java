package program;

public class OfficeService extends Employee  {
	
	private static Customers[] customer = new Customers[100];
	private OneMonthCus[] oneMontcus = new OneMonthCus[100];
	private ThreeMonthCus[] threeMontcus = new ThreeMonthCus[100];
	private SixMonthCus[] sixMonthcus = new SixMonthCus[100];
	private Over1Year[] OneYearcus = new Over1Year[100];
	int i = 0 , j = 0, k = 0, l = 0,d = 0;

	
	public OfficeService(String name, int age, int iD, String gender, float salary, String phoneNum) {
		super(name, age, iD, gender, salary, phoneNum);
	}

	public float calculate(int dayNo, int multiply) {
		
		return (dayNo*multiply);
	}
	
	public void addNewCustomer(Customers a){
		customer[i] = a;
		i++;
	}
	public void addNewOneCustomer(OneMonthCus a){
		oneMontcus[j] = a;
		customer[i] = a;
		i++;
		j++;
		System.out.println("office");
	}
	public void addNewThreeCustomer(ThreeMonthCus a){
		threeMontcus[k] = a;
		customer[i] = a;
		i++;
		k++;
		System.out.println("office");
	}
	public void addNewSixCustomer(SixMonthCus a){
		sixMonthcus[l] = a;
		customer[i] = a;
		i++;
		l++;
		System.out.println("office");
	}
	public void addNewOverYearCustomer(Over1Year a){
		OneYearcus[d] = a;
		customer[i] = a;
		i++;
		d++;
		System.out.println("office");
	}
	public void checkPersonData(int ID_No) {
		int i;
		for(i=0;i<100;i++){
			if(customer[i].getID() == ID_No) {
				System.out.println("ismi :"+ customer[i].getName());
				System.out.println("yasi :"+ customer[i].getAge());
				System.out.println("cinsiyeti :"+ customer[i].getGender());
				System.out.println("id nosu :"+ customer[i].getID());
				System.out.println("ödenecek ucret :"+ customer[i].getPrice());
				System.out.println("kilosu :"+ customer[i].getWeight());
				System.out.println("boyu :"+ customer[i].getHeight());
				System.out.println("telefon numarasi :"+ customer[i].getPhoneNum());
				break;
			}
				
		}
	}

	public static Customers[] getCustomer() {
		return customer;
	}

	public void setCustomer(Customers[] customer) {
		this.customer = customer;
	}
	
	
}