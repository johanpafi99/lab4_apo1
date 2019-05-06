package MODEL;
public class Medicine{

	private String name;
	private double quantify;
	private double price;
	private double frecuency;
	private int doseGiven;

	public Medicine(String theName, double theQuantify, double thePrice, double theFrecuency, int theDoseGiven){
		name = theName;
		quantify = theQuantify;
		price = thePrice;
		frecuency = theFrecuency;
		doseGiven = theDoseGiven;
	}

	public String getName(){
		return name;
	}
  public double getQuantify(){
		return quantify;
	}
  public double getPrice(){
		return price;
	}
  public double getFrecuency(){
		return frecuency;
	}
  public int getDoseGiven(){
		return doseGiven;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setQuantify(double quantify){
		this.quantify = quantify;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public void setFrecuency(double frecuency){
		this.frecuency = frecuency;
	}
	public void setDoseGiven(int doseGiven){
		this.doseGiven = doseGiven;
	}


	public double medicineCost(){
		return (quantify*price)*doseGiven;
	}

}
