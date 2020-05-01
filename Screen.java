/*
*  Authors: Team 11-3: Bradley Fusting, Takiyah Price, Kelsey McRae, Malachi Parks
*  Class Section: 011
*  Lab Section: 031L
*  TA: Vineeth Gutta
*  Due: May 18th, 2020 (5/18/20)
*
*  This file contains the contents for the project for CISC275. The project for the 
*  class is to make gardening software for the township of Arden, DE to help
*  promote forest edge preservation. 
*  
*/

/**
 * Abstract class that defines the behaviors each subclass Screen should have: backwards navigation, a way to show
 * and close the Screen, and a way to protect its contents from being edited to prevent conflicting actions from 
 * Screens that are showing simultaneously.
 * 
 * @author Takiyah Price
 *
 */

//last edited: 5-1-20 11:07AM

public abstract class Screen {
	
	
	private Screen previousScreen = this;

	
	/**
	 * Goes back one screen by showing its previous screen.
	 */
	public void goToPreviousScreen() {
		System.out.println("Going to: "+previousScreen);
		previousScreen.showScreen();
	}
	
	/**
	 * Returns this Screen's previous Screen.
	 * 
	 * @return the Screen that is seen before this Screen.
	 */
	public Screen getPreviousScreen() {
		return previousScreen;
	}
	
	/**
	 * Sets this Screen's previous Screen to the given Screen.
	 * 
	 * @param s the Screen that should be seen before this Screen
	 */
	public void setPreviousScreen(Screen s) {
		previousScreen = s;
		System.out.println("previous screen set to "+previousScreen);
	}
	
	/**
	 * Makes this Screen visible to the user.
	 */
	public void showScreen() {
		System.out.println("most screens should probably override show");
	}
	
	
	/**
	 * Prevents this Screen's content from being edited by the user.
	 */
	public void setUneditable() {
		System.out.println("most screens should probably override setUneditable");
	}
	
	/**
	 * Allows this Screen's content to be edited by the user.
	 */
	public void setEditable() {
		System.out.println("most screens should probably override setEditable");
	}
	
	/**
	 * Closes this Screen so that it is no longer visible to the user.
	 */
	public void closeScreen() {
		System.out.println("close this Screen");
	}
	
	
	
	
	
}
