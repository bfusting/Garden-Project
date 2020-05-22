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
 * The GardenTile Object which makes up the individual squares on the GardenPlot.
 * They can hold AddOns and contain properties like water and light level as well as soil type 
 * <p>
 * @author Bradley
 * 
 *
 *
 */
public class GardenTile implements Comparable<AddOn>,Serializable {
	private static final long serialVersionUID = 1982591688L;
	
	private int xLoc;
	private int yLoc;
	private String blankImage;
	private boolean isActive;
	private boolean isEmpty;
	private String soilType;
	
	/**
	 * int waterLevel, int sunLightLevel
	 * 
	 * on a scale of 1 - 5 the level of water and light on the GardenTile
	 */
	private int waterLevel;
	private int sunLightLevel;
	
	/**
	 * AddOn addON 
	 * the AddOn that occupies this GardenTile
	 */
	private AddOn addOn = null;
	
	private Plant plant = null;
	
	/**
	 * Constructor setting variables to default settings 
	 * boolean values set to true, ints set to 0,
	 * and strings set to the empty string
	 */
	public GardenTile() {
		isActive = true;
		isEmpty = true;
		soilType = "";
		waterLevel = 0;
		sunLightLevel = 0;
	}
		/**
		 * Constructor for the GardenTile class with x and y parameters
		 * <p>
		 * 
		 * @param x - x position of tile
		 * @param y - position of tile
		 */
		public GardenTile(int x, int y) {
		isActive = true;
		isEmpty = true;
		soilType = "";
		waterLevel = 0;
		sunLightLevel = 0;
		this.xLoc = x;
		this.yLoc = y;
	}
		
		/**
		 * Constructor With x and y parameters and a Soil type parameter
		 * <p>
		 * @param x - x position of tile
		 * @param y - y position of tile
		 * @param sT - soil type 
		 */
		public GardenTile(int x, int y, String sT) {
			isActive = true;
			isEmpty = true;
			soilType = sT;
			waterLevel = 0;
			sunLightLevel = 0;
			this.xLoc = x;
			this.yLoc = y;
		}
		
		/**
		 * Constructor With x and y parameters and a boolean for the active parameter
		 * <p>
		 * @param x - x position of tile
		 * @param y - y position of tile
		 * @param active - whether or not this tile is active
		 */
		public GardenTile(int x, int y, boolean active) {
			isActive = active;
			isEmpty = true;
			soilType = "";
			waterLevel = 0;
			sunLightLevel = 0;
			this.xLoc = x;
			this.yLoc = y;
		}
		
	
	/**
	 * Removes the AddOn that occupies the GardenTile
	 * <p>
	 */
	public void remove() {
		this.addOn = null;
		this.isEmpty = true;
	}
	
	/**
	 * adds an AddOn to the GardenTile
	 * 
	 * @param a - AddOn to be set to this.addOn
	 */
	public void add(AddOn a) {
		this.addOn = a;
		this.isEmpty = false;
	}
	
	/**
	 * 
	 * @return
	 * Returns the description of the AddOn in the Tile
	 */
	public String getHighlightedTileInfo() {
		return this.addOn.getDescription();
	}
	
	
	
	/**\
	 * Returns an array of recommended plants based on surrounding tile information
	 * <p>
	 * @param arr - an array of AddOn's that surround this tile
	 * @return result - 
	 * Returns an array of Plants that should be used in this GardenTile
	 */
	/*public Plant[] getRecommendations(AddOn[] arr) {
			//TODO:
			//Have to test for each type of AddOn
			//Order of AddOn's in arr are Tile to the left, then right, then above, then below
			//Also have to make this work with the .csv of plants when we get that in
			Plant[] result = new Plant[5];
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i].getClass() == Plant.class) {
					Plant pA = (Plant) arr[i];
					if(pA.getPlantType() == "Tree") {
						result[i] = temp.getTreeArr().get(0);
						
					}
					
					if(pA.getPlantType() == "Flower") {
						result[i] = temp.getFlowerArr().get(0);
					}
					
					if(pA.getPlantType() == "Shrub") {
						result[i] = temp.getShrubArr().get(0);
					}
					
					
				}
				
				
			}
			
			
			return null;
		}*/
		
	/**
	 * Checks if the AddOn's are the same
	 * @param a
	 * @return
	 */
	public boolean equals(AddOn a) {
		return a == this.getAddOn();
	}
	
	/**
	 * 
	 */
	public int compareTo(AddOn a) {
		return 0;
	}
	
	
	/**
	 * Tells whether the tile is active.
	 * @return a boolean indicating whether the tile is active.
	 */
	public boolean isActive(){
		return this.isActive;
	}
	
	/**
	 * Indicates whether the tile is empty.
	 * @return a boolean, true if the tile is empty, false otherwise.
	 * 
	 */
	public boolean isEmpty() {
		return this.isEmpty;
	}
	


	/**
	 * Returns the water level of the tile.
	 * @return the water level of the tile.
	 */
	public int getWaterLevel() {
		return waterLevel;
	}

	/**
	 * Sets the water level of the tile, keeping within 1-5 inclusive.
	 * @param waterLevel the water level of the tile.
	 */
	public void setWaterLevel(int waterLevel) {
		this.waterLevel = Math.max(1, waterLevel);
		this.waterLevel = Math.min(this.waterLevel, 5);
	}

	/**
	 * Returns the sunlight level of the tile.
	 * @return the sunlight level of the tile.
	 */
	public int getSunLightLevel() {
		return sunLightLevel;
	}

	/**
	 * Sets the sunlight level with the given int, keeping within the range of 1-5 inclusive.
	 * @param sunLightLevel
	 */
	public void setSunLightLevel(int sunLightLevel) {
		this.sunLightLevel = Math.max(1,sunLightLevel);
		this.sunLightLevel = Math.min(this.sunLightLevel, 5);
	}

	/**
	 * Returns the AddOn contained in the tile.
	 * @return the AddOn in the tile.
	 */
	public AddOn getAddOn() {
		return addOn;
	}

	/**
	 * Sets the addOn attribute with the given addOn and changes the attribute indicating whether the tile
	 * is empty to false.
	 * @param addOn the AddOn to be held in the tile.
	 */
	public void setAddOn(AddOn addOn) {
		this.addOn = addOn;
		isEmpty = false;
	}
	
	/**
	 * Sets the plant attribute to the given Plant and changes the attribute indicating whether the tile is empty to false.
	 * @param p the Plant to be held in the tile.
	 */
	public void setPlant(Plant p) {
		this.plant = p;
		isEmpty = false;
	}

	/**
	 * Returns the plant attribute.
	 * @return the plant contained in the tile.
	 */
	public Plant getPlant() {
		return this.plant;
	}
	/**
	 * Sets the tile's activity.
	 * @param isActive True if the tile is active, false otherwise.
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	

	/**
	 * Empties the tile by setting the property isEmpty to true and setting the addOn and plant attributes to null.
	 */
	public void setEmpty() {
		isEmpty = true;
		addOn=null;
		plant=null;
	}

	/**
	 *  Gets the x position of the tile.
	 * @return the x position of the tile.
	 */
	public int getxLoc() {
		return xLoc;
	}

	/**
	 * Sets the x position of the tile.
	 * @param xLoc the x position of the tile.
	 */
	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	/**
	 * Gets the y position of the tile.
	 * @return the y position of the tile.
	 * 
	 */
	public int getyLoc() {
		return yLoc;
	}

	/**
	 * @param yLoc
	 * Sets the y position of the tile.
	 * 
	 */
	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}
	
	@Override
	public String toString() {
		String waterL = Plant.getWaterStrArr()[waterLevel-1];
		String sunL = Plant.getSunStrArr()[sunLightLevel-1];
		
		return "Location: ("+xLoc+","+yLoc+")\nWater level: "+waterL+"\nSunlight level: "+sunL;
	}
	
	
}
