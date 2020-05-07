import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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

//last edited: 5-7-20 6:40AM

public class Exit extends Screen {
	private Stage exitStage;
	//private Scene exitWithSave;
	//private Scene exitWithoutSave;
	private Button saveButton;
	private Button quitButton;
	//private Button yesButton;
	private Button cancelButton;
	private Group root;
	private AnchorPane exitAP;
	
	private final int BtnMinWidth = 100;
	private final int BtnMinHeight = 50;
	private final int BtnPrefWidth = 140;
	private final int fontSize = 16;
	private final double distFromTop = 20.0;
	private final double distFromSides = 80.0; 
	private final int hGap = 100;
	private final int columns = 2;
	private final double offsetTopBottom = 60;
	private final double offsetRightLeft = 50;
	private final int exitStageWidth = 400;
	private final int exitStageHeight = 120;
	
	public Exit(Controller c) {
		saveButton = new Button("Save and Quit");
		saveButton.setMinSize(BtnMinWidth, BtnMinHeight);
		saveButton.setOnMouseClicked(c.getSaveBTN());
		saveButton.setPrefWidth(BtnPrefWidth);
		
		//quitButton = new Button("Quit without Saving");
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
		
		/*
		HBox textBox = new HBox();
		exitAP = new AnchorPane();
		Text text = new Text("Are you sure you want to quit?");
		
		textBox.getChildren().add(text);
		textBox.setAlignment(Pos.CENTER);
		text.setTextAlignment(TextAlignment.CENTER);
		text.setFont(Font.font("Arial",FontWeight.BOLD,fontSize));
		AnchorPane.setTopAnchor(textBox, distFromTop);
		AnchorPane.setLeftAnchor(textBox,distFromSides);
		AnchorPane.setRightAnchor(textBox, distFromSides);
		
		exitAP.getChildren().add(textBox);
		exitAP.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGREY,CornerRadii.EMPTY,Insets.EMPTY)));
	
		*/
		
		
	}
	
	/**
	 * 
	 */
	public void showExitWithSave() {
		super.getPreviousScreen().setUneditable();
		
		ImageView tools = new ImageView(new Image("/imageedit_1_3152080240.png",70,70,true,true));
		tools.setX((500-70)/2);
		tools.setY(0);
		root = new Group();
		GridPane gp = new GridPane();
		Color bgColor = Color.web("#B2DCE0");
		gp.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY,new Insets(6))));
		gp.setGridLinesVisible(false);
		gp.setVgap(5);
		gp.setMinSize(500, 200);
		gp.setMaxSize(500,200);
		gp.setAlignment(Pos.TOP_CENTER);
		gp.setBorder(new Border(new BorderStroke(Color.web("#5a6453"),BorderStrokeStyle.SOLID,CornerRadii.EMPTY,new BorderWidths(4))));
		
		
		Text exitMessage = new Text("Are you sure you want to quit?");
		exitMessage.setTextAlignment(TextAlignment.CENTER);
		exitMessage.setFont(Font.font("Verdana",FontWeight.BOLD,fontSize));
		
		Text warning = new Text("(Any unsaved changes may be lost.)");
		warning.setTextAlignment(TextAlignment.CENTER);
		warning.setFont(Font.font("Verdana",FontPosture.ITALIC,14));
		warning.setFill(Color.web("#595e64"));
		
		Rectangle left = new Rectangle(220,4,Color.web("#5a6453"));
		Rectangle right = new Rectangle(220,4,Color.web("#5a6453"));
		TilePane toolsPane = new TilePane(left,right);
		toolsPane.setMinHeight(70);
		toolsPane.setAlignment(Pos.CENTER_LEFT);
		toolsPane.setHgap(60);
		
		TilePane textPane = new TilePane(exitMessage,warning);
		textPane.setVgap(5);
		textPane.setHgap(200);
		textPane.setAlignment(Pos.BASELINE_CENTER);
		
		quitButton.setText("Quit without Saving");
		cancelButton.setMinWidth(140);
		//TilePane buttonPane = new TilePane(saveButton,quitButton,cancelButton);
		//buttonPane.setPadding(new Insets(15));
		//buttonPane.setHgap(20);
		GridPane buttonPane = new GridPane();
		buttonPane.setMinWidth(500);
		ColumnConstraints buttonW = new ColumnConstraints(140);
		buttonPane.getColumnConstraints().addAll(buttonW,buttonW,buttonW);
		buttonPane.setPadding(new Insets(10));
		buttonPane.setHgap(20);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.add(saveButton, 0, 2);
		buttonPane.add(cancelButton, 1, 2 );
		buttonPane.add(quitButton, 2, 2);
		
		
		
		
		//gp.setHgap(30);
		gp.add(toolsPane, 0, 0);
		gp.add(textPane,0,1);
		gp.add(buttonPane, 0, 2);
		
		root.getChildren().addAll(gp,tools);
		Scene exitScene = new Scene(root,500,200);
		exitStage.setScene(exitScene);
		exitStage.show();
		/*//need to fix button positions
		super.getPreviousScreen().setUneditable();
		TilePane tPane = new TilePane();
		quitButton.setText("Quit without Saving");
		tPane.getChildren().addAll(saveButton,quitButton,cancelButton);
		HBox hbox = new HBox();
		tPane.setTileAlignment(Pos.CENTER);
		tPane.setHgap(60);
		tPane.setPrefColumns(columns);
		hbox.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGREY,CornerRadii.EMPTY,Insets.EMPTY)));
		hbox.setPadding(new Insets(60,40,60,25));
		hbox.getChildren().setAll(tPane);
		
		TilePane.setMargin(hbox, Insets.EMPTY);
		root = new Group();
		root.getChildren().addAll(hbox,exitAP);
		
		//
		
		
		Scene exitScene = new Scene(root,exitStageWidth,exitStageHeight);
		exitStage.setScene(exitScene);
		exitStage.show();*/
		
		
		
		
		
		
	}
	
	/**
	 * 
	 */
	public void showExitWithoutSave() {
		/*super.getPreviousScreen().setUneditable();
		
		TilePane tPane = new TilePane();
		HBox hbox = new HBox();
		tPane.setTileAlignment(Pos.CENTER);
		tPane.setHgap(hGap);
		tPane.setPrefColumns(columns);
		hbox.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGREY,CornerRadii.EMPTY,Insets.EMPTY)));
		hbox.setPadding(new Insets(offsetTopBottom,offsetRightLeft,offsetTopBottom,offsetRightLeft));
		hbox.getChildren().setAll(tPane);
		
		TilePane.setMargin(hbox, Insets.EMPTY);
		root = new Group();
		root.getChildren().addAll(hbox,exitAP);
		
		
		quitButton.setText("Yes");
		tPane.getChildren().addAll(quitButton,cancelButton);
		
		Scene exitScene = new Scene(root,exitStageWidth,exitStageHeight);
		exitStage.setScene(exitScene);
		exitStage.show();*/
		
		
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
	

	
	
	
}
