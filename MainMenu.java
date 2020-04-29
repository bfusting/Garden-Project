

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
 * View that handles the creation and presentation of the main menu screen. Contains 
 * the visual components for the main menu window that will be made visible at the start
 * of the program, including options for creating a new garden, loading an existing garden,
 * viewing the instructions and exiting the program.
 *
 *
 * @author Takiyah Price
 */
//last edited: 4-28-20 2:54PM

public class MainMenu extends Screen {
	private Button createNewGardenButton;
	private Button loadGardenButton;
	private Button instructionsButton;
	private Button exitButton;
	private Image backgroundImage;
	private ImageView backgroundIV;
	private Scene mainMenuScene;
	private Stage primaryStage;
	private BorderPane bPane;
	
	private Screen previousScreen = this;
	
	/**
	 * Constructor for the Main Menu that creates new Buttons for creating or loading a garden and 
	 * the background Image for the window, then sets a new Stage with a Scene containing these components.
	 * 
	 */
	public MainMenu(Controller c, Stage s) {
		//Create Buttons and Background
		createNewGardenButton = new Button("Create New Garden");
		createNewGardenButton.setMinSize(200, 60);
		createNewGardenButton.setOnMouseClicked(c.getCreateNewGarden());
		
		loadGardenButton = new Button("Load Garden");
		loadGardenButton.setMinSize(200, 60);
		loadGardenButton.setOnMouseClicked(c.getLoadGarden());
		
		instructionsButton = new Button("Instructions");
		instructionsButton.setMinSize(200, 60);
		instructionsButton.setOnMouseClicked(c.getInstructionShow());
		
		exitButton = new Button("Exit");
		exitButton.setMinSize(200, 60);
		exitButton.setOnMouseClicked(c.getExit());
		
		
		backgroundImage = new Image("img/700.jpeg");
		backgroundIV = new ImageView(backgroundImage);
		backgroundIV.setFitWidth(1200);
		backgroundIV.setFitHeight(1610);
		backgroundIV.setPreserveRatio(true);
		backgroundIV.setSmooth(true);
		
		primaryStage = s;
		
		
		bPane = new BorderPane();
		
		//
		
		//AnchorPane tileAP = new AnchorPane();
		//AnchorPane.setTopAnchor(tileAP, 220.0);
		//AnchorPane.setLeftAnchor(tPane, 20.0);
		//AnchorPane.setRightAnchor(tPane,20.20);
		//tileAP.getChildren().add(tPane);
		
		AnchorPane buttonAP = new AnchorPane();
		AnchorPane.setTopAnchor(createNewGardenButton,220.0);
		AnchorPane.setTopAnchor(loadGardenButton, 320.0);
		AnchorPane.setTopAnchor(instructionsButton, 420.0);
		AnchorPane.setTopAnchor(exitButton, 520.0);
		
		AnchorPane.setLeftAnchor(createNewGardenButton,50.0);
		AnchorPane.setLeftAnchor(loadGardenButton, 50.0);
		AnchorPane.setLeftAnchor(instructionsButton, 50.0);
		AnchorPane.setLeftAnchor(exitButton, 50.0);
		
		AnchorPane.setRightAnchor(createNewGardenButton,50.0);
		AnchorPane.setRightAnchor(loadGardenButton, 50.0);
		AnchorPane.setRightAnchor(instructionsButton, 50.0);
		AnchorPane.setRightAnchor(exitButton, 50.0);
		
		buttonAP.getChildren().addAll(createNewGardenButton,loadGardenButton,instructionsButton,exitButton);
		
		bPane.setLeft(buttonAP);
		
		bPane.setRight(backgroundIV);
		
		buttonAP.setMinWidth(300);
		buttonAP.setBackground(new Background(new BackgroundFill(Color.DARKCYAN,CornerRadii.EMPTY,Insets.EMPTY)));
		
		
		mainMenuScene = new Scene(bPane,1200,800);
		
	}
	
	
	
	/**
	 * Makes the MainMenu Stage visible to the user.
	 * 
	 */
	public void showMainMenu(Stage theStage) {
		theStage.setTitle("Garden Designer");
		theStage.setScene(mainMenuScene);
	}
	
	@Override
	public void show() {
		primaryStage.setTitle("Garden Designer");
		bPane.setDisable(false);
		primaryStage.setScene(mainMenuScene);
	}
	
	@Override
	public String toString() {
		return "Main Menu";
	}
	
	@Override
	public void setUneditable() {
		bPane.setDisable(true);
	}
}


