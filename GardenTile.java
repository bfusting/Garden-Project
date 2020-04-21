import java.io.Serializable;
/**
 * 
 * @author Bradley
 *
 */
public class GardenTile implements Comparable<T>,Serializable {
	
	//Don't forget the constructor and getters/setters

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
}
