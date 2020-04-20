package pkgMain;


import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/*
 * 
 */

public class MyMovingImageView2 extends Application {

	private ImgController2 imc;
	private ImageView iv1;
	private final double WIDTH = 800;
	private final double HEIGHT = 600;
	
	private ImageView iv2;
	private ArrayList<ImageView> weedviews;
	StackPane sPane;
	FlowPane fPane;
	Group root;
	TilePane tPane;
	BorderPane bPane;
	Image img;
	
	
	public MyMovingImageView2(){
    	iv1 = new ImageView();
		imc = new ImgController2(this);
		weedviews = new ArrayList<ImageView>();
		
	}
		
    @Override
    public void start(Stage stage) {
 
    	/*
    	Original code
    	Image im1 = new Image(getClass().getResourceAsStream("/img/commonMilkweed.png"));
    	iv1.setImage(im1);
    	iv1.setPreserveRatio(true);
    	iv1.setFitHeight(100);
    	iv1.setOnMouseDragged(imc.getHandlerForDrag());
    	Scene scene = new Scene(new StackPane(iv1), WIDTH, HEIGHT);
        stage.setScene(scene);
    	*/
    	
   
    	
    	Image im1 = new Image(getClass().getResourceAsStream("/img/commonMilkweed.png"));
    	iv1.setImage(im1);
    	iv1.setPreserveRatio(true);
    	iv1.setFitHeight(100);
    	iv1.setOnDragDetected(imc.getHandlerForWeedDragDetected());
    	
   
    	
    	// Creating creating a borderPane, TilePane and Flow Pane with label buttons
    	bPane = new BorderPane();
    	tPane = new TilePane();
    	fPane = new FlowPane();
    	
    	
    	sPane = new StackPane();
    	root = new Group();
    	
    	
    	Label fLabel = new Label("FlowPane");
    	Label tLabel = new Label("TilePane");
    	// Setting tPane/fPane and their properties
    	tPane.setBackground((new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY))));
    	tLabel.setStyle("-fx-font-weight: bold");
    	fPane.setBackground((new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY))));
    	fLabel.setStyle("-fx-font-weight: bold");
    	// Adding to Labels to Panes, then tPane/fPane to borderPane
    	tPane.getChildren().add(tLabel);
    	tPane.getChildren().add(iv1); // added second so label is at top
    	
    	fPane.getChildren().add(fLabel);
    	bPane.setLeft(tPane);
    	bPane.setCenter(fPane);
        
    	sPane.getChildren().add(bPane);
    	
    	bPane.setOnMouseDragged(imc.getHandlerForDrag());
    	bPane.setOnMouseReleased(imc.getHandlerForDragDropped());
    	
    	Scene scene = new Scene(sPane, WIDTH,HEIGHT);
    	
    	
    	stage.setScene(scene);
        //
        
		//iv1.setTranslateX(iv1.getLayoutX() - WIDTH/2 + imc.getStartingX());
		//iv1.setTranslateY(iv1.getLayoutY() - HEIGHT/2 + imc.getStartingY());

        stage.show();
    }
    public void setX(double x) {
    	iv2.setTranslateX(iv2.getLayoutX() - WIDTH/2 + x);
    	
    }
    public void setY(double y) {
    	iv2.setTranslateY(iv2.getLayoutY() - HEIGHT/2 + y);
    	
    }
    public static void main(String[] args) {
        launch();
    }
    
    public void dropWeedImageView() {
    	
    	sPane.getChildren().remove(iv2);
    	fPane.getChildren().add(iv2);
    	
    	
    }
    
    public void createWeedImageView() {
    	System.out.println("copy created");
    	img = new Image(getClass().getResourceAsStream("/img/commonMilkweed.png"));
    	
    	iv2 = new ImageView(img);
    	iv2.setPreserveRatio(true);
    	iv2.setFitHeight(100);
    	
    	iv2.setTranslateX(iv2.getLayoutX() - WIDTH/2 + imc.getStartingX());
    	iv2.setTranslateY(iv2.getLayoutY() - HEIGHT/2 + imc.getStartingY());
    	
    	sPane.getChildren().add(iv2);
    	
    	
    	
    	
    	weedviews.add(iv2);
    }

}