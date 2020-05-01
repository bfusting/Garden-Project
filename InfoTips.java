import java.util.ArrayList;
import java.util.Date;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;


//Updated: 4/25 9:52

/**
 * 
 * @author Kelsey McRae
 * 
 * <br> 
 * <br> Takes the attributes of the plant and shows them to the user when hovered over or clicked on.
 *
 */

public class InfoTips{
	private Scene infoTipsScene;
	private Label color;
	private Label waterNeed;
	private Label bloomTime;
	private Label sunlightNeeded;
	private Label plantHeight;
	private Label provideShade;
	private Label plantType;
	private Label animalsFed;
	
	
	/**
	 * Constructor that takes properties of the plant
	 * 
	 * @param col Color of the plant
	 * @param water Amount of water needed by the plant
	 * @param bloom Date of the plant's specific bloom time
	 * @param sun Amount of sun needed
	 * @param height Height of the plant in bloom
	 * @param shade Amount of shade needed by the plant
	 * @param type Type of plant
	 * @param animals List of animals that feed off this plant
	 */
	
	public InfoTips(String col, int water, Date bloom, int sun, double height, boolean shade, String type, ArrayList<String> animals) {
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
	
	/**
	 * Default constructor just to work in view for now
	 * not used in real project after Alpha
	 * Made by Malachi
	 * -Kelsey Approved
	 */
	public InfoTips() {
		color = null;
		waterNeed = null;
		bloomTime = null;
		sunlightNeeded = null;
		plantHeight = null;
		provideShade = null;
		plantType = null;
		animalsFed = null;
	}
	
	/**
	 * Organizes all of the labels of plant attributes
	 * 
	 * @param stage The stage of InfoTips' scene
	 */
	
	public void showInfoTips(Stage stage) {
		
		AnchorPane root = new AnchorPane();
		Label it = new Label ("Info and Tips");
		AnchorPane.setTopAnchor(it, 100.0);
		AnchorPane.setLeftAnchor(it, 235.0);
		root.getChildren().add(it);
		infoTipsScene = new Scene(root, 500.0, 500.0);
		
		stage.setTitle("InfoTips");
		stage.setScene(infoTipsScene);
		stage.show();
		
	}
	
}
