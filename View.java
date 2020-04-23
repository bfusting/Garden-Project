import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
 * General view that handles the visual components of the program. Contains 
 * the Buttons that are used on multiple screens and manages the primary
 * screen that the user is viewing at any point as well as a secondary window 
 * for saving before quitting to be shown when the user presses the exit button.
 * 
 * @author Takiyah Price 
 */


public class View  {
	private Button instructionsButton;
	private Button exitButton;
	private Button saveButton;
	private Button backButton;
	private Button mainMenu;
	private Stage primaryStage;
	private Scene primaryScene;
	private Stage exitStage;
	private Scene exitScene;
	
	/**
	 * Empty constructor for the View to be overridden by subclasses.
	 */
	public View() {
	}
	
	/**
	 * Constructor for the View that creates the instructions, exit, back and main menu Buttons
	 * and sets primaryStage to the Stage created at the start of the program. 
	 * 
	 * @param theStage the Stage created automatically at the start of the program
	 */
	public View(Stage theStage) {
		instructionsButton = new Button("Instructions");
		exitButton = new Button("Exit");
		backButton = new Button("Back");
		mainMenu = new Button("Main Menu");

			
		this.primaryStage = theStage;
	}
	
	
	/**
	 * Creates a window to ask if the user would like to save before exiting by
	 * creating a new Stage with a Scene containing the save Button and a Button for closing
	 * the program, then sets the new Stage to exitStage and makes it visible to the user.
	 * 
	 * @see View#exitStage
	 * @see View#exitScene
	 * @see View#saveButton
	 */
	public void exit() {
		System.out.println("create window to ask user to save before exiting");
	}
	
	/**
	 * Closes all open windows after the user saves or quits without saving.
	 */
	public void close() {
		System.out.println("close application (meaning close all open windows)");
	}
	
	
	
		
	
}
