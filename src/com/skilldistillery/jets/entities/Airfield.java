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
				Jet createAJet = null;

				if (type.equals("Passenger")) {
					createAJet = new PassengerJet(model, speed, range, price);
				}
				else if (type.equals("Cargo")) {
					createAJet = new CargoPlane(model, speed, range, price);
				} 
				else if (type.equals("Fighter")) {
					createAJet = new FighterJet(model, speed, range, price);
				}
				fleet.add(createAJet);
			}
		} catch (IOException e) {
			System.err.println(e);
		}		
		return fleet;
	}
	public void listFleet(Airfield airfield) {
		System.out.println();
		for (int i = 0; i < airfield.getFleet().size(); i++) {
			System.out.println(airfield.getFleet().get(i));
		}
	}

	public void fly(Airfield airfield) {
		System.out.println();
		for (int i = 0; i < airfield.getFleet().size(); i++) {
			airfield.getFleet().get(i).fly();
		}
	}
	public void findFastest(Airfield airfield) {
		double max = airfield.getFleet().get(0).getSpeed();
		for (int i = 1; i < airfield.getFleet().size(); i++) {
			if (max <= airfield.getFleet().get(i).getSpeed()) {
				max = airfield.getFleet().get(i).getSpeed();
			}
		}
		System.out.println("\nHere's the fatest jet, with a speed of " + max + " mph:");
		for (int i = 0; i < airfield.getFleet().size(); i++) {
			if (airfield.getFleet().get(i).getSpeed() == max) {
				System.out.println(airfield.getFleet().get(i));
			}
		}
	}
	public void findBestRange(Airfield airfield) {
		double max = airfield.getFleet().get(0).getRange();
		for (int i = 1; i < airfield.getFleet().size(); i++) {
			if (max <= airfield.getFleet().get(i).getRange()) {
				max = airfield.getFleet().get(i).getRange();
			}
		}
		System.out.println("\nHere's the jet with the longest range, which is " + max + " miles:");
		for (int i = 0; i < airfield.getFleet().size(); i++) {
			if (airfield.getFleet().get(i).getRange() == max) {
				System.out.println(airfield.getFleet().get(i));
			}
		}
	}
	public void loadCargoJets(Airfield airfield) {
		System.out.println();
		for (int i = 0; i < airfield.getFleet().size(); i++) {
			if (airfield.getFleet().get(i) instanceof CargoPlane) {
				((CargoPlane) airfield.getFleet().get(i)).loadCargo();
			}
		}
	}
	public void dogfight(Airfield airfield) {
		System.out.println();
		for (int i = 0; i < airfield.getFleet().size(); i++) {
			if (airfield.getFleet().get(i) instanceof FighterJet) {
				((FighterJet) airfield.getFleet().get(i)).fight();
			}
		}
	}
	public void addJet(Airfield airfield, String model, double speed, int range, long price) {
		Jet createAJet = new PassengerJet(model, speed, range, price);
		fleet.add(createAJet);
	}
	
	public void listWithIndex(Airfield airfield) {
		System.out.println();
		for (int i = 0; i < airfield.getFleet().size(); i++) {
			int menuIndex = i + 1;
			System.out.println(menuIndex + ": " + airfield.getFleet().get(i));
		}
	}
	public String rmJet(Airfield airfield, int jetToDelete) {
		String deletedModel = airfield.getFleet().get(jetToDelete - 1).getModel();
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

// only the airfield can talk to the jets' many methods
