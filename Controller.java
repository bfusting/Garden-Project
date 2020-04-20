import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;

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
 */
public class Controller {
	private Model model;
	private View view;
	
	/**
	 * 
	 */
	public Controller() {
		model = new Model();
		view = new View();
	}//Controller
	
	/**
	 * 
	 * @param tofu
	 */
	public static void main(String[] tofu) {
		System.out.println("Hello World");
		//launch();
	}//main
	
	/**
	 * 
	 * @param stage
	 */
	public static void start(Stage stage) {
		System.out.println("Do Something");
	}//start
	
	/**
	 * 
	 * @param event
	 */
	public void createNewGarden(MouseEvent event) {
		System.out.println("NEW GARDEN HAHAHAHAHAH");
	}//createNewGarden
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getCreateNewGarden() {
		return 0;
	}//getCreateNewGarden
	
	/**
	 * 
	 * @param event
	 */
	public void loadGarden(MouseEvent event) {
		System.out.println("Load Garden Here");
	}//loadGarden
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getLoadGarden() {
		return 0;
	}//getCreateNewGarden
	
	/**
	 * 
	 * @param event
	 */
	public void exit(MouseEvent event) {
		System.out.println("Exit by saving the closing");
	}//exit
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getExit() {
		return 0;
	}//getCreateNewGarden
	
	
	/**
	 * 
	 * @param event
	 */
	public void instructionsShow(MouseEvent event) {
		System.out.println("Show Instructions");
	}//instructionsShow
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getInstructionShow() {
		return 0;
	}//getCreateNewGarden
	
	
	/**
	 * 
	 * @param event
	 */
	public void backBTN(MouseEvent event) {
		System.out.println("Go Back");
	}//backBTN
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getBackBTN() {
		return 0;
	}//getCreateNewGarden
	
	/**
	 * 
	 * @param event
	 */
	public void chooseDesign(MouseEvent event) {
		System.out.println("Choose Templatttteeeeee");
	}//choseDesign
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getChooseDesign() {
		return 0;
	}//getCreateNewGarden
	
	
	/**
	 * 
	 * @param event
	 */
	public void comboCheckBox(MouseEvent event) {
		System.out.println("click me!");
	}//comboCheckBox
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getComboCheckBox() {
		return 0;
	}//getCreateNewGarden
	
	
	/**
	 * 
	 * @param event
	 */
	public void recommendationsBTN(MouseEvent event) {
		System.out.println("WE RECOMMEND COVID19");
	}//recommendationsBTN
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getRecommendationsBTN() {
		return 0;
	}//getCreateNewGarden
	
	
	/**
	 * 
	 * @param event
	 */
	public void changeSeasonsBTN(MouseEvent event) {
		System.out.println("Now is FAAAAAAAAAAAALLLLLLLLLLLLLLLLLL");
	}//changeSeasonsBTN
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getChangeSeasonsBTN() {
		return 0;
	}//getCreateNewGarden
	
	
	/**
	 * 
	 * @param event
	 */
	public void mainMenuBTN(MouseEvent event) {
		System.out.println("Take Me Home");
	}//mainMenuBTN
	
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getMainMenuBTN() {
		return 0;
	}//getCreateNewGarden
	
	/**
	 * 
	 * @param event
	 */
	public void changeTab(MouseEvent event) {
		System.out.println("change tabbbbb");
	}//changeTab
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getChangeTab() {
		return 0;
	}//getCreateNewGarden
	
	
	/**
	 * 
	 * @param event
	 */
	public void startDrag(MouseEvent event) {
		System.out.println("Starting to drag my soul out of my bodddyyyyyy");
	}//startDrag
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getStartDrag() {
		return 0;
	}//getCreateNewGarden
	
	
	/**
	 * 
	 * @param event
	 */
	public void detectDrag(DragEvent event) {
		System.out.println("Tiles should be detecting drag events");
	}//detectDrag
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getDetectDrag() {
		return 0;
	}//getCreateNewGarden
	
	/**
	 * 
	 * @param event
	 */
	public void okayToDrop(DragEvent event) {
		System.out.println("Highlight Green if Okay");
	}//okayToDrop
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getOkayToDrop() {
		return 0;
	}//getCreateNewGarden
	
	
	/**
	 * 
	 * @param event
	 */
	public void detectDragDrop(DragEvent event) {
		System.out.println("Tiles should detect drag and add that plant");
	}//detectDragDrop
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getDetectDragDrop() {
		return 0;
	}//getCreateNewGarden
	
	
	/**
	 * 
	 * @param event
	 */
	public void scrollPage(ScrollEvent event) {
		System.out.println("Should scroll page for information");
	}//scrollPage
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getScrollPage() {
		return 0;
	}//getCreateNewGarden
	
	
	/**
	 * 
	 * @param event
	 */
	public void editBTN(MouseEvent event) {
		System.out.println("Loads In information");
	}//editBTN
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getEditBTN() {
		return 0;
	}//getCreateNewGarden
	
	
	/**
	 * 
	 * @param event
	 */
	public void saveBTN(MouseEvent event) {
		System.out.println("SAVE OFTEN");
	}//saveBTN
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getSaveBTN() {
		return 0;
	}//getCreateNewGarden
	
	
	/**
	 * 
	 * @param event
	 */
	public void infoTipsBTN(MouseEvent event) {
		System.out.println("Displays tips");
	}//infoTipsBTN
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getInfoTipsBTN() {
		return 0;
	}//getCreateNewGarden
	
	/**
	 * 
	 * @param event
	 */
	public void viewSeasonsBTN(MouseEvent event) {
		System.out.println("Should be full season view");
	}//viewSeasonsBTN
	
	/**
	 * 
	 * @return
	 */
	public EventHandler getViewSeasonsBTN() {
		return 0;
	}//getCreateNewGarden
	
	
}//Controller
