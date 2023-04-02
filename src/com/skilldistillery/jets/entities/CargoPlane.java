package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier {
	public CargoPlane () {}
	public CargoPlane (String model, double speed, int range, long price, String pilot) {
		super(model, speed, range, price, pilot);
	}
	
	public void loadCargo() {
		System.out.println(getModel() + " cargo status: " + cargoStatus());
	}
	
	public String cargoStatus() {
		String[] randomStatuses = new String[] {
				"Airlift inpection complete; loading awaits telescoping material handler.",
				"Cargo frustrated; undeclared HAZMAT.",
				"Pallets loaded via winch; Loadmasters inspecting holddowns.",
				"Cargo rejected; pallet weights not balanced per load diagram.",
				"Heavy drop platforms loaded; lifting ramp."};
		int randomIndex = (int) (randomStatuses.length * Math.random());
		return randomStatuses[randomIndex];
	}
	
	@Override
	public void fly() {
		super.fly();
		System.out.println(", Pilot " + getPilot() + " says: " + pilotSays());;
	}
	
	public String pilotSays() {
		String[] cargoPilotSays = new String[] {
				"\"Notify the APOD to have MHE standing-by on the tarmac.\"",
				"\"We'll get these supplies there in no time.\"",
				"\"We're so heavy with this payload, we might hit the treetops.\""};
		int randomIndex = (int) (cargoPilotSays.length * Math.random());
		return cargoPilotSays[randomIndex];
	}
	
	@Override 
	public String toString() { 
		  return "Cargo Plane: " + super.toString();
		  }
}
