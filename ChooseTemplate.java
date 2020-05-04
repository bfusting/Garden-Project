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
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
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

//Last edited 5-3-20 5:46PM

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
	
	//from drawScene
	private Controller con;
	GridPane grid;
	private final int gridspacing = 50;
	private final int choiceBoxWidth = 375;
	private final int buttonBoxWidth = 215;
	private final int choiceBoxHeight = 275;
	private final int textBoxHeight = 50;
	private Polygon triangle;
	private HBox triangleBox;
	private Button next;
	private Background hoverBG;
	private final int mouseEnterOutline = 2;
	private final int mouseExitOutline = 0;
	
	/**
	 * Constructor for ChooseTemplate that creates Buttons for choosing the shape of the 
	 * garden and puts them on a new Scene. Each Button has an ImageView indicating its 
	 * respective layout that will be created on click.
	 * 
	 */
	public ChooseTemplate(Controller c,Stage s) {
		con = c;
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
		grid = new GridPane();
		grid.setGridLinesVisible(false);
		grid.setHgap(gridspacing);
		grid.setVgap(gridspacing);
		
		ColumnConstraints choiceBoxColCon = new ColumnConstraints(choiceBoxWidth);
		grid.getColumnConstraints().addAll(choiceBoxColCon,choiceBoxColCon,new ColumnConstraints(buttonBoxWidth));
		RowConstraints rowcon = new RowConstraints(choiceBoxHeight);
		grid.getRowConstraints().addAll(new RowConstraints(textBoxHeight), rowcon,rowcon);
		
		
		Circle instructionCircle = new Circle(12,View.borderColor);
		instructionCircle.setCenterX(165);
		instructionCircle.setCenterY(70);
		instructionCircle.setStroke(Color.web("#2c471a"));
		instructionCircle.setStrokeWidth(mouseEnterOutline);
		
		
		
		Text text = new Text("Please select a shape for the layout of your garden.");
		text.setFont(Font.font("Verdana",FontPosture.ITALIC,20));
		text.setTextAlignment(TextAlignment.CENTER);
		HBox textBox = new HBox(text);
		
		
		textBox.setAlignment(Pos.CENTER);
		
		HBox squareBox = new HBox();
		//squareBox.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		squareBox.setAlignment(Pos.CENTER);
		squareBox.setPadding(new Insets(39));
		Border choiceBoxBorder = new Border(new BorderStroke(Color.web("#4e824a"),BorderStrokeStyle.DASHED,CornerRadii.EMPTY, new BorderWidths(2)));
		
		squareBox.setBorder(choiceBoxBorder);
		HBox circleBox = new HBox();
		circleBox.setAlignment(Pos.CENTER);
		circleBox.setBorder(choiceBoxBorder);
		circleBox.setPadding(new Insets(39));
		triangleBox = new HBox();
		triangleBox.setAlignment(Pos.CENTER);
		triangleBox.setPadding(new Insets(39));
		triangleBox.setBorder(choiceBoxBorder);
		triangle = new Polygon(100.0, 0.0, 0.0,200.0, 200.0,200.0);
		triangle.setFill(Color.web("#28461b"));
		triangle.setOnMouseEntered(con.getMouseEnter());
		triangle.setOnMouseExited(con.getMouseExit());
		
		//this changes the background and borders of the choice box
		hoverBG = new Background(new BackgroundImage(new Image("img/v850-sasi-13.jpg"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT));
		//Background b = new Background(new BackgroundImage(new Image("img/v850-sasi-13.jpg"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT));
		//triangleBox.setBackground(b);
		//triangle.setStroke(Color.BLACK);
		//triangle.setStrokeWidth(2);
		//BorderStroke blackborderstroke = new BorderStroke(Color.BLACK,BorderStrokeStyle.DASHED,CornerRadii.EMPTY, new BorderWidths(4));
		//triangleBox.setBorder(new Border(blackborderstroke));
		
		
		///
		triangleBox.getChildren().add(triangle);
		HBox customBox = new HBox();
		customBox.setAlignment(Pos.CENTER);
		customBox.setBorder(choiceBoxBorder);
		customBox.setPadding(new Insets(39));
		customBox.getChildren().add(new Rectangle(200,200));
		
		squareBox.getChildren().add(new Rectangle(200,200,Color.web("#28461b")));
		circleBox.getChildren().add(new Circle(100,Color.web("#28461b")));
		
		
		
		grid.setBackground(new Background(new BackgroundFill(Color.web("#a5c96b"), CornerRadii.EMPTY, new Insets(View.borderWidth))));
		grid.setBorder(View.primarySceneBorder);
		
		VBox buttonBox = new VBox(30);
		//buttonBox.setPadding(new Insets(10));
		buttonBox.setAlignment(Pos.CENTER_RIGHT);
		
		
		Button mainMenu = new Button("Main Menu");
		mainMenu.setFont(Font.font("Verdana",15));
		mainMenu.setMinSize(170, 65);
		
		//mainMenu.setBorder(new Border(new BorderStroke(Color.web("#4e824a"),BorderStrokeStyle.SOLID,CornerRadii.EMPTY, new BorderWidths(2))));
		
		Button exit = new Button("Exit");
		exit.setFont(Font.font("Verdana",15));
		exit.setMinSize(170, 65);
		exit.setOnMouseClicked(con.getExit());
		
		Button instructions = new Button("Instructions");
		instructions.setFont(Font.font("Verdana",15));
		instructions.setMinSize(170, 65);
		instructions.setOnMouseClicked(con.getInstructionShow());
		
		next = new Button("To Preferences");
		next.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20.0));
		next.setMinSize(180, 70);
		
		buttonBox.getChildren().addAll(mainMenu,exit,instructions);
		
		 AnchorPane buttonAP = new AnchorPane();
		 AnchorPane.setRightAnchor(buttonBox,0.0);
		 AnchorPane.setRightAnchor(next,0.0);
		 AnchorPane.setBottomAnchor(next, 20.0);
		 
		 buttonAP.getChildren().addAll(buttonBox,next);
		 //buttonAP.setBackground(new Background(new BackgroundFill(Color.BLUE,CornerRadii.EMPTY,Insets.EMPTY)));
		
		GridPane.setConstraints(squareBox,0,1);
		GridPane.setConstraints(circleBox,1,1);
		GridPane.setConstraints(triangleBox,0,2);
		GridPane.setConstraints(customBox,1,2);
		//GridPane.setConstraints(buttonBox,2,0);
		grid.add(buttonAP, 2, 1,1,2);
		
		grid.add(textBox,0,0,2,1);
		//grid.setHalignment(child, value);
		grid.getChildren().addAll(squareBox,circleBox,triangleBox,customBox);
		grid.setPadding(new Insets(25));
		
		Group root = new Group(grid);
		root.getChildren().add(instructionCircle);
		grid.setMinSize(View.primarySceneWidth, View.primarySceneHeight);
		Scene gridScene = new Scene(root,View.primarySceneWidth,View.primarySceneHeight);
		theStage.setScene(gridScene);
		
		
	}
	
	public void mouseInside(Shape s) {
		if (s.equals(triangle)) {
			triangleBox.setBackground(hoverBG);
			triangle.setStroke(Color.BLACK);
			triangle.setStrokeWidth(mouseEnterOutline);
		}
	}
	
	public void mouseOutside(Shape s) {
		if (s.equals(triangle)) {
		triangleBox.setBackground(Background.EMPTY);
		triangle.setStrokeWidth(mouseExitOutline);
		}
	}
	
	@Override
	public void setUneditable() {
		theStage.setOpacity(View.nonEditableOpacity);
	}
	
	@Override
	public void setEditable() {
		theStage.setOpacity(View.EditableOpacity);
	}
}


