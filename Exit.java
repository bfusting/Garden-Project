import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * 
 * @author Takiyah Price
 *
 */

//last edited: 4-29-20 12:30AM

public class Exit extends Screen {
	private static final StageStyle StageStyle = null;
	private Stage exitStage;
	//private Scene exitWithSave;
	//private Scene exitWithoutSave;
	private Button saveButton;
	private Button quitButton;
	private Button yesButton;
	private Button cancelButton;
	private Group root;
	private AnchorPane exitAP;

	
	public Exit(Controller c) {
		saveButton = new Button("Save and Quit");
		saveButton.setMinSize(100, 50);
		saveButton.setOnMouseClicked(c.getSaveAndQuit());
		saveButton.setPrefWidth(140);
		
		quitButton = new Button("Quit without Saving");
		quitButton.setMinSize(100, 50);
		quitButton.setOnMouseClicked(c.getCloseAllWindows());
		
		yesButton = new Button("Yes");
		yesButton.setOnMouseClicked(c.getCloseAllWindows());
		yesButton.setMinSize(100, 50);
		
		cancelButton = new Button("Cancel");
		cancelButton.setMinSize(100,50);
		cancelButton.setOnMouseClicked(c.getBackBTN());
		
		exitStage = new Stage(StageStyle.UNDECORATED);
		exitStage.initModality(Modality.APPLICATION_MODAL);
		exitStage.setAlwaysOnTop(true);
		//
		
		HBox textBox = new HBox();
		exitAP = new AnchorPane();
		Text text = new Text("Are you sure you want to quit?");
		
		textBox.getChildren().add(text);
		textBox.setAlignment(Pos.CENTER);
		text.setTextAlignment(TextAlignment.CENTER);
		text.setFont(Font.font("Arial",FontWeight.BOLD,16));
		AnchorPane.setTopAnchor(textBox, 20.0);
		AnchorPane.setLeftAnchor(textBox,85.0);
		AnchorPane.setRightAnchor(textBox, 85.0);
		
		exitAP.getChildren().add(textBox);
		exitAP.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGREY,CornerRadii.EMPTY,Insets.EMPTY)));
	
		
		
		
	}
	
	public void showExitWithSave() {
		super.getPreviousScreen().setUneditable();
		TilePane tPane = new TilePane();
		tPane.getChildren().addAll(saveButton,quitButton,cancelButton);
		HBox hbox = new HBox();
		tPane.setTileAlignment(Pos.CENTER);
		tPane.setHgap(60);
		tPane.setPrefColumns(2);
		hbox.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGREY,CornerRadii.EMPTY,Insets.EMPTY)));
		hbox.setPadding(new Insets(60,40,60,25));
		hbox.getChildren().setAll(tPane);
		
		TilePane.setMargin(hbox, Insets.EMPTY);
		root = new Group();
		root.getChildren().addAll(hbox,exitAP);
		
		//
		
		
		Scene exitScene = new Scene(root,400,120);
		exitStage.setScene(exitScene);
		exitStage.show();
		
		/*super.getPreviousScreen().setUneditable();
		TilePane tPane = new TilePane();
		tPane.getChildren().addAll(saveButton,quitButton);
		HBox hbox = new HBox();
		tPane.setTileAlignment(Pos.CENTER);
		tPane.setHgap(60);
		tPane.setPrefColumns(2);
		hbox.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGREY,CornerRadii.EMPTY,Insets.EMPTY)));
		hbox.setPadding(new Insets(60,40,60,25));
		hbox.getChildren().setAll(tPane);
		
		TilePane.setMargin(hbox, Insets.EMPTY);
		root = new Group();
		root.getChildren().addAll(hbox,exitAP);
		
		//
		
		
		Scene exitScene = new Scene(root,400,120);
		exitStage.setScene(exitScene);
		
		exitStage.show();*/
		
		
		
		
	}
	
	public void showExitWithoutSave() {
		super.getPreviousScreen().setUneditable();
		
		TilePane tPane = new TilePane();
		HBox hbox = new HBox();
		tPane.setTileAlignment(Pos.CENTER);
		tPane.setHgap(100);
		tPane.setPrefColumns(2);
		hbox.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGREY,CornerRadii.EMPTY,Insets.EMPTY)));
		hbox.setPadding(new Insets(60,50,60,50));
		hbox.getChildren().setAll(tPane);
		
		tPane.setMargin(hbox, Insets.EMPTY);
		root = new Group();
		root.getChildren().addAll(hbox,exitAP);
		
		//
		tPane.getChildren().addAll(yesButton,cancelButton);
		
		Scene exitScene = new Scene(root,400,120);
		exitStage.setScene(exitScene);
		exitStage.show();
		
		
	}
	
	/**
	 * 
	 */
	public void closeExit() {
		exitStage.close();
	}
	/**
	 * 
	 */
	@Override
	public void goToPreviousScreen() {
		exitStage.close();
		
		super.getPreviousScreen().show();
	}
	
	@Override
	public String toString() {
		return "Exit Screen";
	}
	
	
}
