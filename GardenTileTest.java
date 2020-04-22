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
		gT.add(a);
		Plant[] p = {};
		assertTrue(gT.getRecommendations() == p);
		
		
	}
	
	@Test
	/**
	 * Creates a GardenPlot and four GardenTiles to test if getSurroundingInfo() returns an array list of surrounding tiles AddOns
	 */
	void testGetSurroundingInfo() {
		GardenPlot gP = new GardenPlot();
		GardenTile g1 = new GardenTile();
		GardenTile g2 = new GardenTile();
		GardenTile g3 = new GardenTile();
		GardenTile[][] gB = {{g1, g2, g3}};
		gP.setLayout(gB);
		AddOn[] aA = {g1.getAddOn(), g3.getAddOn()};
		assertTrue(g2.getSurroundingInfo() == aA);
	}
	
	@Test
	/**
	 * Creats a GardenTile and an Addon and tests to see if the validPlacement() returns true or false depending on the current AddOn
	 */
	void testValidPlacement() {
		GardenTile gT = new GardenTile();
		AddOn a = new AddOn();
		assertTrue(gT.validPlacement(a)== true);
		gT.add(a);
		assertTrue(gT.validPlacement(a)== false);
		
	}
}
