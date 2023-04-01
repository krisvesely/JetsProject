package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet {
	public PassengerJet() {
	}

	public PassengerJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public String toString() {
		return "Passenger Jet: " + super.toString();
	}

}
