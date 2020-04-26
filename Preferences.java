import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
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
	private ComboBox<String> color;
	
	private int gardenLength;
	private int gardenWidth;
	
	private Scene preferencesScene;
	
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
	public ComboBox<String> getColor() {
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
		Label pref = new Label ("This is preferences");
		AnchorPane.setTopAnchor(pref, 100.0);
		root.getChildren().add(pref);
		preferencesScene = new Scene(root, 500 500);
		
		stage.setTitle("Preferences");
		stage.setScene(preferencesScene);
		stage.show();
		
	}
}
