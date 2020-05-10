import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.util.ArrayList;

import javax.swing.event.ChangeListener;

import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
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
	private ComboBox<String> waterReq;
	private ComboBox<String> lightReq;
	//private ColorPicker color;
	private ComboBox<String> color;
	private ComboBox<String> season;
	private Slider light;
	private Slider water;
	private Slider length;
	private Slider width;
	
	private ComboBox<Integer> gardenLength;
	private ComboBox<Integer> gardenWidth;
	
	private final int totalPrefs = 2;
	
	private Scene preferencesScene;
	
	private Button startCreating;
	private Button back;
	
	private Controller c;
	Stage stage;
	
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
	public ComboBox<String> getWaterReq() {
		return waterReq;
	}
	
	/**
	 * 
	 * @return LightReq The amount of light required for the plant
	 */
	public ComboBox<String> getLightReq() {
		return lightReq;
	}
	
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
		stage.setTitle("Preferences");
		stage.setScene(preferencesScene);
	}
	
	public void temp() {
		back = new Button("Back to Templates");
		back.setOnMouseClicked(c.getBackBTN());
		startCreating = new Button("Start Creating");
		startCreating.setOnMouseClicked(c.getDesignTime());
		startCreating.setDisable(true);
		
		
		TilePane tpane = new TilePane();
		color = new ComboBox<String>();
		color.setEditable(true);
		color.getItems().addAll("Red","Green","Purple","Blue","Orange","Yellow","Pink","White");
		color.setOnAction(c.getPreferenceChanged());
		
		season = new ComboBox<String>();
		season.getItems().addAll("Spring","Summer","Autumn","Winter");
		season.setOnAction(c.getPreferenceChanged());
		
		
		light = new Slider();
		water = new Slider();
		width = new Slider();
		length = new Slider();
		
		
		
		Slider[] sliders = new Slider[]{light,water,length,width};
		for (Slider s : sliders) {
			s.setMin(1);
			s.setMax(5);
			s.setShowTickMarks(true);
			s.setMajorTickUnit(1);
			s.setBlockIncrement(1);
			s.setSnapToTicks(true);
			s.setShowTickLabels(true);
		}
		
		
		
		
		tpane.setVgap(50);
		Button mainMenu = new Button("Main Menu");
		mainMenu.setOnMouseClicked(c.getMainMenuWarning());
		tpane.getChildren().addAll(color,season,light,water,length,width,back,startCreating,mainMenu);
		preferencesScene = new Scene(tpane,View.primarySceneWidth,View.primarySceneHeight);
		stage.setScene(preferencesScene);
		
		
	}
	
	public void allowStartCreating() {
		startCreating.setDisable(false);
		
		
	}
	
	/**
	 * Sends the values of the Nodes on this Screen when the user clicks the 'Start Creating' button to the Controller.
	 */
	public void sendPreferences() {
		String colPref = color.getValue();
		Seasons seasonPref = Seasons.valueOf(season.getValue().toUpperCase());
		int lightPref = (int)light.getValue();
		int waterPref = (int)water.getValue();
		int lengthPref = (int) length.getValue();
		int widthPref = (int) width.getValue();
		System.out.println("Sending to model:\nColor: "+colPref+", Season: "+seasonPref+", Light level: "+lightPref+"\nWater level: "+waterPref+", Length: "+ lengthPref+", Width: "+widthPref);
		c.setPreferences(color.getValue(), seasonPref, lightPref,waterPref,lengthPref,widthPref);
	}
	
	public void setValues(String colorPref, String seasonPref, int waterPref,int lightPref, int lengthPref, int widthPref) {
		color.setValue(colorPref);
		season.setValue(seasonPref);
		water.setValue(waterPref);
		light.setValue(lightPref);
		length.setValue(lengthPref);
		width.setValue(widthPref);
	}
	
	
}

