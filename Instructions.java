import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Instructions extends View {
	private Label instructions;
	private Scene instructionsScene;
	private Stage instructionsStage;
	private String text;
	
	
	/**
	 * 
	 */
	public Instructions() {
		text = "instructions undefined";
		instructions = new Label(text);
		
		instructionsScene = new Scene(instructions);
		instructionsStage = new Stage();
		instructionsStage.setScene(instructionsScene);
	}
	
	/**
	 * 
	 * @return text
	 */
	public String getText() {
		return text;
	}
}
