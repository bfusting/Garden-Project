import javafx.scene.input.MouseEvent;
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
	 * @param event
	 */
	public void loadGarden(MouseEvent event) {
		System.out.println("Load Garden Here");
	}//loadGarden
	
	
	/**
	 * 
	 * @param event
	 */
	public void exit(MouseEvent event) {
		System.out.println("Exit by saving the closing");
	}//exit
	
	/**
	 * 
	 * @param event
	 */
	public void instructionsShow(MouseEvent event) {
		System.out.println("Show Instructions");
	}//instructionsShow
	
	/**
	 * 
	 * @param event
	 */
	public void backBTN(MouseEvent event) {
		System.out.println("Go Back");
	}//backBTN
	
	/**
	 * 
	 * @param event
	 */
	public void chooseDesign(MouseEvent event) {
		System.out.println("Choose Templatttteeeeee");
	}//choseDesign
	
	/**
	 * 
	 * @param event
	 */
	public void comboCheckBox(MouseEvent event) {
		System.out.println("click me!");
	}//comboCheckBox
	
	/**
	 * 
	 * @param event
	 */
	public void recommendationsBTN(MouseEvent event) {
		System.out.println("WE RECOMMEND COVID19");
	}//recommendationsBTN
	
	/**
	 * 
	 * @param event
	 */
	public void changeSeasonsBTN(MouseEvent event) {
		System.out.println("Now is FAAAAAAAAAAAALLLLLLLLLLLLLLLLLL");
	}//changeSeasonsBTN
	
	/**
	 * 
	 * @param event
	 */
	public void mainMenuBTN(MouseEvent event) {
		System.out.println("Take Me Home");
	}//mainMenuBTN
	
	/**
	 * 
	 * @param event
	 */
	public void changeTab(MouseEvent event) {
		System.out.println("change tabbbbb");
	}//changeTab
	
	/**
	 * 
	 * @param event
	 */
	public void startDrag(MouseEvent event) {
		System.out.println("Starting to drag my soul out of my bodddyyyyyy");
	}//startDrag
}//Controller
