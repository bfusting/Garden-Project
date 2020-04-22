import java.io.Serializable;
import java.util.ArrayList;

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
 * @author Malachi Parks
 * 
 * Where all the raw data of the program goes from the GardenPlot which holds 
 * GardenTiles which have attributes such as sunlight received and soil wetness. Furthermore
 * the GardenTiles hold an AddOn or Plant with their own attributes. 
 */

public class Model implements Serializable{
	
	private GardenPlot userPlot;
	private ArrayList<AddOn> selectionArr;
	private ArrayList<Plant> shrubArr;
	private ArrayList<Plant> treeArr;
	private ArrayList<Plant> underGrowthArr;
	
	
	/**
	 * Constructor where the ArrayLists are initialized for space and
	 * a new GardenPlot is created
	 * 
	 * @see GardenPlot
	 */
	public void Model() {
		userPlot = new GardenPlot();
		selectionArr = new ArrayList<AddOn>();
		shrubArr = new ArrayList<Plant>();
		treeArr = new ArrayList<Plant>();
		underGrowthArr = new ArrayList<Plant>();
	}//Model()
	
	/**
	 * Used to generate alternate GardenPlots for the Final View
	 * since they are generated. Calls the GardenPlot constructor
	 * then fills it by copying original array over. From there will 
	 * autofill the rest of the spaces
	 */
	public void createGardenPlotAlts() {
		System.out.println("Creating alternate gardens for final view");
	}//createGardenPlotAlts
	
	/**
	 * From preferences updates the array. However changes the current index 
	 * variable which is in that scope only and adds 6 to it to get the next 
	 * items in the arrayList
	 * 
	 */
	public void updateSeclectionArr() {
		System.out.println("Fill after preferences, more desirable in front");
	}
	
	
	/**
	 * From preferences updates the array. However changes the current index 
	 * variable which is in that scope only and adds 6 to it to get the next 
	 * items in the arrayList
	 */
	public void updateShrubArr() {
		System.out.println("Fill after preferences, more desirable in front");
	}
	
	/**
	 * From preferences updates the array. However changes the current index 
	 * variable which is in that scope only and adds 6 to it to get the next 
	 * items in the arrayList
	 */
	public void updateTreeArr() {
		System.out.println("Fill after preferences, more desirable in front");
	}
	
	/**
	 * From preferences updates the array. However changes the current index 
	 * variable which is in that scope only and adds 6 to it to get the next 
	 * items in the arrayList
	 */
	public void updateUnderGrowthArr() {
		System.out.println("Fill after preferences, more desirable in front");
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
	 *Returns a arrayList of AddOns
	 *<p>
	 *getter for SelectionArray List
	 *
	 * @return selectionArr Addon List of what the user is currently seeing
	 */
	public ArrayList<AddOn> getSelectionArr() {
		return selectionArr;
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
	
	////////////////////////////		SETTERS			////////////////////////////
	
	/**
	 * 
	 * @param a
	 */
	public void setSelectionArr(ArrayList<AddOn> a) {
		System.out.println("Setter Info Here");
	}
	
	/**
	 * 
	 * @param a
	 */
	public void setShrubArr(ArrayList<Plant> a) {
		System.out.println("Setter Info Here");
	}
	
	/**
	 * 
	 * @param a
	 */
	public void setTreeArr(ArrayList<Plant> a) {
		System.out.println("Setter Info Here");
	}
	
	/**
	 * 
	 * @param a
	 */
	public void setUnderGrowthArr(ArrayList<Plant> a) {
		System.out.println("Setter Info Here");
	}
	
	/**
	 * 
	 * @param Object
	 */
	public boolean equals(Object o) {
		if(o != this && o != null) {
			Model m = (Model)o;
			return m.selectionArr.equals(this.selectionArr);
		}
		return false;
	}
}//Model