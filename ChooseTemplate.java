import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
	public ChooseTemplate() {
	
		
		squareTemplate = new ImageView(new Image("no image"));
		circleTemplate = new ImageView(new Image("no image"));
		triangleTemplate = new ImageView(new Image("no image"));
		designYourOwn = new ImageView(new Image("no image"));
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
	
	/**
	 * 
	 */
	public void showChooseTemplate() {
		
	}
	
}
