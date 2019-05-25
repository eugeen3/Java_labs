package by.bsuir.comparator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class Window {
	private static final String FIRST = "First number";
	private static final String SECOND = "Second number";
	private static final String THIRD = "Third number";
	private static final String COMPARE_BUTTON_TEXT = "Compare";
	private static final String VALUE_MAX = "Max value ";

	private static final int WINDOW_WIDTH = 180;
	private static final int WINDOW_HEIGHT = 320;

	private GridPane gridpane;
	private Scene scene;

	private Button compare;
	private TextField inputFirstNumber;
	private TextField inputSecondNumber;
	private TextField inputThirdNumber;
	private Label firstNumber;
	private Label secondNumber;
	private Label thirdNumber;
	private Label result;

	public Window() {
		gridpane = new GridPane();
		scene = new Scene(gridpane, WINDOW_HEIGHT, WINDOW_WIDTH);

		compare = new Button(COMPARE_BUTTON_TEXT);
		result = new Label();
		firstNumber = new Label(FIRST);
		secondNumber = new Label(SECOND);
		thirdNumber = new Label(THIRD);
		inputFirstNumber = new TextField();
		inputSecondNumber = new TextField();
		inputThirdNumber = new TextField();
	}

	public void setGridpaneParams() {
		gridpane.setPadding(new Insets(30));
		gridpane.setHgap(20);
		gridpane.setVgap(10);

		gridpane.getColumnConstraints().add(new ColumnConstraints(120));
		gridpane.getColumnConstraints().add(new ColumnConstraints(120));
	}

	public void fillGridpane() {
		gridpane.add(firstNumber, 0, 0);
		gridpane.add(secondNumber, 0, 1);
		gridpane.add(thirdNumber, 0, 2);
		gridpane.add(result, 0, 3);
		gridpane.add(inputFirstNumber, 1, 0);
		gridpane.add(inputSecondNumber, 1, 1);
		gridpane.add(inputThirdNumber, 1, 2);
		gridpane.add(compare, 1, 3);
	}


	public void setAction() {
		compare.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Integer[] values = {Integer.parseInt(inputFirstNumber.getText()),
									Integer.parseInt(inputSecondNumber.getText()),
									Integer.parseInt(inputThirdNumber.getText())}; 
				
				Integer maxValue = values[0];
				for (int i = 1; i < 3; i++) {
					if (values[i] > maxValue) 
						maxValue = values[i];
				}
				
				result.setText(VALUE_MAX + maxValue);
			}
		});	
	}	
	
	public Scene getScene() {
		return scene;
	}
}