package MODEL;
import java.util.ArrayList;
public class ClinicHistory{

	private boolean state;
	private String symptom;
	private String diagnostic;
	public final static int MAX_DATE = 1;

	private ArrayList<Client> human;
	private ArrayList<Medicine> medicine;
	private Date[] dateHospitalization;
	private Date[] dateExit;

	public ClinicHistory(boolean theState, String theSymptom, String theDiagnostic){
		state = theState;
		symptom = theSymptom;
		diagnostic = theDiagnostic;
		human = new ArrayList<>();
		medicine = new ArrayList<>();
		dateHospitalization = new Date[MAX_DATE];
		dateExit = new Date[MAX_DATE];
	}

	public boolean getState(){
		return state;
	}
  public String getSymptom(){
		return symptom;
	}
  public String getDiagnostic(){
		return diagnostic;
	}
  public ArrayList<Client> getHuman(){
		return human;
	}
  public ArrayList<Medicine> getMedicine(){
		return medicine;
	}
	public Date[] getDateHospitalization(){
		return dateHospitalization;
	}
  public Date[] getDateExit(){
		return dateExit;
	}
  public void setSymptom(String symptom){
		this.symptom = symptom;
	}
	public void setState(boolean state){
		this.state = state;
	}
	public void setDiagnostic(String diagnostic){
		this.diagnostic = diagnostic;
	}
	public void setDateHospitalization(Date[] dateHospitalization){
		this.dateHospitalization = dateHospitalization;
	}
	public void setDateExit(Date[] dateExit){
		this.dateExit = dateExit;
	}

	//---------------------------------------------------------------------------------------

  public void dateAdd(int day, int month, int year){
		Date date = new Date(day, month, year);
		dateHospitalization[0]=date;
	}

	//----------------------------------------------------------------------------------------

  public void addDateExit(int day, int month, int year){
		Date date = new Date(day, month, year);
		dateExit[0] = date;
	}

	//-----------------------------------------------------------------------------------------------

  public void addMedicine(String name, double quantify, double price, double frecuency, int doseGiven){
		Medicine medicines = new Medicine(name,quantify, price, frecuency, doseGiven);
		medicine.add(medicines);
	}

	//----------------------------------------------------------------------------------------

  public double medicationCost(){
		double sum = 0.0;
		for(int i = 0; i < medicine.size(); i++){
			double quantify = medicine.get(i).getQuantify();
			double price = medicine.get(i).getPrice();
			double doseGiven = medicine.get(i).getDoseGiven();
			sum += (quantify*price)*doseGiven;
		}
		return sum;
	}

	public void addMedication(Medicine medicines){
		medicine.add(medicines);
	}

	//------------------------------------------------------------------------------------

  public Date dateExit(){
		return dateExit[0];
	}
	public Date dateHospitalization(){
		return dateHospitalization[0];
	}

	//--------------------------------------------------------------

  public String nameMedicine(){
		String msg = "";
		for(int i = 0; i<medicine.size();i++){
			msg += "" + medicine.get(i).getName() + "\n";
		}
		return msg;
	}

}
