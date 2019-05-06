package MODEL;
import java.util.ArrayList;
public class Pet{

	private String name;
	private String typePet;
	private int age;
	private double weight;

	private ArrayList<ClinicHistory> historys;

	public Pet(String theName, String theTypePet, int theAge, double theWeight){
	name = theName;
	typePet = theTypePet;
	age = theAge;
	historys = new ArrayList<>();
	weight = theWeight;
	}

	public String getName(){
		return name;
	}
  public String getTypePet(){
		return typePet;
	}
  public int getAge(){
		return age;
	}
  public double getWeight(){
		return weight;
	}
  public ArrayList<ClinicHistory> getHistorys(){
		return historys;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setTypePet(String typePet){
		this.typePet = typePet;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setWeigth(double weight){
		this.weight = weight;
	}

	public void historyAdd(ClinicHistory hist,int day, int month, int year){
		historys.add(hist);
		for(int k = 0; k<historys.size();k++){
			if(historys.get(k)== hist){
				historys.get(k).dateAdd( day, month, year);
			}
		}
	}

	public ClinicHistory foundHistory(){
		ClinicHistory hist = null;
		for(int i =0; i<historys.size();i++){
			if(historys.get(i).getState() == true){
				hist = historys.get(i);
			}
		}
		return hist;
	}

	//-------------------------------------------------------------------------------------------

  public double petIncome(){
		double sum = 0.0;
		for(int i = 0; i< historys.size(); i++){
			sum += historys.get(i).medicationCost();
		}
		return sum;
	}

	public int dateOfPet(int dayN, int monthN, int yearN){
		int daysPet = 0;
		for(int i = 0; i< ClinicHistory.MAX_DATE; i++){
				int day2 =historys.get(i).dateHospitalization().getDay();
				int month2= historys.get(i).dateHospitalization().getMonth();
				int year2 = historys.get(i).dateHospitalization().getYear();
			if(historys.get(i).dateExit()!= null){
				int day1 =historys.get(i).dateExit().getDay();
				int month1= historys.get(i).dateExit().getMonth();
				int year1 = historys.get(i).dateExit().getYear();

				daysPet += 360*(year1-year2)+30*(month1-month2)+(day1-day2);
			}else{
				daysPet += 360*(year2-yearN)+30*(month2-monthN)+(day2-dayN);
			}
		}
		return daysPet;
	}

	public boolean stateHistory(){
		boolean hist = false;
		for(int i =0; i<historys.size() && hist != true;i++){
			if(historys.get(i).getState() != false){
				hist = true;
			}
		}
		return hist;
	}

	//-----------------------------------------------------------------------------------------

  public String seeData(){
		String msg = "";
		for(int i = 0; i<historys.size();i++){
			if(historys.get(i).dateExit() == null){
				msg += "income on the date " + historys.get(i).dateHospitalization().getDay() + "/" + historys.get(i).dateHospitalization().getMonth() + "/" + historys.get(i).dateHospitalization().getYear()+"\n";
				msg += "Admission with symptoms: \n" + historys.get(i).getSymptom() + "\n";
				msg += "Possible diagnosis: \n" + historys.get(i).getDiagnostic() +"\n";
				msg += "it was supplied: \n" + historys.get(i).nameMedicine();
			}
		}
		return msg;
	}

	//--------------------------------------------------------------------------------

  public ArrayList<String> seeDataAnimal(){
		ArrayList<String> menssage = new ArrayList<>();
		String msg = "";
		for(int i = 0; i<historys.size();i++){
				msg += "income on the date " + historys.get(i).dateHospitalization().getDay() + "/" + historys.get(i).dateHospitalization().getMonth() + "/" + historys.get(i).dateHospitalization().getYear()+"\n";
				if(historys.get(i).dateExit()!= null){
					msg += "out on the date " + historys.get(i).dateExit().getDay() + "/" + historys.get(i).dateExit().getMonth() + "/" + historys.get(i).dateExit().getYear()+"\n";
				}
				msg += "Admission with symptoms: \n" + historys.get(i).getSymptom() + "\n";
				if(historys.get(i).getState()!= false){
				msg += "the story is: \n" + " open \n";
				}else{
					msg += "the story is: \n" + " close \n";
				}
				msg += "Possible diagnosis: \n" + historys.get(i).getDiagnostic() +"\n";
				msg += "it was supplied: \n" + historys.get(i).nameMedicine();
				menssage.add(msg);
		}
		return menssage;
	}

	//----------------------------------------------------------------------------

  public int dateOfPet1(int dayN, int monthN, int yearN){
		int daysPet = 0;
		for(int i = 0; i< ClinicHistory.MAX_DATE; i++){
				int day2 =historys.get(i).dateHospitalization().getDay();
				int month2= historys.get(i).dateHospitalization().getMonth();
				int year2 = historys.get(i).dateHospitalization().getYear();
			if(historys.get(i).dateExit()!= null){
				int day1 =historys.get(i).dateExit().getDay();
				int month1= historys.get(i).dateExit().getMonth();
				int year1 = historys.get(i).dateExit().getYear();
				daysPet += 360*(year1-year2)+30*(month1-month2)+(day1-day2);
			}
		}
		return daysPet;
	}

	public double medicationCost(){
		double cost = 0.0;
		for(int i = 0; i< ClinicHistory.MAX_DATE; i++){
			if(historys.get(i).dateExit()!= null){
				historys.get(i).medicationCost();
			}
		}
		return cost;
	}
	//--------------------------------------------------------------------------------------

  public ArrayList<String> seeLastDataAnimal(){
		ArrayList<String> menssage = new ArrayList<>();
		String msg = "";
		for(int i = 0; i<historys.size();i++){
				if(historys.get(i).dateExit()!= null){
					if(historys.get(i).getState()!= true){
					msg += "income on the date " + historys.get(i).dateHospitalization().getDay() + "/" + historys.get(i).dateHospitalization().getMonth() + "/" + historys.get(i).dateHospitalization().getYear()+"\n";
					msg += "out on the date " + historys.get(i).dateExit().getDay() + "/" + historys.get(i).dateExit().getMonth() + "/" + historys.get(i).dateExit().getYear()+"\n";
					msg += "Admission with symptoms: \n" + historys.get(i).getSymptom() + "\n";
					msg += "Possible diagnosis: \n" + historys.get(i).getDiagnostic() +"\n";
					msg += "it was supplied: \n" + historys.get(i).nameMedicine();
					menssage.add(msg);
					}
				}
		}
		return menssage;
	}	
}
