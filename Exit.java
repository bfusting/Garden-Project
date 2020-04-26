/**
 * 
 * @author Takiyah Price
 *
 */

public class Exit extends Screen {
	private Stage exitStage;
	private Scene exitWithSave;
	private Scene exitWithoutSave;
	Button saveButton;
	Button quitButton;
	Button yesButton;
	Button goBackButton;
	
	public Exit(Controller c) {
		saveButton = new Button("Save");
		quitButton = new Button("Quit");
		yesButton = new Button("Yes");
		goBackButton = new Button("Go Back");
		
		//HBox hbox = new HBox();
		//hbox.getChildren().addAll(saveButton,quitButton);
		exitStage = new Stage();
		exitStage.setAlwaysOnTop(true);
		//exitWithSave = new Scene(hbox,300,200);
	}
	
	public void showExitWithSave() {
		HBox hbox = new HBox();
		hbox.getChildren().addAll(saveButton,quitButton);
		exitWithSave = new Scene(hbox,300,200);
		exitStage.setScene(exitWithSave);
		exitStage.show();
	}
	
	public void showExitWithoutSave() {
		HBox hbox = new HBox();
		hbox.getChildren().addAll(yesButton,goBackButton);
		exitWithoutSave = new Scene(hbox,300,200);
		exitStage.setScene(exitWithoutSave);
		exitStage.show();
	}
	
	
}
