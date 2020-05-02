import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
 * Where all the raw data of the program goes from the GardenPlot which holds 
 * GardenTiles which have attributes such as sunlight received and soil wetness. Furthermore
 * the GardenTiles hold an AddOn or Plant with their own attributes. 
 * 
 * @author Malachi Parks
 * 
 */

public class Model implements Serializable{
	
	// Holds all the data for our plants
	
	private GardenPlot userPlot;
	private ArrayList<GardenPlot> altPlots;
	private ArrayList<Plant> flowerArr;
	private ArrayList<Plant> shrubArr;
	private ArrayList<Plant> treeArr;
	private ArrayList<Plant> underGrowthArr;
	private ArrayList<AddOn> sceneryArr;
	private ArrayList<Plant> allPlants;
	
	// Prefs given by user
	private String userPrefColor;
	private Seasons userPrefSeason;
	private int userPrefLight;
	private int userPrefWater;
	
	
	/**
	 * Constructor where the ArrayLists are initialized for space and
	 * a new GardenPlot is created
	 * 
	 * @see GardenPlot
	 */
	public void Model() {
		userPlot = new GardenPlot();
		// Creating temp Plants for Bradley to use in methods, remove later
		
		Plant purpleConeFlower = new Plant("Purple Cone Flower", 1, "cone flower", 
				"purple", 0, 0, 0, 0, Seasons.AUTUMN, false, null, null, null, null, null);
		
		Plant sugarMaple = new Plant("Sugar Maple", 4, "Maple Tree", "Yellow", 3, 0,
				0, 0, Seasons.SUMMER, true, null, null, null, null, null);
		
		Plant sweetFern = new Plant("Sweet Fern", 1, "Fern Variant", "White",
				3, 2, 3.0, 0, Seasons.SPRING, false, null, null, "Shrub", null, null);

		Plant milkWeed = new Plant("Milkweed", 1, "Common Milkweed", "Orange", 4, 2, 
				2.00, 0, Seasons.SUMMER, false, null, null, "UnderGrowth", null, null);
		
		flowerArr = new ArrayList<Plant>();
		flowerArr.add(purpleConeFlower);
		
		shrubArr = new ArrayList<Plant>();
		shrubArr.add(sweetFern);
		
		treeArr = new ArrayList<Plant>();
		treeArr.add(sugarMaple);
		
		underGrowthArr = new ArrayList<Plant>();
		underGrowthArr.add(milkWeed);
		
		sceneryArr = new ArrayList<AddOn>();
		
		allPlants = new ArrayList<Plant>();
		
		userPrefColor = "";
		userPrefSeason = null;
		userPrefLight = 0;
		userPrefWater = 0;
		
	}//Model()
	
	/**
	 * Used to generate alternate GardenPlots for the Final View
	 * since they are generated. Calls the GardenPlot constructor
	 * then fills it by copying original array over. From there will 
	 * autofill the rest of the spaces
	 */
	public void createGardenPlotAlts() {
		System.out.println("Creating alternate gardens for final view");
		
		GardenPlot gP1 = new GardenPlot();
		gP1.setLayout(userPlot.getLayout());
		gP1.fillEmpty();
		
		GardenPlot gP2 = new GardenPlot();
		gP2.setLayout(userPlot.getLayout());
		gP2.fillEmpty();
		
		GardenPlot gP3 = new GardenPlot();
		gP3.setLayout(userPlot.getLayout());
		gP3.fillEmpty();
		
		this.altPlots.add(gP1);
		this.altPlots.add(gP2);
		this.altPlots.add(gP3);
		
		
	}		
		
		
		
	
	/**
	 * From preferences updates the array. However changes the current index 
	 * variable which is in that scope only and adds 6 to it to get the next 
	 * items in the arrayList
	 * 
	 */
	public void updateFlowerArr() {
		allPlants.sort(new SortbyType());
		// Traaverses through sorted list and addeds all shrubs
		for(Plant p: allPlants) {
			if(p.getPlantType().equals("Flower")) {
				if(flowerArr != null){
				flowerArr.add(p);
				}
			}
		}
		//sorting by Water Req
		flowerArr.sort(new SortbyWaterNeed());
		//sorting by Light Reg
		flowerArr.sort(new SortbyLightNeed());
		//sorting by Bloolm Req
		flowerArr.sort(new SortbyBloomTime());
		//sorting by color
		flowerArr.sort(new SortbyColor());
	}
	
	
	/**
	 * From preferences updates the array. However changes the current index 
	 * variable which is in that scope only and adds 6 to it to get the next 
	 * items in the arrayList
	 */
	public void updateShrubArr() {
		allPlants.sort(new SortbyType());
		// Traaverses through sorted list and addeds all shrubs
		for(Plant p: allPlants) {
			if(p.getPlantType().equals("Shrub")) {
				if(shrubArr != null){
				shrubArr.add(p);
				}
			}
		}
		//sorting by Water Req
		shrubArr.sort(new SortbyWaterNeed());
		//sorting by Light Reg
		shrubArr.sort(new SortbyLightNeed());
		//sorting by Bloolm Req
		shrubArr.sort(new SortbyBloomTime());
		//sorting by color
		shrubArr.sort(new SortbyColor());
	}
	
	/**
	 * From preferences updates the array. However changes the current index 
	 * variable which is in that scope only and adds 6 to it to get the next 
	 * items in the arrayList
	 */
	public void updateTreeArr() {
		allPlants.sort(new SortbyType());
		// Traaverses through sorted list and addeds all shrubs
		for(Plant p: allPlants) {
			if(p.getPlantType().equals("Tree")) {
				if(treeArr != null){
				treeArr.add(p);
				}
			}
		}
		//sorting by Water Req
		treeArr.sort(new SortbyWaterNeed());
		//sorting by Light Reg
		treeArr.sort(new SortbyLightNeed());
		//sorting by Bloolm Req
		treeArr.sort(new SortbyBloomTime());
		//sorting by color
		treeArr.sort(new SortbyColor());
	}
	
	/**
	 * From preferences updates the array. However changes the current index 
	 * variable which is in that scope only and adds 6 to it to get the next 
	 * items in the arrayList
	 */
	public void updateUnderGrowthArr() {
		allPlants.sort(new SortbyType());
		// Traaverses through sorted list and addeds all shrubs
		for(Plant p: allPlants) {
			if(p.getPlantType().equals("UnderGrowth")) {
				if(underGrowthArr != null){
				underGrowthArr.add(p);
				}
			}
		}
		//sorting by Water Req
		underGrowthArr.sort(new SortbyWaterNeed());
		//sorting by Light Reg
		underGrowthArr.sort(new SortbyLightNeed());
		//sorting by Bloolm Req
		underGrowthArr.sort(new SortbyBloomTime());
		//sorting by color
		underGrowthArr.sort(new SortbyColor());
	}
	
	/**
	 * Changes the current index 
	 * variable which is in that scope only and adds 6 to it to get the next 
	 * items in the arrayList
	 */
	public void updateSceneryArr() {
		// make it take in all the stuff that isn't plants
	}
	
	
	////////////////////////////		GETTERS UNDERNEATH			////////////////////////////
	
	/**
	 * Returns a GardenPlot
	 * <p>
	 * Getter for attribute userPlot
	 * 
	 * @return userPlot the GardenPlot the user created
	 */
	public GardenPlot getUserPlot() {
		return userPlot;
	}
	
	/**
	 *Returns a arrayList of Plants
	 *<p>
	 *getter for flowerArr List
	 *
	 * @return flowerArr Plnat List of flowers 
	 */
	public ArrayList<Plant> getFlowerArr() {
		return flowerArr;
	}
	
	/**
	 *Returns a arrayList of Plants
	 *<p>
	 *getter for Shrub Array List
	 *
	 * @return shrubArr Shrub List of what the user is currently seeing
	 */
	public ArrayList<Plant> getShrubArr() {
		return shrubArr;
	}
	
	/**
	 *Returns a arrayList of Plants
	 *<p>
	 *getter for Tree Array List
	 *
	 * @return TreeArr Tree List of what the user is currently seeing
	 */
	public ArrayList<Plant> getTreeArr() {
		return treeArr;
	}
	
	/**
	 *Returns a arrayList of Plants
	 *<p>
	 *getter for UnderGrowth Array List
	 *
	 * @return UnderGrowth UnderGrowth List of what the user is currently seeing
	 */
	public ArrayList<Plant> getUnderGrowth(){
		return underGrowthArr;
	}
	
	/**
	 * Returns the altPlots attribute from model, which will be used
	 * to add new gardenPlots to the Array
	 * <p>
	 * Returns the altPlots attribute
	 * 
	 * @return altPlots used in the final view generation
	 */
	public ArrayList<GardenPlot> getAltPlots(){
		return altPlots;
	}
	
	/**
	 * Returns the sceneryArr attribute from model, which will be used
	 * to add Addons to the Array
	 * <p>
	 * Returns the sceneryArr attribute
	 * 
	 * @return Holds items such as benchs, path, etc
	 */
	public ArrayList<AddOn> getSceneryArr(){
		return sceneryArr;
	}
	
	/**
	 * Returns the allPlants attribute from model which will be used to 
	 * hold all the plants the program has.
	 * <p>
	 * Getter for the allPlants attribute
	 * 
	 * @return allPlants is an arrayList holding all the plants in the program
	 */
	//public ArrayList<Plant> getAllPlants(){
	public ArrayList<Plant> getAllPlants(){
		return allPlants;
	}
	
	
	////////////////////////////		SETTERS			////////////////////////////
	
	/**
	 * Takes in ArrayList of type AddOn and sets the SelectionArray to the new array
	 * <p>
	 * Used as a setter for the selectionArr
	 * 
	 * @param a new ArrayList used to set selectionArr
	 */
	public void setFlowerArr(ArrayList<Plant> a) {
		flowerArr = a;
	}
	
	/**
	 * Takes in ArrayList of type Plant and sets the ShrubArray to the new array
	 * <p>
	 * Used as a setter for the ShrubArr
	 * 
	 * @param a new ArrayList used to set ShrubArr
	 */
	public void setShrubArr(ArrayList<Plant> a) {
		shrubArr = a;
	}
	
	/**
	 * Takes in ArrayList of type Plant and sets the TreeArray to the new array
	 * <p>
	 * Used as a setter for the TreeArr
	 * 
	 * @param a new ArrayList used to set TreeArr
	 */
	public void setTreeArr(ArrayList<Plant> a) {
		treeArr = a;
	}
	
	/**
	 * Takes in ArrayList of type Plant and sets the UnderGrowthArray to the new array
	 * <p>
	 * Used as a setter for the UnderGrowthArr
	 * 
	 * @param a new ArrayList used to set UnderGrowthArr
	 */
	public void setUnderGrowthArr(ArrayList<Plant> a) {
		underGrowthArr = a;
	}
	
	/**
	 * Takes in a GardenPlot p and sets userPlot to the new plot.
	 * <p>
	 * Setter for userPlot
	 * 
	 * @param p new Gardenplot to set userPlot to
	 */
	public void setUserPlot(GardenPlot p) {
		userPlot = p;
	}
	
	/**
	 * Takes in a ArrayList and sets scenery to the new list.
	 * <p>
	 * Setter for sceneryArr
	 * 
	 * @param a is a new arrayList of addons to take in
	 */
	public void setSceneryArr(ArrayList<AddOn> a) {
		sceneryArr = a;
	}	
	
	//////////////////// Comparators ///////////////////////////////////
	
	/**
	 * Comparator class used to sort a collections of Plants by their type
	 * attribute of their type by using the Comparator interface
	 * 
	 * @author Malachi Parks
	 *
	 */
	class SortbyType implements Comparator<Plant> 
	{ 
	    // Used for sorting in ascending order of 
	    // plant type ("Shrub", "UnderGrowth", "Tree", ...)
	    public int compare(Plant a, Plant b) 
	    { 
	        return a.getPlantType().compareTo(b.getPlantType()); 
	    } 
	} 
	
	/**
	 * Comparator class used to sort a collections of Plants by their 
	 * attribute of their waterRequirement by using the Comparator interface
	 * 
	 * @author Malachi Parks
	 *
	 */
	class SortbyWaterNeed implements Comparator<Plant> 
	{ 
	    // Used for sorting water requirement to live
		// in ascending order
	    public int compare(Plant a, Plant b) 
	    { 
	        return a.getWaterNeed() - b.getWaterNeed(); 
	    } 
	} 
	
	/**
	 * Comparator class used to sort a collections of Plants by their 
	 * attribute of their lightReq by using the Comparator interface
	 * 
	 * @author Malachi Parks
	 *
	 */
	class SortbyLightNeed implements Comparator<Plant> 
	{ 
	    // Used for sorting Light requirement to live
		// in ascending order
	    public int compare(Plant a, Plant b) 
	    { 
	        return a.getSunLightNeed() - b.getSunLightNeed(); 
	    } 
	} 
	  
	/**
	 * Comparator class used to sort a collections of Plants by their 
	 * attribute of their Color by using the Comparator interface
	 * 
	 * @author Malachi Parks
	 *
	 */
	class SortbyColor implements Comparator<Plant> 
	{ 
	    // Used for sorting Color requirement to live
		// in lexical order
	    public int compare(Plant a, Plant b) 
	    { 
	        return a.getColor().compareTo(b.getColor()); 
	    } 
	} 
	
	/**
	 * Comparator class used to sort a collections of Plants by their 
	 * attribute of their bloomTime by using the Comparator interface
	 * 
	 * @author Malachi Parks
	 *
	 */
	class SortbyBloomTime implements Comparator<Plant> 
	{ 
	    // Used for sorting BloomTime where the enum
		// is based off of string values
	    public int compare(Plant a, Plant b) 
	    { 
	        return a.getBloomTime().compareTo(b.getBloomTime()); 
	    } 
	}
}//Model