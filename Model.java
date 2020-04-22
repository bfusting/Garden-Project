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
 * 
 */

public class Model implements Serializable{
	
	private GardenPlot userPlot;
	private ArrayList<AddOn> selectionArr;
	private ArrayList<Plant> shrubArr;
	private ArrayList<Plant> treeArr;
	private ArrayList<Plant> underGrowthArr;
	
	
	/**
	 * @see
	 */
	public void Model() {
		userPlot = new GardenPlot();
		selectionArr = new ArrayList<AddOn>();
		shrubArr = new ArrayList<Plant>();
		treeArr = new ArrayList<Plant>();
		underGrowthArr = new ArrayList<Plant>();
	}//Model()
	
	/**
	 * 
	 */
	public void createGardenPlotAlts() {
		System.out.println("Creating alternate gardens for final view");
	}//createGardenPlotAlts
	
	/**
	 * 
	 */
	public void updateSeclectionArr() {
		System.out.println("Fill after preferences, more desirable in front");
	}
	
	
	/**
	 * 
	 */
	public void updateShrubArr() {
		System.out.println("Fill after preferences, more desirable in front");
	}
	
	/**
	 * 
	 */
	public void updateTreeArr() {
		System.out.println("Fill after preferences, more desirable in front");
	}
	
	/**
	 * 
	 */
	public void updateUnderGrowthArr() {
		System.out.println("Fill after preferences, more desirable in front");
	}
	
	
	////////////////////////////		GETTERS UNDERNEATH			////////////////////////////
	
	/**
	 * 
	 */
	public GardenPlot getUserPlot() {
		return userPlot;
	}
	
	/**
	 *
	 * @return
	 */
	public ArrayList<AddOn> getSelectionArr() {
		return selectionArr;
	}
	
	/**
	 *
	 * @return
	 */
	public ArrayList<Plant> getShrubArr() {
		return shrubArr;
	}
	
	/**
	 *
	 * @return
	 */
	public ArrayList<Plant> getTreeArr() {
		return treeArr;
	}
	
	/**
	 * 
	 * @return
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