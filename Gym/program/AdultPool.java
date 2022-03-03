package program;

public class AdultPool extends Pool {
	
	public AdultPool(String Name,int Floor,float Size,int PeopleCapacity,int numberofPeople,float depth) {
		super(Name,Floor,Size,PeopleCapacity,numberofPeople,depth);
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
