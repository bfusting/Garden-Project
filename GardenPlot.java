import java.util.*;
/**
 * 
 * @author Bradley
 *
 */
public class GardenPlot {
	String shape;
	
	GardenTile[][] layout;
	
	int length;
	int width;
	
	HashSet<Plant> currentPlants = new HashSet<Plant>();
	
	Seasons season;
	
	public void GardenPlot() {
		
	}
	
	public void GardenPlot(String s, int l, int w) {
		this.shape = s;
		this.length = l;
		this.width = w;
		
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public GardenTile[][] getLayout() {
		return layout;
	}

	public void setLayout(GardenTile[][] layout) {
		this.layout = layout;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public HashSet<Plant> getCurrentPlants() {
		return currentPlants;
	}

	public void setCurrentPlants(HashSet<Plant> currentPlants) {
		this.currentPlants = currentPlants;
	}

	public Seasons getSeason() {
		return season;
	}

	public void setSeason(Seasons season) {
		this.season = season;
	}
		
	public void selectActiveGardenTiles() {
		
	}
	
	public boolean isSurroundingEmpty(int x, int y){
		return true;
	}
	
	public void fillEmpty() {
		
	}
}
