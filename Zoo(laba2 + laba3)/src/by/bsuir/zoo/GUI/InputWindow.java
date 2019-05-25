package by.bsuir.zoo.GUI;

import by.bsuir.zoo.animals.Elephant;
import by.bsuir.zoo.animals.Ostrich;
import by.bsuir.zoo.animals.Tiger;
import by.bsuir.zoo.animals.Flamingo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InputWindow {
	private Label animalName;
	private TextField inputName;
	private Label bodyLength;
	private Button dataEntered;
	private TextField inputBodyLength;
	private GridPane root;

	private Label wingsLentgh;
	private TextField inputWingsLength;

	private Label stripesAmount;
	private TextField inputStripesAmount;

	private Label pawsAmount;
	private Label trunkLength;
	private TextField inputPawsAmount;
	private TextField inputTrunkLength;

	private Scene secondScene;
	private Stage newWindow;
	//private Animal animal;
	private Elephant elephant;
	private Tiger tiger;
	private Ostrich ostrich;
	private Flamingo flamingo;

	public Elephant addElephant(Stage primaryStage) {
		animalName = new Label(ConstantData.ANIMAL_NAME);
		inputName = new TextField();
		bodyLength = new Label(ConstantData.INPUT_WINDOW_BODY_LENGTH);
		dataEntered = new Button(ConstantData.INPUT_WINDOW_OK);
		inputBodyLength = new TextField();
		root = new GridPane();

		root.add(animalName, 0, 0);
		root.add(inputName, 1, 0);
		root.add(bodyLength, 0, 1);
		root.add(inputBodyLength, 1, 1);

		pawsAmount = new Label(ConstantData.INPUT_WINDOW_AMOUNT_OF_PAWS);
		trunkLength = new Label(ConstantData.INPUT_WINDOW_TRUNK_LENGTH);
		inputPawsAmount = new TextField();
		inputTrunkLength = new TextField();

		root.add(pawsAmount, 0, 2);
		root.add(inputPawsAmount, 1, 2);
		root.add(trunkLength, 0, 3);
		root.add(inputTrunkLength, 1, 3);
		root.add(dataEntered, 0, 4, 2, 1);

		root.setPadding(new Insets(ConstantData.MAIN_WINDOW_INSETS));
		root.setVgap(ConstantData.INPUT_WINDOW_VGAP);
		root.setHgap(ConstantData.INPUT_WINDOW_HGAP);

		secondScene = new Scene(root, ConstantData.INPUT_WINDOW_WIDTH, ConstantData.INPUT_WINDOW_HEIGHT_MAMMAL);

		newWindow = new Stage();
		newWindow.setTitle(ConstantData.INPUT_WINDOW_TITLE);
		newWindow.setScene(secondScene);
		newWindow.setResizable(false);
		newWindow.initOwner(primaryStage);
		newWindow.initModality(Modality.WINDOW_MODAL);
		newWindow.show();

		dataEntered.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					elephant = new Elephant(Integer.parseInt(inputBodyLength.getText()),
							Integer.parseInt(inputPawsAmount.getText()), 
							Integer.parseInt(inputTrunkLength.getText()),
							inputName.getText());
				} catch (NumberFormatException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText(ConstantData.WRONG_INPUT_MSG);
					alert.showAndWait();
				}

				newWindow.close();
			}
		});

		//return (Elephant)animal;	
		return elephant;
	}

	public Tiger addTiger(Stage primaryStage) {
		animalName = new Label(ConstantData.ANIMAL_NAME);
		inputName = new TextField();
		bodyLength = new Label(ConstantData.INPUT_WINDOW_BODY_LENGTH);
		dataEntered = new Button(ConstantData.INPUT_WINDOW_OK);
		inputBodyLength = new TextField();
		root = new GridPane();

		root.add(animalName, 0, 0);
		root.add(inputName, 1, 0);
		root.add(bodyLength, 0, 1);
		root.add(inputBodyLength, 1, 1);

		pawsAmount = new Label(ConstantData.INPUT_WINDOW_AMOUNT_OF_PAWS);
		stripesAmount = new Label(ConstantData.INPUT_WINDOW_AMOUNT_OF_STRIPES);
		inputPawsAmount = new TextField();
		inputStripesAmount = new TextField();

		root.add(pawsAmount, 0, 2);
		root.add(inputPawsAmount, 1, 2);
		root.add(stripesAmount, 0, 3);
		root.add(inputStripesAmount, 1, 3);
		root.add(dataEntered, 0, 4, 2, 1);

		root.setPadding(new Insets(ConstantData.MAIN_WINDOW_INSETS));
		root.setVgap(ConstantData.INPUT_WINDOW_VGAP);
		root.setHgap(ConstantData.INPUT_WINDOW_HGAP);

		secondScene = new Scene(root, ConstantData.INPUT_WINDOW_WIDTH, ConstantData.INPUT_WINDOW_HEIGHT_MAMMAL);

		newWindow = new Stage();
		newWindow.setTitle(ConstantData.INPUT_WINDOW_TITLE);
		newWindow.setScene(secondScene);
		newWindow.setResizable(false);
		newWindow.initOwner(primaryStage);
		newWindow.initModality(Modality.WINDOW_MODAL);
		newWindow.show();

		dataEntered.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					tiger = new Tiger(Integer.parseInt(inputBodyLength.getText()),
							Integer.parseInt(inputPawsAmount.getText()),
							Integer.parseInt(inputStripesAmount.getText()), 
							inputName.getText());
				} catch (NumberFormatException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText(ConstantData.WRONG_INPUT_MSG);
					alert.showAndWait();
				}

				newWindow.close();
			}
		});
		
		//return (Tiger)animal;	
		return tiger;
	}
	
	public Ostrich addOstrich(Stage primaryStage) {
		animalName = new Label(ConstantData.ANIMAL_NAME);
		inputName = new TextField();
		bodyLength = new Label(ConstantData.INPUT_WINDOW_BODY_LENGTH);
		dataEntered = new Button(ConstantData.INPUT_WINDOW_OK);
		inputBodyLength = new TextField();
		root = new GridPane();

		root.add(animalName, 0, 0);
		root.add(inputName, 1, 0);
		root.add(bodyLength, 0, 1);
		root.add(inputBodyLength, 1, 1);
		
		wingsLentgh = new Label(ConstantData.INPUT_WINDOW_WINGS_LENGTH);
		inputWingsLength = new TextField();

		root.add(wingsLentgh, 0, 2);
		root.add(inputWingsLength, 1, 2);
		root.add(dataEntered, 0, 3, 2, 1);

		root.setPadding(new Insets(ConstantData.MAIN_WINDOW_INSETS));
		root.setVgap(ConstantData.INPUT_WINDOW_VGAP);
		root.setHgap(ConstantData.INPUT_WINDOW_HGAP);

		secondScene = new Scene(root, ConstantData.INPUT_WINDOW_WIDTH, ConstantData.INPUT_WINDOW_HEIGHT_BIRD);

		newWindow = new Stage();
		newWindow.setTitle(ConstantData.INPUT_WINDOW_TITLE);
		newWindow.setScene(secondScene);
		newWindow.setResizable(false);
		newWindow.initOwner(primaryStage);
		newWindow.initModality(Modality.WINDOW_MODAL);
		newWindow.show();

		dataEntered.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					ostrich = new Ostrich(Integer.parseInt(inputBodyLength.getText()),
										Integer.parseInt(inputWingsLength.getText()), 
										inputName.getText());
				} catch (NumberFormatException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText(ConstantData.WRONG_INPUT_MSG);
					alert.showAndWait();
				}

				newWindow.close();
			}
		});

		//return (Ostrich)animal;
		return ostrich;
	}
	
	public Flamingo addFlamingo(Stage primaryStage) {
		animalName = new Label(ConstantData.ANIMAL_NAME);
		inputName = new TextField();
		bodyLength = new Label(ConstantData.INPUT_WINDOW_BODY_LENGTH);
		dataEntered = new Button(ConstantData.INPUT_WINDOW_OK);
		inputBodyLength = new TextField();
		root = new GridPane();

		root.add(animalName, 0, 0);
		root.add(inputName, 1, 0);
		root.add(bodyLength, 0, 1);
		root.add(inputBodyLength, 1, 1);
		
		wingsLentgh = new Label(ConstantData.INPUT_WINDOW_WINGS_LENGTH);
		inputWingsLength = new TextField();

		root.add(wingsLentgh, 0, 2);
		root.add(inputWingsLength, 1, 2);
		root.add(dataEntered, 0, 3, 2, 1);

		root.setPadding(new Insets(ConstantData.MAIN_WINDOW_INSETS));
		root.setVgap(ConstantData.INPUT_WINDOW_VGAP);
		root.setHgap(ConstantData.INPUT_WINDOW_HGAP);

		secondScene = new Scene(root, ConstantData.INPUT_WINDOW_WIDTH, ConstantData.INPUT_WINDOW_HEIGHT_BIRD);

		newWindow = new Stage();
		newWindow.setTitle(ConstantData.INPUT_WINDOW_TITLE);
		newWindow.setScene(secondScene);
		newWindow.setResizable(false);
		newWindow.initOwner(primaryStage);
		newWindow.initModality(Modality.WINDOW_MODAL);
		newWindow.show();

		dataEntered.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					flamingo = new Flamingo(Integer.parseInt(inputBodyLength.getText()),
										Integer.parseInt(inputWingsLength.getText()), 
										inputName.getText());
				} catch (NumberFormatException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText(ConstantData.WRONG_INPUT_MSG);
					alert.showAndWait();
				}

				newWindow.close();
			}
		});

		//return (Flamingo)animal;
		return flamingo;
	}
}