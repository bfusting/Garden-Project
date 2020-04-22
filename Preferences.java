import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

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

public class Preferences extends View{
	private ComboBox<String> bloomTime;
	private ComboBox<String> waterReq;
	private ComboBox<String> lightReq;
	private ComboBox<String> color;
	
	private int gardenLength;
	private int gardenWidth;
	
	public void askSize() {
		
	}
	
	/*
	 *  Gets the ComboBox for 
	 */
	public ComboBox<String> getBloomTime() {
		return bloomTime;
	}
	public ComboBox<String> getWaterReq() {
		return waterReq;
	}
	public ComboBox<String> getLightReq() {
		return lightReq;
	}
	public ComboBox<String> getColor() {
		return color;
	}
	
	public int getGardenLength() {
		return gardenLength;
	}
	
	public int getGardenWidth() {
		return gardenWidth;
	}
	
	public void showPreferences(Stage stage) {
		
	}
}
