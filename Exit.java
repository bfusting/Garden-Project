import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


/**
 * 
 * @author Takiyah Price
 *
 */

public class Exit extends Screen {
	private Stage exitStage;
	private Scene exitWithSave;
	private Scene exitWithoutSave;
	private Button saveButton;
	private Button quitButton;
	private Button yesButton;
	private Button cancelButton;
	private Group root;
	private AnchorPane exitAP;
	
	public Exit(Controller c) {
		saveButton = new Button("Save and Quit");
		saveButton.setMinSize(100, 50);
		
		quitButton = new Button("Quit without Saving");
		quitButton.setMinSize(100, 50);
		yesButton = new Button("Yes");
		yesButton.setOnMouseClicked(c.getCloseAllWindows());
		
		yesButton.setMinSize(100, 50);
		cancelButton = new Button("Cancel");
		cancelButton.setMinSize(100,50);
		
		exitStage = new Stage();
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
	
		/*tPane.setTileAlignment(Pos.CENTER);
		tPane.setHgap(100);
		tPane.setPrefColumns(2);
		hbox.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGREY,CornerRadii.EMPTY,Insets.EMPTY)));
		hbox.setPadding(new Insets(60,50,60,50));
		hbox.getChildren().setAll(tPane);
		
		tPane.setMargin(hbox, Insets.EMPTY);
		root = new Group();
		root.getChildren().addAll(hbox,exitAP);*/
		
		
		//exitStage.show();
		
		
	}
	
	public void showExitWithSave() {
		HBox hbox = new HBox();
		hbox.getChildren().addAll(saveButton,quitButton);
		Scene exitScene = new Scene(root,400,120);
		exitStage.setScene(exitScene);
		
		
		exitWithSave = new Scene(hbox,400,120);
		exitStage.setScene(exitWithSave);
		exitStage.show();
	}
	
	public void showExitWithoutSave() {
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
		
		/*TilePane tPane = new TilePane();
		
		
		HBox hbox = new HBox(80);
		HBox textBox = new HBox();
		AnchorPane exitAP = new AnchorPane();
		Text text = new Text("Are you sure you want to quit?");
		textBox.getChildren().add(text);
		textBox.setAlignment(Pos.CENTER);
		text.setTextAlignment(TextAlignment.CENTER);
		text.setFont(Font.font("Arial",FontWeight.BOLD,16));
		AnchorPane.setTopAnchor(textBox, 20.0);
		AnchorPane.setLeftAnchor(textBox,85.0);
		//
		AnchorPane.setRightAnchor(textBox, 85.0);
		//
		exitAP.getChildren().add(textBox);
		exitAP.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGREY,CornerRadii.EMPTY,Insets.EMPTY)));
		
		tPane.getChildren().addAll(yesButton,cancelButton);
		tPane.setTileAlignment(Pos.CENTER);
		tPane.setHgap(100);
		
		tPane.setPrefColumns(2);
		hbox.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGREY,CornerRadii.EMPTY,Insets.EMPTY)));
		hbox.setPadding(new Insets(60,50,60,50));
		hbox.getChildren().setAll(tPane);
		
		tPane.setMargin(hbox, Insets.EMPTY);
		Group root = new Group();
		root.getChildren().addAll(hbox,exitAP);
		
		
		
		exitWithoutSave = new Scene(root,400,120);
		exitStage.setScene(exitWithoutSave);
		exitStage.show();*/
		
		
		/*HBox hbox = new HBox();
		AnchorPane exitAP = new AnchorPane();
		
		Text text = new Text("Are you sure you want to quit?");
		hbox.getChildren().add(text);
		hbox.setAlignment(Pos.CENTER);
		text.setTextAlignment(TextAlignment.CENTER);
		text.setFont(Font.font("Arial",FontWeight.BOLD,16));
		
		AnchorPane.setTopAnchor(hbox, 20.0);
		AnchorPane.setLeftAnchor(hbox, 80.0);
		AnchorPane.setRightAnchor(hbox,80.0);
		
		exitAP.getChildren().addAll(hbox,yesButton,cancelButton);
		
		
		exitWithoutSave = new Scene(exitAP,400,120);
		exitStage.setScene(exitWithoutSave);
		exitStage.show();*/
		
		/*HBox hbox = new HBox();
		//hbox.getChildren().addAll(yesButton,goBackButton);
		
		BorderPane bPane = new BorderPane();
		
		Text text = new Text("Are you sure you want to quit?");
		hbox.getChildren().add(text);
		hbox.setAlignment(Pos.CENTER);
		text.setTextAlignment(TextAlignment.CENTER);
		text.setFont(Font.font("Arial",FontWeight.BOLD,15));
		
		//AnchorPane textAP = new AnchorPane(hbox);
		//AnchorPane yesButtonAP = new AnchorPane(yesButton);
		//AnchorPane cancelButtonAP = new AnchorPane(cancelButton);
		
		//AnchorPane.setTopAnchor(hbox, 20.0);
		//AnchorPane.setTopAnchor(yesButton, 50.0);
		//AnchorPane.setTopAnchor(cancelButton, 50.0);
		//AnchorPane.setLeftAnchor(yesButton, 20.0);
		//AnchorPane.setRightAnchor(cancelButton, 20.0);
		//AnchorPane.setBottomAnchor(yesButton, 20.0);
		//AnchorPane.setBottomAnchor(cancelButton, 20.0);
		HBox yesBox = new HBox(yesButton);
		yesBox.setAlignment(Pos.CENTER);
		HBox cancelBox = new HBox(cancelButton);
		AnchorPane.setTopAnchor(yesBox, 40.0);
		AnchorPane.setTopAnchor(cancelBox,40.0);
		
		AnchorPane yesButtonAP = new AnchorPane();
		yesButtonAP.getChildren().add(yesBox);
		
		
		bPane.setTop(hbox);
		bPane.setLeft(yesButtonAP);
		//bPane.setRight(cancelButtonAP);
		//bPane.setLeft(yesBox);
		bPane.setRight(cancelBox);
		
		
		
		//exitWithoutSave = new Scene(hbox,300,200);
		exitWithoutSave = new Scene(bPane,400,120);
		exitStage.setScene(exitWithoutSave);
		exitStage.show();*/
	}
	
	public void closeExit() {
		exitStage.close();
	}
	
	
	
	
}
