package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Airfield {
	private List<Jet> fleet;

	public Airfield() {
		readFromFile();
	}

	public List<Jet> readFromFile() {
		fleet = new ArrayList<>();

		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String aJet;
			while ((aJet = bufIn.readLine()) != null) {

				String[] jetDetails = aJet.split(",");
				String type = jetDetails[0];
				String model = jetDetails[1];
				double speed = Double.parseDouble(jetDetails[2]);
				int range = Integer.parseInt(jetDetails[3]);
				long price = Long.parseLong(jetDetails[4]);
				createAJet(type, model, speed, range, price);
			}
		} catch (IOException e) {
			System.err.println(e);
		}		
		return fleet;
	}
	
	public void createAJet(String type, String model, double speed, int range, long price) {
		Jet newJet = null;
		if (type.equals("Passenger")) {
			newJet = new PassengerJet(model, speed, range, price);
		}
		else if (type.equals("Cargo")) {
			newJet = new CargoPlane(model, speed, range, price);
		} 
		else if (type.equals("Fighter")) {
			newJet = new FighterJet(model, speed, range, price);
		}
		fleet.add(newJet);
	}
	
	public void listFleet() {
		System.out.println();
		for (int i = 0; i < fleet.size(); i++) {
			System.out.println(fleet.get(i));
		}
	}

	public void fly() {
		System.out.println();
		for (int i = 0; i < fleet.size(); i++) {
			fleet.get(i).fly();
		}
	}
	public void findFastest() {
		double max = fleet.get(0).getSpeed();
		for (int i = 1; i < fleet.size(); i++) {
			if (max <= fleet.get(i).getSpeed()) {
				max = fleet.get(i).getSpeed();
			}
		}
		System.out.println("\nHere's the fatest jet, with a speed of " + (int)max + " mph:");
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i).getSpeed() == max) {
				System.out.println(fleet.get(i));
			}
		}
	}
	public void findBestRange() {
		double max = fleet.get(0).getRange();
		for (int i = 1; i < fleet.size(); i++) {
			if (max <= fleet.get(i).getRange()) {
				max = fleet.get(i).getRange();
			}
		}
		System.out.println("\nHere's the jet with the longest range, which is " + (int)max + " miles:");
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i).getRange() == max) {
				System.out.println(fleet.get(i));
			}
		}
	}
	public void loadCargoJets() {
		System.out.println();
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i) instanceof CargoPlane) {
				((CargoPlane) fleet.get(i)).loadCargo();
			}
		}
	}
	public void dogfight() {
		System.out.println();
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i) instanceof FighterJet) {
				((FighterJet) fleet.get(i)).fight();
			}
		}
	}
//	public void addJet(String model, double speed, int range, long price) {
//		Jet createAJet = new PassengerJet(model, speed, range, price);
//		fleet.add(createAJet);
//	}
	
	public void listWithIndex() {
		System.out.println();
		for (int i = 0; i < fleet.size(); i++) {
			int menuIndex = i + 1;
			System.out.println(menuIndex + ": " + fleet.get(i));
		}
	}
	public String rmJet(int jetToDelete) {
		String deletedModel = fleet.get(jetToDelete - 1).getModel();
		fleet.remove(jetToDelete - 1); 
		return deletedModel;
	}
	public List<Jet> getFleet() {
		return fleet;
	}
	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}
	@Override
	public String toString() {
		return "Airfield [fleet=" + fleet + "]";
	}
}
