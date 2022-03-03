package program;

public class ThreeMonthCus extends Customers {
	
	public ThreeMonthCus(String Name, int Age, int ID_No ,String Gender,float Price,float Weight,float Height,String PhoneNum ) {
		super(Name,Age,ID_No,Gender,Price,Weight,Height,PhoneNum);
		
	}
	
public float calculateDiscount(int dayNo, int Package) {
		
		return dayNo*Package;
	}
	
	public float calculateBodyIndex(float Weight, float Height) {
		
		return (Weight*Weight)/ Height;
	}

}
