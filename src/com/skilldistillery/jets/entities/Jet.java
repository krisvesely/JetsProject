package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;
	private String pilot;
	
	public Jet() {}
	public Jet(String model, double speed, int range, long price, String pilot) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.pilot = pilot;
	}

	public void fly() {
		double flightTime = getRange() / getSpeed();
		flightTime = Math.round(flightTime * 100.00) / 100.00;
		System.out.print(toString() + "\n   Flight Time: " + flightTime + " hours");
	}
	
	public String getModel() {
		return model;     
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	public String getPilot() {
		return pilot;
	}
	public void setPilot(String pilot) {
		this.pilot = pilot;
	}
	
	@Override
	public String toString() {
		return "Model: " + model + ", Pilot: " + pilot + ", Speed: " + (int)speed + " mph, Range: " + range 
				+ " miles, Price: $" + price;
	}
	
}
