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

//Last edited 4-26-20 6:46PM

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
	//private ImageView squareTemplate;
	//private ImageView circleTemplate;
	//private ImageView triangleTemplate;
	//private ImageView designYourOwn;
	private Button chooseSquare;
	private Button chooseCircle;
	private Button chooseTriangle;
	private Button chooseDesign;
	
	/**
	 * Constructor for ChooseTemplate that creates Buttons for choosing the shape of the 
	 * garden and puts them on a new Scene. Each Button has an ImageView indicating its 
	 * respective layout that will be created on click.
	 * 
	 */
	public ChooseTemplate(Controller c) {
		//Label label = new Label("choose a template");
		//Button button = new Button("Exit");
		//button.setMinSize(200,60);
		
		//need to get images
		AnchorPane chooseTemplateAP = new AnchorPane();
		chooseTemplateAP.setBackground(new Background(new BackgroundFill(Color.DARKCYAN,CornerRadii.EMPTY,Insets.EMPTY)));
		
		ImageView squareTemplate = new ImageView(new Image("/img/Square.png"));
		ImageView circleTemplate = new ImageView(new Image("/img/Circle.png"));
		ImageView triangleTemplate = new ImageView(new Image("/img/Triangle.png"));
		ImageView designYourOwn = new ImageView(new Image("/img/DesignYourOwn.png"));
		chooseSquare = new Button("Choose Square Garden",squareTemplate);
		chooseSquare.setMaxSize(200, 60);
		chooseSquare.setOnMouseClicked(c.getChooseDesign());
		
		//HBox stHBox = new HBox();
		//HBox tdHBox = new HBox();
		TilePane tPane = new TilePane();
		
		
		chooseCircle = new Button("Choose Circular Garden",circleTemplate);
		
		
		chooseCircle.setMinSize(200, 60);
		chooseTriangle = new Button("Choose Triangular Garden",triangleTemplate);
		chooseTriangle.setMinSize(200, 60);
		chooseDesign = new Button("Design Your Own",designYourOwn);
		chooseDesign.setMinSize(200,60);
		
		//stHBox.getChildren().addAll(chooseSquare,chooseTriangle);
		//tdHBox.getChildren().addAll(chooseTriangle,chooseDesign);
		
		
		//tPane.getChildren().addAll(stHBox,tdHBox);
		
		tPane.getChildren().addAll(chooseSquare, chooseCircle,chooseTriangle,chooseDesign);
		tPane.setHgap(100);
		tPane.setVgap(100);
		tPane.setPrefColumns(2);
		tPane.setAlignment(Pos.CENTER);
		
		
		
		AnchorPane.setLeftAnchor(tPane, 40.0);
		AnchorPane.setRightAnchor(tPane, 40.0);
		AnchorPane.setTopAnchor(tPane, 80.0);
		chooseTemplateAP.getChildren().add(tPane);
		
		//button.setOnMouseClicked(c.getExit());
		chooseTemplateScene = new Scene(chooseTemplateAP,1200,800);
		
		
		
		//squareTemplate = new ImageView(new Image("no image"));
		//circleTemplate = new ImageView(new Image("no image"));
		//triangleTemplate = new ImageView(new Image("no image"));
		//designYourOwn = new ImageView(new Image("no image"));
	}
	
	public void showChooseTemplate(Stage theStage) {
		theStage.setTitle("Choose a Template");
		theStage.setScene(chooseTemplateScene);
		
	}
	
}


