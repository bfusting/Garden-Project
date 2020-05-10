import java.io.Serializable;

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
 * @author Bradley
 * The GardenTile Object which makes up the individual squares on the GardenPlot.
 * They can hold AddOns and contain properties like water and light level as well as soil type 
 *
 *
 */
public class GardenTile implements Comparable<AddOn>,Serializable {
	
	
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
	
	/**
	 * Constructor setting variables to default settings
	 */
	public GardenTile() {
		isActive = true;
		isEmpty = true;
		soilType = "";
		waterLevel = 0;
		sunLightLevel = 0;
	}
		/**
		 * Constructor With x and y parameters
		 * @param x
		 * @param y
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
		 * @param x
		 * @param y
		 * @param sT soil type
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
		 * Constructor With x and y parameters and a Soil type parameter
		 * @param x
		 * @param y
		 * @param active
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
	 * @param a 
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
	
	//temp is being used while we have temporary plant objects in the Model class.  Will remove later
	private Model temp = new Model();
	
	/**\
	 * 
	 * @return
	 * Returns an array of Plants that should be used in this GardenTile
	 */
	public Plant[] getRecommendations(AddOn[] arr) {
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
				
				if(pA.getPlantType() == "UnderGrowth") {
					result[i] = temp.getUnderGrowth().get(0);
				}
				
			}
			
			
		}
		
		
		return null;
	}
	
	
	
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
	 * Tests to see if the AddOn was placed in a valid spot.
	 * 
	 * @return
	 */
	public boolean validPlacement() {
		if(this.addOn != null) {
			return false;
		}
		else return true;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isActive(){
		return this.isActive;
	}
	
	/**
	 * 
	 * @return
	 * 
	 * 
	 */
	public boolean isEmpty() {
		return this.isEmpty;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSoilType() {
		return soilType;
	}

	/**
	 * 
	 * @param soilType
	 */
	public void setSoilType(String soilType) {
		this.soilType = soilType;
	}

	/**
	 * 
	 * @return
	 */
	public int getWaterLevel() {
		return waterLevel;
	}

	/**
	 * 
	 * @param waterLevel
	 */
	public void setWaterLevel(int waterLevel) {
		this.waterLevel = waterLevel;
	}

	/**
	 * 
	 * @return
	 */
	public int getSunLightLevel() {
		return sunLightLevel;
	}

	/**
	 * 
	 * @param sunLightLevel
	 */
	public void setSunLightLevel(int sunLightLevel) {
		this.sunLightLevel = sunLightLevel;
	}

	/**
	 * 
	 * @return
	 */
	public AddOn getAddOn() {
		return addOn;
	}

	/**
	 * 
	 * @param addOn
	 */
	public void setAddOn(AddOn addOn) {
		this.addOn = addOn;
	}

	/**
	 * 
	 * @param isActive
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getIsActive() {
		return this.isActive;
	}

	/**
	 * 
	 * @param isEmpty
	 */
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	/**
	 * 
	 * @return
	 */
	public int getxLoc() {
		return xLoc;
	}

	/**
	 * 
	 * @param xLoc
	 */
	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	/**
	 * 
	 * @return
	 * 
	 */
	public int getyLoc() {
		return yLoc;
	}

	/**
	 * 
	 * @param yLoc
	 * sets the y position of the tile
	 * 
	 */
	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}

}
