import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Bradley
 *
 */
public class GardenPlotTest {

	
	@Test
	/**
	 * tests to see if the tile selected is set to active when selectActiveGardenTiles() is called
	 */
	void testSelectActiveGardenTiles() {
		GardenPlot gP = new GardenPlot();
		GardenTile gT = new GardenTile();
		GardenTile[][] gA = {{gT}};
		gP.setLayout(gA);
		
		gP.selectActiveGardenTiles();
		assertTrue(gP.getLayout()[0][0].getIsActive() == true);
	}
	
	@Test
	/**
	 * tests to see if isSurroundingEmpty() returns true if the surrounding is empty and false when its not empty
	 * @param x
	 * @param y
	 */
	void testIsSurroundingEmpty() {
		GardenPlot gP = new GardenPlot();
		GardenTile gT = new GardenTile();
		GardenTile[][] gA = {{gT}};
		gP.setLayout(gA);
		
		assertTrue(gP.isSurroundingEmpty(0,0));
		GardenTile g1 = new GardenTile();
		GardenTile g2 = new GardenTile();
		GardenTile g3 = new GardenTile();
		GardenTile g4 = new GardenTile();
		GardenTile g5 = new GardenTile();
		GardenTile g6 = new GardenTile();
		GardenTile g7 = new GardenTile();
		GardenTile g8 = new GardenTile();
		GardenTile g9 = new GardenTile();
		
		g5.setxLoc(1);
		g5.setyLoc(1);
		GardenTile[][] gB = {{g1, g2, g3},
							 {g4, g5, g6},
							 {g7, g8, g9}};
		
		AddOn a = new AddOn();
		g1.add(a);
		g2.add(a);
		g3.add(a);
		
		assertFalse(gP.isSurroundingEmpty(1, 1));
		
	}
	
	@Test
	/**
	 * Tests to see if empty gardenTiles get filled
	 */
	void testFillEmpty() {
		GardenPlot gP = new GardenPlot();
		GardenTile gT = new GardenTile();
		GardenTile[][] gA = {{gT}};
		gP.setLayout(gA);
		gP.fillEmpty();
		
		for(GardenTile[] a : gA) {
			for(GardenTile t : a) {
				assertTrue(t.getAddOn() != null);
			}
		}
	}
	
	@Test
	/**
	 * Creates a GardenPlot and four GardenTiles to test if getSurroundingInfo() returns an array list of surrounding tiles AddOns
	 */
	void testGetSurroundingInfo() {
		GardenPlot gP = new GardenPlot();
		GardenTile g1 = new GardenTile();
		g1.setxLoc(1);
		g1.setyLoc(1);
		GardenTile g2 = new GardenTile();
		GardenTile g3 = new GardenTile();
		GardenTile[][] gB = {{g1, g2, g3}};
		gP.setLayout(gB);
		AddOn[] aA = {g1.getAddOn(), g3.getAddOn()};
		assertTrue(gP.getSurroundingInfo(1,1) == aA);
	}
}
