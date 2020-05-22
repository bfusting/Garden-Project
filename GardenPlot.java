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

import java.util.*;
import java.io.*;
/**
 * Used to represent the entirety of the Garden Plot in a two dimensional array.
 * The layout is a 2D array of GardenTiles which have attributes such as 
 * a Plant or Addon attribute (depending on what is dragged and dropped on the space). 
 * These tiles will also be the inactive or active depending on custom size. The length
 * and width are both ints representing the length and width of the garden in ints.
 * Shape is the shape of the garden passed in by templates, while season is the 
 * season of the garden.
 * <p>
 * @author Bradley Fusting
 *
 */
public class GardenPlot implements Serializable{
	private static final long serialVersionUID = 1059128301L;
	
	String shape;
	
	/**
	 * GardenTile[][] layout
	 * 
	 * a 2d array of GardenTiles that make up the GardenPlot
	 */
	GardenTile[][] layout;
	
	int length;
	int width;
	
	/**
	 * HashSet currentPlants
	 * 
	 * a hashset of all the current plants in the GardenTiles
	 */
	HashSet<Plant> currentPlants = new HashSet<Plant>();
	
	Seasons season;
	

	
	/**
	 * Constructor that sets shape, length and width
	 * Sets layout to a default 5x5
	 * 
	 * @param s shape
	 * @param l length
	 * @param w width
	 */
	public GardenPlot(String s, int l, int w) { 
		this.shape = s;
		this.length = l;
		this.width = w;
		
		switch(shape) {
		case ("square"):
			makeSquare();
			break;
		case ("triangle"):
			makeTriangle();
			break;
		case ("circle"):
			makeCircle();
			break;
		case ("custom"):
			makeSquare();
		}
		
	}
	
	public GardenPlot() {
		this.makeSquare();
	}
	
	
	/**
	 * Creates a 2D GardenTile array with inputs for width and height of the plot
	 * 
	 * 
	 * @param width - the width of the plot
	 * @param height - the height of the plot
	 * @return result - the 2D array of tiles making up the plot
	 */
	public GardenTile[][] makeSizeSquare(int length, int width){
		GardenTile[][] result = new GardenTile[length][width];
		
		for(int i = 0; i < length; i++) {
			for(int k = 0; k < width; k++) {
				result[i][k] = new GardenTile(i, k);
			}
		}
		
		return result;
	}
	
	/**
	 * Creates a square 2D GardenTile array for the layout.
	 * Also initializes all gardenTiles with x and y values
	 * @return
	 * returns layout - the array for this.layout
	 */
	public void makeSquare(){
		layout = new GardenTile[length][width];
		
		for(int i = 0; i < length; i++) {
			for(int k = 0; k < width; k++) {
				layout[i][k] = new GardenTile(i, k);
			}
		}

	}
		
	
	
	/**
	 * Creates a 2D array of garden tiles and deactivates specific tiles in order to create a triangle shape
	 * for the layout.
	 * <p>
	 * Used to create the triangle used for triangle shaped gardenPlots
	 * 
	 */
	public void makeTriangle(){
	
		layout = new GardenTile[length][width];
		int invis = 0;
		for(int i = 0; i < length; i++) {
			
			for (int left =0;left < invis;left++) {
				layout[i][left]=new GardenTile(i,left,false);
				if (left>=length-2) { break;}
			}
			for(int middle = invis; middle < width-invis; middle++) {
				layout[i][middle]= new GardenTile(i,middle);
			}
			for (int right = width-invis; right<width;right++) {
				layout[i][right]= new GardenTile(i,right,false);
			}
			invis+=1;
			
		}
	
	}
	
	/**
	 * Creates a 2D array of GardenTiles and activates them in a shape of a circle with 7 rows and 7 columns
	 * 
	 * 
	 * @return
	 * returns the 2D array of GardenTiles to be used in this.layout
	 */
	public void makeCircle(){
		
		//Row 1
		GardenTile gT1 = new GardenTile(0,0, false);
		GardenTile gT2 = new GardenTile(1,0, false);
		GardenTile gT3 = new GardenTile(2,0);
		GardenTile gT4 = new GardenTile(3,0);
		GardenTile gT5 = new GardenTile(4,0);
		GardenTile gT6 = new GardenTile(1,3, false);
		GardenTile gT7 = new GardenTile(2,3, false);
		
		//Row 2
		GardenTile gT8 = new GardenTile(3,3, false);
		GardenTile gT9 = new GardenTile(4,3);
		GardenTile gT10 = new GardenTile(0,1);
		GardenTile gT11 = new GardenTile(1,1);
		GardenTile gT12 = new GardenTile(2,1);
		GardenTile gT13 = new GardenTile(3,1);
		GardenTile gT14 = new GardenTile(4,1, false);
		
		//Row 3
		GardenTile gT15 = new GardenTile(1,3);
		GardenTile gT16 = new GardenTile(2,3);
		GardenTile gT17 = new GardenTile(3,3);
		GardenTile gT18 = new GardenTile(4,3);
		GardenTile gT19 = new GardenTile(0,2);
		GardenTile gT20 = new GardenTile(1,2);
		GardenTile gT21 = new GardenTile(2,2);
		
		//Row 4
		GardenTile gT22 = new GardenTile(3,2);
		GardenTile gT23 = new GardenTile(4,2);
		GardenTile gT24 = new GardenTile(1,3);
		GardenTile gT25 = new GardenTile(2,3);
		GardenTile gT26 = new GardenTile(3,3);
		GardenTile gT27 = new GardenTile(4,3);
		GardenTile gT28 = new GardenTile(0,3);
		
		//Row 5
		GardenTile gT29 = new GardenTile(1,3);
		GardenTile gT30 = new GardenTile(2,3);
		GardenTile gT31 = new GardenTile(3,3);
		GardenTile gT32 = new GardenTile(4,3);
		GardenTile gT33 = new GardenTile(1,3);
		GardenTile gT34 = new GardenTile(2,3);
		GardenTile gT35 = new GardenTile(3,3);
		
		//Row 6
		GardenTile gT36 = new GardenTile(4,3, false);
		GardenTile gT37 = new GardenTile(0,4);
		GardenTile gT38 = new GardenTile(1,4);
		GardenTile gT39 = new GardenTile(2,4);
		GardenTile gT40 = new GardenTile(3,4);
		GardenTile gT41 = new GardenTile(4,4);
		GardenTile gT42 = new GardenTile(5,4, false);
		
		//Row 7
		GardenTile gT43 = new GardenTile(5,4, false);
		GardenTile gT44 = new GardenTile(6,4, false);
		GardenTile gT45 = new GardenTile(7,4);
		GardenTile gT46 = new GardenTile(5,4);
		GardenTile gT47 = new GardenTile(6,4);
		GardenTile gT48 = new GardenTile(7,4, false);
		GardenTile gT49 = new GardenTile(7,4, false);
		

		GardenTile[][] result = {{gT1, gT2, gT3, gT4, gT5, gT6, gT7},
								 {gT8, gT9, gT10, gT11, gT12, gT13, gT14},
								 {gT15, gT16, gT17, gT18, gT19, gT20, gT21},
								 {gT22, gT23, gT24, gT25, gT26, gT27, gT28},
								 {gT29, gT30, gT31, gT32, gT33, gT34, gT35,},
								 {gT36, gT37, gT38, gT39, gT40, gT41, gT42},
								 {gT43, gT44, gT45, gT46, gT47, gT48, gT49}
										};
		
		layout = result;
		length = 7;
		width = 7;
	}
	

	/**
	 * 
	 * @return a GardenTile 2D array representing the layout of the garden.
	 * returns layout
	 */
	public GardenTile[][] getLayout() {
		return layout;
	}

	
	/**
	 * sets layout
	 * @param layout
	 */
	public void setLayout(GardenTile[][] layout) {
		this.layout = layout;
	}



	/**
	 * 
	 * @return
	 * returns currentPlants
	 */
	public HashSet<Plant> getCurrentPlants() {
		return currentPlants;
	}

	/**
	 * sets currentPlants
	 * @param currentPlants
	 */
	public void setCurrentPlants(HashSet<Plant> currentPlants) {
		this.currentPlants = currentPlants;
	}

	

	
		
		
	
	
}

