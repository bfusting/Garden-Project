import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GardenTileTest {
	@Test
	void testRemove() {
		GardenTile gT = new GardenTile();
		AddOn a = new AddOn();
		gT.add(a);
		gT.remove();
		assertTrue(gT.getAddOn() == null);
	}
	
	@Test
	void testAdd(AddOn a) {
		GardenTile gT = new GardenTile();
		AddOn b = new AddOn();
		gT.add(b);
		assertTrue(gT.getAddOn() == b);
		
	}
	
	@Test
	void testGetHighlightedTileInfo() {
		GardenTile gT = new GardenTile();
		AddOn a = new AddOn();
		gT.add(a);
		assertTrue(gT.getHighlightedTileInfo() == a.description);
	}
	
	@Test
	void testGetRecommendations() {

		GardenTile gT = new GardenTile();
		Plant[] p = {};
		assertTrue(gT.getRecommendations() == p);
	}
	
	@Test
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
	void testValidPlacement() {
		GardenTile gT = new GardenTile();
		AddOn a = new AddOn();
		assertTrue(gT.validPlacement(a)== true);
		gT.add(a);
		assertTrue(gT.validPlacement(a)== false);
		
	}
}
