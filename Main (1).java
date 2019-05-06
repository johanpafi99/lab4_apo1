package UI;
import MODEL.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{

	private Veterinary veterinary;
	private Scanner reader;

	public Main(){
		init();
		reader = new Scanner(System.in);
	}

	public static void main(String[] args){
		Main m = new Main();
		m.menu();
		m.showMenu();
	}

	public void menu(){
		welcome();
	}

	public void welcome(){
    System.out.println(".............................................................................");
    System.out.println("--------------------           My Little Pet.            --------------------");
    System.out.println(".............................................................................");
	}

	public void showMenu(){
		int userInput=0;
		while(userInput!=12){
			showOptions();
			userInput = reader.nextInt();
			reader.nextLine();
			if(userInput==1){
	    System.out.println("Client name:");
		String name = reader.nextLine();
		System.out.println("Client  iD:");
		int id = reader.nextInt();
		System.out.println("Client address:");
		String address = reader.nextLine();
		System.out.println("Client  cell:");
		int phoneNumber = reader.nextInt();
		System.out.println("How many pets does the client have?:");
		int quantityPets = reader.nextInt();
		reader.nextLine();
		 for(int i = 0; i < quantityPets; i++){
      System.out.println("...........................................................................");
			System.out.println("Mascot "+(i+1)+":");
			System.out.println("Mascot name:");
			String nameM = reader.nextLine();
			System.out.println("Mascot age:");
			int age = reader.nextInt();
			reader.nextLine();
			System.out.println("Mascot weight:");
			double weight = reader.nextDouble();
			reader.nextLine();
			System.out.println("Mascot type(1 for cat, 2 for dog, 3 for bird, 4 for others):");
			int mascotType = reader.nextInt();
			String type = "";
			if(mascotType == 1){
				type = "Cat";
			}else if(mascotType == 2){
				type = "Dog";
			}else if(mascotType == 3){
				type = "Bird";
			}else if(mascotType == 4){
				type = "Other";
			}else{
				System.out.println("Ingrese un tipo valido");
			}
			System.out.println(veterinary.addClient( name, id, address , phoneNumber, nameM, type, age, weight));
		}
		System.out.println("The client was added successfully");
	}
		else if(userInput==2){
			int error = 0;
		  while (error == 0){
			System.out.println("Enter the id of the pet owner");
			int id = reader.nextInt();
			System.out.println("Enter the name of the pet who wants to hospitalize");
			String nameM = reader.nextLine();
							boolean state = true;
							System.out.println("What symptoms does the pet have?");
							String symptom = reader.nextLine();
							System.out.println("What is the possible diagnosis of the pet?");
							String diagnostic = reader.nextLine();
							System.out.println("enter the current day");
							int day = reader.nextInt();
							System.out.println("enter the current month (please the number)");
							int month = reader.nextInt();
							System.out.println("enter the current year");
							int year = reader.nextInt();
							System.out.println("How many medicines does the animal need?");
							int medicines = reader.nextInt();
							System.out.println("Enter the name of medicine");
							String nameMedicine = reader.nextLine();
							System.out.println("Enter the quantity of medicine for dose (mlg)");
							double quantify = reader.nextDouble();
							System.out.println("Enter the price of medicine for mlg");
							double price = reader.nextDouble();
							System.out.println("Enter the frecuency with whom you drink medicine for hour");
							double frecuency = reader.nextDouble();
							System.out.println("Enter the quantity of dose");
							int doseGiven = reader.nextInt();
							System.out.println(veterinary.createHistoryPet(id, nameM, symptom,diagnostic, state, day, month, year, nameMedicine, quantify, price, frecuency, doseGiven));
							int option = reader.nextInt();
							error = 1;
			}
			}
			else if(userInput==3){
				System.out.println("Enter the id of the pet owner");
				int id = reader.nextInt();
				System.out.println("Enter the name of the pet who was discharge");
				String nameM = reader.nextLine();
				System.out.println("Enter the current day.");
				int day = reader.nextInt();
				System.out.println("Enter the current month (please the number)");
				int month = reader.nextInt();
				System.out.println("Enter the current year");
				int year = reader.nextInt();
				if(veterinary.closeHistory(id, nameM, day, month , year ) != false){
					System.out.println("The history of the mascot has been closed");
				}else{
					System.out.println("No active medical history or pet was found, please re-enter the data");
				}
			}
			else if(userInput==4){
				System.out.println("Please enter the current day");
				int dayN = reader.nextInt();
				System.out.println("Please enter the current month (in numbers)");
				int monthN = reader.nextInt();
				System.out.println("Please enter the current year");
				int yearN = reader.nextInt();
				System.out.println("The veterinary's income is" + " $" + veterinary.veterinaryIncome(dayN, monthN, yearN) + "$");
			}
			else if(userInput==5){
				System.out.println("Enter the id of the pet owner");
				int id = reader.nextInt();
				System.out.println("Enter the name of the pet you want to attach the story to");
				String nameM = reader.nextLine();
				System.out.println("the story is activated? \n" + "1. yes \n" + "2. not \n");
				int activated = reader.nextInt();
				boolean state = false;
				if(activated == 1){
				state = true;
				}else if(activated == 2){
					state = false;
				}
				System.out.println("What symptoms does the pet have?");
				String symptom = reader.nextLine();
				System.out.println("What is the possible diagnosis of the pet?");
				String diagnostic = reader.nextLine();
				System.out.println("enter the current day");
				int day = reader.nextInt();
				System.out.println("enter the current month (please the number)");
				int month = reader.nextInt();
				System.out.println("enter the current year");
				int year = reader.nextInt();
				System.out.println("How many medicines does the animal need?");
				int medicines = reader.nextInt();
				for(int e = 0; e<medicines; e++){
				System.out.println(veterinary.hospitalizePet(id, nameM));
				System.out.println("Enter the name of medicine");
				String nameMedicine = reader.nextLine();
				System.out.println("Enter the quantity of medicine for dose (mlg)");
				double quantify = reader.nextDouble();
				System.out.println("Enter the price of medicine for mlg");
				double price = reader.nextDouble();
				System.out.println("Enter the frecuency with whom you drink medicine for hour");
				double frecuency = reader.nextDouble();
				System.out.println("Enter the quantity of dose");
				int doseGiven = reader.nextInt();
				System.out.println(veterinary.createHistoryPet(id, nameM, symptom,diagnostic, state, day, month, year, nameMedicine, quantify, price, frecuency, doseGiven));
				}
			}
			else if (userInput==6){
				System.out.println("Enter the name of pet");
				String nameM = reader.nextLine();
				if(veterinary.availabilityThePet(nameM)!= false){
					if(veterinary.petsRoom(nameM) != 0){
					System.out.println("The number of the petsRoom is " + veterinary.petsRoom(nameM));
					}else{
						System.out.println("the pet is not in any room");
					}
				}else{
					System.out.println("The pet is not hospitalized :)");
				}
			}
			else if(userInput==7){
				System.out.println("Enter the name of the pet wonder");
				String name = reader.nextLine();
				System.out.println("Enter the name of the pet ");
				String nameM = reader.nextLine();
				System.out.println(veterinary.seeDataAnimal(name, nameM));
			}
			else if (userInput==8){
				System.out.println("Enter the name of the pet wonder");
				String name = reader.nextLine();
				System.out.println("Enter the name of the pet ");
				String nameM = reader.nextLine();
				System.out.println("Please enter the current day");
				int dayN = reader.nextInt();
				System.out.println("Please enter the current month (in numbers)");
				int monthN = reader.nextInt();
				System.out.println("Please enter the current year");
				int yearN = reader.nextInt();
				System.out.println("The cost of hospitalization is" + veterinary.costPet(name, nameM, dayN, monthN, yearN) + "$");
			}
			else if (userInput==9){
				System.out.println("The stories of hospitalized pets are:");
				System.out.println(veterinary.showPetsHospitalizad());
			}
			else if (userInput==10){
				System.out.println("Enter the name of the pet ");
				String name = reader.nextLine();
				System.out.println(veterinary.dataWonderPet(name));
			}else if (userInput==11){
				System.out.println("Enter the name of the pet wonder");
				String name = reader.nextLine();
				System.out.println("Enter the name of the pet ");
				String nameM = reader.nextLine();
				System.out.println("The history of previous hospitalizations are:");
				System.out.println(veterinary.seeLastDataAnimal( name, nameM));
			}
		}
	}
public void showOptions(){
  System.out.println("---------------------------------------------------------------------------");
  System.out.println("PLEASE TYPE THE OPTION YOU WANT TO REVIEW.");
  System.out.println("                                                                          |");
  System.out.println("1.Register Client and Pet.\n ");
  System.out.println("                                                                          |");
  System.out.println("2.Hospitalize the pet.\n");
  System.out.println("                                                                          |");
  System.out.println("3.Close the clinical history ");
  System.out.println("                                                                          |");
  System.out.println("4.Know the veterinary income");
  System.out.println("                                                                          |");
  System.out.println("5.Append a clinical history");
  System.out.println("                                                                          |");
  System.out.println("6.Number of the pet's room");
  System.out.println("                                                                          |");
  System.out.println("7. See the clinical history of an animal");
  System.out.println("                                                                          |");
  System.out.println("8. Calculate the cost of a hospitalization");
  System.out.println("                                                                          |");
  System.out.println("9. See all historyz of the veterinary");
  System.out.println("                                                                          |");
  System.out.println("10. give the contact of the owner of a hospitalized animal");
  System.out.println("                                                                          |");
  System.out.println("11. Previous clinical history of a pet");
  System.out.println("                                                                          |");
  System.out.println("12. Exit the program");
  System.out.println("---------------------------------------------------------------------------");
}
public void init(){
}
}
