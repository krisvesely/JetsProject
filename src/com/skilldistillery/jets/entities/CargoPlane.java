package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet {
	public CargoPlane () {}
	public CargoPlane (String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	  @Override 
	  public String toString() { 
		  return "Cargo Plane: " + super.toString();
		  }
	 

}
