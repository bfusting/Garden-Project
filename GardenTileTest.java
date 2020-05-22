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
	
	
	
	
}
