package program;

public class Main {
	public static void main(String[] args) {
		
		
		
		OneMonthCus c1 = new OneMonthCus("mert1", 21, 12451245,"kýz",200f,65f,174f,"05048656");
		ThreeMonthCus c2 = new ThreeMonthCus("mert2", 21, 124512435,"erkek",200f,65f,174f,"05048656");	
		SixMonthCus c3 = new SixMonthCus("mert3", 21, 124512445,"erkek",200f,65f,174f,"05048656");	
		SixMonthCus c4 = new SixMonthCus("mert4", 21, 124512465,"erkek",200f,65f,174f,"05048656");	
		Over1Year c5 = new Over1Year("mert5", 21, 124512441,"erkek",200f,65f,1745f,"050486565");

		Trainers t1 = new Trainers("Mert", 20, 2202001, "Erkek",2000f,"191112031");
		
		
		OfficeService OfS = new OfficeService("mustafa", 25, 7001995, "kýz",1000f,"9999999");
		Security Sec1 = new Security("mustafa", 25, 1201995, "Erkek",3000f, "10000001");
		t1.addNewCustomer(c1);
		OfS.addNewOneCustomer(c1);
		OfS.addNewThreeCustomer(c2);
		OfS.addNewSixCustomer(c3);
		OfS.addNewSixCustomer(c4);
		OfS.addNewOverYearCustomer(c5);
		System.out.print("\n-----------------------------------------------\n");
		OfS.checkPersonData(124512445);
		
		Sec1.checkEntryCart(124512435);
		System.out.print("\n-----------------------------------------------\n");
		Sec1.checkEntryCart(1245124655);
		System.out.print("\n-----------------------------------------------\n");
		Sec1.checkEntryCart(124512465);
		System.out.print("\n-----------------------------------------------\n");
		Sec1.checkEntryCart(124512441);
		System.out.print("\n-----------------------------------------------\n");
		
		Customers swimmer = new Customers("ismail",12,2324,"erkek",567f,"854684569");
		System.out.print(swimmer.calculateDiscount(2)+" tl indirim uygulandý.");
		System.out.print("\n-----------------------------------------------\n");
	
		
	}
}
