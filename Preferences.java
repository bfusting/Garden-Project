import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.Group;
import javafx.scene.Scene;

//Updated: 4/25 9:52

/**
 * 
 * @author Kelsey McRae
 * <br> 
 * <br> The view that gets the user's preferences for plant selection
 *
 */
public class Preferences{
	private ComboBox<String> bloomTime;
	private ComboBox<String> waterReq;
	private ComboBox<String> lightReq;
	private ColorPicker color;
	
	private int gardenLength;
	private int gardenWidth;
	
	private Scene preferencesScene;
	
	private Controller c;
	
	public Preferences(Controller controller) {
		this.c = controller;
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
	public ColorPicker getColor() {
		return color;
	}
	
	/**
	 * 
	 * @return gardenLength The length of the garden space
	 */
	public int getGardenLength() {
		return gardenLength;
	}
	
	/**
	 * 
	 * @return gardenWidth The width of the garden space
	 */
	public int getGardenWidth() {
		return gardenWidth;
	}
	
	/**
	 * Uses all of the combo boxes the user will use to select preferences
	 * 
	 * @param stage The stage for Preferences' scene
	 */
	public void showPreferences(Stage stage) {
		
		AnchorPane root = new AnchorPane();
		
		Label pref = new Label("Select Your Plant Preferences and Requirements");
		AnchorPane.setTopAnchor(pref, 40.0);
		AnchorPane.setLeftAnchor(pref,100.0);
		
		Rectangle r1 = new Rectangle(30, 65, 430, 3);
		r1.setStroke(Color.DARKGREEN);
		r1.setStrokeWidth(1);
		
		
		bloomTime = new ComboBox<String>();
		bloomTime.getItems().addAll("Fall","Winter","Spring","Summer");
		
		Label btLabel = new Label("Bloom time:	");
		AnchorPane.setLeftAnchor(btLabel,120.0);
		AnchorPane.setTopAnchor(btLabel,100.0);
		
		AnchorPane.setTopAnchor(bloomTime,100.0);
		AnchorPane.setLeftAnchor(bloomTime, 200.0);
		
		waterReq = new ComboBox<String>();
		
		Label colorLabel = new Label("Plant Color:	");
		AnchorPane.setLeftAnchor(colorLabel, 120.0);
		AnchorPane.setTopAnchor(colorLabel, 180.0);
		color = new ColorPicker(Color.DARKGREEN);
		AnchorPane.setLeftAnchor(color, 200.0);
		AnchorPane.setTopAnchor(color, 180.0);
		
		
//		Label pref = new Label ("This is preferences");
//		AnchorPane.setTopAnchor(pref, 100.0);
		root.getChildren().addAll(bloomTime, pref, btLabel, r1, colorLabel, color);
		preferencesScene = new Scene(root, 500.0, 500.0);
		
		stage.setTitle("Preferences");
		stage.setScene(preferencesScene);
		stage.show();
		
	}
}
