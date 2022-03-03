package program;

public class OneMonthCus extends Customers{
	
	public OneMonthCus(String Name, int Age, int ID_No,String Gender,float Price,float Weight,float Height,String PhoneNum ) {
		super(Name,Age,ID_No,Gender,Price,Weight,Height,PhoneNum);
	}
	
public float calculateDiscount(int dayNo, int Package) {
		
		return dayNo*Package;
	}
	
	public float calculateBodyIndex(float Weight, float Height) {
		
		return (Weight*Weight)/ Height;
	}
}
