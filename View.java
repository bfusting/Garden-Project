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
 * @author takiyah
 *
 * General view that handles the visual components of the program. Contains 
 * the Buttons that are used on multiple screens and manages the primary
 * screen that the user is viewing at any point as well as secondary windows.
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
	 * Empty constructor for the View to be overridden by subclass views
	 */
	public View() {
	}
	
	/**
	 * Constructor for the View. Creates the instructions, exit, back and main menu buttons
	 * and sets the primary stage to the stage created at the start of the program.
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
	 * Creates the window to ask the user if they would like to save before exiting.
	 * 
	 * @see View#exitStage
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
