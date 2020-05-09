import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/*
*  Authors: Team 11-3: Bradley Fusting, Takiyah Price, Kelsey McRae, Malachi Parks
*  Class Section: 011
*  Lab Section: 031L
*  TA: Vineeth Gutta
*  Due: May 18th, 2020 (5/18/20)
*
*  This file contains the contents for the project for CISC275. The project for the 
*  class is to make gardening software for the township of Arden, DE to help
*  promote forest edge preservation. 
*  
*/

/**
 * 
 * @author Malachi Parks
 * 
 * Used to test the Model class from the constructor to updating the arrays of trees
 * and plant arrays. Getters and Setters are not tested in this file yet but 
 * will be in next version
 *
 */
class ModelTest {

	@Test
	void testModel() {
		Model m = new Model();
		assertTrue(m instanceof Model);
	}

	@Test
	/*
	 * When called with event handler should just create a new gardenPlot
	 * thus just generates a new GardenPlot, need to rewrite equals method
	 * to see what makes a Model equal
	 */
	void testCreateGardenPlotAlts() {
		Model m1 = new Model();
		Model m2 = new Model();
		m1.equals(m2);
	}

	@Test
	/*
	 * Should update the index of the selection arrayList and only show the current
	 * 6 items in the array
	 */
	void testupdateFlowerArr() {
		Model m = new Model();
		//checking if array is empty
		assertTrue(m.getFlowerArr().isEmpty());
		
		// It calls the AddOn default constructor no idea why fix in next push
		AddOn a = new AddOn();
		ArrayList<AddOn> newSelection = new ArrayList<AddOn>();
		newSelection.add(a);
		
		// Calling method then comparing to newSelection ArrayList
		m.updateArrs();
		assertTrue(m.getFlowerArr().equals(newSelection));
	}

	@Test
	/*
	 * Should update the index of the Shrub arrayList and only show the current
	 * 6 items in the array
	 */
	void testUpdateShrubArr() {
		Model m = new Model();
		//checking if array is empty
		assertTrue(m.getFlowerArr().isEmpty());
		
		// It calls the AddOn default constructor no idea why fix in next push
		Plant milkWeed = new Plant("Milkweed", 1, "Common Milkweed", "Orange", 4, 2, 
				2.00, 0, Seasons.SUMMER, false, null, null, "UnderGrowth", null, null);
		ArrayList<Plant> newShrub = new ArrayList<Plant>();
		newShrub.add(milkWeed);
		
		// Calling method then comparing to newSelection ArrayList
		m.updateArrs();
		assertTrue(m.getFlowerArr().equals(newShrub));
	}

	@Test
	/*
	 * Should update the index of the Tree arrayList and only show the current
	 * 6 items in the array
	 */
	void testUpdateTreeArr() {
		Model m = new Model();
		//checking if array is empty
		assertTrue(m.getFlowerArr().isEmpty());
		
		// It calls the AddOn default constructor no idea why fix in next push
		Plant milkWeed = new Plant("Milkweed", 1, "Common Milkweed", "Orange", 4, 2, 
				2.00, 0, Seasons.SUMMER, false, null, null, "UnderGrowth", null, null);
		ArrayList<Plant> newTree = new ArrayList<Plant>();
		newTree.add(milkWeed);
		
		// Calling method then comparing to newSelection ArrayList
		m.updateArrs();
		assertTrue(m.getFlowerArr().equals(newTree));
	}

	@Test
	void testUpdateUnderGrowthArr() {
		Model m = new Model();
		//checking if array is empty
		assertTrue(m.getFlowerArr().isEmpty());
		
		// It calls the AddOn default constructor no idea why fix in next push
		Plant milkWeed = new Plant("Milkweed", 1, "Common Milkweed", "Orange", 4, 2, 
				2.00, 0, Seasons.SUMMER, false, null, null, "UnderGrowth", null, null);
		ArrayList<Plant> newUnderGrowth = new ArrayList<Plant>();
		newUnderGrowth.add(milkWeed);
		
		// Calling method then comparing to newSelection ArrayList
		m.updateArrs();
		assertTrue(m.getFlowerArr().equals(newUnderGrowth));
	}

}
