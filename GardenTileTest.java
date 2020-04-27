import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GardenTileTest {
	@Test
	/**
	 * Creates a GardenTile and AddOn and test to see if remove() removes the AddON
	 */
	void testRemove() {
		GardenTile gT = new GardenTile();
		AddOn a = new AddOn();
		gT.add(a);
		gT.remove();
		assertTrue(gT.getAddOn() == null);
	}
	
	@Test
	/**
	 * Creates a GardenTile and AddOn and test to see if add() correctly adds the AddOn to the GardenTile
	 */
	void testAdd() {
		GardenTile gT = new GardenTile();
		AddOn b = new AddOn();
		gT.add(b);
		assertTrue(gT.getAddOn() == b);
		
	}
	
	@Test
	/**
	 * Creates a GardenTile and an AddOn and tests to see if getHighlightedTileInfo() returns info from the selected tile
	 */
	void testGetHighlightedTileInfo() {
		GardenTile gT = new GardenTile();
		AddOn a = new AddOn();
		gT.add(a);
		assertTrue(gT.getHighlightedTileInfo() == a.description);
	}
	
	@Test
	/**
	 * Creates a GardenTile and an AddOn and tests if getRecommendations returns recommended plants
	 */
	void testGetRecommendations() {

		GardenTile gT = new GardenTile();
		AddOn a = new AddOn();
		AddOn b = new AddOn();
		AddOn[] arr = {b};
		gT.add(a);
		Plant[] p = {null, null, null, null, null};
		assertTrue(gT.getRecommendations(arr) == p);
		
		
	}
	
	
	
	@Test
	/**
	 * Creats a GardenTile and an Addon and tests to see if the validPlacement() returns true or false depending on the current AddOn
	 */
	void testValidPlacement() {
		GardenTile gT = new GardenTile();
		AddOn a = new AddOn();
		assertTrue(gT.validPlacement()== true);
		gT.add(a);
		assertTrue(gT.validPlacement()== false);
		
	}
}
