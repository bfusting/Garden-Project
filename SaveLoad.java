/*import java.io.File;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;





//last edited: 5-2-20 3:08PM

public class SaveLoad extends Screen{
	private FileChooser fileChooser;
	private double nonEditableOpacity = 0.85;
	private double EditableOpacity = 1.0;
	
	
	public SaveLoad() {
		
		fileChooser = new FileChooser();
		
	}
	
	
	public File showSaveWindow(Stage s) {
		//super.getPreviousScreen().setUneditable();
		Stage z = new Stage();
		//s.setAlwaysOnTop(true);
		s.setOpacity(nonEditableOpacity);
		File file = fileChooser.showSaveDialog(s);
		s.setOpacity(EditableOpacity);
		return file;
	}
	
	
	public File showLoadWindow(Stage s) {
		//super.getPreviousScreen().setUneditable();
		s.setOpacity(nonEditableOpacity);
		
		File file = fileChooser.showOpenDialog(s);
		s.setOpacity(EditableOpacity);
		return file;
	}
	
	@Override
	public String toString() {
		return "Save/Load";
	}
	
	@Override
	public void goToPreviousScreen() {
		//super.getPreviousScreen().setEditable();
	}
}
*/

