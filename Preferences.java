import javafx.scene.control.ComboBox;

public class Preferences {
	private ComboBox<String> bloomTime;
	private ComboBox<?> waterReq;
	private ComboBox<?> lightReq;
	private ComboBox<String> color;
	
	private double length;
	private double width;
	
	public void askSize() {
		
	}
	
	public ComboBox<String> getBloomTime() {
		return bloomTime;
	}
	public ComboBox<?> getWaterReq() {
		return waterReq;
	}
	public ComboBox<?> getLightReq() {
		return lightReq;
	}
	public ComboBox<String> getColor() {
		return color;
	}
}
