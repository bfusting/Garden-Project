import javafx.scene.Scene;
import javafx.scene.control.Label;

public class InfoTips extends View{
	private Scene contentHolder;
	private Label color;
	private Label waterNeed;
	private Label bloomTime;
	private Label sunlightNeeded;
	private Label plantHeight;
	private Label provideShade;
	private Label plantType;
	private Label animalsFed;
	
	public void InfoTips(String col, int water, Date bloom, int sun, double height, boolean shade, String type, ArrayList<String> animals) {
		color = new Label(col);
		waterNeed = new Label(String.valueOf(water));
		bloomTime = new Label(bloom.toString());
		sunlightNeeded = new Label(String.valueOf(sun));
		plantHeight = new Label(String.valueOf(height));
		
		String yesShade = "There is shade provided.";
		String noShade = "There is no shade provided.";
		
		if (shade) {
			provideShade = new Label(yesShade);
		} else {
			provideShade = new Label(noShade);
		}
		
		plantType = new Label(type);
		
		String b = "";
		
		for(String a : animals) {
			b = b + a + " , ";
		}
		
		animalsFed = new Label(b);
				
	}
	
	public void showInfoTips(Stage stage) {
		
	}
}
