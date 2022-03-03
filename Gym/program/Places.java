package program;

public class Places {
	
	protected String Name;
	protected int Floor;
	protected float Size;
	protected int PeopleCapacity;
	protected int numberofPeople;
	

	public Places(String name, int floor, float size) {
		Name = name;
		Floor = floor;
		Size = size;
	}

	public Places(String Name,int Floor,float Size,int PeopleCapacity,int numberofPeople) {
		this.Name = Name;
		this.Floor = Floor;
		this.Size = Size;
		this.PeopleCapacity = PeopleCapacity;
		this.numberofPeople = numberofPeople;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public int getFloor() {
		return Floor;
	}

	public void setFloor(int Floor) {
		this.Floor = Floor;
	}

	public float getSize() {
		return Size;
	}

	public void setSize(float Size) {
		this.Size = Size;
	}

	public int getPeopleCapacity() {
		return PeopleCapacity;
	}

	public void setPeopleCapacity(int PeopleCapacity) {
		this.PeopleCapacity = PeopleCapacity;
	}
	
	public void setNumberofPeople(int numberofPeople) {
		this.numberofPeople = numberofPeople;
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
