

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * Screen that handles the creation and presentation of the exit screen, which asks the user if
 * they are sure they want to quit the program, or gives the options of saving with or without quitting
 * and canceling if the Screen currently in control of the primaryStage is one that has a save feature.
 * 
 * @see Screen
 * 
 * @author Takiyah Price
 *
 */

//last edited: 5-7-20 12:15PM

public class Exit extends Screen {
	private Stage exitStage;
	
	private Button saveButton;
	private Button quitButton;
	
	private Button cancelButton;
	private Group root;

	
	
	
	private GridPane gp;
	private Text exitMessage;
	private Text warning;
	private Rectangle left;
	private Rectangle right;
	private TilePane toolsPane;
	private TilePane textPane;
	private GridPane buttonPane;
	private Scene exitScene;
	
	/**
	 * Constructor for the Exit Screen. Asks the user for confirmation of intent to close the application, with the option of saving
	 * first if they have started creating or editing.
	 * @param c the Controller, which manages the event handlers for the buttons on this screen.
	 */
	public Exit(Controller c) {
		final int BtnMinWidth = 140;
		final int BtnMinHeight = 50;
		final int exitStageWidth = 500;
		final int exitStageHeight = 200;
		final int outsideBorder = 4;
		final int insideBorder = 6;
		final int toolIconDimensions = 70;
		final int rowDist = 5;
		final int headingFontSize = 16;
		final int subheadingFontSize = 14;
		final int lineWidth = 220;
		final int lineDist = 60;
		final int btnDist = 20;
		final int btnPaddingAmt = 10;
		
		saveButton = new Button("Save and Quit");
		saveButton.setMinSize(BtnMinWidth, BtnMinHeight);
		saveButton.setOnMouseClicked(c.getSaveBTN());
		
		
		quitButton = new Button();
		quitButton.setMinSize(BtnMinWidth, BtnMinHeight);
		quitButton.setOnMouseClicked(c.getCloseAllWindows());
	
		
		cancelButton = new Button("Cancel");
		cancelButton.setMinSize(BtnMinWidth,BtnMinHeight);
		cancelButton.setOnMouseClicked(c.getBackBTN());
		
		exitStage = new Stage(StageStyle.UNDECORATED);
		exitStage.initModality(Modality.APPLICATION_MODAL);
		exitStage.setAlwaysOnTop(true);
		//
		
		root = new Group();
		
		
		
		ImageView tools = new ImageView(new Image("/imageedit_1_3152080240.png",toolIconDimensions,toolIconDimensions,true,true));
		tools.setX((exitStageWidth-toolIconDimensions)/2);
		tools.setY(0);
		
		
		
		Color bgColor = Color.web("#B2DCE0");
		Color borderColor = Color.web("#5a6453");
		Color warningTextColor = Color.web("#595e64");
		
		gp = new GridPane();
		gp.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY,new Insets(insideBorder))));
		gp.setGridLinesVisible(false);
		gp.setVgap(rowDist);
		gp.setMinSize(exitStageWidth, exitStageHeight);
		gp.setMaxSize(exitStageWidth,exitStageHeight);
		gp.setAlignment(Pos.TOP_CENTER);
		gp.setBorder(new Border(new BorderStroke(borderColor,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,new BorderWidths(outsideBorder))));
		
		exitMessage = new Text("Are you sure you want to quit?");
		exitMessage.setTextAlignment(TextAlignment.CENTER);
		exitMessage.setFont(Font.font("Verdana",FontWeight.BOLD,headingFontSize));
		
		warning = new Text("(Any unsaved changes may be lost.)");
		warning.setTextAlignment(TextAlignment.CENTER);
		warning.setFont(Font.font("Verdana",FontPosture.ITALIC,subheadingFontSize));
		warning.setFill(warningTextColor);
		
		Rectangle left = new Rectangle(lineWidth,outsideBorder,borderColor);
		Rectangle right = new Rectangle(lineWidth,outsideBorder,borderColor);
		TilePane toolsPane = new TilePane(left,right);
		toolsPane.setMinHeight(toolIconDimensions);
		toolsPane.setAlignment(Pos.CENTER_LEFT);
		toolsPane.setHgap(lineDist);
		
		TilePane textPane = new TilePane(exitMessage,warning);
		textPane.setVgap(rowDist);
		textPane.setHgap(exitStageWidth);
		textPane.setAlignment(Pos.BASELINE_CENTER);
		
		buttonPane = new GridPane();
		buttonPane.setMinWidth(exitStageWidth);
		ColumnConstraints buttonW = new ColumnConstraints(BtnMinWidth);
		buttonPane.getColumnConstraints().addAll(buttonW,buttonW,buttonW);
		buttonPane.setPadding(new Insets(btnPaddingAmt));
		buttonPane.setHgap(btnDist);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.add(saveButton, 1, 2);
		buttonPane.add(cancelButton, 0, 2 );
		buttonPane.add(quitButton, 2, 2);
		
		gp.add(toolsPane, 0, 0);
		gp.add(textPane,0,1);
		gp.add(buttonPane, 0, 2);
		
		root.getChildren().addAll(gp,tools);
		exitScene = new Scene(root,exitStageWidth,exitStageHeight);
		exitStage.setScene(exitScene);
		

	}
	
	
	
	
	
	@Override
	public void goToPreviousScreen() {
		exitStage.close();
		System.out.println("Exit overrides gotToPreviousScreen to close its stage first");
		super.getPreviousScreen().setEditable();
	}
	
	@Override
	public String toString() {
		return "Exit Screen";
	}
	
	@Override
	public void closeScreen() {
		exitStage.close();
	}
	
	/**
	 * Makes the exit screen visible to the user by showing the exitScreen Stage. Warns the user that changes may be lost
	 * and gives the option of saving if they have reached a point that allows saving.
	 * @param exitCase a String representing the exit condition: whether the user is closing the application from a point that may have
	 * unsaved changes or going back to the main menu
	 * @see Screen#showScreen()
	 */
	public void showScreen(String exitCase) {
		super.getPreviousScreen().setUneditable();
		switch (exitCase){
		case ("exitSave"):
			
			
			/*saveButton.setVisible(true);
			warning.setVisible(true);
			quitButton.setText("Quit without Saving");
			break;*/
		
		case ("exitNoSave"):
			quitButton.setText("Proceed");
			saveButton.setVisible(false);
			warning.setVisible(false);
			break;
		case ("toMainMenu"):
			
			
		}
	
		exitStage.show();
	}
	
	

	
	
	
}
