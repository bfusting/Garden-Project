import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FinalView extends View{
	private Button edit;
	private Button infoTips;
	private Button viewSeasons;
	private Button save;
	private Scene finalView;
	private GardenPlot originalPlot;
	private GardenPlot plotIdea1;
	private GardenPlot plotIdea2;
	private GardenPlot plotIdea3;
	
	public FinalView(GardenPlot ogPlot) {
		originalPlot = ogPlot;
	}
	
	
	public GardenPlot getPlotIdea1() {
		return plotIdea1;
	}
	
	public GardenPlot getplotIdea2() {
		return plotIdea2;
	}
	
	public GardenPlot getplotIdea3() {
		return plotIdea3;
	}
	
	public void setplotIdea1(GardenPlot plot1) {
		this.plotIdea1 = plot1;
	}
	
	public void setplotIdea2(GardenPlot plot2) {
		this.plotIdea2 = plot2;
	}
	
	public void setplotIdea3(GardenPlot plot3) {
		this.plotIdea3 = plot3;
	}
	
	
	public void showFinalView(Stage stage) {
		
	}

}
