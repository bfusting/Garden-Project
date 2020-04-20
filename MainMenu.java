import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainMenu extends View {
	Button createNewGarden;
	Button loadGarden;
	Image backgroundImage;
	Instructions instructions;
	
	/**
	 * 
	 * @param theStage
	 */
	public MainMenu(Stage theStage) {
		primaryStage = theStage;
		createNewGarden = new Button("Create New Garden");
		loadGarden = new Button("Load Garden");
	}
	
	/**
	 * 
	 */
	public void templatePopUp() {
		System.out.println("construct instructions popup");
	}
}
