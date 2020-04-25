import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * @author Kelsey McRae
 * <br> 
 * <br> The view in which the user designs their garden by dragging and dropping plants, trees, pathways, and other options.
 * Also contains buttons for recommendations, change of seasons, and plant info.
 *
 */

public class DesignGarden extends View{
	private int selectionArrLen;
	private int selectionArrWid;
	private ArrayList<Image> selectionArr;
	private TabPane plants;
	private TabPane tree;
	private TabPane pathways;
	private TabPane buildings;
	private GridPane plot;
	private Button recommendations;
	private Button changeSeasons;
	private int seasonIndexer;
	private Text plantInfo;
	private ArrayList<Image> imagesUsed;
	
	/**
	 * Updates the viewable array of plants, trees, etc able to be dragged into the garden.
	 */
	public void updateSelectionIndex() {
		
	}
	
	/**
	 * Creates the array of plants/trees/etc for the user to choose from based on local requirements and user preferences.
	 */
	public void createImageArray() {
		
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
	
//	@Override
	public void showDesignGarden(Stage stage) {

			stage.setTitle("Design Garden");
			AnchorPane root = new AnchorPane();
			
			recommendations = new Button("Recommendations");
			changeSeasons = new Button("Change Seasons");
			
			AnchorPane.setTopAnchor(recommendations, 40.0);
			AnchorPane.setRightAnchor(recommendations, 40.0);
			
			AnchorPane.setTopAnchor(changeSeasons, 70.0);
			AnchorPane.setRightAnchor(changeSeasons, 40.0);
			
			root.getChildren().addAll(recommendations,changeSeasons);
			
			Scene scene = new Scene(root,600,300);
			
			stage.setTitle("Design Garden");
			stage.setScene(scene);
			stage.show();
	}
	
	
}
