package com.skilldistillery.jets.app;

import com.skilldistillery.jets.entities.Airfield;

public class JetsApplication {

	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.launch();
	}
	
	public void launch() {
		Airfield airfield = new Airfield();
		for (int i = 0; i < airfield.getFleet().size(); i++) {
			System.out.println(airfield.getFleet().get(i));
		}
	
	}

}
