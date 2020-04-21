import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


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
	
	
	
	
	public void updateSelectionIndex() {
		
	}
	
	public void createImageArray() {
		
	}
	
	public void openRecommendations() {
		
	}
	
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
