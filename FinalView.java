import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;

//Updated: 4/25 9:52
/**
 * 
 * @author Kelsey McRae
 * <br>
 * <br> The View that allow the user to see their final garden they created as well as alternate possible versions.
 *
 */
public class FinalView extends Screen {
	private Button edit;
	private Button infoTips;
	private Button viewSeasons;
	private Button save;
	private GardenPlot originalPlot;
	private GardenPlot plotIdea1;
	private GardenPlot plotIdea2;
	private GardenPlot plotIdea3;
	private AnchorPane root;
	private Scene finalViewScene;
	private Stage primaryStage;
	private Controller c;
	
	private GridPane originalGP;
	
	private int canvasHeight = 800;
	private int canvasWidth = 1200;
	
	/**
	 * The constructor of FinalView
	 * 
	 * @param: ogPlot The original garden plot that was designed by the user.
	 */
	
	public FinalView(Controller controller, Stage s) {
		this.c = controller;
		primaryStage = s;
	}
	
	public void setOriginalPlot(GardenPlot ogPlot) {
		this.originalPlot = ogPlot;
	}
	
	/**
	 * 
	 * @return plotIdea1 The first alternate version of the original garden plot designed by user.
	 */
	public GardenPlot getPlotIdea1() {
		return plotIdea1;
	}
	
	/**
	 * 
	 * @return plotIdea2 The second alternate version of the original garden plot designed by user.
	 */
	public GardenPlot getPlotIdea2() {
		return plotIdea2;
	}
	
	/**
	 * 
	 * @return plotIdea3 The third alternate version of the original garden plot designed by user.
	 */
	public GardenPlot getPlotIdea3() {
		return plotIdea3;
	}
	
	/**
	 * 
	 * @param plot1 The first alternate garden plot as generated by controller.
	 */
	public void setPlotIdea1(GardenPlot plot1) {
		this.plotIdea1 = plot1;
	}
	
	/**
	 * 
	 * @param plot2 The second alternate garden plot as generated by controller.
	 */
	
	public void setPlotIdea2(GardenPlot plot2) {
		this.plotIdea2 = plot2;
	}
	
	/**
	 * 
	 * @param plot3 The third alternate garden plot as generated by controller.
	 */
	
	public void setPlotIdea3(GardenPlot plot3) {
		this.plotIdea3 = plot3;
	}
	
	/**
	 * 
	 * Contains the buttons and views of the final garden options.
	 * 
	 * @param stage The stage for finalView's scene.
	 */
	public void showFinalView(Stage stage) {
		
		
		root = new AnchorPane();
		
		// creating OriginalGP Plot + making it move
		//originalGP = new GridPane();
		
		

		Rectangle r1 = new Rectangle(150, 100, 900, 500);
		r1.setStroke(Color.LIGHTGRAY);
		r1.setFill(Color.LIGHTGRAY);
		r1.setStrokeWidth(1);
		
//		AnchorPane buttons = new AnchorPane();
		
		edit = new Button("Edit");
		infoTips = new Button("Info and Tips");
		viewSeasons = new Button("View Seasons");
		save = new Button("Save");
		Button exit = new Button("Exit");
		//Binding Event handlers to buttons
		
<<<<<<< HEAD
		edit.setOnMouseClicked(c.getBackBTN());
=======
		edit.setOnMouseClicked(c.getDesignTime());
		//edit.setOnMouseClicked(c.getBackBTN());
		
>>>>>>> master
		infoTips.setOnMouseClicked(c.getInfoTipsBTN());
		viewSeasons.setOnMouseClicked(c.getViewSeasonsBTN());
		save.setOnMouseClicked(c.getSaveBTN());
		exit.setOnMouseClicked(c.getExit());
		
		
		Button mainMenu = new Button("Main Menu");
		mainMenu.setOnMouseClicked(c.getMainMenuWarning());

		root.setBottomAnchor(edit, 150.0);
		root.setBottomAnchor(viewSeasons, 150.0);
		root.setBottomAnchor(infoTips, 150.0);
		root.setBottomAnchor(save, 150.0);
		root.setBottomAnchor(exit, 150.0);
		root.setBottomAnchor(mainMenu, 150.0);
		
		root.setLeftAnchor(edit, 200.0);
		root.setLeftAnchor(viewSeasons, 350.0);
		root.setLeftAnchor(infoTips, 550.0);
		root.setLeftAnchor(save, 780.0);
		root.setLeftAnchor(exit, 980.0);
		root.setLeftAnchor(mainMenu,1080.0);
		
		root.getChildren().addAll(edit, viewSeasons, infoTips, save,exit,mainMenu);
		
		

		
//		Label fv = new Label ("This is final view");
//		AnchorPane.setTopAnchor(fv, 100.0);
		// setting up seasonsGP with controller
				originalGP = new GridPane();
				
				// setting up the seasonGP with the information from DesignGarden
				for (int i = 0; i < c.getView().getDesignGardenScreen().getLength(); i++) {
				     ColumnConstraints column = new ColumnConstraints(c.getView().getDesignGardenScreen()
				    		 .getColConstraint());
				     originalGP.getColumnConstraints().add(column);
				 }
				for (int i = 0; i < c.getView().getDesignGardenScreen().getWidth(); i++) {
				     RowConstraints row = new RowConstraints(c.getView().getDesignGardenScreen()
				    		 .getRowConstraint());
				     originalGP.getRowConstraints().add(row);
				 }
				
				originalGP.getChildren().addAll(c.getView().getDesignGardenScreen()
						.getPlot().getChildren());
		root.setTopAnchor(originalGP, 100.0);
		root.setLeftAnchor(originalGP, 150.0);
		
		root.getChildren().addAll(r1,originalGP);
		finalViewScene = new Scene(root, canvasWidth, canvasHeight);
		
		stage.setTitle("Final View");
		stage.setScene(finalViewScene);
		stage.show();
		
	}

	/**
	 * 
	 * @return edit - The Edit button
	 */
	public Button getEditBTTN() {
		return edit;
	}
	/**
	 * 
	 * @return infoTips - The Info and Tips button
	 */
	public Button getInfoTipsBTTN() {
		return infoTips;
	}
	/**
	 * 
	 * @return viewSeasons - The View Seasons button
	 */
	public Button getViewSeasonsBTTN() {
		return viewSeasons;
	}
	/**
	 * 
	 * @return save - The Save button
	 */
	public Button getSaveBTTN() {
		return save;
	}
	
	@Override
	public void setUneditable() {
		root.setDisable(true);
	}
	
	@Override
	public void setEditable() {
		root.setDisable(false);
	}
	
	@Override
	public void showScreen() {
		//should combine these into one show method
		showFinalView(primaryStage);
	}
	
	@Override
	public String toString() {
		return "Final View";
	}
	
	public GridPane getOriginalGP() {
		return originalGP;
	}

}
