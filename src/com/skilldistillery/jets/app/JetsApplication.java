package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.Airfield;

public class JetsApplication {

	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.launch();
	}
	
	public void launch() {
		System.out.println("Welcome to the Jets Application!");
		Airfield airfield = new Airfield();
		menu(airfield);
	}
	
	public void menu(Airfield airfield) {
		boolean menuOpen = true;
		Scanner sc = new Scanner(System.in);
		do {
			printMenu();
			int menuChoice = sc.nextInt();
			sc.nextLine();
			switch (menuChoice) {
			case 1:
				airfield.listFleet(airfield);
				break;
			case 2:
				airfield.fly(airfield);
				break;
			case 3:
				airfield.findFastest(airfield);
				break;
			case 4:
				airfield.findBestRange(airfield);
				break;
			case 5:
				airfield.loadCargoJets(airfield);
				break;
			case 6:
				airfield.dogfight(airfield);
				break;
			case 7:
				System.out.print("\nPlease enter the jet's model: ");
				String model = sc.nextLine();
				System.out.print("Enter the jet's speed in mph: ");
				double speed = sc.nextDouble();
				System.out.print("Enter the jet's range in miles: ");
				int range = sc.nextInt();
				System.out.print("Enter the jet's price in USD: $");
				long price = sc.nextLong();
				airfield.addJet(airfield, model, speed, range, price);
				System.out.println("\nWelcome to the fleet, " + model + "!");
				break;
			case 8:
				airfield.listWithIndex(airfield);
				System.out.print("\nPlease enter the list number of the jet to remove: ");
				int jetToDelete = sc.nextInt();
				sc.nextLine();
				System.out.println("\n" + airfield.rmJet(airfield, jetToDelete) + " has been removed from the fleet.");
				break;
			case 9:
				System.out.println("\nGoodbye.");
				menuOpen = false;
				break;
			default:
				System.out.println("\nInvalid entry. Please enter a whole number '1' through '9'");
				}
//			sc.nextLine();
		} while (menuOpen);
		sc.close();
	}
	
	public void printMenu() {
		System.out.println("\n:::::::::::::::  MENU  :::::::::::::::\n"
				+ "1. View the complete fleet list\n"
				+ "2. Fly all jets in the fleet\n"
				+ "3. View the fatest jet in the fleet\n"
				+ "4. View the jet with the longest range\n"
				+ "5. Load all cargo jets\n"
				+ "6. Dogfight\n"
				+ "7. Add a jet to the fleet\n"
				+ "8. Remove a jet from the fleet\n"
				+ "9. Quit\n"
				+ "::::::::::::::::::::::::::::::::::::::\n");
		System.out.print("Please enter a number 1-9, corresponding to your menu choice: ");
	}

}
