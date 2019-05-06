package MODEL;
import java.util.ArrayList;
public class Client{

	private String name;
	private int id;
	private String address;
	private int phoneNumber;

	public final static String C = "Cat";
	public final static String D = "Dog";
	public final static String B = "Bird";
	public final static String O = "Other";

	private ArrayList<Pet> pets;

	public Client(String theName, int theId, String theAddress, int thePhoneNumber){
		name = theName;
		id = theId;
		address = theAddress;
		phoneNumber = thePhoneNumber;
		pets = new ArrayList<>();
	}

	public String getName(){
		return name;
	}
  public int getId(){
		return id;
	}
  public String getAddress(){
		return address;
	}
  public int getPhoneNumber(){
		return phoneNumber;
	}
  public ArrayList<Pet> getPets(){
		return pets;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setId(int id){
		this.id = id;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setPhoneNumber(int phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public void addPet(String nameM, String type, int age, double weight){
		Pet pet = new Pet(nameM, type, age, weight);
		pets.add(pet);
	}
	public int petSize(){
		return pets.size();
	}
	public Pet positionOfThePet(int i){
		Pet pet = pets.get(i);
		return pet;
	}
	public void addHistory(ClinicHistory hist, int i, int day, int month, int year){
		pets.get(i).historyAdd(hist, day, month, year);
	}
	//---------------------------------------------------------------------------------------------
	public ClinicHistory foundHistory(int i){
		return pets.get(i).foundHistory();
	}
	//--------------------------------------------------------------------------------------------
	public double petsCost(int dayN, int monthN, int yearN){
		double sum = 0.0;
		for(int i = 0; i< petSize();i++){
			if("Car".equals(pets.get(i).getTypePet())){
				if(1.0<=pets.get(i).getWeight() && 3.0>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*10000;
				}else if(3.1<=pets.get(i).getWeight() && 10>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*12000;
				}else if(10.1<=pets.get(i).getWeight() && 20>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*15000;
				}else{
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*20000;
				}
			}else if("Dog".equals(pets.get(i).getTypePet())){
				if(1.0<=pets.get(i).getWeight() && 3.0>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*15000;
				}else if(3.1<=pets.get(i).getWeight() && 10>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*17000;
				}else if(10.1<=pets.get(i).getWeight() && 20>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*20000;
				}else{
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*25000;
				}
			}else if("Bird".equals(pets.get(i).getTypePet())){
				if(1.0<=pets.get(i).getWeight() && 3.0>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*10000;
				}else if(3.1<=pets.get(i).getWeight() && 10>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*12000;
				}else if(10.1<=pets.get(i).getWeight() && 20>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*20000;
				}else{
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*25000;
				}
			}else if("Other".equals(pets.get(i).getTypePet())){
				if(1.0<=pets.get(i).getWeight() && 3.0>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*10000;
				}else if(3.1<=pets.get(i).getWeight() && 10>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*17000;
				}else if(10.1<=pets.get(i).getWeight() && 20>=pets.get(i).getWeight() ){
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*30000;
				}else{
					sum+= (pets.get(i).dateOfPet(dayN, monthN, yearN))*30000;
				}
			}
		}
		return sum;
	}
	public boolean stateHistory(int i){
		return pets.get(i).stateHistory();
	}
	//----------------------------------------------------------------------------------------------
	public ArrayList<String> showPetsHospitalizad(){
		ArrayList<String> menssage = new ArrayList<>();
		String msg = "";
		for(int i = 0; i<pets.size();i++){
			if(stateHistory(i) != false){
				msg += "The name of the pet is " + pets.get(i).getName() + " is a"+ pets.get(i).getTypePet() +"\n";
				msg += pets.get(i).seeData();
				menssage.add(msg);
			}
		}
		return menssage;
	}
	//-----------------------------------------------------------------------------------
	public String seeDataAnimal(String name){
		String msg = "";
		for(int i = 0; i<pets.size(); i++){
			if(name.equals(pets.get(i).getName())){
				for(int k = 0; k<pets.get(i).seeDataAnimal().size(); k++ ){
				msg = pets.get(i).seeDataAnimal().get(k);
				}
			}
		}
		return msg;
	}
	//---------------------------------------------------------------------------------------
	public double costPet(String name, int dayN, int monthN, int yearN){
		double cost = 0.0;
		for(int i = 0; i<pets.size(); i++){
			if(name.equals(pets.get(i).getName())){
				if("Car".equals(pets.get(i).getTypePet())){
				if(1.0<=pets.get(i).getWeight() && 3.0>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1( dayN,  monthN,  yearN))*10000;
				}else if(3.1<=pets.get(i).getWeight() && 10>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*12000;
				}else if(10.1<=pets.get(i).getWeight() && 20>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*15000;
				}else{
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*20000;
				}
			}else if("Dog".equals(pets.get(i).getTypePet())){
				if(1.0<=pets.get(i).getWeight() && 3.0>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*15000;
				}else if(3.1<=pets.get(i).getWeight() && 10>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*17000;
				}else if(10.1<=pets.get(i).getWeight() && 20>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*20000;
				}else{
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*25000;
				}
			}else if("Bird".equals(pets.get(i).getTypePet())){
				if(1.0<=pets.get(i).getWeight() && 3.0>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*10000;
				}else if(3.1<=pets.get(i).getWeight() && 10>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*12000;
				}else if(10.1<=pets.get(i).getWeight() && 20>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*20000;
				}else{
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*25000;
				}
			}else if("Other".equals(pets.get(i).getTypePet())){
				if(1.0<=pets.get(i).getWeight() && 3.0>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*10000;
				}else if(3.1<=pets.get(i).getWeight() && 10>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*17000;
				}else if(10.1<=pets.get(i).getWeight() && 20>=pets.get(i).getWeight() ){
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*30000;
				}else{
					cost+= (pets.get(i).dateOfPet1(dayN, monthN, yearN))*30000;
				}
			}
			cost += pets.get(i).medicationCost();
			}
		}
		return cost;
	}
	//--------------------------------------------------------------------------------
	public String seeLastDataAnimal(String name){
		String msg = "";
		for(int i = 0; i<pets.size(); i++){
			if(name.equals(pets.get(i).getName())){
				for(int k = 0; k<pets.get(i).seeLastDataAnimal().size(); k++)
				msg = pets.get(i).seeLastDataAnimal().get(k);
			}
		}
		return msg;
	}
}
