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


/**
 * 
 * The Screen that allow the user to see their final garden they created as well as alternate possible versions.
 * <br>
 * <br>
 * @author Kelsey McRae
 *
 */
public class FinalView extends Screen {
	private Button edit;
	private Button infoTips;
	private Button viewSeasons;
	private Button save;
	
	private AnchorPane root;
	private Scene finalViewScene;
	private Stage theStage;
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
		theStage = s;
		
		root = new AnchorPane();
		
		originalGP = new GridPane();
		
		

		Rectangle r1 = new Rectangle(150, 100, 900, 500);
		r1.setStroke(Color.LIGHTGRAY);
		r1.setFill(Color.LIGHTGRAY);
		r1.setStrokeWidth(1);
		
		edit = new Button("Edit");
		infoTips = new Button("Info and Tips");
		viewSeasons = new Button("View Seasons");
		save = new Button("Save");
		Button exit = new Button("Exit");
		Button instructions = new Button("Instructions");
		//Binding Event handlers to buttons
		
		edit.setOnMouseClicked(c.getBackBTN());
		
		infoTips.setOnMouseClicked(c.getInfoTipsBTN());
		viewSeasons.setOnMouseClicked(c.getViewSeasonsBTN());
		save.setOnMouseClicked(c.getSaveBTN());
		exit.setOnMouseClicked(c.getExit());
		instructions.setOnMouseClicked(c.getInstructionShow());
		
		Button mainMenu = new Button("Main Menu");
		mainMenu.setOnMouseClicked(c.getMainMenuWarning());
		
		double buttonsBottom = 75.0;

		AnchorPane.setBottomAnchor(edit, buttonsBottom);
		AnchorPane.setBottomAnchor(viewSeasons, buttonsBottom);
		AnchorPane.setBottomAnchor(infoTips, buttonsBottom);
		AnchorPane.setBottomAnchor(save, buttonsBottom);
		AnchorPane.setBottomAnchor(exit, buttonsBottom);
		AnchorPane.setBottomAnchor(mainMenu, buttonsBottom);
		AnchorPane.setBottomAnchor(instructions, buttonsBottom);
		
		AnchorPane.setLeftAnchor(instructions,50.0);
		AnchorPane.setLeftAnchor(edit, 200.0);
		AnchorPane.setLeftAnchor(viewSeasons, 350.0);
		AnchorPane.setLeftAnchor(infoTips, 550.0);
		AnchorPane.setLeftAnchor(save, 780.0);
		AnchorPane.setLeftAnchor(exit, 980.0);
		AnchorPane.setLeftAnchor(mainMenu,1080.0);
		
		root.getChildren().addAll(edit, viewSeasons, infoTips, save,exit,mainMenu,instructions);
		
		
		root.getChildren().add(r1);
		finalViewScene = new Scene(root, canvasWidth, canvasHeight);
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
		Instructions.setHighlightedSection(3);
		root.getChildren().remove(originalGP);
		originalGP = View.drawGrid(c, false);
		AnchorPane.setTopAnchor(originalGP, 100.0);
		AnchorPane.setLeftAnchor(originalGP, 150.0);
		root.getChildren().add(originalGP);
		theStage.setTitle("Final View");
		theStage.setScene(finalViewScene);
		
	}
	
	@Override
	public String toString() {
		return "Final View";
	}
	


}
