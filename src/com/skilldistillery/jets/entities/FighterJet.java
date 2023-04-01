package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {
	public FighterJet() {
	}

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void fight() {
		System.out.println(getModel() + " crew disposition: " + crewStatus());
	}

	
	public String crewStatus() {
		String[] randomStatuses = new String[] {
				"I feel the need ... the need for speed.",
				"Remember boys, no points for second place.",
				"It's not the plane, it's the pilot.",
				"Kowabunga!",
				"Buckle up!",
				"Just a walk in the park, Kazansky"};
		int randomIndex = (int) (randomStatuses.length * Math.random());
		return randomStatuses[randomIndex];
	}
	
	@Override
	public String toString() {
		return "Fighter Jet: " + super.toString();
	}

}
