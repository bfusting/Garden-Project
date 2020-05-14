import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


//Updated: 4/25 9:52

/**
 * 
 * @author Kelsey McRae
 * 
 * <br> 
 * <br> Takes the attributes of the plant and shows them to the user when hovered over or clicked on.
 *
 */

public class InfoTips extends Screen{
	
	private final int HEIGHT = 500;
	private final int WIDTH = 250;
	private Controller c;
	private Stage stage;
	
	private HashSet<Plant> hs;
	
	
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
	
/*	public InfoTips(String col, int water, Date bloom, int sun, double height, boolean shade, String type, ArrayList<String> animals) {
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
*/	
	public InfoTips(Controller controller) {
		this.c = controller;
	}
	
	/**
	 * Default constructor just to work in view for now
	 * not used in real project after Alpha
	 * Made by Malachi
	 * -Kelsey Approved
	 */
/*	public InfoTips() {
		color = null;
		waterNeed = null;
		bloomTime = null;
		sunlightNeeded = null;
		plantHeight = null;
		provideShade = null;
		plantType = null;
		animalsFed = null;
	}
*/	
	/**
	 * Organizes all of the labels of plant attributes
	 * 
	 * @param stage The stage of InfoTips' scene
	 */
	
	public void showInfoTips() {
		Accordion acc = new Accordion();

		
		hs = Model.getUsedPlants();
//		ArrayList<Text> texts = new ArrayList<Text>();

		for (Plant p : hs) {

			String name = p.getName();
			String latinName = p.getLatinName();
			String titleStr = name + " - " + latinName;
			String body = p.toString();
			
			Text bodyText = new Text(body);

			TitledPane tp = new TitledPane();
			tp.setText(titleStr);
			tp.setContent(bodyText);
			
			acc.getPanes().add(tp);

		}		
		stage = new Stage();
		stage.setTitle("Info and Tips");
		
		
		BorderPane root = new BorderPane();
		root.getChildren().add(acc);
		
		root.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN,CornerRadii.EMPTY,Insets.EMPTY)));
		
		
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		stage.setScene(scene);
		
		
	}
		

	@Override
	public void showScreen() {
		//should consolidate into one showScreen method
		showInfoTips();
		stage.show();
		stage.toFront();
		
	}
	
	@Override
	public void closeScreen() {
		stage.close();
	}
	
		
}
	

