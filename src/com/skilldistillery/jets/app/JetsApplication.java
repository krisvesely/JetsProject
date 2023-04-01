package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.Airfield;

public class JetsApplication {

	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.launch();
	}
	
	public void launch() {
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
				for (int i = 0; i < airfield.getFleet().size(); i++) {
					System.out.println(airfield.getFleet().get(i));
				}
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
				airfield.addJet();
				break;
			case 8:
				airfield.rmJet();
				break;
			case 9:
				System.out.println("\nGoodbye.");
				menuOpen = false;
				break;
			default:
				System.out.println("\nInvalid entry. Please enter a number '1', '2', '3', or '4'");
				}
			sc.nextLine();
		} while (menuOpen);
		sc.close();
	}
	
	public void printMenu() {
		System.out.println("Please enter a number 1-9, corresponding to your menu choice: "
				+ "1. View the complete fleet list"
				+ "2. Fly all jets in the fleet"
				+ "3. View the fatest jet in the fleet"
				+ "4. View the jet with the longest range"
				+ "5. Load all cargo jets"
				+ "6. Dogfight"
				+ "7. Add a jet to the fleet"
				+ "8. Remove a jet from the fleet"
				+ "9. Quit");
	}

}
