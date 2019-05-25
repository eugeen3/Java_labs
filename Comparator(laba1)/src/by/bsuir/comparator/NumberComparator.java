package by.bsuir.comparator;

import javafx.application.Application;
import javafx.stage.Stage;

public class NumberComparator extends Application {
	
	private Window newWindow;
	
	public NumberComparator() {
		newWindow = new Window();
	}
	
	@Override
	public void start(Stage primaryStage) {
		newWindow.setGridpaneParams();
		newWindow.fillGridpane();
		newWindow.setAction();
		
		primaryStage.setTitle("NumberComparator");
		primaryStage.setResizable(false);
		primaryStage.setScene(newWindow.getScene());
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}