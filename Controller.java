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
	
	public static void start(Stage stage) {
		
	}
	
}//Controller
