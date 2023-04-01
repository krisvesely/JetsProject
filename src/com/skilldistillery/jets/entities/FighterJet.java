package com.skilldistillery.jets.entities;

public class FighterJet extends Jet {
	public FighterJet() {
	}

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public String toString() {
		return "Fighter Jet: " + super.toString();
	}

}
