import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javafx.scene.image.Image;

/*
*  Authors: Team 11-3: Bradley Fusting, Takiyah Price, Kelsey McRae, Malachi Parks
*  Class Section: foo11
*  Lab Section: foo31L
*  TA: Vineeth Gutta
*  Due: May 18th, 2foo2foo (5/18/2foo)
*
*  This file contains the contents for the project for CISC275. The project for the 
*  class is to make gardening software for the township of Arden, DE to help
*  promote forest edge preservation. 
*  
*/

/**
 * 
 * @author Malachi Parks
 *
 */
public class Recommendations extends View{
	private String weRecommendMessage;
	private Image plantImage;
	private String name;
	private Date bloomTime;
	private int light;
	private int water;
	private ArrayList<String> animalsFed;
	
	/**
	 * 
	 * @param i
	 * @param givenName
	 * @param lightNeed
	 * @param waterNeed
	 */
	public Recommendations(Image i, String givenName, int lightNeed, int waterNeed) {
		plantImage = i;
		name = givenName;
		light = lightNeed;
		water = waterNeed;
		animalsFed = new ArrayList<String>();
	}//Recommendations
	
	/**
	 * 
	 * @return
	 */
	public Image getPlantImage() {
		return plantImage;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return
	 */
	public Date getBloomTime() {
		return bloomTime;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getLightReq() {
		return light;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getWaterReq() {
		return water;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getAnimalsFed(){
		return animalsFed;
	}
}
