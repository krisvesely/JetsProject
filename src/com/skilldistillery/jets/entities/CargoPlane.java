package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier {
	public CargoPlane () {}
	public CargoPlane (String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void loadCargo() {
		System.out.print(getModel() + ": Airlift inpection complete; pallets loading and being tied down now.");
	}
	
	@Override 
	public String toString() { 
		  return "Cargo Plane: " + super.toString();
		  }
}
