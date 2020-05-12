import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

import javax.swing.event.ChangeListener;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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
	//private ComboBox<String> waterReq;
	//private ComboBox<String> lightReq;
	//private ColorPicker color;
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
	
	private final Border unfinishedPrefBorder = new Border(new BorderStroke(View.borderColor1,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,new BorderWidths(2.0)));
	
	
	private Controller c;
	Stage stage;
	
	//private Label lengthLabel;
	//private Label widthLabel;
	private Label lengthL;
	private Label widthL;
	
	
	public Preferences(Controller controller,Stage theStage) {
		this.c = controller;
		stage = theStage;
		temp();
		/*back = new Button("Back to Templates");
		back.setOnMouseClicked(c.getBackBTN());
		
		AnchorPane root = new AnchorPane();
		
		Label pref = new Label("Select Your Plant Preferences and Requirements");
		AnchorPane.setTopAnchor(pref, 40.0);
		AnchorPane.setLeftAnchor(pref,100.0);
		
		Rectangle r1 = new Rectangle(30, 65, 430, 3);
		r1.setStroke(Color.DARKGREEN);
		r1.setStrokeWidth(1);
		
		
		bloomTime = new ComboBox<String>();
		bloomTime.getItems().addAll("Fall","Winter","Spring","Summer");
		bloomTime.setOnAction(c.getPreferenceChanged());
		
		Label btLabel = new Label("Bloom time:	");
		AnchorPane.setLeftAnchor(btLabel,120.0);
		AnchorPane.setTopAnchor(btLabel,100.0);
		
		AnchorPane.setTopAnchor(bloomTime,100.0);
		AnchorPane.setLeftAnchor(bloomTime, 200.0);
		
		gardenLength = new ComboBox<Integer>();
		gardenLength.setEditable(true);
		gardenWidth = new ComboBox<Integer>();
		gardenWidth.setEditable(true);
		
		AnchorPane.setLeftAnchor(gardenLength,230.0);
		AnchorPane.setTopAnchor(gardenLength,310.0);
		AnchorPane.setLeftAnchor(gardenWidth,230.0);
		AnchorPane.setTopAnchor(gardenWidth,360.0);
		
		Label getGardenDim = new Label("What is the size of your available garden space? ");
		AnchorPane.setLeftAnchor(getGardenDim,100.0);
		AnchorPane.setTopAnchor(getGardenDim,265.0);
		
		Label glLabel = new Label("Garden length (ft): ");
		AnchorPane.setLeftAnchor(glLabel,100.0);
		AnchorPane.setTopAnchor(glLabel,310.0);
		
		Label gwLabel = new Label("Garden width (ft): ");
		AnchorPane.setLeftAnchor(gwLabel,100.0);
		AnchorPane.setTopAnchor(gwLabel,360.0);
		
		
		waterReq = new ComboBox<String>();
		
		Label colorLabel = new Label("Plant Color:	");
		AnchorPane.setLeftAnchor(colorLabel, 120.0);
		AnchorPane.setTopAnchor(colorLabel, 160.0);
		color = new ColorPicker(Color.DARKGREEN);
		AnchorPane.setLeftAnchor(color, 200.0);
		AnchorPane.setTopAnchor(color, 160.0);
		
		startCreating = new Button("Start Creating");
		AnchorPane.setBottomAnchor(startCreating, 40.0);
		AnchorPane.setRightAnchor(startCreating, 40.0);
		AnchorPane.setBottomAnchor(back, 40.0);
		AnchorPane.setLeftAnchor(back, 40.0);
		
		// Binding to event Listener
		startCreating.setOnMouseClicked(c.getDesignTime());
		
//		Label pref = new Label ("This is preferences");
//		AnchorPane.setTopAnchor(pref, 100.0);
		root.getChildren().addAll(bloomTime, pref, btLabel, r1, colorLabel, color, startCreating, glLabel, gwLabel, gardenLength, gardenWidth, getGardenDim,back);
		preferencesScene = new Scene(root, 500.0, 500.0);*/
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
		switch (c.getTemplateFromModel()) {
		case ("triangle"):
			length.setVisible(true);
			width.setVisible(false);
			lengthL.setVisible(true);
			widthL.setVisible(false);
			lengthL.setText("Rows");
			totalPrefs=5;
			break;
		case ("circle"):
			width.setVisible(false);
			length.setVisible(false);
			widthL.setVisible(false);
			lengthL.setVisible(false);
			totalPrefs=4;
			break;
		case("square"):
			width.setVisible(true);
			length.setVisible(true);
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
		
		
		
		stage.setTitle("Preferences");
		stage.setScene(preferencesScene);
	}
	
	public void temp() {
		back = new Button("Back to Templates");
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
			s.setBlockIncrement(1);
			s.setSnapToTicks(true);
			s.setShowTickLabels(true);
		}
		
    
    //widthLabel = new Label("width");
//lengthLabel = new Label("length");

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
			int waterPref = (int)water.getValue();
			c.setPreferences("", null, 0, waterPref, 0, 0);
			water.setBorder(Border.EMPTY);
			System.out.println("Water level sent: "+ waterPref);
		}
		else if (control.equals(light)) {
			int lightPref = (int)light.getValue();
			c.setPreferences("",null,lightPref,0,0,0);
			light.setBorder(Border.EMPTY);
			System.out.println("Light level sent: "+ lightPref);
		}
		else if (control.equals(length)) {
			int lengthPref = (int) length.getValue();
			c.setPreferences("",null,0,0,lengthPref,0);
			length.setBorder(Border.EMPTY);
			System.out.println("Length sent: "+lengthPref);
		}
		else if (control.equals(width)) {
			int widthPref = (int) width.getValue();
			c.setPreferences("",null,0,0,0,widthPref);
			width.setBorder(Border.EMPTY);
			System.out.println("Width sent: "+ widthPref);
		}
		/*String colPref = color.getValue();
		Seasons seasonPref = Seasons.valueOf(season.getValue().toUpperCase());
		int lightPref = (int)light.getValue();
		int waterPref = (int)water.getValue();
		int lengthPref = (int) length.getValue();
		int widthPref = (int) width.getValue();
		System.out.println("Sending to model:\nColor: "+colPref+", Season: "+seasonPref+", Light level: "+lightPref+"\nWater level: "+waterPref+", Length: "+ lengthPref+", Width: "+widthPref);
		c.setPreferences(color.getValue(), seasonPref, lightPref,waterPref,lengthPref,widthPref);*/
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

