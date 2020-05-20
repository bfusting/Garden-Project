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
 * <br> Takes the attributes of the plant and shows them to the user when clicking on the Info and Tips button.
 *
 */

public class InfoTips {
	
	private final int HEIGHT = 500;
	private final int WIDTH = 250;
	
	private Stage stage;
	
	private HashSet<Plant> hs;
	private AnchorPane root;
	private Accordion acc;
	
	/**
	 * Constructor of InfoTips that takes in a controller
	 * 
	 * @param controller
	 */
	public InfoTips() {
		
		stage = new Stage();
		stage.setTitle("Info and Tips");
	}
	
	/**
	 * Displays info for all plants already in garden
	 * 
	 */
	
	public void showInfoTips() {	
		root = new AnchorPane();
		acc = new Accordion();

		ArrayList<String> titles = new ArrayList<String>();
		ArrayList<Text> texts = new ArrayList<Text>();
		ArrayList<TitledPane> tps = new ArrayList<TitledPane>();
		ArrayList<AnchorPane> aps = new ArrayList<AnchorPane>();
		
		for (Plant p : Model.getUsedPlants()) {
			String name = p.getName();
			String latinName = p.getLatinName();
			String titleStr = name + " - " + latinName;

			titles.add(titleStr);
//			texts.add(new Text(p.toString()));
			Text bodyTxt = new Text(p.toString());
			AnchorPane ap = new AnchorPane();
			ap.getChildren().add(bodyTxt);
			AnchorPane.setLeftAnchor(bodyTxt, 5.0);
			AnchorPane.setTopAnchor(bodyTxt, 5.0);
			aps.add(ap);
		}
		for (int i = 0; i < titles.size(); i++) {
			tps.add( new TitledPane(titles.get(i),aps.get(i)));
		}
		
		acc.getPanes().addAll(tps);
		
		if (!tps.isEmpty()) {
			acc.setExpandedPane(tps.get(0));
		} else {
			Text isEmptyTxt = new Text("Please drag a plant into your garden");
			AnchorPane.setTopAnchor(isEmptyTxt, 10.0);
			AnchorPane.setLeftAnchor(isEmptyTxt, 5.0);
			root.getChildren().add(isEmptyTxt);
		}
		acc.setMinWidth(WIDTH-10.0);
		
		root.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN,CornerRadii.EMPTY,Insets.EMPTY)));
		
		AnchorPane.setTopAnchor(acc, 5.0);
		AnchorPane.setLeftAnchor(acc, 5.0);

		root.getChildren().add(acc);

		Scene scene = new Scene(root,WIDTH+50.0,HEIGHT+50.0);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * Closes the screen
	 */
		
//	@Override
	public void closeScreen() {
		stage.close();
	}
}