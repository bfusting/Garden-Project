import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
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
 * Screen that handles the creation and presentation of the main menu screen. Contains 
 * the visual components for the main menu window that will be made visible at the start
 * of the program, including options for creating a new garden, loading an existing garden,
 * viewing the instructions and exiting the program.
 *
 * @see Screen
 * @author Takiyah Price
 */
//last edited: 5-2-20 5:38PM

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
	
	private final double cnDistFromTop = 220.0;
	private final double lgDistFromTop = 320.0;
	private final double iDistFromTop = 420.0;
	private final double eDistFromTop = 520.0;
	private final double DistFromSides = 50.0;
	private final int APminWidth = 300;
	private final int buttonWidth = 200;
	private final int buttonHeight = 60;
	private final int backgroundIVWidth = 1200;
	private final int backgroundIVHeight = 1610;
	
	
	/**
	 * Constructor for the Main Menu that creates new Buttons for creating or loading a garden and 
	 * the background Image for the window, then creates a new Scene containing these components and sets the
	 * given Stage with it.
	 * 
	 * 
	 * @param c the Controller, which manages the communication between the View and the Model
	 * @param s the Stage that will be set with the Scene created
	 */
	public MainMenu(Controller c, Stage s) {
		//Create Buttons and Background
		createNewGardenButton = new Button("Create New Garden");
		createNewGardenButton.setMinSize(buttonWidth, buttonHeight);
		createNewGardenButton.setOnMouseClicked(c.getCreateNewGarden());
		
		loadGardenButton = new Button("Load Garden");
		loadGardenButton.setMinSize(buttonWidth, buttonHeight);
		loadGardenButton.setOnMouseClicked(c.getLoadGarden());
		
		instructionsButton = new Button("Instructions");
		instructionsButton.setMinSize(buttonWidth, buttonHeight);
		instructionsButton.setOnMouseClicked(c.getInstructionShow());
		
		exitButton = new Button("Exit");
		exitButton.setMinSize(buttonWidth, buttonHeight);
		exitButton.setOnMouseClicked(c.getExit());
		
		
		backgroundImage = new Image("img/700.jpeg");
		backgroundIV = new ImageView(backgroundImage);
		backgroundIV.setFitWidth(backgroundIVWidth);
		backgroundIV.setFitHeight(backgroundIVHeight);
		backgroundIV.setPreserveRatio(true);
		backgroundIV.setSmooth(true);
		
		primaryStage = s;
		
		
		bPane = new BorderPane();
		
		
		
		AnchorPane buttonAP = new AnchorPane();
		AnchorPane.setTopAnchor(createNewGardenButton,cnDistFromTop);
		AnchorPane.setTopAnchor(loadGardenButton, lgDistFromTop);
		AnchorPane.setTopAnchor(instructionsButton, iDistFromTop);
		AnchorPane.setTopAnchor(exitButton, eDistFromTop);
		
		AnchorPane.setLeftAnchor(createNewGardenButton,DistFromSides);
		AnchorPane.setLeftAnchor(loadGardenButton, DistFromSides);
		AnchorPane.setLeftAnchor(instructionsButton, DistFromSides);
		AnchorPane.setLeftAnchor(exitButton, DistFromSides);
		
		AnchorPane.setRightAnchor(createNewGardenButton,DistFromSides);
		AnchorPane.setRightAnchor(loadGardenButton, DistFromSides);
		AnchorPane.setRightAnchor(instructionsButton, DistFromSides);
		AnchorPane.setRightAnchor(exitButton, DistFromSides);
		
		buttonAP.getChildren().addAll(createNewGardenButton,loadGardenButton,instructionsButton,exitButton);
		
		bPane.setLeft(buttonAP);
		
		bPane.setRight(backgroundIV);
		
		buttonAP.setMinWidth(APminWidth);
		buttonAP.setBackground(new Background(new BackgroundFill(Color.DARKCYAN,CornerRadii.EMPTY,Insets.EMPTY)));
		
		
		mainMenuScene = new Scene(bPane,View.primarySceneWidth,View.primarySceneHeight);
		
	}
	
	

	
	@Override
	public void showScreen() {
		super.setPreviousScreen(this);
		primaryStage.setTitle("Garden Designer");
		
		primaryStage.setScene(mainMenuScene);
	}
	
	@Override
	public String toString() {
		return "Main Menu";
	}
	
	@Override
	public void setUneditable() {
		bPane.setDisable(true);
		primaryStage.setOpacity(View.nonEditableOpacity);
	}
	
	@Override
	public void setEditable() {
		bPane.setDisable(false);
		primaryStage.setOpacity(View.EditableOpacity);
	}
}


