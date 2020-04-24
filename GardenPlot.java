import java.util.*;
/**
 * 
 * @author Bradley
 *
 */
public class GardenPlot {
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
	 * 
	 * @param s shape
	 * @param l length
	 * @param w width
	 */
	public void GardenPlot(String s, int l, int w) { 
		this.shape = s;
		this.length = l;
		this.width = w;
		
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
					if(layout[k][i-1].getAddOn() != null || layout[k][i+1].getAddOn() != null) {
						return false;
					}
					
					//Testing Tiles above and below
					if(layout[k-1][i].getAddOn() != null || layout[k+1][i] != null) {
						return false;
					}
					
					//Its empty if it made it here
					else {
						return true;
					}
				}
				
			
			
			}
		}
		
		return true;
}
		
		
		
		
		
	
	
	/**
	 * Fills empty tiles in the layout with AddOns
	 */
	public void fillEmpty() {
		
	}
}
