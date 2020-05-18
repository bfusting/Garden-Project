import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderImage;
import javafx.scene.layout.BorderRepeat;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

import javax.swing.event.ChangeListener;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;

//Updated: 4/26 5:08 >>updated by TJ 4/30 made it extend Screen

/**
 * 
 * @author Kelsey McRae
 * <br> 
 * <br> The view that gets the user's preferences for plant selection
 *
 */
public class Preferences extends Screen{
	private ComboBox<String> bloomTime;
	private ComboBox<String> color;
	private ComboBox<String> season;
	private Slider light;
	private Slider water;
	private Slider length;
	private Slider width;
	
	private String lengthText;
	
	private int totalPrefs = 6;
	
	private Scene preferencesScene;
	
	private Button startCreating;
	private Button back;
	private String backBTNText;
	
	private final Border unfinishedPrefBorder = new Border(new BorderStroke(View.settingsBorderColor,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,new BorderWidths(2.0)));
	
	
	private Controller c;
	Stage stage;
	
	
	private Text lengthL;
	private Text widthL;
	
	
	public Preferences(Controller controller,Stage theStage) {
		this.c = controller;
		stage = theStage;
		temp();
		//
		/*back = new Button("Back to Templates");
		back.setOnMouseClicked(c.getBackBTN());
		
		startCreating = new Button("Start Creating");
		startCreating.setOnMouseClicked(c.getDesignTime());
		startCreating.setDisable(true);
		
		
		AnchorPane aPane = new AnchorPane();
		color = new ComboBox<String>();
		color.setEditable(true);
		color.getItems().addAll("Red","Green","Purple","Blue","Orange","Yellow","Pink","White");
		color.setOnAction(c.getPreferenceChanged());
		color.setBorder(unfinishedPrefBorder);
		
		season = new ComboBox<String>();
		season.getItems().addAll("Spring","Summer","Autumn","Winter");
		season.setOnAction(c.getPreferenceChanged());
		season.setBorder(unfinishedPrefBorder);
		
		light = new Slider();
		light.addEventHandler(MouseEvent.MOUSE_CLICKED, c.getMouseClicked());
		
		water = new Slider();
		water.addEventHandler(MouseEvent.MOUSE_CLICKED, c.getMouseClicked());
		
		width = new Slider();
		width.addEventHandler(MouseEvent.MOUSE_CLICKED, c.getMouseClicked());
		
		length = new Slider();
		length.addEventHandler(MouseEvent.MOUSE_CLICKED, c.getMouseClicked());
		
		
		
		Slider[] sliders = new Slider[]{light,water,length,width};
		for (Slider s : sliders) {
			s.setBorder(unfinishedPrefBorder);
			s.setMin(1);
			s.setMax(5);
			s.setShowTickMarks(true);
			s.setMajorTickUnit(1);
			s.setBlockIncrement(5);
			s.setSnapToTicks(true);
			s.setShowTickLabels(true);
		}
		
    
    	Button mainMenu = new Button("Main Menu");
    	mainMenu.setOnMouseClicked(c.getMainMenuWarning());
		double lAnchors = 600.0;
		
		AnchorPane.setTopAnchor(color, 50.0);
		AnchorPane.setTopAnchor(season, 150.0);
		AnchorPane.setTopAnchor(light, 250.0);
		AnchorPane.setTopAnchor(water, 350.0);
		AnchorPane.setTopAnchor(length, 450.0);
		AnchorPane.setTopAnchor(width, 550.0);
		AnchorPane.setTopAnchor(startCreating, 650.0);
		AnchorPane.setTopAnchor(mainMenu, 650.0);
		AnchorPane.setLeftAnchor(color, lAnchors);
		AnchorPane.setLeftAnchor(season, lAnchors);
		AnchorPane.setLeftAnchor(light, lAnchors);
		AnchorPane.setLeftAnchor(water, lAnchors);
		AnchorPane.setLeftAnchor(length, lAnchors);
		AnchorPane.setLeftAnchor(width, lAnchors);
		AnchorPane.setLeftAnchor(startCreating, lAnchors);
		AnchorPane.setLeftAnchor(mainMenu, 400.0);
		
		Label colorL = new Label("Preferred Color: ");
		Label seasonL = new Label("Preferred bloom season: ");
		Label lightL = new Label("Light availability: ");
		Label waterL = new Label("Water availability: ");
		lengthText = "Enter the length of your available garden space (ft): ";
		lengthL = new Label(lengthText);
		widthL = new Label("Width (ft): ");
		
		double labelAnchors = 350.0;
		AnchorPane.setTopAnchor(colorL, 50.0);
		AnchorPane.setTopAnchor(seasonL, 150.0);
		AnchorPane.setTopAnchor(lightL, 250.0);
		AnchorPane.setTopAnchor(waterL, 350.0);
		AnchorPane.setTopAnchor(lengthL, 450.0);
		AnchorPane.setTopAnchor(widthL, 550.0);
		AnchorPane.setLeftAnchor(colorL, labelAnchors);
		AnchorPane.setLeftAnchor(seasonL, labelAnchors);
		AnchorPane.setLeftAnchor(lightL, labelAnchors);
		AnchorPane.setLeftAnchor(waterL, labelAnchors);
		AnchorPane.setLeftAnchor(lengthL, labelAnchors-150.0);
		AnchorPane.setLeftAnchor(widthL, labelAnchors+75.0);
		
		
		
		//Button mainMenu = new Button("Main Menu");
		
		aPane.getChildren().addAll(color,season,light,water,length,width,back,startCreating,mainMenu, colorL, seasonL, lightL, waterL, lengthL, widthL);
		preferencesScene = new Scene(aPane,View.primarySceneWidth,View.primarySceneHeight);
		stage.setScene(preferencesScene);
		*/
		
	}
	
	public int getTotalPrefs() {
		return totalPrefs;
	}
	
	/**
	 * 
	 * Asks the user for the length and width of their future garden space
	 */
	public void askSize() {
		
	}

	/**
	 * 
	 * @return bloomTime The time of year the plant is in bloom
	 */
	public ComboBox<String> getBloomTime() {
		return bloomTime;
	}
	
	/**
	 * 
	 * @return waterReq The amount of water required for the plant
	 */
	/*public ComboBox<String> getWaterReq() {
		return waterReq;
	}*/
	
	/**
	 * 
	 * @return LightReq The amount of light required for the plant
	 */
	/*public ComboBox<String> getLightReq() {
		return lightReq;
	}*/
	
	/**
	 * 
	 * @return color The color of the plant
	 */
	//public ColorPicker getColor() {
		//return color;
	//}
	
/*	/**
	 * 
	 * @return gardenLength The length of the garden space
	 *
	public int getGardenLength() {
		return gardenLength;
	}
	
	/**
	 * 
	 * @return gardenWidth The width of the garden space
	 *
	public int getGardenWidth() {
		return gardenWidth;
	}
*/	
	/*
	/**
	 * Uses all of the combo boxes the user will use to select preferences
	 * 
	 * @param stage The stage for Preferences' scene
	 
	public void showPreferences(Stage stage) {
		
		
		
		stage.show();
		
	}*/
	
	/**
	 * 
	 * @return startCreating - The Start Creating button that takes you to DesignGarden
	 */
	public Button getStartCreating() {
		return startCreating;
	}
	
	@Override
	public String toString() {
		return "Preferences";
	}
	
	@Override
	public void showScreen() {
		Instructions.setHighlightedSection(1);
		String template = c.getTemplateFromModel();
		
		if (template.equals("triangle")) {
			length.setVisible(true);
			length.setMax(4);
			width.setVisible(false);
			lengthL.setVisible(true);
			widthL.setVisible(false);
			lengthL.setText("Number of Rows: ");
			totalPrefs=5;	
		} 
		else if (template.equals("circle")) {
		
			width.setVisible(false);
			length.setVisible(false);
			widthL.setVisible(false);
			lengthL.setVisible(false);
			totalPrefs=4;
		}
		else if (template.equals("square") || template.equals("custom")) {
			width.setVisible(true);
			width.setMax(9);
			length.setVisible(true);
			length.setMax(6);
			widthL.setVisible(true);
			lengthL.setVisible(true);
			lengthL.setText(lengthText);
			totalPrefs=6;
		}
		
		if (!c.verifySettings()) {
			startCreating.setDisable(true);
		} else {
			startCreating.setDisable(false);
		}
		
		back.setText("Selected: "+template.toUpperCase()+"\n\nBack to Templates");
		
		stage.setTitle("Preferences");
		stage.setScene(preferencesScene);
	}
	
	public void temp() {
		int borderWidth = 50;
		Color borderColor = Color.web("#122310");
		lengthText = "Enter the length of your \navailable garden space (ft): ";
		
		back = new Button();
		back.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,12));
		
		back.setMinSize(180, 70);
		back.setOnMouseClicked(c.getBackBTN());
		
		startCreating = new Button("Start Creating");
		startCreating.setOnMouseClicked(c.getDesignTime());
		startCreating.setDisable(true);
		startCreating.setMinSize(180, 70);
		startCreating.setFont(View.backNextBTNFont);
		
		color = new ComboBox<String>();
		color.setEditable(false);
		color.setMinSize(150, 25);
		color.getItems().addAll("Red","Green","Purple","Blue","Orange","Yellow","Pink","White");
		color.setOnAction(c.getPreferenceChanged());
		color.setBorder(unfinishedPrefBorder);
		
		season = new ComboBox<String>();
		season.setMinSize(150, 25);
		season.getItems().addAll("Spring","Summer","Autumn","Winter");
		season.setOnAction(c.getPreferenceChanged());
		season.setBorder(unfinishedPrefBorder);
		
		light = new Slider();
		
		light.addEventHandler(MouseEvent.MOUSE_CLICKED, c.getMouseClicked());
		water = new Slider();
		water.addEventHandler(MouseEvent.MOUSE_CLICKED, c.getMouseClicked());
		width = new Slider();
		width.addEventHandler(MouseEvent.MOUSE_CLICKED, c.getMouseClicked());
		length = new Slider();
		length.addEventHandler(MouseEvent.MOUSE_CLICKED, c.getMouseClicked());
		
		
		
		Slider[] sliders = new Slider[]{light,water,length,width};
		for (Slider s : sliders) {
			s.setBorder(unfinishedPrefBorder);
			s.setMin(1);
			s.setMax(5);
			s.setShowTickMarks(true);
			s.setMajorTickUnit(1);
			s.setBlockIncrement(1);
			s.setSnapToTicks(true);
			s.setShowTickLabels(true);
		}
		
    
   

    	Button mainMenu = new Button("Main Menu");
    	mainMenu.setOnMouseClicked(c.getMainMenuWarning());
    	mainMenu.setMinSize(160, 60);
		mainMenu.setFont(Font.font("Verdana",15));
    	
    	Button exit = new Button("Exit");
    	exit.setOnMouseClicked(c.getExit());
    	exit.setMinSize(160,60);
    	exit.setFont(Font.font("Verdana",15));
    	
    	Button instructions = new Button("Instructions");
    	instructions.setOnMouseClicked(c.getInstructionShow());
    	instructions.setMinSize(160, 60);
    	instructions.setFont(Font.font("Verdana",15));
    	/*double lAnchors = 600.0;
		
		AnchorPane.setTopAnchor(color, 50.0);
		AnchorPane.setTopAnchor(season, 150.0);
		AnchorPane.setTopAnchor(light, 250.0);
		AnchorPane.setTopAnchor(water, 350.0);
		AnchorPane.setTopAnchor(length, 450.0);
		AnchorPane.setTopAnchor(width, 550.0);
		AnchorPane.setTopAnchor(startCreating, 650.0);
		AnchorPane.setTopAnchor(mainMenu, 650.0);
		AnchorPane.setLeftAnchor(color, lAnchors);
		AnchorPane.setLeftAnchor(season, lAnchors);
		AnchorPane.setLeftAnchor(light, lAnchors);
		AnchorPane.setLeftAnchor(water, lAnchors);
		AnchorPane.setLeftAnchor(length, lAnchors);
		AnchorPane.setLeftAnchor(width, lAnchors);
		AnchorPane.setLeftAnchor(startCreating, lAnchors);
		AnchorPane.setLeftAnchor(mainMenu, 400.0);*/
		
		Font font = new Font(16);
    	Text colorL = new Text("Preferred Color: ");
    	colorL.setFont(font);
    	Text seasonL = new Text("Preferred bloom season: ");
    	seasonL.setFont(font);
    	Text lightL = new Text("Light availability: ");
    	lightL.setFont(font);
    	Text waterL = new Text("Water availability: ");
    	waterL.setFont(font);
    	lengthL = new Text(lengthText);
    	lengthL.setFont(font);
    	lengthL.setTextAlignment(TextAlignment.RIGHT);
    	widthL = new Text("Width (ft): ");
    	widthL.setFont(font);
    	
		//Label colorL = new Label("Preferred Color: ");
		//Label seasonL = new Label("Preferred bloom season: ");
		//Label lightL = new Label("Light availability: ");
		//Label waterL = new Label("Water availability: ");
		//lengthText = "Enter the length of your available garden space (ft): ";
		//lengthL = new Label(lengthText);
		//widthL = new Label("Width (ft): ");
		
		Color bg1 =  Color.web("#8fc36f");
		
		GridPane gPane = new GridPane();
		gPane.setGridLinesVisible(false);
		
		Rectangle divider = new Rectangle(860,View.borderWidth,View.borderWidth,760);
		divider.setFill(borderColor);
		
		Circle instructionCircle = new Circle(12,Color.web("#4b7260"));
		instructionCircle.setCenterX(110);
		instructionCircle.setCenterY(98);
		instructionCircle.setStroke(borderColor);
		instructionCircle.setStrokeWidth(2);
		
		Text instructionText = new Text("Please enter the following preferences and characteristics.");
		instructionText.setFont(Font.font("Verdana",FontPosture.ITALIC,20));
		instructionText.setTextAlignment(TextAlignment.CENTER);
		instructionText.setX(140);
		instructionText.setY(105);
		
		gPane.setMinSize(1160, 760);
		gPane.setMaxSize(1160, 760);
		
		gPane.setBackground(View.settingsBackground);
		
		
		BorderWidths bw = new BorderWidths(borderWidth);
		gPane.setBorder(new Border(new BorderImage(View.settingsAccentImg, bw, null, bw, false, BorderRepeat.ROUND,BorderRepeat.REPEAT)));
		
		HBox hBox = new HBox(gPane);
		
		hBox.setBorder(new Border(new BorderStroke(borderColor,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,new BorderWidths(View.borderWidth))));
		
		hBox.setMinSize(View.primarySceneWidth, View.primarySceneHeight);
		
		
		VBox labelBox = new VBox(75);
		labelBox.setAlignment(Pos.BASELINE_RIGHT);
		labelBox.getChildren().addAll(colorL,seasonL,lightL,waterL,lengthL,widthL);
		labelBox.setPadding(new Insets(90,40,0,0));
		
		gPane.getColumnConstraints().addAll(new ColumnConstraints(200),new ColumnConstraints(270),new ColumnConstraints(250),new ColumnConstraints(340));
		gPane.getRowConstraints().add(new RowConstraints(660));
		
		
		VBox backBTNBox = new VBox(back);
		backBTNBox.setAlignment(Pos.BOTTOM_CENTER);
		backBTNBox.setPadding(new Insets(0,0,15,15));
		
		VBox controlsBox = new VBox(61);
		controlsBox.getChildren().addAll(color,season,light,water,length,width);
		controlsBox.setAlignment(Pos.TOP_CENTER);
		controlsBox.setPadding(new Insets(90,0,0,0));
		
		AnchorPane sideBTNPane = new AnchorPane();
		
		VBox sideBTNBox = new VBox(30);
		sideBTNBox.getChildren().addAll(mainMenu,exit,instructions);
		sideBTNBox.setAlignment(Pos.CENTER);
		
		AnchorPane.setTopAnchor(sideBTNBox,90.0);
		AnchorPane.setRightAnchor(sideBTNBox,30.0);
		
		AnchorPane.setBottomAnchor(startCreating, 15.0);
		AnchorPane.setRightAnchor(startCreating, 30.0);
		
		sideBTNPane.getChildren().addAll(sideBTNBox,startCreating);
		
		
		gPane.add(backBTNBox, 0, 0);
		gPane.add(labelBox, 1, 0);
		gPane.add(controlsBox, 2, 0);
		gPane.add(sideBTNPane, 3, 0);
		
		Group root = new Group();
		root.getChildren().addAll(hBox,divider,instructionCircle,instructionText);
		
		/*double labelAnchors = 350.0;
		AnchorPane.setTopAnchor(colorL, 50.0);
		AnchorPane.setTopAnchor(seasonL, 150.0);
		AnchorPane.setTopAnchor(lightL, 250.0);
		AnchorPane.setTopAnchor(waterL, 350.0);
		AnchorPane.setTopAnchor(lengthL, 450.0);
		AnchorPane.setTopAnchor(widthL, 550.0);
		AnchorPane.setLeftAnchor(colorL, labelAnchors);
		AnchorPane.setLeftAnchor(seasonL, labelAnchors);
		AnchorPane.setLeftAnchor(lightL, labelAnchors);
		AnchorPane.setLeftAnchor(waterL, labelAnchors);
		AnchorPane.setLeftAnchor(lengthL, labelAnchors-150.0);
		AnchorPane.setLeftAnchor(widthL, labelAnchors+75.0);*/
		
		
		
		//Button mainMenu = new Button("Main Menu");
		
		//aPane.getChildren().addAll(color,season,light,water,length,width,back,startCreating,mainMenu, colorL, seasonL, lightL, waterL, lengthL, widthL);
		
		/*TilePane left = new TilePane(colorL, seasonL,lightL,waterL,lengthL,widthL);
		left.setVgap(80);
		//left.setHgap(290);
		left.setMinWidth(580);
		left.setMaxWidth(580);
		//left.setAlignment(Pos.CENTER);
		left.setTileAlignment(Pos.CENTER_RIGHT);
		TilePane right = new TilePane(color,season,light,water,length,width);
		right.setVgap(80);
		//right.setHgap(290);
		right.setMinWidth(580);
		right.setMaxWidth(580);
		left.setTileAlignment(Pos.CENTER);*/
		
		/*ColumnConstraints colCon = new ColumnConstraints(530);
		gPane.getColumnConstraints().add(colCon);
		gPane.getRowConstraints().add(new RowConstraints(660));
		
		gPane.add(aPane, 0, 0);*/
		
		//preferencesScene = new Scene(aPane,View.primarySceneWidth,View.primarySceneHeight);
		preferencesScene = new Scene(root,View.primarySceneWidth,View.primarySceneHeight);
	
		stage.setScene(preferencesScene);
		
		
		
	}
	
	public void allowStartCreating() {
		startCreating.setDisable(false);
		
		
	}
	
	/**
	 * Sends the values of the Nodes on this Screen when the user clicks the 'Start Creating' button to the Controller.
	 */
	public void sendPreference(Control control) {
		
		
		if (control.equals(color)) {
			String colPref = color.getValue();
			c.setPreferences(colPref, null, 0, 0, 0, 0);
			color.setBorder(Border.EMPTY);
			System.out.println("Color sent: "+colPref);
		}
		else if (control.equals(season)) {
			Seasons seasonPref = Seasons.valueOf(season.getValue().toUpperCase());
			c.setPreferences("", seasonPref, 0, 0, 0, 0);
			season.setBorder(Border.EMPTY);
			System.out.println("Season sent: "+seasonPref);
		}
		else if (control.equals(water)) {
			int waterPref = Math.round((float)water.getValue());
			c.setPreferences("", null, 0, waterPref, 0, 0);
			water.setBorder(Border.EMPTY);
			System.out.println("Water level sent: "+ waterPref);
		}
		else if (control.equals(light)) {
			int lightPref = Math.round((float)light.getValue());
			c.setPreferences("",null,lightPref,0,0,0);
			light.setBorder(Border.EMPTY);
			System.out.println("Light level sent: "+ lightPref);
		}
		else if (control.equals(length)) {
			int lengthPref = Math.round( (float)length.getValue());
			c.setPreferences("",null,0,0,lengthPref,0);
			length.setBorder(Border.EMPTY);
			System.out.println("Length sent: "+lengthPref);
		}
		else if (control.equals(width)) {
			int widthPref = Math.round((float)width.getValue());
			c.setPreferences("",null,0,0,0,widthPref);
			width.setBorder(Border.EMPTY);
			System.out.println("Width sent: "+ widthPref);
		}
		
	}
	
	public void setValues(String colorPref, String seasonPref, int waterPref,int lightPref, int lengthPref, int widthPref) {
		color.setValue(colorPref);
		season.setValue(seasonPref);
		water.setValue(waterPref);
		light.setValue(lightPref);
		length.setValue(lengthPref);
		width.setValue(widthPref);
		
		if (colorPref=="") {
			color.setBorder(unfinishedPrefBorder);
		} else {
			color.setBorder(Border.EMPTY);
		}
		
		if (seasonPref=="") {
			season.setBorder(unfinishedPrefBorder);
		} else {
			season.setBorder(Border.EMPTY);
		}
		
		if (waterPref==0) {
			water.setBorder(unfinishedPrefBorder);
		} else {
			water.setBorder(Border.EMPTY);
		}
		
		if(lightPref==0) {
			light.setBorder(unfinishedPrefBorder);
		} else {
			light.setBorder(Border.EMPTY);
		}
		
		if(lengthPref==0) {
			length.setBorder(unfinishedPrefBorder);
		} else {
			length.setBorder(Border.EMPTY);
		}
		
		if(widthPref==0) {
			width.setBorder(unfinishedPrefBorder);
		} else {
			width.setBorder(Border.EMPTY);
		}
	}
	
	
}

