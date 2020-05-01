import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
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

//Last edited 4-28-20 4:07PM

/**
 * 
 * View that handles the creation and presentation of the screen containing Buttons
 * for choosing a square, circular or triangular garden layout or drawing the perimeter
 * manually. 
 * 
 * @author Takiyah Price
 *
 */

public class ChooseTemplate extends Screen {
	private Scene chooseTemplateScene;
	private Stage theStage;
	//private ImageView squareTemplate;
	//private ImageView circleTemplate;
	//private ImageView triangleTemplate;
	//private ImageView designYourOwn;
	private Button chooseSquare;
	private Button chooseCircle;
	private Button chooseTriangle;
	private Button chooseDesign;
	private Button backButton;
	
	/**
	 * Constructor for ChooseTemplate that creates Buttons for choosing the shape of the 
	 * garden and puts them on a new Scene. Each Button has an ImageView indicating its 
	 * respective layout that will be created on click.
	 * 
	 */
	public ChooseTemplate(Controller c,Stage s) {
		theStage = s;
		//Label label = new Label("choose a template");
		//Button button = new Button("Exit");
		//button.setMinSize(200,60);
		
		//getting images for buttons
		AnchorPane chooseTemplateAP = new AnchorPane();
		chooseTemplateAP.setBackground(new Background(new BackgroundFill(Color.DARKCYAN,CornerRadii.EMPTY,Insets.EMPTY)));
		
		TilePane tPane = new TilePane();
		
		ImageView squareTemplate = new ImageView(new Image("/img/Square.png"));
		ImageView circleTemplate = new ImageView(new Image("/img/Circle.png"));
		ImageView triangleTemplate = new ImageView(new Image("/img/Triangle.png"));
		ImageView designYourOwn = new ImageView(new Image("/img/DesignYourOwn.png"));
		
		//setting up buttons
		chooseSquare = new Button("Choose Square Garden",squareTemplate);
		chooseSquare.setMaxSize(200, 60);
		chooseSquare.setOnMouseClicked(c.getTemplateToPref());
		
		chooseCircle = new Button("Choose Circular Garden",circleTemplate);
		chooseCircle.setMinSize(200, 60);
		
		chooseTriangle = new Button("Choose Triangular Garden",triangleTemplate);
		chooseTriangle.setMinSize(200, 60);
		
		chooseDesign = new Button("Design Your Own",designYourOwn);
		chooseDesign.setMinSize(200,60);
		
		backButton = new Button("Back");
		backButton.setMinSize(100,50);
		backButton.setOnMouseClicked(c.getBackBTN());
		
		tPane.getChildren().addAll(chooseSquare, chooseCircle,chooseTriangle,chooseDesign);
		tPane.setHgap(100);
		tPane.setVgap(100);
		tPane.setPrefColumns(2);
		tPane.setAlignment(Pos.CENTER);
		
		TilePane rootPane = new TilePane();
		rootPane.setPrefRows(2);
		rootPane.setAlignment(Pos.CENTER);
		rootPane.getChildren().addAll(tPane,backButton);
		
		chooseTemplateScene = new Scene(rootPane,1200,800);
		
		
		/*tPane.getChildren().addAll(chooseSquare, chooseCircle,chooseTriangle,chooseDesign);
		tPane.setHgap(100);
		tPane.setVgap(100);
		tPane.setPrefColumns(2);
		tPane.setAlignment(Pos.CENTER);
		
		
		
		AnchorPane.setLeftAnchor(tPane, 40.0);
		AnchorPane.setRightAnchor(tPane, 40.0);
		AnchorPane.setTopAnchor(tPane, 80.0);
		chooseTemplateAP.getChildren().add(tPane);
		
		chooseTemplateScene = new Scene(chooseTemplateAP,1200,800);*/
		
		
	}
	
	public void showChooseTemplate(Stage theStage) {
		//can delete
		
	}
	
	@Override
	public String toString() {
		return "Choose Template";
	}
	
	
	@Override
	public void showScreen() {
		theStage.setTitle("Choose a Template");
		theStage.setScene(chooseTemplateScene);
	}
	
}


