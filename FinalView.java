import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * 
 * @author Kelsey McRae
 * <br>
 * <br> The View that allow the user to see their final garden they created as well as alternate possible versions.
 *
 */
public class FinalView{
	private Button edit;
	private Button infoTips;
	private Button viewSeasons;
	private Button save;
	private Scene finalView;
	private GardenPlot originalPlot;
	private GardenPlot plotIdea1;
	private GardenPlot plotIdea2;
	private GardenPlot plotIdea3;
	
	/**
	 * The constructor of FinalView
	 * 
	 * @param: ogPlot The original garden plot that was designed by the user.
	 */
	
	public FinalView(GardenPlot ogPlot) {
		originalPlot = ogPlot;
	}
	
	/**
	 * 
	 * @return plotIdea1 The first alternate version of the original garden plot designed by user.
	 */
	public GardenPlot getPlotIdea1() {
		return plotIdea1;
	}
	
	/**
	 * 
	 * @return plotIdea2 The second alternate version of the original garden plot designed by user.
	 */
	public GardenPlot getPlotIdea2() {
		return plotIdea2;
	}
	
	/**
	 * 
	 * @return plotIdea3 The third alternate version of the original garden plot designed by user.
	 */
	public GardenPlot getPlotIdea3() {
		return plotIdea3;
	}
	
	/**
	 * 
	 * @param plot1 The first alternate garden plot as generated by controller.
	 */
	public void setPlotIdea1(GardenPlot plot1) {
		this.plotIdea1 = plot1;
	}
	
	/**
	 * 
	 * @param plot2 The second alternate garden plot as generated by controller.
	 */
	
	public void setPlotIdea2(GardenPlot plot2) {
		this.plotIdea2 = plot2;
	}
	
	/**
	 * 
	 * @param plot3 The third alternate garden plot as generated by controller.
	 */
	
	public void setPlotIdea3(GardenPlot plot3) {
		this.plotIdea3 = plot3;
	}
	
	/**
	 * 
	 * Contains the buttons, and views of the final garden options.
	 * 
	 * @param stage The stage for finalView's scene.
	 */
/*	public void showFinalView(Stage stage) {
		
	}
*/

}
