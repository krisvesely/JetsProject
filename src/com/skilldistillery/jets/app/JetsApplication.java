package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.Airfield;

public class JetsApplication {

	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.launch();
	}
	
	public void launch() {
		System.out.println("Welcome to the Jets Application, where you can fly the friendly, or combatant, skies!");
		Airfield airfield = new Airfield();
		menu(airfield);
	}
	
	public void menu(Airfield airfield) {
		boolean menuOpen = true;
		Scanner sc = new Scanner(System.in);
		do {
			printMenu();
			int menuChoice = sc.nextInt();
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
				airfield.addJet(airfield);
				break;
			case 8:
				airfield.rmJet(airfield);
				break;
			case 9:
				System.out.println("\nGoodbye.");
				menuOpen = false;
				break;
			default:
				System.out.println("\nInvalid entry. Please enter a whole number '1' through '9'");
				}
			sc.nextLine();
		} while (menuOpen);
		sc.close();
	}
	
	public void printMenu() {
		System.out.println("\nPlease enter a number 1-9, corresponding to your menu choice:\n"
				+ "1. View the complete fleet list\n"
				+ "2. Fly all jets in the fleet\n"
				+ "3. View the fatest jet in the fleet\n"
				+ "4. View the jet with the longest range\n"
				+ "5. Load all cargo jets\n"
				+ "6. Dogfight\n"
				+ "7. Add a jet to the fleet\n"
				+ "8. Remove a jet from the fleet\n"
				+ "9. Quit");
	}

}
