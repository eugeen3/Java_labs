package by.bsuir.zoo.GUI;

import java.util.Iterator;
import java.util.List;

import by.bsuir.zoo.Worker;
import by.bsuir.zoo.animals.Elephant;
import by.bsuir.zoo.animals.Flamingo;
import by.bsuir.zoo.animals.Ostrich;
import by.bsuir.zoo.animals.Tiger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InformationWindow {
	private Scene scene;
	private GridPane gridpane;
	private ScrollPane root;
	private Stage newWindow;
	
	private Label name;
	private Label bodyLength;
	private Label wingsLength;
	private Label pawsAmount;
	private Label trunkLength;
	private Label stripesAmount;
	private Label gridpaneData;
	private Label cageStatus;
	
	private Button feed;
	private Button cleanCage;
	private Button fly;
	
	private int rowIndex; 
	
	private Worker worker;
	
	public void showElephantsList(Stage primaryStage, List<Elephant> list) {
		root = new ScrollPane();
		gridpane = new GridPane();

		name = new Label(ConstantData.INFORMATION_WINDOW_NAME);
		bodyLength = new Label(ConstantData.INFORMATION_WINDOW_BODY_LENGTH);
		pawsAmount = new Label(ConstantData.INFORMATION_WINDOW_AMOUNT_OF_PAWS);
		trunkLength = new Label(ConstantData.INFORMATION_WINDOW_TRUNK_LENGTH);
		cageStatus = new Label(ConstantData.CAGE_STATUS);
		
		gridpane.add(name, 0, 0);
		gridpane.add(bodyLength, 1, 0);
		gridpane.add(pawsAmount, 2, 0);
		gridpane.add(trunkLength, 3, 0);
		gridpane.add(cageStatus, 4, 0);
		
		rowIndex = 0;
		Iterator<Elephant> it = list.iterator();
        while (it.hasNext())
        {
        	Elephant el = it.next();

            gridpaneData = new Label(el.getName());
            gridpane.add(gridpaneData, 0, rowIndex);

            gridpaneData = new Label(Integer.toString(el.getBodyLength()));
            gridpane.add(gridpaneData, 1, rowIndex);

            gridpaneData = new Label(Integer.toString(el.getPawsAmount()));
            gridpane.add(gridpaneData, 2, rowIndex);
            
            gridpaneData = new Label(Integer.toString(el.getTrunkLength()));
            gridpane.add(gridpaneData, 3, rowIndex);
            
            if(el.getIsCageClean()) {
            	gridpaneData = new Label(ConstantData.CAGE_CLEAN);
            }
            else {
            	gridpaneData = new Label(ConstantData.CAGE_NOT_CLEAN);
            }
            gridpane.add(gridpaneData, 4, rowIndex);
            
            cleanCage = new Button(ConstantData.INFORMATION_WINDOW_CLEAN_CAGE);
            gridpane.add(cleanCage, 5, rowIndex);
            
            feed = new Button(ConstantData.INFORMATION_WINDOW_FEED);
            gridpane.add(feed, 6, rowIndex);
            
            cleanCage.setOnAction(new EventHandler<ActionEvent>() {
    			public void handle(ActionEvent event) {
    				worker.cleanCage(el);
    			}
    		});
    		
            feed.setOnAction(new EventHandler<ActionEvent>() {
    			public void handle(ActionEvent event) {
    				worker.feed(el);
    			}
    		});
            
            rowIndex++;
        }

		gridpane.setPadding(new Insets(ConstantData.MAIN_WINDOW_INSETS));
		gridpane.setVgap(ConstantData.INFORMATION_WINDOW_VGAP);
		gridpane.setHgap(ConstantData.INFORMATION_WINDOW_HGAP);

		root.setContent(gridpane);
		scene = new Scene(root, ConstantData.INFORMATION_WINDOW_WIDTH, ConstantData.INFORMATION_WINDOW_HEIGHT);
		
		
		newWindow = new Stage();
		newWindow.setTitle(ConstantData.INFORMATION_WINDOW_TITLE_ELEPHANTS);
		newWindow.setResizable(false);
		newWindow.setScene(scene);
		newWindow.show();
	}
	
	public void showTigersList(Stage primaryStage, List<Tiger> list) {
		root = new ScrollPane();
		gridpane = new GridPane();

		name = new Label(ConstantData.INFORMATION_WINDOW_NAME);
		bodyLength = new Label(ConstantData.INFORMATION_WINDOW_BODY_LENGTH);
		pawsAmount = new Label(ConstantData.INFORMATION_WINDOW_AMOUNT_OF_PAWS);
		stripesAmount = new Label(ConstantData.INFORMATION_WINDOW_STRIPES_AMOUNT);
		cageStatus = new Label(ConstantData.CAGE_STATUS);
		
		gridpane.add(name, 0, 0);
		gridpane.add(bodyLength, 1, 0);
		gridpane.add(pawsAmount, 2, 0);
		gridpane.add(stripesAmount, 3, 0);
		gridpane.add(cageStatus, 4, 0);
		
		rowIndex = 0;
		Iterator<Tiger> it = list.iterator();
        while (it.hasNext())
        {
        	Tiger tg = it.next();

            gridpaneData = new Label(tg.getName());
            gridpane.add(gridpaneData, 0, rowIndex);

            gridpaneData = new Label(Integer.toString(tg.getBodyLength()));
            gridpane.add(gridpaneData, 1, rowIndex);

            gridpaneData = new Label(Integer.toString(tg.getPawsAmount()));
            gridpane.add(gridpaneData, 2, rowIndex);
            
            gridpaneData = new Label(Integer.toString(tg.getAmountOfStripes()));
            gridpane.add(gridpaneData, 3, rowIndex);
            
            if(tg.getIsCageClean()) {
            	gridpaneData = new Label(ConstantData.CAGE_CLEAN);
            }
            else {
            	gridpaneData = new Label(ConstantData.CAGE_NOT_CLEAN);
            }
            gridpane.add(gridpaneData, 4, rowIndex);
            
            cleanCage = new Button(ConstantData.INFORMATION_WINDOW_CLEAN_CAGE);
            gridpane.add(cleanCage, 5, rowIndex);

            feed = new Button(ConstantData.INFORMATION_WINDOW_FEED);
            gridpane.add(feed, 6, rowIndex);
            
            cleanCage.setOnAction(new EventHandler<ActionEvent>() {
    			public void handle(ActionEvent event) {
    				worker.cleanCage(tg);
    			}
    		});
    		
            feed.setOnAction(new EventHandler<ActionEvent>() {
    			public void handle(ActionEvent event) {
    				worker.feed(tg);
    			}
    		});
            
            rowIndex++;
        }

		gridpane.setPadding(new Insets(ConstantData.MAIN_WINDOW_INSETS));
		gridpane.setVgap(ConstantData.INFORMATION_WINDOW_VGAP);
		gridpane.setHgap(ConstantData.INFORMATION_WINDOW_HGAP);

		root.setContent(gridpane);
		scene = new Scene(root, ConstantData.INFORMATION_WINDOW_WIDTH, ConstantData.INFORMATION_WINDOW_HEIGHT);
		
		newWindow = new Stage();
		newWindow.setTitle(ConstantData.INFORMATION_WINDOW_TITLE_TIGERS);
		newWindow.setResizable(false);
		newWindow.setScene(scene);
		newWindow.show();
	}
	
	public void showOstrichesList(Stage primaryStage, List<Ostrich> list) {
		root = new ScrollPane();
		gridpane = new GridPane();

		name = new Label(ConstantData.INFORMATION_WINDOW_NAME);
		bodyLength = new Label(ConstantData.INFORMATION_WINDOW_BODY_LENGTH);
		wingsLength = new Label(ConstantData.INFORMATION_WINDOW_WINGS_LENGTH);
		cageStatus = new Label(ConstantData.CAGE_STATUS);
		
		gridpane.add(name, 0, 0);
		gridpane.add(bodyLength, 1, 0);
		gridpane.add(wingsLength, 2, 0);
		gridpane.add(cageStatus, 3, 0);
		
		rowIndex = 0;
		Iterator<Ostrich> it = list.iterator();
        while (it.hasNext())
        {
        	Ostrich os = it.next();

            gridpaneData = new Label(os.getName());
            gridpane.add(gridpaneData, 0, rowIndex);

            gridpaneData = new Label(Integer.toString(os.getBodyLength()));
            gridpane.add(gridpaneData, 1, rowIndex);

            gridpaneData = new Label(Integer.toString(os.getWingLength()));
            gridpane.add(gridpaneData, 2, rowIndex);
            
            if(os.getIsCageClean()) {
            	gridpaneData = new Label(ConstantData.CAGE_CLEAN);
            }
            else {
            	gridpaneData = new Label(ConstantData.CAGE_NOT_CLEAN);
            }
            gridpane.add(gridpaneData, 3, rowIndex);
            
            cleanCage = new Button(ConstantData.INFORMATION_WINDOW_CLEAN_CAGE);
            gridpane.add(cleanCage, 4, rowIndex);

            feed = new Button(ConstantData.INFORMATION_WINDOW_FEED);
            gridpane.add(feed, 5, rowIndex);
            
            cleanCage.setOnAction(new EventHandler<ActionEvent>() {
    			public void handle(ActionEvent event) {
    				worker.cleanCage(os);
    			}
    		});
    		
            feed.setOnAction(new EventHandler<ActionEvent>() {
    			public void handle(ActionEvent event) {
    				worker.feed(os);
    			}
    		});
            
            rowIndex++;
        }

		gridpane.setPadding(new Insets(ConstantData.MAIN_WINDOW_INSETS));
		gridpane.setVgap(ConstantData.INFORMATION_WINDOW_VGAP);
		gridpane.setHgap(ConstantData.INFORMATION_WINDOW_HGAP);

		root.setContent(gridpane);
		scene = new Scene(root, ConstantData.INFORMATION_WINDOW_WIDTH, ConstantData.INFORMATION_WINDOW_HEIGHT);
		
		newWindow = new Stage();
		newWindow.setTitle(ConstantData.INFORMATION_WINDOW_TITLE_OSTRICHES);
		newWindow.setResizable(false);
		newWindow.setScene(scene);
		newWindow.show();
	}
	
	public void showFlamingosList(Stage primaryStage, List<Flamingo> list) {
		root = new ScrollPane();
		gridpane = new GridPane();
		
		name = new Label(ConstantData.INFORMATION_WINDOW_NAME);
		bodyLength = new Label(ConstantData.INFORMATION_WINDOW_BODY_LENGTH);
		wingsLength = new Label(ConstantData.INFORMATION_WINDOW_WINGS_LENGTH);
		cageStatus = new Label(ConstantData.CAGE_STATUS);
		
		gridpane.add(name, 0, 0);
		gridpane.add(bodyLength, 1, 0);
		gridpane.add(wingsLength, 2, 0);
		gridpane.add(cageStatus, 3, 0);

		rowIndex = 0;
		Iterator<Flamingo> it = list.iterator();
        while (it.hasNext())
        {
        	Flamingo fl = it.next();

            gridpaneData = new Label(fl.getName());
            gridpane.add(gridpaneData, 0, rowIndex);

            gridpaneData = new Label(Integer.toString(fl.getBodyLength()));
            gridpane.add(gridpaneData, 1, rowIndex);

            gridpaneData = new Label(Integer.toString(fl.getWingLength()));
            gridpane.add(gridpaneData, 2, rowIndex);
            
            if(fl.getIsCageClean()) {
            	gridpaneData = new Label(ConstantData.CAGE_CLEAN);
            }
            else {
            	gridpaneData = new Label(ConstantData.CAGE_NOT_CLEAN);
            }
            gridpane.add(gridpaneData, 3, rowIndex);
            
            cleanCage = new Button(ConstantData.INFORMATION_WINDOW_CLEAN_CAGE);
            gridpane.add(cleanCage, 4, rowIndex);
            
            fly = new Button(ConstantData.INFORMATION_WINDOW_FLY);
            gridpane.add(fly, 5, rowIndex);

            feed = new Button(ConstantData.INFORMATION_WINDOW_FEED);
            gridpane.add(feed, 6, rowIndex);
            
            cleanCage.setOnAction(new EventHandler<ActionEvent>() {
    			public void handle(ActionEvent event) {
    				worker.cleanCage(fl);
    			}
    		});
    		
            feed.setOnAction(new EventHandler<ActionEvent>() {
    			public void handle(ActionEvent event) {
    				worker.feed(fl);
    			}
    		});
            
            fly.setOnAction(new EventHandler<ActionEvent>() {
    			public void handle(ActionEvent event) {
    				worker.feed(fl);
    			}
    		});
            
            rowIndex++;
        }
		gridpane.setPadding(new Insets(ConstantData.MAIN_WINDOW_INSETS));
		gridpane.setVgap(ConstantData.INFORMATION_WINDOW_VGAP);
		gridpane.setHgap(ConstantData.INFORMATION_WINDOW_HGAP);

		root.setContent(gridpane);
		scene = new Scene(root, ConstantData.INFORMATION_WINDOW_WIDTH, ConstantData.INFORMATION_WINDOW_HEIGHT);
		
		newWindow = new Stage();
		newWindow.setTitle(ConstantData.INFORMATION_WINDOW_TITLE_FLAMINGOS);
		newWindow.setResizable(false);
		newWindow.setScene(scene);
		newWindow.show();
	}
}