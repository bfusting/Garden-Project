/*
*  Authors: Team 11-3: Bradley Fusting, Takiyah Price, Kelsey McRae, Malachi Parks
*  Class Section: 011
*  Lab Section: 031L
*  TA: Vineeth Gutta
*  Due: May 18th, 2020 (5/18/20)
*
*  This file contains the contents for lab 8. Lab 8 consists of adding comments 
*  to above each method then generating a javaDoc for the reader of the program. 
*  
*/

/**
 * 
 */

public class Model{
	
	private GardenPlot userPlot;
	private ArrayList<AddOn> selectionArr;
	private ArrayList<AddOn> shrubArr;
	private ArrayList<AddOn> treeArr;
	private ArrayList<AddOn> underGrowth;
	
	
	/**
	 * @see
	 */
	public void Model() {
		userPlot = new GardenPlot();
		selectionArr = new ArrayList<AddOn>();
		shrubArr = new ArrayList<AddOn>();
		treeArr = new ArrayList<AddOn>();
		underGrowth = new ArrayList<AddOn>();
	}//Model()
	
	/**
	 * 
	 */
	public void update() {
		System.out.println("Updates What");
	}//update
	
	/**
	 * 
	 */
	public void createGardenPlotAlts() {
		System.out.println("Creating alternate gardens for final view");
	}//createGardenPlotAlts
	
	/**
	 * 
	 */
	public void fillSeclectionArr() {
		System.out.println("Fill after preferences, more desirable in front");
	}
	
	/**
	 * 
	 */
	public void fillSeclectionArr() {
		System.out.println("Fill after preferences, more desirable in front");
	}
	
	/**
	 * 
	 */
	public void fillShrubArr() {
		System.out.println("Fill after preferences, more desirable in front");
	}
	
	/**
	 * 
	 */
	public void fillTreeArr() {
		System.out.println("Fill after preferences, more desirable in front");
	}
	
	/**
	 * 
	 */
	public void fillUnderGrowthArr() {
		System.out.println("Fill after preferences, more desirable in front");
	}
	
}//Model