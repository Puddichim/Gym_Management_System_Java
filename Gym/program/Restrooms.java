package program;

public class Restrooms extends Places {
	
	public Restrooms(String Name,int Floor,float Size,int PeopleCapacity,int numberofPeople) {
		super(Name,Floor,Size,PeopleCapacity,numberofPeople);
	}
	
	public boolean isSuitEpidemic(int numberofPeople) {
		
		if(getPeopleCapacity() >= (numberofPeople))
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
