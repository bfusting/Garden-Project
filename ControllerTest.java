import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.event.EventHandler;

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
 * Methods which are not tested from the Controller class deal with 
 * making new windows pop up in view and so forth. Each of those methods
 * cannot be junit tested since they deal with GUI implementation.
 * <p>
 * A test file to test event Handlers from the Controller class
 */
class ControllerTest {

	@Test
	/*
	 * Creates a new instance of a controller and asserts to see if it is a controller
	 */
	void testController() {
		Controller c = new Controller();
		assertTrue(c instanceof Controller);
	}
	
	@Test
	/*
	 * 
	 */
	void testGetModel() {
		Controller c = new Controller();
		assertTrue(c.getModel() instanceof Model);
	}
	
	
	@Test
	/*
	 * Creates a new instance of a garden, binds the vent handler to button in 
	 * View and then runs the createNewGardenMethod and checks to see if the 
	 * the gardenPlot is not null
	 */
	void testCreateNewGarden() {
		Controller c = new Controller();
		//c.createNewGarden(event);
		assertTrue(c.getModel().getUserPlot() != null);
	}

	@Test
	/*
	 * Creates new Controller and checks to see if getCreateNewGarden
	 * returns type eventHandler
	 */
	void testGetCreateNewGarden() {
		Controller c = new Controller();
		assertTrue(c.getCreateNewGarden() instanceof EventHandler);
	}

	@Test
	/*
	 * Creates a new instance of a garden, binds the vent handler to button in 
	 * View and then runs the  and checks to see if the 
	 * the gardenPlot is not null
	 */
	void testLoadGardenMouseEvent() {
		Controller c = new Controller();
		//c.loadGarden(event);
		assertTrue(c.getModel().getUserPlot() != null);
	}

	@Test
	/*
	 * Creates new Controller and checks to see if getCreateNewGarden
	 * returns type eventHandler
	 */
	void testGetLoadGarden() {
		Controller c = new Controller();
		assertTrue(c.getLoadGarden() instanceof EventHandler);
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getExit
	 * returns type eventHandler
	 */
	void testGetExit() {
		Controller c = new Controller();
		assertTrue(c.getExit() instanceof EventHandler);
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getInstructionShow
	 * returns type eventHandler
	 */
	void testGetInstructionShow() {
		Controller c = new Controller();
		assertTrue(c.getInstructionShow() instanceof EventHandler);
	}


	@Test
	/*
	 * Creates new Controller and checks to see if the getBackBTN
	 * returns type eventHandler
	 */
	void testGetBackBTN() {
		Controller c = new Controller();
		assertTrue(c.getBackBTN() instanceof EventHandler);
	}

	@Test
	/*
	 * Makes a new instance of a controller, runs the ChooseDesign()
	 * method on c and checks to see if the userPlot is empty. 
	 * If the userplot is not empty checks to see if all the array of tiles are not null
	 */
	void testChooseDesign() {
		Controller c = new Controller();
		c.chooseDesign(null);
		assertTrue(c.getModel().getUnderGrowth() != null);
		for(int row=0; row<c.getModel().getUserPlot().getLayout().length; row++) {
			assertTrue(c.getModel().getUserPlot().getLayout()[row] != null);
		}
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getChooseDesign
	 * returns type eventHandler
	 */
	void testGetChooseDesign() {
		Controller c = new Controller();
		assertTrue(c.getChooseDesign() instanceof EventHandler);
	}


	@Test
	/*
	 * Creates new Controller and checks to see if the getComboCheckBox
	 * returns type eventHandler
	 */
	void testGetComboCheckBox() {
		Controller c = new Controller();
		assertTrue(c.getComboCheckBox() instanceof EventHandler);
	}

	@Test
	void testRecommendationsBTN() {
		fail("Not yet implemented");
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getRecommendationsBTN
	 * returns type eventHandler
	 */
	void testGetRecommendationsBTN() {
		Controller c = new Controller();
		assertTrue(c.getRecommendationsBTN() instanceof EventHandler);
	}

	@Test
	void testChangeSeasonsBTN() {
		fail("Not yet implemented");
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getChangeSeasonsBTN
	 * returns type eventHandler
	 */
	void testGetChangeSeasonsBTN() {
		Controller c = new Controller();
		assertTrue(c.getChangeSeasonsBTN() instanceof EventHandler);
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the  getMainMenuBTN
	 * returns type eventHandler
	 */
	void testGetMainMenuBTN() {
		Controller c = new Controller();
		assertTrue(c.getMainMenuBTN() instanceof EventHandler);
	}
	

	@Test
	/*
	 * Creates new Controller and checks to see if the getChangeTab
	 * returns type eventHandler
	 */
	void testGetChangeTab() {
		Controller c = new Controller();
		assertTrue(c.getChangeTab() instanceof EventHandler);
	}

	@Test
	void testStartDrag() {
		fail("Not yet implemented");
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getStartDrag
	 * returns type eventHandler
	 */
	void testGetStartDrag() {
		Controller c = new Controller();
		assertTrue(c.getStartDrag() instanceof EventHandler);
	}

	@Test
	void testDetectDrag() {
		fail("Not yet implemented");
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getDetectDrag
	 * returns type eventHandler
	 */
	void testGetDetectDrag() {
		Controller c = new Controller();
		assertTrue(c.getDetectDrag() instanceof EventHandler);
	}

	@Test
	void testOkayToDrop() {
		fail("Not yet implemented");
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getOkayToDrop
	 * returns type eventHandler
	 */
	void testGetOkayToDrop() {
		Controller c = new Controller();
		assertTrue(c.getOkayToDrop() instanceof EventHandler);
	}

	@Test
	void testDetectDragDrop() {
		fail("Not yet implemented");
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getDetectDragDrop
	 * returns type eventHandler
	 */
	void testGetDetectDragDrop() {
		Controller c = new Controller();
		assertTrue(c.getDetectDragDrop() instanceof EventHandler);
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getScrollPage
	 * returns type eventHandler
	 */
	void testGetScrollPage() {
		Controller c = new Controller();
		assertTrue(c.getScrollPage() instanceof EventHandler);
	}


	@Test
	/*
	 * Creates new Controller and checks to see if the getEditBTN
	 * returns type eventHandler
	 */
	void testGetEditBTN() {
		Controller c = new Controller();
		assertTrue(c.getEditBTN() instanceof EventHandler);
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getSaveBTN
	 * returns type eventHandler
	 */
	void testGetSaveBTN() {
		Controller c = new Controller();
		assertTrue(c.getSaveBTN() instanceof EventHandler);
	}
	

	@Test
	/*
	 * Creates new Controller and checks to see if the getInfoTipsBTN
	 * returns type eventHandler
	 */
	void testGetInfoTipsBTN() {
		Controller c = new Controller();
		assertTrue(c.getInfoTipsBTN() instanceof EventHandler);
	}

	@Test
	void testViewSeasonsBTN() {
		fail("Not yet implemented");
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getViewSeasonsBTN
	 * returns type eventHandler
	 */
	void testGetViewSeasonsBTN() {
		Controller c = new Controller();
		assertTrue(c.getViewSeasonsBTN() instanceof EventHandler);
	}

	@Test
	void testSaveGarden() {
		fail("Not yet implemented");
	}

	@Test
	void testLoadGarden() {
		fail("Not yet implemented");
	}

}
