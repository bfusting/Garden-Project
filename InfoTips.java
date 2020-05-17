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

public class InfoTips {
	
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
/*		Accordion acc = new Accordion();
		stage = new Stage();
		stage.setTitle("Info and Tips");
		
		AnchorPane root = new AnchorPane();
		root.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN,CornerRadii.EMPTY,Insets.EMPTY)));
	

//		ArrayList<Text> texts = new ArrayList<Text>();

/*		for (Plant p : Model.getUsedPlants()) {

			System.out.println(p);
			
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
		
//		String[] body = new String[]{};
		Text[] body = new Text[] {};
		String[] titles = new String[] {};
		
		for (Plant p : Model.getUsedPlants()) {
			int i = 0;
			String name = p.getName();
			String latinName = p.getLatinName();
			String titleStr = name + " - " + latinName;
			titles[i] = titleStr;
//			body[i] = new Text(p.toString());
			i++;
		}
		TitledPane[] tps = new TitledPane[titles.length];
		
		for (int i = 0; i<titles.length; i++) {
//			tps[i] = new TitledPane(titles[i],body[i]);
			tps[i] = new TitledPane(titles[i], new Text("Testing"));
		}
		
		acc.getPanes().addAll(tps);
		acc.setExpandedPane(tps[0]);
		
		AnchorPane.setTopAnchor(tps[0], 5.0);
		AnchorPane.setLeftAnchor(tps[0], 5.0);


		root.getChildren().add(acc);
*/		
		stage = new Stage();
		stage.setTitle("Info and Tips");
		AnchorPane root = new AnchorPane();


		
		ArrayList<String> titles = new ArrayList<String>();
		ArrayList<Text> texts = new ArrayList<Text>();
		ArrayList<TitledPane> tps = new ArrayList<TitledPane>();
		
		ArrayList<AnchorPane> aps = new ArrayList<AnchorPane>();
		
		Accordion acc = new Accordion();
		
		for (Plant p : Model.getUsedPlants()) {
			String name = p.getName();
			String latinName = p.getLatinName();
			String titleStr = name + " - " + latinName;

			titles.add(titleStr);
//			texts.add(new Text(p.toString()));
			Text bodyTxt = new Text(p.toString());
			AnchorPane ap = new AnchorPane();
			ap.getChildren().add(bodyTxt);
			ap.setLeftAnchor(bodyTxt, 5.0);
			ap.setTopAnchor(bodyTxt, 5.0);
			aps.add(ap);
		}
		
		for (int i = 0; i < titles.size(); i++) {
			tps.add( new TitledPane(titles.get(i),aps.get(i)));
		}
		acc.getPanes().addAll(tps);
		acc.setExpandedPane(tps.get(0));
		acc.setMinWidth(WIDTH-10.0);
		
		root.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN,CornerRadii.EMPTY,Insets.EMPTY)));
		
		AnchorPane.setTopAnchor(acc, 5.0);
		AnchorPane.setLeftAnchor(acc, 5.0);

		root.getChildren().add(acc);

		Scene scene = new Scene(root,WIDTH+50.0,HEIGHT+50.0);
		stage.setScene(scene);
	//	stage.show();
		
		
	}
		

//	@Override
	public void showScreen() {
		//should consolidate into one showScreen method
		showInfoTips();
		stage.show();
		stage.toFront();
		
	}
	
//	@Override
	public void closeScreen() {
		stage.close();
	}
	
		
}
	

