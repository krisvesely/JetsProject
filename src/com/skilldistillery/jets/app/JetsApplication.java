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
				airfield.listFleet();
				break;
			case 2:
				airfield.fly();
				break;
			case 3:
				airfield.findFastest();
				break;
			case 4:
				airfield.findBestRange();
				break;
			case 5:
				airfield.loadCargoJets();
				break;
			case 6:
				airfield.dogfight();
				break;
			case 7:
				addAJet(airfield, sc);
				break;
			case 8:
				rmAJet(airfield, sc);
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
	
	public void addAJet(Airfield airfield, Scanner sc) {
		int typeNum = 0;
		String type = null;
		boolean validType = false;
		do {
			addJetMenu();
			typeNum = sc.nextInt();
			sc.nextLine();
			switch (typeNum) {
			case 1:
				type = "Passenger";
				validType = true;
				break;
			case 2:
				type = "Cargo";
				validType = true;
				break;
			case 3:
				type = "Fighter";
				validType = true;
				break;
			default:
				System.out.println("\nInvalid entry. Please enter a whole number '1' through '3'");
			}
		} while (!validType);
		System.out.print("\nPlease enter the jet's model: ");
		String model = sc.nextLine();
		System.out.print("Enter the jet's speed in mph: ");
		double speed = sc.nextDouble();
		System.out.print("Enter the jet's range in miles: ");
		int range = sc.nextInt();
		System.out.print("Enter the jet's price in USD: $");
		long price = sc.nextLong();
		airfield.createAJet(type, model, speed, range, price);
		System.out.println("\nWelcome to the fleet, " + model + "!");
	}
	
	public void addJetMenu() {
		System.out.print("\nWhat type of jet are you adding?\n"
				+ "\n1. Passenger Jet"
				+ "\n2. Cargo Plane"
				+ "\n3. Fighter Jet\n"
				+ "\nPlease enter 1-3 according to your Jet type: ");
	}
	
	public void rmAJet(Airfield airfield, Scanner sc) {
		int jetToDelete = 0;
		boolean validIndex = false;
		do {
			airfield.listWithIndex();
			System.out.print("\nPlease enter the list number of the jet to remove: ");
			jetToDelete = sc.nextInt();
			sc.nextLine();
			if (jetToDelete > 0 && jetToDelete <+ airfield.getFleet().size()) {
				validIndex = true;
			}
			else {
				System.out.println("\nInvalid entry. Please enter a whole number from the menu.");
			}
		} while (!validIndex);
		System.out.println("\n" + airfield.rmJet(jetToDelete) + " has been removed from the fleet.");
	}
}
