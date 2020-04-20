import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ChooseTemplate extends View {
	ImageView squareTemplate;
	ImageView circleTemplate;
	ImageView triangleTemplate;
	ImageView designYourOwn;
	Button chooseSquare;
	Button chooseCircle;
	Button chooseTriangle;
	Button chooseDesign;
	
	/**
	 * 
	 * @param theStage
	 */
	public ChooseTemplate(Stage theStage) {
	
		primaryStage= theStage;
		
		squareTemplate = new ImageView(createImg("no image"));
		circleTemplate = new ImageView(createImg("no image"));
		triangleTemplate = new ImageView(createImg("no image"));
		designYourOwn = new ImageView(createImg("no image"));
	}
	
	/**
	 * 
	 */
	public void showDesignWindow() {
		
	}
	
	/*
	 * 
	 */
	public void showGardenPlot() {
		
	}
	
	/**
	 * 
	 */
	public void preferencesPopUp() {
		
	}
	
}
