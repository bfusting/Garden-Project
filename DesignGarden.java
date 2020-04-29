import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Node;
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
import javafx.scene.layout.TilePane;
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


//Updated: 4.28 8:01pm

/**
 * 
 * @author Kelsey McRae
 * <br> 
 * <br> The view in which the user designs their garden by dragging and dropping plants, trees, pathways, and other options.
 * Also contains buttons for recommendations, change of seasons, and plant info.
 *
 */

public class DesignGarden extends Screen{
	//	private int selectionArrLen;
	//	private int selectionArrWid;

	private ArrayList<Label> otherArr;
	private ArrayList<ImageView> pSelectionArr;
	
	private int otherArrInd = 0;
	private int pSelectionArrInd = 0;
	
	private TabPane selectGardenType;
	private Tab plants;
	private Tab trees;
	private Tab pathways;
	private Tab otherOptions;

	private Button recommendations;
	private Button changeSeasons;
	private Button infoTips;
	private Button save;
	private Button finalView;
	
	private Button indexLeft;
	private Button indexRight;
	
	private int seasonIndexer;
	private Text plantInfo;
	private ArrayList<Image> imagesUsed;
	
	private Button plantSelectRight;
	private Button plantSelectLeft;
	
	private Scene designGardenScene;
	
	// Why is this there
	private GardenPlot gardenPlot;
	private GridPane plot;
	
	private ImageView[][] soil;
	
	GridPane plantsGP = new GridPane();
	GridPane treesGP = new GridPane();
	GridPane pathsGP = new GridPane();
	GridPane otherGP = new GridPane();
	
	//2d array 5x5 of GardenTile using GridPane
	
	private Controller c;
	
	public DesignGarden(Controller controller) {
		this.c = controller;
	}

	
	public int increaseSelectionArrInd(int currentInd) {
		int newIndex = currentInd + 1;
		return newIndex;
	}
	
	public int decreaseSelectionArrInd(int currentInd) {
		int newIndex = currentInd - 1;
		return newIndex;
	}
	
	public int getOtherArrInd(){
		return otherArrInd;
	}
	public void setOtherArrInd(int newInd) {
		this.otherArrInd = newInd;
	}
	public int getPSelectionArrInd(){
		return pSelectionArrInd;
	}
	public void setPSelectionArrInd(int newInd) {
		this.pSelectionArrInd = newInd;
	}
	
	
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
		
		indexLeft = new Button("<<<");
		indexRight = new Button(">>>");
		
		AnchorPane.setLeftAnchor(indexLeft, 10.0);
		AnchorPane.setLeftAnchor(indexRight, 810.00);
		AnchorPane.setTopAnchor(indexLeft, 120.0);
		AnchorPane.setTopAnchor(indexRight,120.0);
		
		//Tab Pane at top of screen to select plants/trees/paths/other
		selectGardenType = new TabPane();
		selectGardenType.setMinSize(800.0,400.0);
		selectGardenType.setMaxSize(800.0, 400.0);
	
		
		//creating GridPanes for tab content
/*		
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
*/	
		plants = new Tab("Plants");
//		plants.setContent(plantsGP);
		
		trees = new Tab("Trees");
//		trees.setContent(treesGP);
		
		pathways = new Tab("Pathways");
//		pathways.setContent(pathsGP);
		
		otherOptions = new Tab("Other");
//		otherOptions.setContent(otherGP);
		
		
		ImageView iv1 = new ImageView();
		Image im1 = new Image(getClass().getResourceAsStream("/commonMilkweedcopy.png"));
		
		ImageView iv2 = new ImageView();
		Image im2 = new Image(getClass().getResourceAsStream("/commonMilkweedcopy.png"));
		
		ArrayList<ImageView> pSelectionArr = new ArrayList<ImageView>();
		
		iv1.setImage(im1);
    	iv1.setPreserveRatio(true);
    	iv1.setFitHeight(100);
    	
    	pSelectionArr.add(iv1);
    	
    	iv2.setImage(im2);
    	iv2.setPreserveRatio(true);
    	iv2.setFitHeight(100);
    	
    	pSelectionArr.add(iv2);
		
		
		TilePane plantTP = new TilePane();
		plantTP.setHgap(8);
		plantTP.setPrefColumns(5);
		for (ImageView iv : pSelectionArr) {
			iv.setOnDragDetected(c.getStartDrag());
	        plantTP.getChildren().add(iv);
	   	}
		
	    plants.setContent(plantTP);
	    
	    ImageView ivt1 = new ImageView();
		Image imt1 = new Image(getClass().getResourceAsStream("/BlackGumTreecopy.png"));
		
		ImageView ivt2 = new ImageView();
		Image imt2 = new Image(getClass().getResourceAsStream("/BlackGumTreecopy.png"));
		
		ArrayList<ImageView> tSelectionArr = new ArrayList<ImageView>();
		
		ivt1.setImage(imt1);
    	ivt1.setPreserveRatio(true);
    	ivt1.setFitHeight(100);
    	
    	tSelectionArr.add(ivt1);
    	
    	ivt2.setImage(imt2);
    	ivt2.setPreserveRatio(true);
    	ivt2.setFitHeight(100);
    	
    	tSelectionArr.add(ivt2);
		
		
		TilePane treesTP = new TilePane();
		treesTP.setHgap(8);
		treesTP.setPrefColumns(5);
		for (ImageView iv : tSelectionArr) {
			iv.setOnDragDetected(c.getStartDrag());
	        treesTP.getChildren().add(iv);
	   	}
		
	    trees.setContent(treesTP);
    
	    TilePane pathsTP = new TilePane();
	    pathsTP.setHgap(8);
	    pathsTP.setPrefColumns(5);
	    pathsTP.getChildren().addAll(new Label("Stone path"), new Label("Brick Path"), new Label("Straight up dirt"));
	    
	    pathways.setContent(pathsTP);
	    
	    otherArr = new ArrayList<Label>();
	    otherArr.add(new Label("Rock"));
	    otherArr.add(new Label("Tiki hut"));
	    otherArr.add(new Label("She-shed"));
	    otherArr.add(new Label("Bright pink flamingo"));
	    otherArr.add(new Label("Fountain"));
	    otherArr.add(new Label("General Building"));
	    
	    TilePane otherTP = new TilePane();
	    otherTP.setHgap(8);
	    otherTP.setPrefColumns(5);
	    
	    for (int i = (0 + otherArrInd); i<(5+otherArrInd); i++) {
	    	otherTP.getChildren().add(otherArr.get(i));
	    }
//	    otherTP.getChildren().addAll(new Label("Rock"), new Label("Tiki hut"), new Label("She-shed"), new Label("Bright pink flamingo"), new Label("Fountain"), new Label("General Building"));
		
	    otherOptions.setContent(otherTP);
	    
		selectGardenType.getTabs().addAll( plants, trees, pathways, otherOptions);

		AnchorPane.setTopAnchor(selectGardenType, 40.0);
		AnchorPane.setLeftAnchor(selectGardenType, 40.0);

		
		// Other features buttons (recs and seasons) in AnchorPane
		recommendations = new Button("Recommendations");
		changeSeasons = new Button("Change Seasons");
		infoTips = new Button("Info and Tips");
		save = new Button("Save Garden");
		finalView = new Button("Finish");
		
		recommendations.setMinSize(200.0,40.0);
		changeSeasons.setMinSize(200.0,40.0);
		infoTips.setMinSize(200.0,40.0);
		save.setMinSize(200.0, 40.0);
		finalView.setMinSize(200.0, 40.0);
		
		//click recommendations button
		
		recommendations.setOnMouseClicked(c.getRecommendationsBTN());
		
		//Change Seasons Button
		
		changeSeasons.setOnMouseClicked(c.getChangeSeasonsBTN());
		
		//InfoTips Button
		
		infoTips.setOnMouseClicked(c.getInfoTipsBTN());
		
		// Save Button
		
		save.setOnMouseClicked(c.getSaveBTN());
		
		// Finalview Button
		
		finalView.setOnMouseClicked(c.getFinalViewBTN());
		
		AnchorPane apButtons = new AnchorPane();

		Label otherFeaturesLabel = new Label("Other Features: ");
		apButtons.setTopAnchor(otherFeaturesLabel, 60.0);
		apButtons.setTopAnchor(recommendations, 120.0);
		apButtons.setTopAnchor(changeSeasons, 180.0);
		apButtons.setTopAnchor(infoTips, 240.0);
		apButtons.setTopAnchor(save, 300.0);
		apButtons.setTopAnchor(finalView, 360.0);
		
		apButtons.getChildren().addAll(recommendations, changeSeasons, otherFeaturesLabel, infoTips, save, finalView);

		
		root.setTopAnchor(apButtons, 40.0);
		root.setRightAnchor(apButtons, 60.0);
		
		Label emptySpace = new Label("		");
		Label emptySpace2 = new Label("		");
		Label emptySpace3 = new Label("		");
		Label emptySpace4 = new Label("		");
		Label emptySpace5 = new Label("		");
		
		// Replace with vars so works better
		//FitHeight and FitWidth should take in var constraints
		plot = new GridPane();
		soil = new ImageView[5][5];
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				soil[i][j] = new ImageView(new Image("img/soil.jpg"));
				soil[i][j].setPreserveRatio(true);
				soil[i][j].setFitHeight(150);
				soil[i][j].setFitWidth(99);
				plot.add(soil[i][j], i, j,1,1);
			}
		}
		
		/*
		ImageView soil1 = new ImageView();
		soil1.setImage(new Image("img/soil.jpg"));
		soil1.setPreserveRatio(true);
		soil1.setFitHeight(150);
		soil1.setFitWidth(100);
		
		ImageView soil2 = new ImageView();
		soil1.setImage(new Image("img/soil.jpg"));
		soil1.setPreserveRatio(true);
		soil1.setFitHeight(150);
		soil1.setFitWidth(100);
		
		plot = new GridPane();
		plot.add(soil2, 0, 0);
		plot.add(soil1, 1, 1);
		plot.add(emptySpace3, 2, 2);
		plot.add(emptySpace4, 3, 3);
		plot.add(emptySpace5, 4, 4);
		*/
		
		plot.setMinSize(600.0, 600.0);
		for (int i = 0; i < 5; i++) {
	         ColumnConstraints column = new ColumnConstraints(150);
	         plot.getColumnConstraints().add(column);
	     }
		for (int i = 0; i < 5; i++) {
	         RowConstraints row = new RowConstraints(100);
	         plot.getRowConstraints().add(row);
	     }
		
		plot.setOnDragOver(c.getDetectDrag());
		plot.setOnDragDropped(c.getDetectDragDrop());

		plot.setGridLinesVisible(true);
		
		root.setTopAnchor(plot, 200.0);
		root.setLeftAnchor(plot, 40.0);
		
		
		root.getChildren().addAll(apButtons, selectGardenType, plot, indexLeft, indexRight);
		
		designGardenScene = new Scene(root,1200,800);
		
		stage.setTitle("Design Garden");
		stage.setScene(designGardenScene);
		stage.show();
	}

	public Button getRecommendationsBTTN() {
		return recommendations;
	}
	public Button getChangeSeasonsBTTN() {
		return changeSeasons;
	}
	public Button getInfoTipsBTTN() {
		return infoTips;
	}

	
	
}
