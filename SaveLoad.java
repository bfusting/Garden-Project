import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SaveLoad extends View {
	FileChooser fileChooser;
	
	/**
	 * 
	 * @param theStage
	 */
	public SaveLoad(Stage theStage) {
		primaryStage= theStage;
		
		fileChooser = new FileChooser();
	}
	
	
}
