package by.bsuir.zoo.GUI;

import by.bsuir.zoo.Zoo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainWindow {
	private GridPane gridpane;
	private Scene scene;

	private Button addElephant;
	private Button addTiger;
	private Button addOstrich;
	private Button addFlamingo;
	private Button showElephantsList;
	private Button showTigersList;
	private Button showOstrichesList;
	private Button showFlamingosInfo;
	
	private Label elephant;
	private Label tiger;
	private Label ostrich;
	private Label flamingo;
	
	private Zoo myZoo;
	
	public MainWindow() {
		gridpane = new GridPane();
		scene = new Scene(gridpane, ConstantData.MAIN_WINDOW_WIDTH, ConstantData.MAIN_WINDOW_HEIGHT);

		addElephant = new Button(ConstantData.MAIN_WINDOW_ADD_ELEPHANT);
		addTiger = new Button(ConstantData.MAIN_WINDOW_ADD_TIGER);
		addOstrich = new Button(ConstantData.MAIN_WINDOW_ADD_OSTRICH);
		addFlamingo = new Button(ConstantData.MAIN_WINDOW_ADD_FLAMINGO);
		showElephantsList = new Button(ConstantData.MAIN_WINDOW_SHOW_LIST);
		showTigersList = new Button(ConstantData.MAIN_WINDOW_SHOW_LIST);
		showOstrichesList = new Button(ConstantData.MAIN_WINDOW_SHOW_LIST);
		showFlamingosInfo = new Button(ConstantData.MAIN_WINDOW_SHOW_LIST);
		
		elephant = new Label(ConstantData.ELEPHANT);
		tiger = new Label(ConstantData.TIGER);
		ostrich = new Label(ConstantData.OSTRICH);
		flamingo = new Label(ConstantData.FLAMINGO);
		myZoo = new Zoo();
	}

	public void setGridPaneParameters() {
		gridpane.setPadding(new Insets(ConstantData.MAIN_WINDOW_INSETS));
		gridpane.setHgap(ConstantData.MAIN_WINDOW_HGAP);
		gridpane.setVgap(ConstantData.MAIN_WINDOW_VGAP);
	}

	public void fillGridpane() {
		gridpane.add(elephant, 0, 0);
		gridpane.add(tiger, 1, 0);
		gridpane.add(ostrich, 2, 0);
		gridpane.add(flamingo, 3, 0);

		gridpane.add(addElephant, 0, 1);
		gridpane.add(addTiger, 1, 1);
		gridpane.add(addOstrich, 2, 1);
		gridpane.add(addFlamingo, 3, 1);
		
		gridpane.add(showElephantsList, 0, 2);
		gridpane.add(showTigersList, 1, 2);
		gridpane.add(showOstrichesList, 2, 2);
		gridpane.add(showFlamingosInfo, 3, 2);
	}

	public Scene getScene() {
		return scene;
	}

	public void setAction(Stage primaryStage) {
		addElephant.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				InputWindow iw = new InputWindow();
				myZoo.addElephantToArray(iw.addElephant(primaryStage));
			}
		});
		

		addTiger.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				InputWindow iw = new InputWindow();
				myZoo.addTigerToArray(iw.addTiger(primaryStage));
			}
		});

		addOstrich.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				InputWindow iw = new InputWindow();
				myZoo.addOstrichToArray(iw.addOstrich(primaryStage));
			}
		});
		
		addFlamingo.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				InputWindow iw = new InputWindow();
                myZoo.addFlamingoToArray(iw.addFlamingo(primaryStage));
			}
		});
		
		
		showElephantsList.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				InformationWindow iw = new InformationWindow();
				iw.showElephantsList(primaryStage, myZoo.getElephantssInZoo());
			}
		});

		showTigersList.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				InformationWindow iw = new InformationWindow();
				iw.showTigersList(primaryStage, myZoo.getTigersInZoo());
			}
		});

		showOstrichesList.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				InformationWindow iw = new InformationWindow();
				iw.showOstrichesList(primaryStage, myZoo.getOstrichsInZoo());
			}
		});
		
		showFlamingosInfo.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				InformationWindow iw = new InformationWindow();
				iw.showFlamingosList(primaryStage, myZoo.getFlamingosInZoo());
			}
		});
	}
}