package program;

public class Over1Year extends Customers {
	
	public Over1Year(String Name, int Age, int ID_No,String Gender, float Price,float Weight,float Height,String PhoneNum ) {
		super(Name,Age,ID_No,Gender,Price,Weight,Height,PhoneNum);
	}
	
	public float calculateDiscount(int dayNo, int Package) {
		
		return dayNo*Package;
	}
	
	public float calculateBodyIndex(float Weight, float Height) {
		
		return (Weight*Weight)/ Height;
	}
	
	public boolean checkAthlete() {
		return false;
	}
}
