package by.bsuir.zoo.GUI;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	private MainWindow mainWindow = new MainWindow();
	@Override
	public void start(Stage primaryStage) {
		mainWindow.setGridPaneParameters();
		mainWindow.fillGridpane();
		mainWindow.setAction(primaryStage);
		
		primaryStage.setTitle(ConstantData.MAIN_WINDOW_TITLE);
		primaryStage.setResizable(false);
		primaryStage.setScene(mainWindow.getScene());
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}