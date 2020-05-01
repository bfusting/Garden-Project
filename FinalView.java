import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
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
	
	private Scene finalViewScene;
	
	private Controller c;
	
	/**
	 * The constructor of FinalView
	 * 
	 * @param: ogPlot The original garden plot that was designed by the user.
	 */
	
	public FinalView(Controller controller) {
		this.c = controller;
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
		
		
		AnchorPane root = new AnchorPane();
		

		Rectangle r1 = new Rectangle(100, 100, 300, 250);
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
		
		edit.setOnMouseClicked(c.getDesignTime());
		infoTips.setOnMouseClicked(c.getInfoTipsBTN());
		viewSeasons.setOnMouseClicked(c.getViewSeasonsBTN());
		save.setOnMouseClicked(c.getSaveBTN());
		exit.setOnMouseClicked(c.getExit());
		

		root.setTopAnchor(edit, 400.0);
		root.setTopAnchor(viewSeasons, 400.0);
		root.setTopAnchor(infoTips, 400.0);
		root.setTopAnchor(save, 400.0);
		root.setTopAnchor(exit, 400.0);
		
		root.setLeftAnchor(edit, 75.0);
		root.setLeftAnchor(viewSeasons, 130.0);
		root.setLeftAnchor(infoTips, 250.0);
		root.setLeftAnchor(save, 360.0);
		root.setLeftAnchor(exit, 420.0);
		
		root.getChildren().addAll(edit, viewSeasons, infoTips, save,exit);

		
//		Label fv = new Label ("This is final view");
//		AnchorPane.setTopAnchor(fv, 100.0);
		
		
		root.getChildren().add(r1);
		finalViewScene = new Scene(root, 500.0, 500.0);
		
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


}
