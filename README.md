# JetsProject

## Overview
Generates an airfield's fleet of aircraft from an existing list. Users are presented a menu 
from which they can  view attributes of the aircraft, including their model, speed, range, and price; 
and view the aircraft with the fastest speed or longest range. Aircraft can perform 
specific behaviors depending upon whether they're classified as cargo planes or fighter jets. 
Users can also add custom aircraft to the fleet or select any to remove from the fleet. 

## Technologies Used
- Java OOP
- Eclipse
- Git

## Lessons Learned
- Reads String inputs from a .txt file containing the category, model, speed, range, and price for 
each aircraft.   
- Creates a String array from the comma-separated input, then converts selected Strings, 
using wrapper class methods, to primitive data types that match the Jet super-class fields. 
- Declares each aircraft as a Jet, an abstract class. 
- Instantiates each aircraft as a passenger, cargo, or fighter jet object of a 
concrete sub-class to Jet, correlated to the aircraft's category stored at 
the zero-index its the String array.
- Passes the remaining aircraft data as arguments to the class constructor called. 
- Adds each Jet to the fleet comprised by an ArrayList of Jet objects.
- Methods employ for-loops that iterate through the complete fleet, using the size() method
to accommodate the variable size of the fleet as aircraft are added or removed by the User.
- Searches through and compares the Jets' states within the fleet, outputting Jet lists or 
highest performing Jets based upon the User's menu selection.
- Cargo plane and fighter jet sub-classes implement interfaces that declare abstract methods
used by the Jet sub-classes to define their unique behaviors.
