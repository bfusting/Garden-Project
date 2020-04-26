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
 * 
 * @author Bradley Fusting
 *
 */
public class GardenPlot implements Serializable{
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
	public void GardenPlot(String s, int l, int w) { 
		this.shape = s;
		this.length = l;
		this.width = w;
		this.layout = this.makeSquare();
		
		
	}
	
	public void GardenPlot() {
		this.makeSquare();
	}
	
	
	
	/**
	 * Creates a square 5x5 2D GardenTile array for the layout.
	 * Also initializes all gardenTiles with x and y values
	 * @return
	 * returns the array for this.layout
	 */
	public GardenTile[][] makeSquare(){
		//Row 1
		GardenTile gT1 = new GardenTile(0,0);
		GardenTile gT2 = new GardenTile(1,0);
		GardenTile gT3 = new GardenTile(2,0);
		GardenTile gT4 = new GardenTile(3,0);
		GardenTile gT5 = new GardenTile(4,0);
		
		//Row 2
		GardenTile gT6 = new GardenTile(0,1);
		GardenTile gT7 = new GardenTile(1,1);
		GardenTile gT8 = new GardenTile(2,1);
		GardenTile gT9 = new GardenTile(3,1);
		GardenTile gT10 = new GardenTile(4,1);
		
		//Row 3
		GardenTile gT11 = new GardenTile(0,2);
		GardenTile gT12 = new GardenTile(1,2);
		GardenTile gT13 = new GardenTile(2,2);
		GardenTile gT14 = new GardenTile(3,2);
		GardenTile gT15 = new GardenTile(4,2);
		
		//Row 4
		GardenTile gT16 = new GardenTile(0,3);
		GardenTile gT17 = new GardenTile(1,3);
		GardenTile gT18 = new GardenTile(2,3);
		GardenTile gT19 = new GardenTile(3,3);
		GardenTile gT20 = new GardenTile(4,3);
		
		//Row 5
		GardenTile gT21 = new GardenTile(0,3);
		GardenTile gT22 = new GardenTile(1,3);
		GardenTile gT23 = new GardenTile(2,3);
		GardenTile gT24 = new GardenTile(3,3);
		GardenTile gT25 = new GardenTile(4,3);
		
		GardenTile[][] layout = {{gT1, gT2, gT3, gT4, gT5},
								{gT6, gT7, gT8, gT9, gT10},
								{gT11, gT12, gT13, gT14, gT15},
								{gT16, gT17, gT18, gT19, gT20},
								{gT21, gT22, gT23, gT24, gT25}};
		
		return layout;
								}
		
		
	
	
	
	
	
	/**
	 * 
	 * @return
	 * returns shape
	 */
	public String getShape() {
		return shape;
	}
	
	/**
	 * sets shape
	 * @param shape
	 */
	public void setShape(String shape) {
		this.shape = shape;
	}

	/**
	 * 
	 * @return
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
	 * returns length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * sets length
	 * @param length
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * 
	 * @return
	 * returns width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * sets width
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
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

	/**
	 * 
	 * @return
	 * returns season
	 */
	public Seasons getSeason() {
		return season;
	}

	/**
	 * sets season
	 * @param season
	 */
	public void setSeason(Seasons season) {
		this.season = season;
	}
		
	/**
	 * sets GardenTile attribute isActive to true
	 * TODO:
	 * Must move this method into model as eventhandlers are needed for this method
	 */
	public void selectActiveGardenTiles() {
		
	}
	
	/**
	 * Checks if surrounding tiles are empty
	 * 
	 * @param x 
	 * @param y
	 * @return
	 * Returns true if there are no AddOns in surrounding tiles
	 */
	public boolean isSurroundingEmpty(int x, int y){
		//Finding the desired tile
		for(int k = 0; k < layout.length;k++) {
			for(int i = 0; i < layout[k].length; i++) {
				if(layout[k][i].getxLoc() == x && layout[k][i].getyLoc() == y) {
					
					//Testing Tiles to the left and right
				try {
					if(layout[k][i-1].getAddOn() != null) {
						return false;
					}
				}
				catch(ArrayIndexOutOfBoundsException e){
					
				}
				try {
					if(layout[k][i+1].getAddOn() != null) {
						return false;
					}
				}
				catch(ArrayIndexOutOfBoundsException e){
					
				}
				
				
				//Testing Tiles above and below
				try {	
					if(layout[k+1][i] != null) {
						return false;
					}
				}
				catch(ArrayIndexOutOfBoundsException e) {
					
				}
				try {
					//Testing Tiles above and below
						if(layout[k-1][i].getAddOn() != null ) {
							return false;
						}
					}
				catch(ArrayIndexOutOfBoundsException e) {
						
					}
					//Its empty if it made it here
					return true;
				}
			}
		}
		
		return true;
}
		
		
		
		
		
	
	
	/**
	 * Fills empty tiles in the layout with AddOns based on recommendations
	 */
	public void fillEmpty() {
		//Traverses Every Garden Tile
		for(GardenTile[] arr : layout) {
			for(GardenTile gT : arr){
		
		//Checks if the tile is empty and fills it
				if(gT.isEmpty()) {
					gT.add( gT.getRecommendations (this.getSurroundingInfo(gT.getxLoc(), gT.getyLoc()))[0]);
				}
			}
		}
	}
	
	
	
	/**
	 * 
	 * @return
	 * Returns an array of AddOns that are in the surrounding GardenTiles
	 */
	public AddOn[] getSurroundingInfo(int x, int y) {
		
		AddOn[] arr = new AddOn[3];
		//Finding the desired tile
				for(int k = 0; k < layout.length;k++) {
					for(int i = 0; i < layout[k].length; i++) {
						if(layout[k][i].getxLoc() == x && layout[k][i].getyLoc() == y) {
							//Adding surrounding AddOns to the array
							try {
							
							arr[0] = layout[k][i-1].getAddOn();
							}
							catch(ArrayIndexOutOfBoundsException e) {
								arr[0] = null;
							}
							try {
							arr[1] = layout[k][i+1].getAddOn();
							}
							catch(ArrayIndexOutOfBoundsException e) {
								arr[1] = null;
							}
							try {
							arr[2] = layout[k-1][i].getAddOn();
							}
							catch(ArrayIndexOutOfBoundsException e) {
								arr[2] = null;
							}
							try {
							arr[3] = layout[k+1][i].getAddOn();
							}
							catch(ArrayIndexOutOfBoundsException e) {
								arr[3] = null;
							}
							
							
							return arr;
							
						}
					}
				}
				return arr;
	}
	
}

