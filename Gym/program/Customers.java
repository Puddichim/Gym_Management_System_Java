package program;

public class Customers extends Person implements ICustomer1{
	
	private float Price;
	private float Weight;
	private float Height;
	private String PhoneNum;
	
	public Customers(String Name, int Age, int ID,String Gender,float Price,float Weight,float Height,String PhoneNum) {
		super(Name,Age,ID,Gender);
		this.Price = Price;
		this.Weight = Weight;
		this.Height = Height;
		this.PhoneNum = PhoneNum;
	}
	
	


	public Customers(String name, int age, int iD, String gender, float price, String phoneNum) {
		super(name, age, iD, gender);
		Price = price;
		PhoneNum = phoneNum;
		Weight = -1f;
		Height = -1f;
	}




	public float getPrice() {
		return Price;
	}
	public void setPrice(float Price) {
		this.Price = Price;
	}

	public float getWeight() {
		return Weight;
	}

	public void setWeight(float Weight) {
		this.Weight = Weight;
	}

	public float getHeight() {
		return Height;
	}

	public void setHeight(float Height) {
		this.Height = Height;
	}

	public String getPhoneNum() {
		return PhoneNum;
	}

	public void setPhoneNum(String PhoneNum) {
		this.PhoneNum = PhoneNum;
	}
	
	public float calculateDiscount(int Package) {
		float discount =0f;
		switch (Package) {
		case 1:
			discount = 0f;
			break;
		case 2:
			discount = 50f;
			break;
		case 3:
			discount = 200f;
			break;
		case 4:
			discount = 600f;
			break;
		default:
			break;
			
		}
		return discount;
	}
	
	public float calculateBodyIndex(float Weight, float Height) {	
		float bodyIndex =(Weight*Weight)/ Height;
		
		return bodyIndex;
		
	}

}
