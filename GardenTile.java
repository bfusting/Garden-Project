import java.io.Serializable;
/**
 * 
 * @author Bradley
 *
 */
public class GardenTile implements Comparable<T>,Serializable {
	
	
	private int xLoc;
	private int yLoc;


	
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
	 * 
	 */
	public GardenTile() {
		isActive = true;
		isEmpty = true;
		soilType = "";
		waterLevel = 0;
		sunLightLevel = 0;
	}
	
	/**
	 * Removes the AddOn that occupies the GardenTile
	 * <p>
	 */
	public void remove() {
		
	}
	
	/**
	 * adds an AddOn to the GardenTile
	 * 
	 * @param a 
	 */
	public void add(AddOn a) {
		
	}
	
	/**
	 * 
	 * @return
	 * Returns the description of the AddOn in the Tile
	 */
	public String getHighlightedTileInfo() {
		
	}
	
	/**\
	 * 
	 * @return
	 * Returns an array of Plants that should be used around this GardenTile
	 */
	public Plant[] getRecommendations() {
		
	}
	
	/**
	 * 
	 * @return
	 * Returns an array of AddOns that are in the surrounding GardenTiles
	 */
	public AddOn[] getSurroundingInfo() {
		
	}
	
	public boolean equals(AddOn a) {
		
	}
	

	public int compareTo(AddOn a) {
		
	}
	
	/**
	 * 
	 * @param a
	 * @return
	 */
	public boolean validPlacement(AddOn a) {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isActive(){
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return true;
	}
	public String getSoilType() {
		return soilType;
	}

	public void setSoilType(String soilType) {
		this.soilType = soilType;
	}

	public int getWaterLevel() {
		return waterLevel;
	}

	public void setWaterLevel(int waterLevel) {
		this.waterLevel = waterLevel;
	}

	public int getSunLightLevel() {
		return sunLightLevel;
	}

	public void setSunLightLevel(int sunLightLevel) {
		this.sunLightLevel = sunLightLevel;
	}

	public AddOn getAddOn() {
		return addOn;
	}

	public void setAddOn(AddOn addOn) {
		this.addOn = addOn;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public boolean getIsActive() {
		return this.isActive;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public int getxLoc() {
		return xLoc;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}

}
