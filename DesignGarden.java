import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
	// Kelsey I (Malachi Added these so each plant type has it's own picture array)
	// need to make initlaize in show
	private ArrayList<ImageView> shrubSelArr;
	private ArrayList<ImageView> treeSelArr;
	private ArrayList<ImageView> underSelArr;
	
	private int otherArrInd = 0;
	private int pSelectionArrInd = 0;
	
	// used by Controller to choose where in the array to pull plant from
	private int gridPaneInd = 0;
	
	private TabPane selectGardenType;
	private Tab plants;
	private Tab trees;
	private Tab shrubs;
	private Tab undergrowth;
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
	GridPane shrubsGP = new GridPane();
	GridPane underGP = new GridPane();
	GridPane pathsGP = new GridPane();
	GridPane otherGP = new GridPane();
	
	GridPane tileEditingGP = new GridPane();
	
	//2d array 5x5 of GardenTile using GridPane
	
	private Stage theStage;
	
	private AnchorPane root;
	
	private Controller c;
	
	// length/width taken in by user preference
	private int length = 5;
	private int width = 5;
	private final int selectionSize = 6;
	private final double maxTileEditSize = 50.0;
	private final double selectionGPsize = 100.0;
	
	// Used as backdrops colors for selection gridpanes
	private ArrayList<ImageView> backdropColor = new ArrayList<ImageView>();
	
	// used to hold images of more n less light and water
	private ArrayList<ImageView> tileEdit = new ArrayList<ImageView>();
	
	// used to tell if hovering over tile editorers array
	private boolean hoverEditTile = false;
	
	public DesignGarden(Controller controller,Stage s) {
		this.c = controller;
		theStage = s;
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
		// setting up tileEditingGP
		String[] temp = {"img/waterAdd.jpg","img/lessWater.jpg",
				"img/moreLight.png","img/lessLight.png"};
		
		// setting up with each different picture
		for(int i=0; i<temp.length;i++) {
			Image img = new Image(temp[i]);
			ImageView imgV = new ImageView(img);
			imgV.setPreserveRatio(true);
			imgV.setFitHeight(maxTileEditSize);
			imgV.setFitWidth(maxTileEditSize);
			tileEdit.add(imgV);
		}
		
		tileEdit.forEach(imgV -> imgV.setOnDragDetected(c.getStartDrag()));
		
		tileEditingGP.setMaxSize(maxTileEditSize,maxTileEditSize);
		//adding row
		tileEditingGP.getRowConstraints().add(new RowConstraints(maxTileEditSize));
		for (int i = 0; i < 4; i++) {
	         ColumnConstraints column = new ColumnConstraints(maxTileEditSize);
	         tileEditingGP.getColumnConstraints().add(column);
	         tileEditingGP.add(tileEdit.get(i), i, 0,1,1);
		}
		
		// EventHandler to listen to which row, column its on
		tileEditingGP.getChildren().forEach(cell -> cell.setOnMouseEntered(c.getMouseEnterPlantSelection()));
		
		
		// setting up backupDrop with 6 images since that is the size of each gridPane
		for(int i=0; i<selectionSize;i++) {
			ImageView imv1 = new ImageView("img/plantSelectionBackdrop.jpg");
			imv1.setPreserveRatio(true);
			imv1.setFitHeight(100);
			imv1.setFitWidth(100);
			backdropColor.add(imv1);
		}

		//root AnchorPane
		//AnchorPane root = new AnchorPane();
		root = new AnchorPane();
		
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
		
		//setting up the Plant selection gridPane
		plants.setContent(plantsGP);
		
		// max size of items
		plantsGP.setMaxSize(100.0, 100.0);
		//adding row
		plantsGP.getRowConstraints().add(new RowConstraints(100));
		for (int i = 0; i < selectionSize; i++) {
	         ColumnConstraints column = new ColumnConstraints(100);
	         plantsGP.getColumnConstraints().add(column);
	         plantsGP.add(backdropColor.get(i), i, 0,1,1);
		}
		
		plantsGP.getChildren().forEach(cell -> cell.setOnMouseEntered(c.getMouseEnterPlantSelection()));
		
		plantsGP.setGridLinesVisible(true);
		
		/////////////////////////////////////////////////////////////////
		shrubs = new Tab("Shrubs");
		//setting up the Plant selection gridPane
		
		shrubs.setContent(shrubsGP);
		
		// max size of items
		plantsGP.setMaxSize(100.0, 100.0);
		//adding row
		plantsGP.getRowConstraints().add(new RowConstraints(100));
		for (int i = 0; i < selectionSize; i++) {
	         ColumnConstraints column = new ColumnConstraints(100);
	         plantsGP.getColumnConstraints().add(column);
	         plantsGP.add(backdropColor.get(i), i, 0,1,1);
		}
		
		plantsGP.getChildren().forEach(cell -> cell.setOnMouseEntered(c.getMouseEnterPlantSelection()));
		
		plantsGP.setGridLinesVisible(true);
		
		/////////////////////////////////////////////////////////////////
		undergrowth = new Tab("Undergrowth");
//		undergrowth.setContent
		
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
    	
    	// sets handlers for whole array
    	for(ImageView i : pSelectionArr) {
    		i.setOnDragDetected(c.getStartDrag());
    	}//for
    	
		//first 6 elements in array into gridPane
		for(int i=0; i<selectionSize; i++) {
			if(i < pSelectionArr.size()) {
				plantsGP.getChildren().add(pSelectionArr.get(i));
			}
		}
		
		/*
		TilePane plantTP = new TilePane();
		plantTP.setHgap(8);
		plantTP.setPrefColumns(5);
		for (ImageView iv : pSelectionArr) {
			iv.setOnDragDetected(c.getStartDrag());
	        plantTP.getChildren().add(iv);
	   	}
	    plants.setContent(plantTP);
	    */
	    
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
	    
		selectGardenType.getTabs().addAll( plants, trees, shrubs, undergrowth, pathways, otherOptions);

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
		Label tileEditors = new Label("Tile Editors");
		Label otherFeaturesLabel = new Label("Other Features: ");
		apButtons.setTopAnchor(otherFeaturesLabel, 60.0);
		apButtons.setTopAnchor(recommendations, 120.0);
		apButtons.setTopAnchor(changeSeasons, 180.0);
		apButtons.setTopAnchor(infoTips, 240.0);
		apButtons.setTopAnchor(save, 300.0);
		apButtons.setTopAnchor(finalView, 360.0);
		apButtons.setTopAnchor(tileEditors, 420.0);
		apButtons.setTopAnchor(tileEditingGP, 440.0);
		
		apButtons.getChildren().addAll(recommendations, changeSeasons, otherFeaturesLabel, infoTips, save, finalView,tileEditors,tileEditingGP);

		
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
		soil = new ImageView[length][width];
		for(int i=0; i<length; i++) {
			for(int j=0; j<width; j++) {
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
		
		plot.setMaxSize(600.0, 600.0);
		for (int i = 0; i < length; i++) {
	         ColumnConstraints column = new ColumnConstraints(150);
	         plot.getColumnConstraints().add(column);
	     }
		for (int i = 0; i < width; i++) {
	         RowConstraints row = new RowConstraints(100);
	         plot.getRowConstraints().add(row);
	     }
		
		//Drag and drop for normal use of adding plants
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
	public TabPane getSelectGardenType() {
		return selectGardenType;
	}
	public int getGridPaneInd() {
		return gridPaneInd;
	}
	public void setGridPaneInd(int i) {
		gridPaneInd = i;
	}
	public boolean getHoverEditTile() {
		return hoverEditTile;
	}
	public void setHoverEditTile(boolean b) {
		hoverEditTile = b;
	}
	public GridPane getTileEditGP() {
		return tileEditingGP;
	}
	public GridPane getPlantsGP() {
		return plantsGP;
	}
	public GridPane getTreesGP() {
		return treesGP;
	}
	public GridPane getShrubsGP() {
		return shrubsGP;
	}
	public GridPane getUnderGP() {
		return underGP;
	}
	public GridPane getPathsGP() {
		return pathsGP;
	}
	public GridPane getOtherGP() {
		return otherGP;
	}
	
	@Override
	public String toString() {
		return "Design Garden";
	}
	
	@Override
	public void showScreen() {
		//showScreen should really just set the stage with the scene in whatever state it is in
		showDesignGarden(theStage);
	}
	
	@Override
	public void setUneditable() {
		root.setDisable(true);
		theStage.setOpacity(View.nonEditableOpacity);
	}
	
	@Override
	public void setEditable() {
		root.setDisable(false);
		theStage.setOpacity(View.EditableOpacity);
	}

	
	
}
