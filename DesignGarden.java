import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;

//import javafx.scene.shape.Shape.*;


//Updated: 4/25 9:52

/**
 * 
 * @author Kelsey McRae
 * <br> 
 * <br> The view in which the user designs their garden by dragging and dropping plants, trees, pathways, and other options.
 * Also contains buttons for recommendations, change of seasons, and plant info.
 *
 */

public class DesignGarden{
//	private int selectionArrLen;
//	private int selectionArrWid;
private ArrayList<ImageView> selectionArr;
	
	private TabPane selectGardenType;
	private Tab plants;
	private Tab trees;
	private Tab pathways;
	private Tab otherOptions;

	private Button recommendations;
	private Button changeSeasons;
	private Button infoTips;
	
	private int seasonIndexer;
	private Text plantInfo;
	private ArrayList<Image> imagesUsed;
	
	private Button plantSelectRight;
	private Button plantSelectLeft;
	
	private Scene designGardenScene;
	
	private GardenPlot gardenPlot;
	private GridPane plot;
	
	GridPane plantsGP = new GridPane();
	GridPane treesGP = new GridPane();
	GridPane pathsGP = new GridPane();
	GridPane otherGP = new GridPane();
	
	private Controller c;
	
	public DesignGarden(Controller controller) {
		this.c = controller;
	}
	
	//2d array 5x5 of GardenTile using GridPane

	
	

	
/*	/**
	 * Updates the viewable array of plants, trees, etc able to be dragged into the garden.
	 *
	public void updateSelectionIndex() {
		
	}
*/	

	
	public Scene getDesignGardenScene() {
		return designGardenScene;
	}


	/**
	 * Creates the array of plants/trees/etc for the user to choose from based on local requirements and user preferences.
	 */
	public void createImageArray() {
		
	}
	
	public GridPane getPlot() {
		return plot;
	}
	
	
	
/*	/**
	 * Opens the recommendations 
	 *
	public void openRecommendations() {
		
	}
*/
	
	/**
	 * Contains the buttons, panes, and other features that will enable the user to edit their garden view.
	 * 
	 * @param stage The stage for DesignGarden's scene.
	 */
	
	public void showDesignGarden(Stage stage) {

		//root AnchorPane
		AnchorPane root = new AnchorPane();
		
		//Tab Pane at top of screen to select plants/trees/paths/other
		selectGardenType = new TabPane();
		selectGardenType.setMinSize(800.0,400.0);
		selectGardenType.setMaxSize(800.0, 400.0);
	
		
		//creating GridPanes for tab content
		
		Label p1 = new Label("Milkweed		");
		plantsGP.add(p1,0,1);
		Label p2 = new Label("Plant2	");
		plantsGP.add(p2,1,1);
		Label p3 = new Label("Plant3	");
		plantsGP.add(p3,2,1);
		
		Label t1 = new Label("Maple		");
		Label t2 = new Label("Birch		");
		treesGP.add(t1,0,1);
		treesGP.add(t2,1,1);
		
		Label path1 = new Label("Stone path		");
		Label path2 = new Label("Gravel path		");
		pathsGP.add(path1, 0, 1);
		pathsGP.add(path2, 1, 1);
		
		Label other1 = new Label("Rock 		");
		Label other2 = new Label("Tiki hut		");
		Label other3 = new Label("She-shed		");
		otherGP.add(other1, 0, 1);
		otherGP.add(other2, 1, 1);
		otherGP.add(other3, 2, 1);
	
		plants = new Tab("Plants");
		plants.setContent(plantsGP);
		
		trees = new Tab("Trees");
		trees.setContent(treesGP);
		
		pathways = new Tab("Pathways");
		pathways.setContent(pathsGP);
		
		otherOptions = new Tab("Other");
		otherOptions.setContent(otherGP);
		
		selectGardenType.getTabs().addAll( plants, trees, pathways, otherOptions);

		AnchorPane.setTopAnchor(selectGardenType, 40.0);
		AnchorPane.setLeftAnchor(selectGardenType, 40.0);
		AnchorPane.setBottomAnchor(selectGardenType, 40.0);
		
		// Other features buttons (recs and seasons) in AnchorPane
		recommendations = new Button("Recommendations");
		changeSeasons = new Button("Change Seasons");
		infoTips = new Button("Info and Tips");
		
		recommendations.setMinSize(200.0,40.0);
		changeSeasons.setMinSize(200.0,40.0);
		infoTips.setMinSize(200.0,40.0);
		
		//click recommendations button
		
		recommendations.setOnMouseClicked(c.getRecommendationsBTN());
		
		AnchorPane apButtons = new AnchorPane();

		Label otherFeaturesLabel = new Label("Other Features: ");
		apButtons.setTopAnchor(otherFeaturesLabel, 60.0);
		apButtons.setTopAnchor(recommendations, 120.0);
		apButtons.setTopAnchor(changeSeasons, 180.0);
		apButtons.setTopAnchor(infoTips, 240.0);
		
		apButtons.getChildren().addAll(recommendations, changeSeasons, otherFeaturesLabel, infoTips);

		
		root.setTopAnchor(apButtons, 40.0);
		root.setRightAnchor(apButtons, 60.0);
		
		Label emptySpace = new Label("		");
		Label emptySpace2 = new Label("		");
		Label emptySpace3 = new Label("		");
		Label emptySpace4 = new Label("		");
		Label emptySpace5 = new Label("		");
		
		plot = new GridPane();
		plot.add(emptySpace, 0, 0);
		plot.add(emptySpace2, 1, 1);
		plot.add(emptySpace3, 2, 2);
		plot.add(emptySpace4, 3, 3);
		plot.add(emptySpace5, 4, 4);
		plot.setMinSize(600.0, 600.0);
		for (int i = 0; i < 5; i++) {
	         ColumnConstraints column = new ColumnConstraints(150);
	         plot.getColumnConstraints().add(column);
	     }
		for (int i = 0; i < 5; i++) {
	         RowConstraints row = new RowConstraints(100);
	         plot.getRowConstraints().add(row);
	     }
	 

		plot.setGridLinesVisible(true);
		
		root.setTopAnchor(plot, 200.0);
		root.setLeftAnchor(plot, 40.0);
		
		
		root.getChildren().addAll(apButtons, selectGardenType, plot);
		
		designGardenScene = new Scene(root,1200,800);
		
		stage.setTitle("Design Garden");
		stage.setScene(designGardenScene);
		stage.show();
	}


	
	
}
