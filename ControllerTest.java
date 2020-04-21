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
	void testExit() {
		fail("Not yet implemented");
	}

	@Test
	void testGetExit() {
		fail("Not yet implemented");
	}

	@Test
	void testInstructionsShow() {
		fail("Not yet implemented");
	}

	@Test
	void testGetInstructionShow() {
		fail("Not yet implemented");
	}

	@Test
	void testBackBTN() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBackBTN() {
		fail("Not yet implemented");
	}

	@Test
	void testChooseDesign() {
		fail("Not yet implemented");
	}

	@Test
	void testGetChooseDesign() {
		fail("Not yet implemented");
	}

	@Test
	void testComboCheckBox() {
		fail("Not yet implemented");
	}

	@Test
	void testGetComboCheckBox() {
		fail("Not yet implemented");
	}

	@Test
	void testRecommendationsBTN() {
		fail("Not yet implemented");
	}

	@Test
	void testGetRecommendationsBTN() {
		fail("Not yet implemented");
	}

	@Test
	void testChangeSeasonsBTN() {
		fail("Not yet implemented");
	}

	@Test
	void testGetChangeSeasonsBTN() {
		fail("Not yet implemented");
	}

	@Test
	void testMainMenuBTN() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMainMenuBTN() {
		fail("Not yet implemented");
	}

	@Test
	void testChangeTab() {
		fail("Not yet implemented");
	}

	@Test
	void testGetChangeTab() {
		fail("Not yet implemented");
	}

	@Test
	void testStartDrag() {
		fail("Not yet implemented");
	}

	@Test
	void testGetStartDrag() {
		fail("Not yet implemented");
	}

	@Test
	void testDetectDrag() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDetectDrag() {
		fail("Not yet implemented");
	}

	@Test
	void testOkayToDrop() {
		fail("Not yet implemented");
	}

	@Test
	void testGetOkayToDrop() {
		fail("Not yet implemented");
	}

	@Test
	void testDetectDragDrop() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDetectDragDrop() {
		fail("Not yet implemented");
	}

	@Test
	void testScrollPage() {
		fail("Not yet implemented");
	}

	@Test
	void testGetScrollPage() {
		fail("Not yet implemented");
	}

	@Test
	void testEditBTN() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEditBTN() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBTN() {
		fail("Not yet implemented");
	}

	@Test
	void testGetSaveBTN() {
		fail("Not yet implemented");
	}

	@Test
	void testInfoTipsBTN() {
		fail("Not yet implemented");
	}

	@Test
	void testGetInfoTipsBTN() {
		fail("Not yet implemented");
	}

	@Test
	void testViewSeasonsBTN() {
		fail("Not yet implemented");
	}

	@Test
	void testGetViewSeasonsBTN() {
		fail("Not yet implemented");
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
