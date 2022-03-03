package program;


public class Pool extends Places{
	
	private float depth;
	
	public Pool(String Name,int Floor,float Size,int PeopleCapacity,int numberofPeople,float depth) {
		super(Name,Floor,Size,PeopleCapacity,numberofPeople);
		this.depth = depth;
	}

	public float getDepth() {
		return depth;
	}

	public void setDepth(float depth) {
		this.depth = depth;
	}
	
	public void classificationPool() {
		
		if(getDepth() >=2) {
			new ChildPool(Name, Floor, Size, PeopleCapacity, numberofPeople,depth);
		}
		else {
			new AdultPool(Name, Floor, Size, PeopleCapacity, numberofPeople,depth);
		}
		
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

