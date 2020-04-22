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
	void testIsSurroundingEmpty(int x, int y) {
		GardenPlot gP = new GardenPlot();
		GardenTile gT = new GardenTile();
		GardenTile[][] gA = {{gT}};
		gP.setLayout(gA);
		
		assertTrue(gP.isSurroundingEmpty(x, y));
		GardenTile g1 = new GardenTile();
		GardenTile g2 = new GardenTile();
		GardenTile g3 = new GardenTile();
		GardenTile[][] gB = {{g1, g2, g3}};
		
		AddOn a = new AddOn();
		g1.add(a);
		g2.add(a);
		g3.add(a);
		
		assertFalse(gP.isSurroundingEmpty(x, y));
		
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
}