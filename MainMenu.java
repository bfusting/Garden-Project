import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainMenu extends View {
	private Button createNewGarden;
	private Button loadGarden;
	private Image backgroundImage;
	private Stage mainMenuStage;
	private Scene mainMenuScene;
	
	
	/**
	 * 
	 * @param theStage
	 */
	public MainMenu() {
		createNewGarden = new Button("Create New Garden");
		loadGarden = new Button("Load Garden");
		
		backgroundImage = new Image("no images");
	}
	
	/**
	 * 
	 */
	public void templatePopUp() {
		System.out.println("construct instructions popup");
	}
	
	/**
	 * 
	 * @param theStage
	 */
	public void showMainMenu(Stage theStage) {
		
	}
}
