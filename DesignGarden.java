import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
import javafx.stage.Popup;
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
 *  The view in which the user designs their garden by dragging and dropping plants, trees, pathways, and other options.
 * Also contains buttons for recommendations, change of seasons, and plant info.
 * <br>
 * <br>
 * 
 * @author Kelsey McRae
 *
 */

public class DesignGarden extends Screen{
	
	private ArrayList<ImageView> pSelectionArr;
	
	private ArrayList<ImageView> shrubSelArr;
	private ArrayList<ImageView> treeSelArr;
	//private ArrayList<ImageView> underSelArr;
	// just drops a general addon into model
	// add case in controller so it works
	
	private int otherArrInd = 0;
	private int pSelectionArrInd = 0;
	
	// used by Controller to choose where in the array to pull plant from
	private int gridPaneInd = 0;
	
	private TabPane selectGardenType;
	private Tab plants;
	private Tab trees;
	private Tab shrubs;
	private Tab pathways;
	private Tab otherOptions;

	private Button recommendations;
	private Button changeSeasons;
	private Button infoTips;
	private Button save;
	private Button finalView;
	private Button instructions;
	
	private Scene designGardenScene;
	
	private GridPane plot;
	
	
	GridPane plantsGP = new GridPane();
	GridPane treesGP = new GridPane();
	GridPane shrubsGP = new GridPane();
	GridPane pathsGP = new GridPane();
	GridPane otherGP = new GridPane();
	
	GridPane tileEditingGP = new GridPane();
	
	//2d array 5x5 of GardenTile using GridPane
	
	private Stage theStage;
	
	private AnchorPane root;
	
	private Controller c;
	
	// length/width taken in by user preference
	//private int length = 5;
	//private int width = 5;
	private int length;
	private int width;
	private double colConstraint = 90.0;
	private double rowConstraint = 90.0;
	private final int selectionSize = 6;
	private final double maxTileEditSize = 50.0;
	private final double selectionGPsize = 100.0;
	
	// Used as backdrops colors for selection gridpanes
	private ArrayList<ImageView> backdropColor = new ArrayList<ImageView>();
	
	// used to hold images of more n less light and water
	private ArrayList<ImageView> tileEdit = new ArrayList<ImageView>();
	
	// used to tell if hovering over tile editorers array
	private boolean hoverEditTile = false;
	
	private boolean shown = false;
	private boolean customMode = false;
	
	private String[] flower;
	private String[] tree;
	private String[] shrub;
	private String[] path;
	private String[] other;
	
	private Popup infoPopup;
	private Label infoLabel;
	
	private int draggedTileEditorIdx;
	
	public DesignGarden(Controller controller,Stage s) {
		this.c = controller;
		theStage = s;
		
		plot = new GridPane();
		draggedTileEditorIdx=0;



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
	
	public GridPane getPathsGP() {
		return pathsGP;
	}
	public GridPane getOtherGP() {
		return otherGP;
	}
	
	@Override
	public String toString() {
		return "Design Mode";
	}
	
	@Override
	public void showScreen() {
		Instructions.setHighlightedSection(2);
		if (!shown) {
			drawScene();
			shown = true;
			if (customMode) {
				plot.getChildren().forEach(cell -> cell.setOnMouseClicked(c.getGardenTileClicked()));
			}
		}
		plot.getChildren().forEach(cell->cell.addEventHandler(MouseEvent.MOUSE_CLICKED, c.getRemoveFromTile()));
		plot.getChildren().forEach(cell->cell.setOnMouseEntered(c.getHoverEmptyTiles()));
		//plot.getChildren().forEach(cell->cell.setOnDragDropped(null));
		
		theStage.setTitle("Design Mode");
		theStage.setScene(designGardenScene);
		theStage.show();
		
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
	
	public void setUpTabs() {
		// arrays to traverse the gridPanes and their respective names
		Tab tabArr[] = {plants,trees,shrubs,pathways,otherOptions};
		GridPane gpArr[] = {plantsGP,treesGP,shrubsGP,pathsGP,otherGP};
		String tabNames[] = {"Plants","Trees","Shrubs","Pathways","Other"};
		ImageView backdrop[][] = new ImageView[selectionSize][selectionSize];
		ArrayList<ImageView> backdropColor = new ArrayList<ImageView>();
		for(int i=0; i<selectionSize;i++) {
			for(int j=0; j<selectionSize;j++) {
				ImageView imv1 = new ImageView("img/plantSelectionBackdrop.jpg");
				imv1.setPreserveRatio(true);
				imv1.setFitHeight(100);
				imv1.setFitWidth(100);
				backdrop[i][j] = imv1;
			}//for
		}//for
		
		
		
		for(int i=0;i<selectionSize;i++) {
			
			//setting up
			Tab tab = new Tab(tabNames[i]);
			tab.setClosable(false);
			tabArr[i] = tab;
			tabArr[i].setContent(gpArr[i]);
			
			// max size of items
			gpArr[i].setMaxSize(selectionGPsize, selectionGPsize);
			//adding row
			gpArr[i].getRowConstraints().add(new RowConstraints(selectionGPsize));
			for (int j = 0; j < selectionSize; j++) {
		         ColumnConstraints column = new ColumnConstraints(selectionGPsize);
		         gpArr[j].getColumnConstraints().add(column);
		         gpArr[j].getChildren().add(backdrop[i][j]);
			}
			
			gpArr[i].getChildren().forEach(cell -> cell.setOnMouseEntered(c.getMouseEnterPlantSelection()));
			
			gpArr[i].setGridLinesVisible(true);
			
			selectGardenType.getTabs().add(tabArr[i]);
		}
		
		plants.setClosable(false);
	}//setUpTabs

	public void drawScene() {
		c.setSelectionArrs();
		//
		System.out.println("drawing scene");
		length = c.getWidthFromModel();
		width = c.getLengthFromModel();
		
		infoPopup = new Popup();
		infoLabel = new Label();
		infoLabel.setBackground(View.settingsBackground);
		infoLabel.setMinSize(320,200);
		infoLabel.setAlignment(Pos.CENTER);
		infoPopup.getContent().add(infoLabel);
		//infoPopup.setAutoHide(true);
		infoPopup.setAnchorX(1000);
		infoPopup.setAnchorY(700);
		
		
		
		
		//gardenPlot = c.getModel().getUserPlot();
		Insets selectionGPInsets = new Insets(7.5);
		
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
		
		tileEdit.forEach(imgV -> imgV.setOnDragDetected(c.getStartDragForTileEditors()));
		
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
//tileEditingGP.getChildren().forEach(cell -> cell.setOnDragDetected(c.getDragTileEditors()));




//root AnchorPane
//AnchorPane root = new AnchorPane();
root = new AnchorPane();



//Tab Pane at top of screen to select plants/trees/paths/other
selectGardenType = new TabPane();
selectGardenType.setMinSize(selectionGPsize*8,150);
selectGardenType.setMaxSize(selectionGPsize*8, 150);


plants = new Tab("Plants");
plants.setClosable(false);
//setting up the Plant selection gridPane
ScrollPane plantsSP = new ScrollPane();
plantsSP.setPrefSize(selectionGPsize, selectionGPsize*3);
plantsSP.setContent(plantsGP);
plantsSP.setVbarPolicy(ScrollBarPolicy.NEVER);
plantsSP.setHbarPolicy(ScrollBarPolicy.ALWAYS);
plants.setContent(plantsSP);

// max size of items
plantsGP.setMaxSize(selectionGPsize, selectionGPsize);
//adding row
plantsGP.getRowConstraints().add(new RowConstraints(selectionGPsize));
plantsGP.setBackground(new Background(new BackgroundFill(Color.web("#D4D4DC"), CornerRadii.EMPTY, Insets.EMPTY)));

pSelectionArr = new ArrayList<ImageView>();
//setting up with each different picture
for(int i=0; i<flower.length;i++) {
	Image img = new Image(flower[i]);
	ImageView imgV = new ImageView(img);
	imgV.setPreserveRatio(true);
	imgV.setFitHeight(100-15);
	imgV.setFitWidth(100-15);
	imgV.setOnDragDetected(c.getStartDrag());
	pSelectionArr.add(imgV);
}

for (int i = 0; i < flower.length; i++) {
     ColumnConstraints column = new ColumnConstraints(selectionGPsize);
     plantsGP.getColumnConstraints().add(column);
     //plantsGP.add(backdropColor.get(i), i, 0,1,1);
     HBox hbox = new HBox(pSelectionArr.get(i));
     hbox.setAlignment(Pos.CENTER);
     hbox.setPadding(selectionGPInsets);
   	 plantsGP.add(hbox, i, 0,1,1);
     
}

plantsGP.getChildren().forEach(cell -> cell.setOnMouseEntered(c.getMouseEnterPlantSelection()));

plantsGP.setGridLinesVisible(true);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

shrubs = new Tab("Shrubs");
//setting up the Plant selection gridPane
shrubs.setClosable(false);
ScrollPane shrubsSP = new ScrollPane();
shrubsSP.setContent(shrubsGP);
//shrubsSP.setPrefSize(selectionGPsize, selectionGPsize*3);
shrubsSP.setVbarPolicy(ScrollBarPolicy.NEVER);
shrubsSP.setHbarPolicy(ScrollBarPolicy.ALWAYS);
shrubs.setContent(shrubsSP);


shrubSelArr = new ArrayList<ImageView>();
//setting up with each different picture
for(int i=0; i<shrub.length;i++) {
	Image img = new Image(shrub[i]);
	ImageView imgV = new ImageView(img);
	imgV.setPreserveRatio(true);
	imgV.setFitHeight(100-15);
	imgV.setFitWidth(100-15);
	imgV.setOnDragDetected(c.getStartDrag());
	shrubSelArr.add(imgV);
}
shrubsGP.getRowConstraints().add(new RowConstraints(selectionGPsize));
shrubsGP.setBackground(new Background(new BackgroundFill(Color.web("#D4DCDB"), CornerRadii.EMPTY, Insets.EMPTY)));
for (int i = 0; i < shrub.length; i++) {
     ColumnConstraints column = new ColumnConstraints(selectionGPsize);
     shrubsGP.getColumnConstraints().add(column);
     //shrubsGP.add(backdropColor2.get(i), i, 0,1,1);
     HBox hbox = new HBox(shrubSelArr.get(i));
     hbox.setAlignment(Pos.CENTER);
     hbox.setPadding(selectionGPInsets);
     shrubsGP.add(hbox, i, 0,1,1);
     
}

shrubsGP.getChildren().forEach(cell -> cell.setOnMouseEntered(c.getMouseEnterPlantSelection()));
shrubsGP.setGridLinesVisible(true);


////////////////////////////////////////////////////////////////////////////////////////////////////////////

trees = new Tab("Trees");
trees.setClosable(false);
ScrollPane treesSP = new ScrollPane();
treesSP.setVbarPolicy(ScrollBarPolicy.NEVER);
treesSP.setHbarPolicy(ScrollBarPolicy.ALWAYS);
treesSP.setContent(treesGP);
trees.setContent(treesSP);


// max size of items
treesGP.setMaxSize(selectionGPsize, selectionGPsize);
//adding row
treesGP.getRowConstraints().add(new RowConstraints(selectionGPsize));
treesGP.setBackground(new Background(new BackgroundFill(Color.web("#B1B1B2"), CornerRadii.EMPTY, Insets.EMPTY)));
//String[] tree = {"PlantPictures/Box_Elder.jpg","PlantPictures/Cigar_Tree.jpg"};

treeSelArr = new ArrayList<ImageView>();
//setting up with each different picture
for(int i=0; i<tree.length;i++) {
	Image img = new Image(tree[i]);
	ImageView imgV = new ImageView(img);
	imgV.setPreserveRatio(true);
	imgV.setFitHeight(100-15);
	imgV.setFitWidth(100-15);
	imgV.setOnDragDetected(c.getStartDrag());
	treeSelArr.add(imgV);
}
for (int i = 0; i < tree.length; i++) {
     ColumnConstraints column = new ColumnConstraints(selectionGPsize);
     treesGP.getColumnConstraints().add(column);
     //treesGP.add(backdropColor4.get(i), i, 0,1,1);
     HBox hbox = new HBox(treeSelArr.get(i));
     hbox.setPadding(selectionGPInsets);
     hbox.setAlignment(Pos.CENTER);
    	 treesGP.add(hbox, i, 0,1,1);
     
}

treesGP.getChildren().forEach(cell -> cell.setOnMouseEntered(c.getMouseEnterPlantSelection()));

treesGP.setGridLinesVisible(true);

////////////////////////////////////////////////////////////////////////////////////////////////////////////

pathways = new Tab("Pathways");
pathways.setClosable(false);
ScrollPane pathwaysSP = new ScrollPane();
pathwaysSP.setVbarPolicy(ScrollBarPolicy.NEVER);
pathwaysSP.setHbarPolicy(ScrollBarPolicy.ALWAYS);
pathwaysSP.setContent(pathsGP);
pathways.setContent(pathwaysSP);



// max size of items
pathsGP.setMaxSize(selectionGPsize, selectionGPsize);
//adding row
pathsGP.getRowConstraints().add(new RowConstraints(selectionGPsize));
pathsGP.setBackground(new Background(new BackgroundFill(Color.web("#DEDEDE"), CornerRadii.EMPTY, Insets.EMPTY)));


for (int i = 0; i < path.length; i++) {
	Image img = new Image(path[i]);
	ImageView imgV = new ImageView(img);
	imgV.setPreserveRatio(true);
	imgV.setFitHeight(100-15);
	imgV.setFitWidth(100-15);
	imgV.setOnDragDetected(c.getStartDrag()); 
	
	ColumnConstraints column = new ColumnConstraints(selectionGPsize);
     pathsGP.getColumnConstraints().add(column);
     HBox hbox = new HBox(imgV);
     hbox.setPadding(selectionGPInsets);
     hbox.setAlignment(Pos.CENTER);
     pathsGP.add(hbox, i, 0,1,1);
}

pathsGP.getChildren().forEach(cell -> cell.setOnMouseEntered(c.getMouseEnterPlantSelection()));

pathsGP.setGridLinesVisible(true);



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

otherOptions = new Tab("Other");
otherOptions.setClosable(false);
ScrollPane otherSP = new ScrollPane();
otherSP.setVbarPolicy(ScrollBarPolicy.NEVER);
otherSP.setHbarPolicy(ScrollBarPolicy.ALWAYS);
otherSP.setContent(otherGP);
otherOptions.setContent(otherSP);



// max size of items
otherGP.setMaxSize(selectionGPsize, selectionGPsize);
//adding row
otherGP.getRowConstraints().add(new RowConstraints(selectionGPsize));
otherGP.setBackground(new Background(new BackgroundFill(Color.web("#CDCECE"), CornerRadii.EMPTY, Insets.EMPTY)));
for (int i = 0; i < other.length; i++) {
    
     
    Image img = new Image(other[i]);
 	ImageView imgV = new ImageView(img);
 	imgV.setPreserveRatio(true);
 	imgV.setFitHeight(100-15);
 	imgV.setFitWidth(100-15);
 	imgV.setOnDragDetected(c.getStartDrag()); 
 	
 	ColumnConstraints column = new ColumnConstraints(selectionGPsize);
      otherGP.getColumnConstraints().add(column);
      HBox hbox = new HBox(imgV);
      hbox.setPadding(selectionGPInsets);
      hbox.setAlignment(Pos.CENTER);
      otherGP.add(hbox, i, 0,1,1);
   
}

otherGP.getChildren().forEach(cell -> cell.setOnMouseEntered(c.getMouseEnterPlantSelection()));

otherGP.setGridLinesVisible(true);

selectGardenType.getTabs().addAll( plants, trees, shrubs, pathways, otherOptions);

AnchorPane.setTopAnchor(selectGardenType, 40.0);
AnchorPane.setLeftAnchor(selectGardenType, 40.0);


// Other features buttons (recs and seasons) in AnchorPane
recommendations = new Button("Recommendations");
changeSeasons = new Button("Change Seasons");
infoTips = new Button("Info and Tips");
save = new Button("Save Garden");
finalView = new Button("Finish");
instructions = new Button("Instructions");

recommendations.setMinSize(200.0,40.0);
changeSeasons.setMinSize(200.0,40.0);
infoTips.setMinSize(200.0,40.0);
save.setMinSize(200.0, 40.0);
finalView.setMinSize(200.0, 40.0);
instructions.setMinSize(200.0, 40.0);

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

//Instructions Button
instructions.setOnMouseClicked(c.getInstructionShow());

AnchorPane apButtons = new AnchorPane();
Label tileEditors = new Label("Tile Editors");
Label otherFeaturesLabel = new Label("Other Features: ");
AnchorPane.setTopAnchor(otherFeaturesLabel, 60.0);
AnchorPane.setTopAnchor(recommendations, 120.0);
AnchorPane.setTopAnchor(changeSeasons, 180.0);
AnchorPane.setTopAnchor(infoTips, 240.0);
AnchorPane.setTopAnchor(save, 300.0);
AnchorPane.setTopAnchor(instructions, 360.0);
AnchorPane.setTopAnchor(finalView, 420.0);
AnchorPane.setTopAnchor(tileEditors, 480.0);
AnchorPane.setTopAnchor(tileEditingGP, 500.0);

apButtons.getChildren().addAll(recommendations, changeSeasons, otherFeaturesLabel, infoTips, save, finalView,instructions,tileEditors,tileEditingGP);


AnchorPane.setTopAnchor(apButtons, 40.0);
AnchorPane.setRightAnchor(apButtons, 60.0);

Label emptySpace = new Label("		");
Label emptySpace2 = new Label("		");
Label emptySpace3 = new Label("		");
Label emptySpace4 = new Label("		");
Label emptySpace5 = new Label("		");

plot = View.drawGrid(c,true);
plot.setMaxSize(300.0, 300.0);

for (int i = 0; i < length; i++) {
     ColumnConstraints column = new ColumnConstraints(90);
     plot.getColumnConstraints().add(column);
 }
for (int i = 0; i < width; i++) {
     RowConstraints row = new RowConstraints(90);
     plot.getRowConstraints().add(row);
 }

//Drag and drop for normal use of adding plants
plot.setOnDragOver(c.getDetectDrag());
plot.setOnDragDropped(c.getDetectDragDrop());


AnchorPane.setTopAnchor(plot, 200.0);
AnchorPane.setLeftAnchor(plot, 40.0);

root.getChildren().addAll(apButtons, selectGardenType, plot);
designGardenScene = new Scene(root,View.primarySceneWidth,View.primarySceneHeight);



}

	public int getLength() {
		return length;
	}
	public int getWidth() {
		return width;
	}
	public double getColConstraint(){
		return colConstraint;
	}
	public double getRowConstraint() {
		return rowConstraint;
	}
	
	
	
	/**
	 * Sets the arrays of image names for each plant tab with the given String arrays and sets custom mode depending on whether
	 * user has chosen the 'custom' template.
	 * @param flower the String[] containing the names of the images for Plants of habit 'Flower' in the user chosen season.
	 * @param tree the String[] containing the names of the images for Plants of habit 'Tree' in the user chosen season.
	 * @param shrub the String[] containing the names of the images for Plants of habit 'Shrub' in the user chosen season.
	 */
	public void setSelectionArrays(String[] flower,String[] tree, String[] shrub,String[] path,String[]other ) {
		this.flower = flower;
		this.tree = tree;
		this.shrub = shrub;
		this.path = path;
		this.other = other;
		
		customMode = c.getTemplateFromModel().toLowerCase().equals("custom");
	}
	
	/**
	 * Shows the information for the plant or addOn in the selection panes when hovered over.
	 * @param description
	 */
	public void showAddOnInfo(String description) {
		infoPopup.getContent().remove(infoLabel);
		infoLabel.setText(description);
		infoPopup.getContent().add(infoLabel);
		
		infoPopup.show(theStage);
		
	}
	
	/**
	 * Hides the popup for the Plant or AddOn information.
	 */
	public void hideAddOnInfo() {
		infoPopup.hide();
	}
	
	/**
	 * Sets the index of the tile editor that was dragged onto the grid. To be set by the Controller when the user starts a drag event
	 * on a tile.
	 * @param idx The index of the tile editor being dragged onto the grid.
	 * @see Controller#getStartDragForTileEditors()
	 */
	public void setDraggedTileEditorIdx(int idx) {
		draggedTileEditorIdx=idx;
	}
	
	/**
	 * Gets the index of the tile editor that was dragged onto the grid.
	 * @return the index of the tile editor that was dragged onto the grid.
	 */
	public int getDraggedTileEditorIdx() {
		return draggedTileEditorIdx;
	}
	
	
}
