package MODEL;
import java.util.ArrayList;
public class Veterinary{

	public final static int ROOMS_MAX = 8;
	private String name;

	private Room[] rooms;
	private ArrayList<ClinicHistory> history;
	private ArrayList<Client> clients;

	public Veterinary(String theName){
		name = theName;
		rooms = new Room[ROOMS_MAX];
		history = new ArrayList<>();
		clients = new ArrayList<>();
	}

	public String getName(){
		return name;
	}
  public Room[] getRooms(){
		return rooms;
	}
  public ArrayList<ClinicHistory> getHistory(){
		return history;
	}
  public ArrayList<Client> getClients(){
		return clients;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setRooms(Room[] rooms){
		this.rooms = rooms;
	}

	//------------------------------------------------------------------------------
	public String addClient(String name, int id, String address , int phoneNumber, String nameM, String type, int age, double weight){
		String msg = "";
		Client customer = new Client(name, id, address, phoneNumber);
		clients.add(customer);
		int u = 0;
		for(int i = 0; i < clients.size(); i++){
			if(foundClient(id, i) != false){
				clients.get(i).addPet(nameM, type, age, weight);
			}else{
				msg = "The client wasn't finded, please enter the identifier again";
			}
		}
		return msg;
	}

	//--------------------------------------------------------------------------------------------------

  public boolean foundClient(int id, int i){
		boolean foundClient = false;
		if(id == clients.get(i).getId()){
			foundClient = true;
		}
		return foundClient;
	}

	//--------------------------------------------------------------

	public boolean foundPet(int i,int k, String name){
		boolean foundPet = false;
		if(name.equals(clients.get(i).positionOfThePet(k).getName())){
			foundPet = true;
		}
		return foundPet;
	}

	//-------------------------------------------------------------------------------------

  public boolean availabilityOfTheRoom(int room){
		boolean menssage = false;
		if(rooms[room].getPet() != null){
			menssage = false;
		}
		else{
			menssage = true;
		}
		return menssage;
	}

	//-----------------------------------------------------------------------------------------

  public String createHistoryPet(int id, String nameM, String symptom, String diagnostic, boolean state, int day, int month, int year, String nameMedicine, double quantify, double price, double frecuency, int doseGiven){
		String menssage = "";
		Medicine medicine = new Medicine(nameMedicine, quantify, price, frecuency, doseGiven);
		ClinicHistory hist = new ClinicHistory(state, symptom, diagnostic);
		for(int i = 0; i<clientSize();i++){
			if(clients.get(i).getId()==id){
				int k = i;
				for(int u = 0; u<petSize(i); u++){
					int w = u;
				if(foundPet(k , w, nameM)!= false){
					clients.get(i).addHistory(hist, u, day, month, year);
					clients.get(i).foundHistory(k).addMedication(medicine);
					menssage = "The clinical history has been created";
				}else{
					menssage = "Unable to create the clinical history";
				}
				}
			}else{
				menssage = "Unable to create the clinical history";
			}
		}
		return menssage;
	}

	//---------------------------------------------------------------------------------------------

  public boolean closeHistory(int id, String nameM, int day, int month, int year ){
		boolean close = false;
		for(int i = 0; i<clientSize(); i++){
			if(foundClient(id, i)!=false && close != true){
				for(int k = 0; k< petSize(i); k++)
					if(foundPet(i, k, nameM) != false && close != true){
						for(int e = 0; e < ROOMS_MAX; e++){
							if(clients.get(i).positionOfThePet(k) == rooms[e].getPet()){
								rooms[e].setPet(null);
								clients.get(i).foundHistory(k).addDateExit(day, month, year);
								clients.get(i).foundHistory(k).setState(false);
								close = true;
							}
						}
					}
			}
		}
		return close;
	}

	//---------------------------------------------------------------------------------

  public String hospitalizePet(int id,String nameM){
		String menssage = "";
		for(int i = 0; i<clients.size(); i++){
			if(foundClient(id, i) != false){
				for(int u = 0; u<petSize(i); u++){
					if(foundPet(i, u, nameM) !=false){
						for(int k = 0; k<ROOMS_MAX; k++){
							if(availabilityOfTheRoom(k) != false){
								String name = nameM;
								String type = clients.get(i).positionOfThePet(u).getTypePet();
								int age = clients.get(i).positionOfThePet(u).getAge();
								double weight = clients.get(i).positionOfThePet(u).getWeight();
								Pet pet = new Pet(name, type, age, weight);
								rooms[k].setPet(pet);
							}else{
								menssage = "there are no rooms available.";
							}
						}
				}else{
						menssage = "the pet was not found";
					}
				}
			}else{
				menssage = "The client was not found";
			}
		}
		return menssage;
	}

	//----------------------------------------------------------------------------------------------

  public int clientSize(){
		return clients.size();
	}

	public int petSize(int i){
		return clients.get(i).petSize();
	}

	//----------------------------------------------------------------------------

  public double veterinaryIncome(int dayN, int yearN, int monthN){
		double sum = 0.0;
		for(int i = 0; i<clientSize();i++){
			sum += clients.get(i).petsCost(dayN, yearN, monthN);
		}
		return sum;
	}

	//-------------------------------------------------------------------------------------

  public int petsRoom(String nameM){
		int number = 0;
		for(int i = 0; i<ROOMS_MAX;i ++){
			if(nameM.equals(rooms[i].getPet().getName())){
				number = i++;
			}
		}
		return number;
	}

	//-------------------------------------------------------------

  public boolean availabilityThePet(String nameM){
		boolean availability= false;
		for(int i = 0; i<clientSize()&&availability != true; i++){
			for(int k = 0; k<clients.get(i).petSize(); k++){
				if(foundPet(k, i, nameM)!=false){
					availability=clients.get(i).stateHistory(k);
				}
			}
		}
		return availability;
	}

	//------------------------------------------------------

  public String showPetsHospitalizad(){
		String msg = "";
		for(int i = 0; i<clients.size();i++){
			msg+= "----------------------------------------" + "\n";
			msg+= clients.get(i).showPetsHospitalizad();
		}
		return msg;
	}

	//----------------------------------------------------------------------------

  public String seeDataAnimal(String name,String nameM){
		String msg = "";
		for(int i = 0; i<clients.size();i++){
			if(name.equals(clients.get(i).getName())){
				if(clients.get(i).seeDataAnimal(name)!=null){
				msg = clients.get(i).seeDataAnimal(name);
				}
			}
		}
		return msg;
	}

	//----------------------------------------------------------------------

  public double costPet(String name, String nameM,int dayN, int monthN, int yearN){
		double cost = 0.0;
		for(int i = 0; i<clients.size();i++){
			if(name.equals(clients.get(i).getName())){
				cost += clients.get(i).costPet( name, dayN, monthN, yearN);
			}
		}
		return cost;
	}

	//------------------------------------------------------------------------

  public String seeLastDataAnimal(String name,String nameM){
		String msg = "";
		for(int i = 0; i<clients.size();i++){
			if(name.equals(clients.get(i).getName())){
				if(clients.get(i).seeLastDataAnimal(name)!=null){
				msg = clients.get(i).seeDataAnimal(name);
				}
			}
		}
		return msg;
	}


	public String dataWonderPet(String name){
		String msg = "";
		for(int i = 0; i<ROOMS_MAX;i ++){
			if(name.equals(rooms[i].getPet().getName())){
				for(int k = 0; k<clients.size(); k++){
					for(int e = 0; e< clients.get(i).petSize(); e++){
						if(name.equals(clients.get(i).positionOfThePet(e).getName())){
							msg += "The name of the pet wonder is " + clients.get(i).getName() + "\n";
							msg += "The address of the pet wonder is " + clients.get(i).getAddress() + "\n";
							msg += "The phone of the pet wonder is " + clients.get(i).getPhoneNumber() + "\n";
						}
					}
				}
			}
		}
		return msg;
	}
}
