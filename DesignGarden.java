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
	//private ArrayList<ImageView> underSelArr;
	// just drops a general addon into model
	// add case in controller so it works
	private ArrayList<ImageView> otherSelctionArr;
	
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
	
	//private Button indexLeft;
	//private Button indexRight;
	
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
	
	private String[] flower;
	private String[] tree;
	private String[] shrub;
	
	public DesignGarden(Controller controller,Stage s) {
		this.c = controller;
		theStage = s;
		
		plot = new GridPane();




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
		return "Design Garden";
	}
	
	@Override
	public void showScreen() {
		if (!shown) {
			drawScene();
			shown = true;
		}
		theStage.setTitle("Design Garden");
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
		gardenPlot = c.getModel().getUserPlot();
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

// setting up paths images
/*
String pathImgs[] = {"img/dirtPath.jpg","img/stonePath.jpg","img/brickPath.jpg"};
for(int i=0; i<selectionSize/2;i++) {
	ImageView imv = new ImageView(pathImgs[i]);
	imv.setPreserveRatio(true);
	imv.setFitHeight(selectionGPsize);
	imv.setFitWidth(selectionGPsize);
	imv.setOnDragDetected(c.getStartDrag());
	pathsArr.add(imv);
	//pathsGP.add(imv, i, 0);
}
*/

// setting up backupDrop with 6 images since that is the size of each gridPane
/*for(int i=0; i<flower.length;i++) {
	ImageView imv1 = new ImageView("img/plantSelectionBackdrop.jpg");
	imv1.setPreserveRatio(true);
	imv1.setFitHeight(100);
	imv1.setFitWidth(100);
	backdropColor.add(imv1);
}*/

//root AnchorPane
//AnchorPane root = new AnchorPane();
root = new AnchorPane();

/*indexLeft = new Button("<<<");
indexRight = new Button(">>>");

AnchorPane.setLeftAnchor(indexLeft, 10.0);
AnchorPane.setLeftAnchor(indexRight, 810.00);
AnchorPane.setTopAnchor(indexLeft, 120.0);
AnchorPane.setTopAnchor(indexRight,120.0);*/

//Tab Pane at top of screen to select plants/trees/paths/other
selectGardenType = new TabPane();
selectGardenType.setMinSize(selectionGPsize*8,150);
selectGardenType.setMaxSize(selectionGPsize*8, 150);


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

/*ArrayList<ImageView> backdropColor2 = new ArrayList<ImageView>();
for(int i=0; i<selectionSize;i++) {
	ImageView imv1 = new ImageView("img/plantSelectionBackdrop.jpg");
	imv1.setPreserveRatio(true);
	imv1.setFitHeight(100);
	imv1.setFitWidth(100);
	backdropColor2.add(imv1);
}*/

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
treesSP.setContent(treesGP);
trees.setContent(treesSP);

/*ArrayList<ImageView> backdropColor4 = new ArrayList<ImageView>();
for(int i=0; i<selectionSize;i++) {
	ImageView imv1 = new ImageView("img/plantSelectionBackdrop.jpg");
	imv1.setPreserveRatio(true);
	imv1.setFitHeight(100);
	imv1.setFitWidth(100);
	backdropColor4.add(imv1);
}*/

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
pathways.setContent(pathsGP);

ArrayList<ImageView> backdropColor5 = new ArrayList<ImageView>();
for(int i=0; i<selectionSize;i++) {
	ImageView imv1 = new ImageView("img/plantSelectionBackdrop.jpg");
	imv1.setPreserveRatio(true);
	imv1.setFitHeight(100);
	imv1.setFitWidth(100);
	backdropColor5.add(imv1);
}

// max size of items
pathsGP.setMaxSize(selectionGPsize, selectionGPsize);
//adding row
pathsGP.getRowConstraints().add(new RowConstraints(selectionGPsize));
for (int i = 0; i < selectionSize; i++) {
     ColumnConstraints column = new ColumnConstraints(selectionGPsize);
     pathsGP.getColumnConstraints().add(column);
     pathsGP.add(backdropColor5.get(i), i, 0,1,1);
}

pathsGP.getChildren().forEach(cell -> cell.setOnMouseEntered(c.getMouseEnterPlantSelection()));

pathsGP.setGridLinesVisible(true);

// setting up paths Arraylist of images to be displayed
ArrayList<ImageView> pathsArr = new ArrayList<ImageView>();
String pathImgs[] = {"img/dirtPath.jpg","img/stonePath.jpg","img/brickPath.jpg"};
for(int i=0; i<selectionSize/2;i++) {
	ImageView imv = new ImageView(pathImgs[i]);
	imv.setPreserveRatio(false);
	imv.setFitHeight(selectionGPsize*.9);
	imv.setFitWidth(selectionGPsize*.9);
	imv.setOnDragDetected(c.getStartDrag());
	pathsArr.add(imv);
	pathsGP.add(imv, i, 0);
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

otherOptions = new Tab("Other");
otherOptions.setContent(otherGP);

ArrayList<ImageView> backdropColor6 = new ArrayList<ImageView>();
for(int i=0; i<selectionSize;i++) {
	ImageView imv1 = new ImageView("img/plantSelectionBackdrop.jpg");
	imv1.setPreserveRatio(true);
	imv1.setFitHeight(100);
	imv1.setFitWidth(100);
	backdropColor6.add(imv1);
}

// max size of items
otherGP.setMaxSize(selectionGPsize, selectionGPsize);
//adding row
otherGP.getRowConstraints().add(new RowConstraints(selectionGPsize));
for (int i = 0; i < selectionSize; i++) {
     ColumnConstraints column = new ColumnConstraints(selectionGPsize);
     otherGP.getColumnConstraints().add(column);
     otherGP.add(backdropColor6.get(i), i, 0,1,1);
}

otherGP.getChildren().forEach(cell -> cell.setOnMouseEntered(c.getMouseEnterPlantSelection()));

otherGP.setGridLinesVisible(true);

// setting up paths Arraylist of images to be displayed
String otherImgs[] = {"img/rock.jpg","img/tikihut.jpg","img/sheshed.jpg",
		"img/flamingo.jpg","img/fountain.jpg"};
for(int i=0; i<selectionSize-1;i++) {
	ImageView imv = new ImageView(otherImgs[i]);
	imv.setPreserveRatio(false);
	imv.setFitHeight(selectionGPsize*.9);
	imv.setFitWidth(selectionGPsize*.9);
	imv.setOnDragDetected(c.getStartDrag());
	otherGP.add(imv, i, 0);
}

// Done setting up tabs

/*
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
*/

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

//trees.setContent(treesTP);

TilePane pathsTP = new TilePane();
pathsTP.setHgap(8);
pathsTP.setPrefColumns(5);
pathsTP.getChildren().addAll(new Label("Stone path"), new Label("Brick Path"), new Label("Straight up dirt"));

//pathways.setContent(pathsTP);

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
//otherTP.getChildren().addAll(new Label("Rock"), new Label("Tiki hut"), new Label("She-shed"), new Label("Bright pink flamingo"), new Label("Fountain"), new Label("General Building"));

//otherOptions.setContent(otherTP);

selectGardenType.getTabs().addAll( plants, trees, shrubs, pathways, otherOptions);

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
//plot = new GridPane();
plot = View.drawGrid(c);
/*soil = new ImageView[length][width];
for(int i=0; i<length; i++) {
	for(int j=0; j<width; j++) {
		soil[i][j] = new ImageView(new Image("img/soil.jpg"));
		soil[i][j].setPreserveRatio(true);
		soil[i][j].setFitHeight(89);
		soil[i][j].setFitWidth(89);
		plot.add(soil[i][j], i, j,1,1);
	}
/
	for (int i=0;i<c.getLengthFromModel();i++) {
		for (int j=0; j<c.getWidthFromModel();j++) {
				drawTile(i,j,c.getModel().get)
			
			
		}
	}*/


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

plot.setMaxSize(300.0, 300.0);
//plot.setMinSize(200.0, 200.0);
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

//plot.setGridLinesVisible(true);

root.setTopAnchor(plot, 200.0);
root.setLeftAnchor(plot, 40.0);


//root.getChildren().addAll(apButtons, selectGardenType, plot, indexLeft, indexRight);
root.getChildren().addAll(apButtons, selectGardenType, plot);
designGardenScene = new Scene(root,1200,800);



}

	
	/*public int increaseSelectionArrInd(int currentInd) {
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
	
	
	

	
	public Scene getDesignGardenScene() {
		return designGardenScene;
	}*/


	/**
	 * Creates the array of plants/trees/etc for the user to choose from based on local requirements and user preferences.
	 */
	/*public void createImageArray() {
		
	}
	
	public GridPane getPlot() {
		return plot;
	}*/
	
	
	
/*	/**
	 * Opens the recommendations 
	 *
	public void openRecommendations() {
		
	}
*/
	
	

	/*public Button getRecommendationsBTTN() {
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
	}*/
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
	
	/*@Override
	public String toString() {
		return "Design Garden";
	}
	
	@Override
	public void showScreen() {
		theStage.setTitle("Design Garden");
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
		Tab tabArr[] = {plants,trees,shrubs,undergrowth,pathways,otherOptions};
		GridPane gpArr[] = {plantsGP,treesGP,shrubsGP,underGP,pathsGP,otherGP};
		String tabNames[] = {"Plants","Trees","Shrubs","Undergrowth","Pathways","Other"};
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
			tabArr[i] = new Tab(tabNames[i]);
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
	}//setUpTabs*/

	/*public void drawTile(int row, int col,String addOnImgName) {
		ImageView soilImg = new ImageView(new Image("img/soil.jpg"));
		soilImg.setPreserveRatio(true);
		soilImg.setFitHeight(89);
		soilImg.setFitWidth(89);
		plot.add(soilImg, col, row,1,1);
		
		if  (addOnImgName.equals("inactive")) {
			//soilImg.setVisible(false);
			plot.getChildren().remove(soilImg);
		}
		else if (!addOnImgName.equals("")) {
			plot.add(new ImageView(new Image(addOnImgName)), col, row, 1,1);
		}
	}*/
	
	/*public void drawGridPane() {
		for (int i=0;i<c.getLengthFromModel();i++) {
			for (int j=0; j<c.getWidthFromModel();j++) {
				ImageView soilImg = new ImageView(new Image("img/soil.jpg"));
				soilImg.setPreserveRatio(true);
				soilImg.setFitHeight(89);
				soilImg.setFitWidth(89);
				plot.add(soilImg, j, i,1,1);
				
				if  (addOnImgName.equals("inactive")) {
					//soilImg.setVisible(false);
					plot.getChildren().remove(soilImg);
				}
				else if (!addOnImgName.equals("")) {
					plot.add(new ImageView(new Image(addOnImgName)), j, i, 1,1);
				}
				
				
			}
		}
	}*/
	
	/**
	 * Sets the arrays of image names for each plant tab with the given String arrays.
	 * @param flower the String[] containing the names of the images for Plants of habit 'Flower' in the user chosen season.
	 * @param tree the String[] containing the names of the images for Plants of habit 'Tree' in the user chosen season.
	 * @param shrub the String[] containing the names of the images for Plants of habit 'Shrub' in the user chosen season.
	 */
	public void setSelectionArrays(String[] flower,String[] tree, String[] shrub ) {
		this.flower = flower;
		this.tree = tree;
		this.shrub = shrub;
	}
	
}
