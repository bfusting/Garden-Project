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
	
	public void GardenPlot() {
		
	}
	
	/**
	 * 
	 * @param s
	 * @param l
	 * @param w
	 */
	public void GardenPlot(String s, int l, int w) { 
		this.shape = s;
		this.length = l;
		this.width = w;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public String getShape() {
		return shape;
	}
	
	/**
	 * 
	 * @param shape
	 */
	public void setShape(String shape) {
		this.shape = shape;
	}

	/**
	 * 
	 * @return
	 */
	public GardenTile[][] getLayout() {
		return layout;
	}

	
	/**
	 * 
	 * @param layout
	 */
	public void setLayout(GardenTile[][] layout) {
		this.layout = layout;
	}

	/**
	 * 
	 * @return
	 */
	public int getLength() {
		return length;
	}

	/**
	 * 
	 * @param length
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * 
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * 
	 * @return
	 */
	public HashSet<Plant> getCurrentPlants() {
		return currentPlants;
	}

	/**
	 * 
	 * @param currentPlants
	 */
	public void setCurrentPlants(HashSet<Plant> currentPlants) {
		this.currentPlants = currentPlants;
	}

	/**
	 * 
	 * @return
	 */
	public Seasons getSeason() {
		return season;
	}

	/**
	 * 
	 * @param season
	 */
	public void setSeason(Seasons season) {
		this.season = season;
	}
		
	/**
	 * 
	 */
	public void selectActiveGardenTiles() {
		
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isSurroundingEmpty(int x, int y){
		return true;
	}
	
	/**
	 * 
	 */
	public void fillEmpty() {
		
	}
}
