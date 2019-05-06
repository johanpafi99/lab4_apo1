package MODEL;
public class Room{

	private int number;
	private Pet pet;

	public Room(int theNumber, Pet thePet){
		number = theNumber;
		pet = thePet;
	}

	public int getNumber(){
		return number;
	}
  public Pet getPet(){
		return pet;
	}
	public void setNumber(int number){
		this.number = number;
	}
	public void setPet(Pet pet){
		this.pet = pet;
	}
}
