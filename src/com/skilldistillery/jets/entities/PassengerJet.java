package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet {
	public PassengerJet() {
	}

	public PassengerJet(String model, double speed, int range, long price, String pilot) {
		super(model, speed, range, price, pilot);
	}
	
	@Override
	public void fly() {
		super.fly();
		System.out.println(", Pilot " + getPilot() + " says: " + pilotSays());;
	}
	
	public String pilotSays() {
		String[] passPilotSays = new String[] {
				"\"Hor d'oeuvres will be served once we reach cruising altitude.\"",
				"\"Today's in-flight entertainment will be the movie Top Gun.\"",
				"\"Please ensure that your seatback trays are secured in the upright position for takeoff.\""};
		int randomIndex = (int) (passPilotSays.length * Math.random());
		return passPilotSays[randomIndex];
	}

	@Override
	public String toString() {
		return "Passenger Jet: " + super.toString();
	}
}
