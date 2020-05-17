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
	 * Constructor of InfoTips that takes in a controller
	 * 
	 * @param controller
	 */
	public InfoTips(Controller controller) {
		this.c = controller;
	}
	
	/**
	 * Displays info for all plants already in garden
	 * 
	 */
	
	public void showInfoTips() {	
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