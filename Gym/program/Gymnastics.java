package program;

public class Gymnastics extends Stretching {
	
	public Gymnastics(String Name,int Floor,float Size,int PeopleCapacity,int numberofPeople) {
		super(Name,Floor,Size,PeopleCapacity,numberofPeople);
	}
	
	public boolean isSuitEpidemic(int numberofPeople,float Size) {
		
		if(calculatePeopleCapacity(Size) >= (numberofPeople))
			return true;
		else return false;
				
	}
	
	public int calculatePeopleCapacity(float Size) {
		return (int) (Size/2);
	}
	public boolean isMessy() {
		return false;
		
	}
	
}