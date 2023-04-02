package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {
	public FighterJet() {
	}

	public FighterJet(String model, double speed, int range, long price, String pilot) {
		super(model, speed, range, price, pilot);
	}
	
	public void fight() {
		System.out.println(getModel() + " crew attitude: " + crewStatus());
	}

	public String crewStatus() {
		String[] randomStatuses = new String[] {
				"\"I feel the need ... the need for speed.\"",
				"\"Remember boys, no points for second place.\"",
				"\"It's not the plane, it's the pilot.\"",
				"\"Kowabunga!\"",
				"\"Buckle up!\"",
				"\"Just a walk in the park, Kazansky.\""};
		int randomIndex = (int) (randomStatuses.length * Math.random());
		return randomStatuses[randomIndex];
	}
	
	@Override
	public void fly() {
		super.fly();
		System.out.println(", Pilot " + getPilot() + " says: " + pilotSays());;
	}
	
	public String pilotSays() {
		String[] fighterPilotSays = new String[] {
				"\"Let's go supersonic!\"",
				"\"Buckle up - it's gonna be a fast ride.\"",
				"\"Grab your barf bag.\""};
		int randomIndex = (int) (fighterPilotSays.length * Math.random());
		return fighterPilotSays[randomIndex];
	}
	@Override
	public String toString() {
		double machSpeed = getSpeed() / 761.2;
		machSpeed = Math.round(machSpeed * 10.0) / 10.0;
		return "Fighter Jet: " + "Model: " + getModel() + ", Pilot: " + getPilot() + ", Speed: Mach " 
				+ machSpeed + ", Range: " + getRange() + " miles, Price: $" + getPrice();
	}

}
