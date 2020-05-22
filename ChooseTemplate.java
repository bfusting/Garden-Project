import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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


/**
 * 
 * Screen that handles the creation and presentation of the screen containing shapes that the user
 * can select to choose a square, circular or triangular garden layout or drawing the perimeter
 * manually. 
 * 
 * @author Takiyah Price
 *
 */

public class ChooseTemplate extends Screen {
	private Scene chooseTemplateScene;
	private Stage theStage;
	
	private Controller con;
	GridPane grid;
	
	
	private HBox triangleBox;
	private HBox squareBox;
	private HBox circleBox;
	private HBox customBox;
	
	private Button next;
	private Background hoverBG;
	private final int mouseEnterOutline = 2;
	private final int mouseExitOutline = 0;
	
	private Polygon triangle;
	private Rectangle square;
	private Circle circle;
	private Shape custom;
	private Border unclickedBorder;
	private Border clickedBorder;
	private String selectedShapeName;
	
	/**
	 * Constructor for ChooseTemplate that creates Buttons for choosing the shape of the 
	 * garden and puts them on a new Scene. Each Button has an ImageView indicating its 
	 * respective layout that will be created on click.
	 * 
	 */
	public ChooseTemplate(Controller c,Stage s) {
		con = c;
		theStage = s;
		
		final int gridspacing = 50;
		final int choiceBoxWidth = 375;
		final int buttonBoxWidth = 215;
		final int choiceBoxHeight = 275;
		final int textBoxHeight = 50;
		final int instructionCircleRadius = 12;
		final int instructionCircleXPos = 165;
		final int instructionCircleYPos = 70;
		final Color instructionCircleStrokeColor = Color.web("#2c471a");
		final Color templateColor = Color.web("#28461b");
		final double instructionTextSize = 20;
		final int templateDimension = 200;
		final int sideButtonSpacing= 30;
		final int sideButtonFontSize = 15;
		final int sideButtonWidth = 170;
		final int sideButtonHeight = 65;
		final int nextButtonWidth = 180;
		final int nextButtonHeight = 70;
		final double nextButtonBottomDist = 20.0;
		final int gridPaddingAmt = 25;
		final int clickedBorderWidth = 4;
		final Color templateBorderColor = Color.web("#4e824a");
		
		
		selectedShapeName = "";
		unclickedBorder = new Border(new BorderStroke(templateBorderColor,BorderStrokeStyle.DASHED,CornerRadii.EMPTY, new BorderWidths(mouseEnterOutline)));
		clickedBorder = new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.DASHED,CornerRadii.EMPTY, new BorderWidths(clickedBorderWidth)));
		hoverBG = new Background(new BackgroundImage(new Image("img/v850-sasi-13.jpg"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT));
		
		grid = new GridPane();
		grid.setGridLinesVisible(false);
		grid.setHgap(gridspacing);
		grid.setVgap(gridspacing);
		ColumnConstraints choiceBoxColCon = new ColumnConstraints(choiceBoxWidth);
		grid.getColumnConstraints().addAll(choiceBoxColCon,choiceBoxColCon,new ColumnConstraints(buttonBoxWidth));
		RowConstraints rowcon = new RowConstraints(choiceBoxHeight);
		grid.getRowConstraints().addAll(new RowConstraints(textBoxHeight), rowcon,rowcon);
		grid.setMinSize(View.primarySceneWidth, View.primarySceneHeight);
		grid.setBackground(new Background(new BackgroundFill(View.settingsBackgroundColor, CornerRadii.EMPTY, new Insets(View.borderWidth))));
		grid.setBorder(View.settingsBorder);
		grid.setPadding(new Insets(gridPaddingAmt));
		
		
		triangle = new Polygon(100.0, 0.0, 0.0,200.0, 200.0,200.0);
		triangle.setFill(templateColor);
		initTemplate(triangle);
		
		square = new Rectangle(templateDimension,templateDimension,templateColor);
		initTemplate(square);
		
		circle = new Circle(templateDimension/2,templateColor);
		initTemplate(circle);
		
		custom = new Rectangle(templateDimension,templateDimension);
		initTemplate(custom);
		
		Circle instructionCircle = new Circle(instructionCircleRadius,View.settingsBorderColor);
		instructionCircle.setCenterX(instructionCircleXPos);
		instructionCircle.setCenterY(instructionCircleYPos);
		instructionCircle.setStroke(instructionCircleStrokeColor);
		instructionCircle.setStrokeWidth(mouseEnterOutline);
		
		Text text = new Text("Please select a shape for the layout of your garden.");
		text.setFont(Font.font("Verdana",FontPosture.ITALIC,instructionTextSize));
		text.setTextAlignment(TextAlignment.CENTER);
		HBox textBox = new HBox(text);
		textBox.setAlignment(Pos.CENTER);
		
		squareBox = new HBox();
		initTemplateBox(squareBox);
		squareBox.getChildren().add(square);
		circleBox = new HBox();
		initTemplateBox(circleBox);
		circleBox.getChildren().add(circle);
		triangleBox = new HBox();
		initTemplateBox(triangleBox);
		triangleBox.getChildren().add(triangle);
		customBox = new HBox();
		initTemplateBox(customBox);
		customBox.getChildren().add(custom);
	
		
		VBox buttonBox = new VBox(sideButtonSpacing);
		buttonBox.setAlignment(Pos.CENTER_RIGHT);
		
		
		Button mainMenu = new Button("Main Menu");
		mainMenu.setFont(Font.font("Verdana",sideButtonFontSize));
		mainMenu.setMinSize(sideButtonWidth, sideButtonHeight);
		mainMenu.setOnMouseClicked(con.getBackBTN());
		
		Button exit = new Button("Exit");
		exit.setFont(Font.font("Verdana",sideButtonFontSize));
		exit.setMinSize(sideButtonWidth, sideButtonHeight);
		exit.setOnMouseClicked(con.getExit());
		
		Button instructions = new Button("Instructions");
		instructions.setFont(Font.font("Verdana",sideButtonFontSize));
		instructions.setMinSize(sideButtonWidth, sideButtonHeight);
		instructions.setOnMouseClicked(con.getInstructionShow());
		
		next = new Button("To Preferences");
		next.setFont(View.backNextBTNFont);
		next.setMinSize(nextButtonWidth, nextButtonHeight);
		next.setDisable(true);
		next.setOnMouseClicked(con.getTemplateToPref());
		
		buttonBox.getChildren().addAll(mainMenu,exit,instructions);
		
		 AnchorPane buttonAP = new AnchorPane();
		 AnchorPane.setRightAnchor(buttonBox,0.0);
		 AnchorPane.setRightAnchor(next,0.0);
		 AnchorPane.setBottomAnchor(next, nextButtonBottomDist);
		 
		 buttonAP.getChildren().addAll(buttonBox,next);
		
		
		GridPane.setConstraints(squareBox,0,1);
		GridPane.setConstraints(circleBox,1,1);
		GridPane.setConstraints(triangleBox,0,2);
		GridPane.setConstraints(customBox,1,2);
		grid.add(buttonAP, 2, 1,1,2);
		
		grid.add(textBox,0,0,2,1);
		grid.getChildren().addAll(squareBox,circleBox,triangleBox,customBox);
		
		Group root = new Group(grid);
		root.getChildren().add(instructionCircle);
		
		chooseTemplateScene = new Scene(root,View.primarySceneWidth,View.primarySceneHeight);
		
	}
	
	
	
	@Override
	public String toString() {
		return "Templates";
	}
	
	
	@Override
	public void showScreen() {
		Instructions.setHighlightedSection(0);
		theStage.setTitle("Choose a Template");
		theStage.setScene(chooseTemplateScene);
	}
	
	
	/**
	 * Detects which template the mouse entered and changes its appearance by calling setHoverAffect() on
	 * the required template Shape.
	 * 
	 * @param s the Shape that the mouse entered. Will be one of the square, triangle, circle,
	 * or custom templates.
	 * 
	 * @see ChooseTemplate#setHoverEffect(HBox, Shape)
	 */
	public void mouseInside(Shape s) {
		if (s.equals(triangle)) {
			setHoverEffect(triangleBox,triangle);
		} else if (s.equals(circle)) {
			setHoverEffect(circleBox,circle);
		} else if (s.equals(square)) {
			setHoverEffect(squareBox,square);
		} else if (s.equals(custom)) {
			setHoverEffect(customBox,custom);
		}
		
	}
	
	/**
	 * Changes the background of the given HBox and the stroke color and width of the given Shape. To be called by
	 * mouseInside to update the template when hovered over.
	 * @param h the HBox containing the shape that the mouse entered.
	 * @param s the Shape that the mouse entered.
	 * 
	 * @see ChooseTemplate#mouseInside(Shape s)
	 */
	public void setHoverEffect(HBox h,Shape s) {
		h.setBackground(hoverBG);
		s.setStroke(Color.BLACK);
		s.setStrokeWidth(mouseEnterOutline);
	}
	
	/**
	 * Resets the background of the given HBox and removes the stroke color of the given Shape. To be called by
	 * mouseOutside to update the template when the mouse exits the node.
	 * @param h the HBox containing the shape that the mouse exited.
	 * @param s the Shape that the mouse exited.
	 * 
	 * @see ChooseTemplate#mouseOutside(Shape)
	 */
	public void removeHoverEffect(HBox h, Shape s) {
		h.setBackground(Background.EMPTY);
		s.setStrokeWidth(mouseExitOutline);
	}
	
	/**
	 * Detects which template the mouse exited and resets its appearance by calling removeHoverEffect.
	 * 
	 * @param s the Shape that the mouse exited. Will be one of the square, triangle, circle,
	 * or custom templates.
	 * 
	 * @see ChooseTemplate#removeHoverEffect(HBox, Shape)
	 */
	public void mouseOutside(Shape s) {
		if (s.equals(triangle) && !selectedShapeName.equals("triangle")) {
		removeHoverEffect(triangleBox,triangle);
		} else if (s.equals(square) && !selectedShapeName.equals("square")) {
			removeHoverEffect(squareBox,square);
		} else if (s.equals(circle) && !selectedShapeName.equals("circle")) {
			removeHoverEffect(circleBox,circle);
		} else if (s.equals(custom) && !selectedShapeName.equals("custom")) {
			removeHoverEffect(customBox,custom);
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
	
	/**
	 * Sets the event handlers for the mouse entering and exiting the template Shapes.
	 * @param s the Shape that will be set with the event handlers from the controller.
	 * 
	 * @see Controller#getMouseEnter()
	 * @see Controller#getMouseExit()
	 * @see Controller#getMouseClicked()
	 */
	public void initTemplate(Shape s) {
		s.setOnMouseEntered(con.getMouseEnter());
		s.setOnMouseExited(con.getMouseExit());
		s.setOnMouseClicked(con.getMouseClicked());
	}
	
	/**
	 * Sets the alignment, padding and border for the given HBox. Called to initialize the
	 * boxes containing the four template Shapes.
	 * 
	 * @param h the HBox containing one of the four template Shapes.
	 */
	public void initTemplateBox(HBox h) {
		final int templatePaddingAmt = 39;
		
		h.setAlignment(Pos.CENTER);
		h.setPadding(new Insets(templatePaddingAmt));
		h.setBorder(unclickedBorder);
		
	}
	
	/**
	 * Updates the appearance of the HBox containing the template Shape that was clicked to
	 * communicate that it has been selected, and calls removeMouseClickedEffect on all other 
	 * Shapes to keep only the most recent selection.
	 * @param s the Shape that the mouse has clicked.
	 * 
	 * @see ChooseTemplate#removeMouseClickedEffect(Shape)
	 */
	public void mouseClicked(Shape s) {
		next.setDisable(false);
		
		if (!s.equals(triangle) && selectedShapeName.equals("triangle")) {
			removeHoverEffect(triangleBox,triangle);
		} 
		else if (!s.equals(square) && selectedShapeName.equals("square")) {
			removeHoverEffect(squareBox,square);
		} 
		else if (!s.equals(circle) && selectedShapeName.equals("circle")) {
			removeHoverEffect(circleBox,circle);
		}
		else if (!s.equals(custom) && selectedShapeName.equals("custom")) {
			removeHoverEffect(customBox,custom);
		}
		
		
		if (s.equals(triangle)) {
			triangleBox.setBorder(clickedBorder);
			selectedShapeName = "triangle";
			removeMouseClickedEffect(triangle);
		}
		else if (s.equals(circle)) {
			circleBox.setBorder(clickedBorder);
			selectedShapeName = "circle";
			removeMouseClickedEffect(circle);
		} else if (s.equals(square)) {
			squareBox.setBorder(clickedBorder);
			selectedShapeName = "square";
			removeMouseClickedEffect(square);
		} else if (s.equals(custom)) {
			customBox.setBorder(clickedBorder);
			selectedShapeName = "custom";
			removeMouseClickedEffect(custom);
		}
		System.out.println(selectedShapeName);
	}
	
	
	/**
	 * Removes the background and border set for mouse clicked for all
	 * other shapes besides the one passed in. To be called by mouseClicked to
	 * ensure that only one template is selected.
	 * 
	 * @param s the template Shape that has been clicked.
	 */
	public void removeMouseClickedEffect(Shape s) {
		if (s.equals(triangle)) {
			circleBox.setBorder(unclickedBorder);
			squareBox.setBorder(unclickedBorder);
			customBox.setBorder(unclickedBorder);
		} else if (s.equals(circle)) {
			squareBox.setBorder(unclickedBorder);
			triangleBox.setBorder(unclickedBorder);
			customBox.setBorder(unclickedBorder);
		} else if (s.equals(square)) {
			circleBox.setBorder(unclickedBorder);
			triangleBox.setBorder(unclickedBorder);
			customBox.setBorder(unclickedBorder);
		} else if (s.equals(custom)) {
			triangleBox.setBorder(unclickedBorder);
			circleBox.setBorder(unclickedBorder);
			squareBox.setBorder(unclickedBorder);
		}
	}
	
	/**
	 * Returns the name of the selected template.
	 * 
	 * @return a String representing the selected template Shape.
	 */
	public String getSelectedTemplate() {
		return selectedShapeName;
	}
}


