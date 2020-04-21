import javafx.scene.control.ComboBox;

public class Preferences extends View{
	private ComboBox<String> bloomTime;
	private ComboBox<String> waterReq;
	private ComboBox<String> lightReq;
	private ComboBox<String> color;
	
	private int gardenLength;
	private int gardenWidth;
	
	public void askSize() {
		
	}
	
	public ComboBox<String> getBloomTime() {
		return bloomTime;
	}
	public ComboBox<String> getWaterReq() {
		return waterReq;
	}
	public ComboBox<String> getLightReq() {
		return lightReq;
	}
	public ComboBox<String> getColor() {
		return color;
	}
	
	public int getGardenLength() {
		return gardenLength;
	}
	
	public int getGardenWidth() {
		return gardenWidth;
	}
	
	public void showPreferences(Stage stage) {
		
	}
}
