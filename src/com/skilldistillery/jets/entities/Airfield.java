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
	

	public void fly() {
		
	}
	
	public void findFastest() {
		
	}

	public void findBestRange() {
		
	}
	public void loadCargoJets() {
		
	}

	public void dogfight() {
		
	}

	public void addJet() {
		
	}
	
	public void rmJet() {
		
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
