import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;

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
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c instanceof Controller);
	}
	
	@Test
	/*
	 * 
	 */
	void testGetModel() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getModel() instanceof Model);
	}
	
	
	@Test
	/*
	 * Creates a new instance of a garden, binds the vent handler to button in 
	 * View and then runs the createNewGardenMethod and checks to see if the 
	 * the gardenPlot is not null
	 */
	void testCreateNewGarden() {
		View view = new View();
		Controller c = new Controller(view);
		//c.createNewGarden(event);
		assertTrue(c.getModel().getUserPlot() != null);
	}

	@Test
	/*
	 * Creates new Controller and checks to see if getCreateNewGarden
	 * returns type eventHandler
	 */
	void testGetCreateNewGarden() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getCreateNewGarden() instanceof EventHandler);
	}

	@Test
	/*
	 * Creates a new instance of a garden, binds the vent handler to button in 
	 * View and then runs the  and checks to see if the 
	 * the gardenPlot is not null
	 */
	void testLoadGardenMouseEvent() {
		View view = new View();
		Controller c = new Controller(view);
		//c.loadGarden(event);
		assertTrue(c.getModel().getUserPlot() != null);
	}

	@Test
	/*
	 * Creates new Controller and checks to see if getCreateNewGarden
	 * returns type eventHandler
	 */
	void testGetLoadGarden() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getLoadGarden() instanceof EventHandler);
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getExit
	 * returns type eventHandler
	 */
	void testGetExit() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getExit() instanceof EventHandler);
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getInstructionShow
	 * returns type eventHandler
	 */
	void testGetInstructionShow() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getInstructionShow() instanceof EventHandler);
	}


	@Test
	/*
	 * Creates new Controller and checks to see if the getBackBTN
	 * returns type eventHandler
	 */
	void testGetBackBTN() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getBackBTN() instanceof EventHandler);
	}

	@Test
	/*
	 * Makes a new instance of a controller, runs the ChooseDesign()
	 * method on c and checks to see if the userPlot is empty. 
	 * If the userplot is not empty checks to see if all the array of tiles are not null
	 */
	void testChooseDesign() {
		View view = new View();
		Controller c = new Controller(view);
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
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getChooseDesign() instanceof EventHandler);
	}


	@Test
	/*
	 * Creates new Controller and checks to see if the getComboCheckBox
	 * returns type eventHandler
	 */
	void testGetComboCheckBox() {
		View view = new View();
		Controller c = new Controller(view);
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
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getRecommendationsBTN() instanceof EventHandler);
	}

	@Test
	/*
	 * Creates a new controller, a new mouseEvent and then uses changeSeasons.
	 * Should change the new enumeration value to SUMMER since default starting is 
	 * SPRING
	 */
	void testChangeSeasonsBTN() {
		View view = new View();
		Controller c = new Controller(view);
		//MouseEvent event = new MouseEvent(null, 0, 0, 0, 0, null, 0, false, false, false, false, false, false, false, false, false, false, false, false, null);
		//c.changeSeasonsBTN(event);
		assertEquals(c.getModel().getUserPlot().getSeason(), "SUMMER");
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getChangeSeasonsBTN
	 * returns type eventHandler
	 */
	void testGetChangeSeasonsBTN() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getChangeSeasonsBTN() instanceof EventHandler);
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the  getMainMenuBTN
	 * returns type eventHandler
	 */
	void testGetMainMenuBTN() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getMainMenuBTN() instanceof EventHandler);
	}
	

	@Test
	/*
	 * Creates a new controller, new plant instance with image and all,
	 * makes a ImageView tied to that image and sees if the Node where the 
	 * event originated copied the img into the dragboard
	 */
	void testStartDrag() {
		/*
		Controller c = new Controller();
		Plant p = new Plant();
		ImageView tempImg = new ImageView();
		tempImg.setImage();
		 */
		fail("Not written yet");
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getStartDrag
	 * returns type eventHandler
	 */
	void testGetStartDrag() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getStartDrag() instanceof EventHandler);
	}

	@Test
	/*
	 * Create new controller and node. Set the drag event controller and then 
	 * check the coordinates to see after the drag event if the imageView has moved
	 */
	void testDetectDrag() {
		View view = new View();
		Controller c = new Controller(view);
		ImageView n = new ImageView();
		n.setOnDragDetected(c.getDetectDrag());
		assertEquals(n.getX(),125);
		assertEquals(n.getY(),50);
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getDetectDrag
	 * returns type eventHandler
	 */
	void testGetDetectDrag() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getDetectDrag() instanceof EventHandler);
	}

	@Test
	/*
	 * Makes a new controller and node and checks if the drag event is over it
	 * If so the background of the gridPane tile should be green. Checks to see if the color
	 * is green. Else the background Color is grey
	 */
	void testOkayToDrop() {
		View view = new View();
		Controller c = new Controller(view);
		TilePane tpane = new TilePane();
		FlowPane fpane = new FlowPane();
		fpane.setOnDragEntered(c.getOkayToDrop());
		assertEquals(fpane.getStyle(), "-fx-background-color: GREEN");
		assertTrue(!fpane.getStyle().equals("-fx-background-color:GREY"));
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getOkayToDrop
	 * returns type eventHandler
	 */
	void testGetOkayToDrop() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getOkayToDrop() instanceof EventHandler);
	}

	@Test
	/*
	 * Creates new Controller and new view, then checks if the model at the 
	 * first row and column is not empty, if it's not empty it passes the test
	 * Emulation drop into 0,0
	 */
	void testDetectDragDrop() {
		View view = new View();
		Controller c = new Controller(view);
		ImageView i = new ImageView();
		i.setOnDragDropped(c.getDetectDragDrop());
		assertTrue(!c.getModel().getUserPlot().getLayout()[0][0].isEmpty());
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getDetectDragDrop
	 * returns type eventHandler
	 */
	void testGetDetectDragDrop() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getDetectDragDrop() instanceof EventHandler);
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getScrollPage
	 * returns type eventHandler
	 */
	void testGetScrollPage() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getScrollPage() instanceof EventHandler);
	}


	@Test
	/*
	 * Creates new Controller and checks to see if the getEditBTN
	 * returns type eventHandler
	 */
	void testGetEditBTN() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getEditBTN() instanceof EventHandler);
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getSaveBTN
	 * returns type eventHandler
	 */
	void testGetSaveBTN() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getSaveBTN() instanceof EventHandler);
	}
	

	@Test
	/*
	 * Creates new Controller and checks to see if the getInfoTipsBTN
	 * returns type eventHandler
	 */
	void testGetInfoTipsBTN() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getInfoTipsBTN() instanceof EventHandler);
	}

	@Test
	/*
	 * Creates new Controller and checks to see if the getViewSeasonsBTN
	 * returns type eventHandler
	 */
	void testGetViewSeasonsBTN() {
		View view = new View();
		Controller c = new Controller(view);
		assertTrue(c.getViewSeasonsBTN() instanceof EventHandler);
	}

	@Test
	/*
	 * Creating a new Controller and setting the first tile up with a new GardenTile
	 * and then serializing them to see if it writes out to file and if the objects 
	 * within the file stay linked
	 */
	void testSaveGarden() {
		try
			{
			View view = new View();
			Controller c = new Controller(view);
			c.getModel().getUserPlot().getLayout()[0][0] = new GardenTile();
		    FileOutputStream fos = new FileOutputStream("tempdata.ser");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(c);
		    oos.close();
		        }
		        catch (Exception ex)
		        {
		            fail("Exception thrown during test: " + ex.toString());
		        }

		        try
		        {
		            FileInputStream fis = new FileInputStream("tempdata.ser");
		            ObjectInputStream ois = new ObjectInputStream(fis);
		            Controller c = (Controller) ois.readObject();
		            ois.close();

		            assertTrue(c.getModel().getUserPlot().getLayout()[0][0].isActive());
		            assertTrue(!c.getModel().equals(null));

		            // Clean up the file
		            new File("tempdata.ser").delete();
		        }
		        catch (Exception ex)
		        {
		            fail("Exception thrown during test: " + ex.toString());
		        }
		    }

	@Test
	void testLoadGarden() {
		fail("Not yet implemented");
	}

}
