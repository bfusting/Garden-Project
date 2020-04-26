import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

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
/*	public void showPreferences(Stage stage) {
		
	}
	*/
}
