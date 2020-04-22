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
 */


public class View  {
	private Button instructionsButton;
	private Button exitButton;
	private Button saveButton;
	private Button backButton;
	private Button mainMenu;
	private int gardenLength;
	private int gardenWidth;
	private Stage primaryStage;
	private Scene primaryScene;
	private Stage exitStage;
	private Scene exitScene;
	
	
	public View() {
	}
	
	public View(Stage theStage) {
		instructionsButton = new Button("Instructions");
		exitButton = new Button("Exit");
		backButton = new Button("Back");
		mainMenu = new Button("Main Menu");
		gardenLength = -1;
		gardenWidth = -1;
		
		
		
		this.primaryStage = theStage;
	}
	
	
	
	/**
	 * 
	 */
	public void exit() {
		System.out.println("create window to ask user to save before exiting");
	}
	
	/**
	 * 
	 */
	public void close() {
		
	}
	
	/**
	 * 
	 */
	public void returnToMain() {
		System.out.println("switch primary scene back to main menu");
	}
	
	/**
	 * 
	 */
	public void update() {
		
	}
	
	//GETTERS AND SETTERS
	
	/**
	 * 
	 */
	public void setGardenLength(int length) {
		gardenLength = length;
	}
	
	/**
	 * 
	 * @param width
	 */
	public void setGardenWidth(int width) {
		gardenWidth = width;
	}
	
	
}
