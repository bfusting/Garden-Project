package pkgMain;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

public class ImgController2 {

	private final boolean DEBUG = true;
	MyMovingImageView2 view;
	MyMovingImageModel2 model;
	boolean weedDragStarted;
	
	//
	ArrayList<MyMovingImageModel2> weeds;
	//
	ImgController2(MyMovingImageView2 view){
		this.view = view;
		//model = new MyMovingImageModel2();
		
		weedDragStarted = false;
		weeds = new ArrayList<MyMovingImageModel2>();
		
		if (DEBUG) System.out.println("ic created");
	}
	
	public void drag(MouseEvent event) {
		if (weedDragStarted) {
		Node n = (Node)event.getSource();
		
		if (DEBUG) System.out.println("ic mouse drag tx: " + n.getTranslateX() + ", ex: " + event.getX() );
		
		
		//model.setX(model.getX() + event.getX()); //event.getX() is the amount of horiz drag
		//model.setY(model.getY() + event.getY());
		model.setX(event.getX());
		model.setY(event.getY());
		
		view.setX( model.getX() );
		view.setY( model.getY() );
		} else {
			System.out.println("weed not dragged");
		}
		
		
		
		/*Node n = (Node)event.getSource();
		if (DEBUG) System.out.println("ic mouse drag tx: " + n.getTranslateX() + ", ex: " + event.getX() );
		
		
		
		model.setX(model.getX() + event.getX()); //event.getX() is the amount of horiz drag
		model.setY(model.getY() + event.getY());
		view.setX( model.getX() );
		view.setY( model.getY() );
		//n.setTranslateX(n.getTranslateX() + event.getX()); //not MVC! what problem does this create?
		//n.setTranslateY(n.getTranslateY() + event.getY());
		
		 */
	}
	
	public void dragDropped(MouseEvent event) {
		if (weedDragStarted) {
		weedDragStarted=false;
		view.dropWeedImageView();
		}
	}
	
	public void weedDragStart(MouseEvent event) {
		System.out.println("drag started");
		weedDragStarted= true;
		
		model = new MyMovingImageModel2();
		view.createWeedImageView();
		
		
		weeds.add(model);
	}

	public EventHandler getHandlerForDrag() {
		return event -> drag((MouseEvent) event);
	}
	
	public EventHandler getHandlerForWeedDragDetected() {
		return event -> weedDragStart((MouseEvent) event);
	}
	
	public EventHandler getHandlerForDragDropped() {
		return event -> dragDropped((MouseEvent) event);
	}

/*	public void tellModelStartingCoords(double x, double y) {
		model.setX(view.getImgStartingX());
		model.setY(view.getImgStartingY());
		if (DEBUG) System.out.println("start: " + model.getX() + " " + model.getY());
	}
*/
	public double getStartingX() {
		return model.getX();
	}
	public double getStartingY() {
		return model.getY();
	}
	
	
}
