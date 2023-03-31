package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Airfield {
	private List<Jet> fleet;
	
	//populate its fleet in the ctor
	
	public List<Jet> readFromFile(String fileName) {
		List<Jet> jets = new ArrayList<>();
		
		try ( BufferedReader bufIn = new BufferedReader(new FileReader(fileName)) ) {
			  String aJet;
			  while ((aJet = bufIn.readLine()) != null) {
				  String[] jetDetails = aJet.split(", ");
				  //create the appropriate jet based upon all the jet detail
				  /*if the jetDetails[0] happens to be a DCV, then create a Dilithium Powered jet
				   * if the jetDetails[0] happens to be a Fighter, then create a Fighter jet
				   * 
				   */
			  }
			}
			catch (IOException e) {
			  System.err.println(e);
			}
		
		return jets;
	}
	//read in the various jet types from the file
	// as you read in a jet, create a jet,
	// and add that specific jet type to your jet list
}

/* only the airfield can talk to the jets
 * many methods
 * 
 */
