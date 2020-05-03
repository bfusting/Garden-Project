import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.*;
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

//Last edited 5-3-20 1:10PM

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
		//theStage.setScene(chooseTemplateScene);
		drawScene();
	}
	
	public void drawCircle() {
		SVGPath svg = new SVGPath();
		Group root = new Group(svg);
		
		svg.setContent("M 600 400 A 50 50 0 1 1 725 400 A 50 50 0 1 1 600 400");
		svg.setFill(Color.DARKOLIVEGREEN);
		svg.setStroke(Color.BLACK);
		Scene circleScene = new Scene(root,View.primarySceneWidth,View.primarySceneHeight);
		theStage.setScene(circleScene);
	}
	
	public void drawScene() {
		GridPane grid = new GridPane();
		grid.setGridLinesVisible(true);
		grid.setHgap(50);
		grid.setVgap(50);
		ColumnConstraints colcon = new ColumnConstraints(375);
		grid.getColumnConstraints().addAll(colcon,colcon);
		RowConstraints rowcon = new RowConstraints(275);
		grid.getRowConstraints().addAll(new RowConstraints(50), rowcon,rowcon);
		
		Circle iCircle = new Circle(12,Color.web("#4e824a"));
		iCircle.setCenterX(165);
		iCircle.setCenterY(70);
		iCircle.setStroke(Color.web("#2c471a"));
		iCircle.setStrokeWidth(2);
		//iCircle.setStroke(value);
		
		//Label label = new Label("Please select a shape for your garden.");
		Text text = new Text("Please select a shape for the layout of your garden.");
		text.setFont(Font.font("Verdana",FontPosture.ITALIC,20));
		text.setTextAlignment(TextAlignment.CENTER);
		HBox labelBox = new HBox(text);
		
		
		labelBox.setAlignment(Pos.CENTER);
		
		HBox squareBox = new HBox();
		//squareBox.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		squareBox.setAlignment(Pos.CENTER);
		squareBox.setPadding(new Insets(50));
		Border choiceBoxBorder = new Border(new BorderStroke(Color.web("#4e824a"),BorderStrokeStyle.DASHED,CornerRadii.EMPTY, new BorderWidths(2)));
		
		squareBox.setBorder(choiceBoxBorder);
		HBox circleBox = new HBox();
		circleBox.setAlignment(Pos.CENTER);
		circleBox.setBorder(choiceBoxBorder);
		circleBox.setPadding(new Insets(50));
		HBox triangleBox = new HBox();
		triangleBox.setAlignment(Pos.CENTER);
		triangleBox.setPadding(new Insets(50));
		triangleBox.setBorder(choiceBoxBorder);
		Polygon triangle = new Polygon(100.0, 0.0, 0.0,200.0, 200.0,200.0);
		triangle.setFill(Color.web("#28461b"));
		//triangle.setScaleX(1.2);
		//triangle.setScaleY(1.2);
		
		///
		Background b = new Background(new BackgroundImage(new Image("img/v850-sasi-13.jpg"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT));
		triangleBox.setBackground(b);
		triangle.setStroke(Color.BLACK);
		triangle.setStrokeWidth(2);
		BorderStroke blackborderstroke = new BorderStroke(Color.BLACK,BorderStrokeStyle.DASHED,CornerRadii.EMPTY, new BorderWidths(4));
		triangleBox.setBorder(new Border(blackborderstroke));
		
		///
		triangleBox.getChildren().add(triangle);
		HBox customBox = new HBox();
		customBox.setAlignment(Pos.CENTER);
		customBox.setBorder(choiceBoxBorder);
		customBox.setPadding(new Insets(50));
		customBox.getChildren().add(new Rectangle(200,200));
		
		squareBox.getChildren().add(new Rectangle(200,200,Color.web("#28461b")));
		circleBox.getChildren().add(new Circle(100,Color.web("#28461b")));
		
		
		
		grid.setBackground(new Background(new BackgroundFill(Color.web("#a5c96b"), CornerRadii.EMPTY, new Insets(20))));
		//grid.setBackground(new Background(new BackgroundFill(Color.color(.411, .69, .564), CornerRadii.EMPTY, new Insets(20))));
		//grid.setBackground(new Background(new BackgroundFill(Color.color(.486,, .69, .564), CornerRadii.EMPTY, new Insets(20))));
		//grid.setBorder(new Border(new BorderStroke(Color.color(.101,.254,.203),BorderStrokeStyle.SOLID,CornerRadii.EMPTY,new BorderWidths(20))));
		grid.setBorder(new Border(new BorderStroke(Color.web("#4e824a"),BorderStrokeStyle.SOLID,CornerRadii.EMPTY,new BorderWidths(20))));
		
		HBox buttonBox = new HBox(10);
		//buttonBox.setPadding(new Insets(10));
		buttonBox.setAlignment(Pos.CENTER_LEFT);
		
		Button mainMenu = new Button("Main Menu");
		mainMenu.setMinSize(150, 40);
		Button exit = new Button("Exit");
		exit.setMinSize(150, 40);
		Button instructions = new Button("Instructions");
		instructions.setMinSize(150, 40);
		
		Button next = new Button("To Preferences");
		
		buttonBox.getChildren().addAll(mainMenu,exit,instructions);
		
		GridPane.setConstraints(squareBox,0,1);
		GridPane.setConstraints(circleBox,1,1);
		GridPane.setConstraints(triangleBox,0,2);
		GridPane.setConstraints(customBox,1,2);
		//GridPane.setConstraints(text,0,0);
		
		grid.add(labelBox,0,0,2,1);
		//grid.setHalignment(child, value);
		grid.getChildren().addAll(squareBox,circleBox,triangleBox,customBox);
		grid.setPadding(new Insets(25));
		
		Group root = new Group(grid);
		root.getChildren().add(iCircle);
		grid.setMinSize(View.primarySceneWidth, View.primarySceneHeight);
		Scene gridScene = new Scene(root,View.primarySceneWidth,View.primarySceneHeight);
		theStage.setScene(gridScene);
		
		//this resets the triangle back to its original state
		//triangleBox.setBackground(Background.EMPTY);
		//triangle.setStrokeWidth(0);
	}
}


