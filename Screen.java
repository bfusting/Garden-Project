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
 * 
 * @author Takiyah Price
 *
 */

//last edited: 4-29-20 2:21PM

public abstract class Screen {
	
	
	private Screen previousScreen = this;
	
	public void goToPreviousScreen() {
		System.out.println("Going to: "+previousScreen);
		previousScreen.showScreen();
	}
	
	public Screen getPreviousScreen() {
		return previousScreen;
	}
	
	public void setPreviousScreen(Screen s) {
		previousScreen = s;
		System.out.println("previous screen set to "+previousScreen);
	}
	
	public void showScreen() {
		System.out.println("most screens should probably override show");
	}
	
	public void setUneditable() {
		System.out.println("most screens should probably override setUneditable");
	}
	
	public void setEditable() {
		System.out.println("most screens should probably override setEditable");
	}
	
	public void closeScreen() {
		System.out.println("close this Screen");
	}
	
	
	
}
