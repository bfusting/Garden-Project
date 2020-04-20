/*
*  Edited on: April 14th, 2020 (4/14/20)
*  Author: T Harvey
*  Editors: Team 11-3: Bradley Fusting, Takiyah Price, Kelsey McRae, Malachi Parks
*  Class Section: 011
*  Lab Section: 031L
*  TA: Vineeth Gutta
*  Due: April 19th, 2020 (4/19/20)
*
*  This file contains the contents for lab 8. Lab 8 consists of adding comments 
*  to above each method then generating a javaDoc for the reader of the program. 
*  
*  All edits were made in the V2 of the model, controller and view
*  
*  Goals of lab 8:
*  
*  Modify the scene to hold a TilePane and a FlowPane. Put the milkweed ImageView in the TilePane. Edit the drag-n-drop behavior so that:
*  1) only a copy of the object moves
*  2) after dragging to the new pane there are two ImageViews, one in each pane.
*  3) you can drag repeatedly and make more.
*  4) Upload a zip to Canvas.
*  
*  Check out the Node documentation at
*  https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html
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
	 * 
	 */
	public void Model() {
		userPlot = new GardenPlot();
		selectionArr = new ArrayList<AddOn>();
		shrubArr = new ArrayList<AddOn>();
	}
	
	
}//Model