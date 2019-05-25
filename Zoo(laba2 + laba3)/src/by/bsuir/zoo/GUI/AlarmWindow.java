package by.bsuir.zoo.GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlarmWindow {
	private Stage alarm;
	private Scene scene;
	private VBox root;
	private Button closeWindow;
	private Label info;
	
	public void flamingoFlying() {
	    root = new VBox();
        
        root.setSpacing(10);
        
        closeWindow = new Button(ConstantData.INPUT_WINDOW_OK);
        root.getChildren().add(closeWindow);

        info = new Label(ConstantData.FLAMINGO_FLYING);
        info.setPrefWidth(80);
        root.getChildren().add(info);
        
		scene = new Scene(root, ConstantData.ALARM_WINDOW_WIDTH, ConstantData.ALARM_WINDOW_HEIGHT);
		
		closeWindow.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				alarm.close();
			}
		});
		
		alarm = new Stage();
		alarm.setResizable(false);
		alarm.setScene(scene);
		alarm.show();
	}
	
	public void animalEating(ConstantData.ANIMALS animalType) {
	    root = new VBox();
   
        closeWindow = new Button(ConstantData.INPUT_WINDOW_OK);
        root.getChildren().add(closeWindow);

        if (animalType == ConstantData.ANIMALS.ELEPHANT) {
        	info = new Label(ConstantData.ELEPHANT + ConstantData.EATING);
        }
        if (animalType == ConstantData.ANIMALS.TIGER) {
        	info = new Label(ConstantData.TIGER + ConstantData.EATING);
        }
        if (animalType == ConstantData.ANIMALS.OSTRICH) {
        	info = new Label(ConstantData.OSTRICH + ConstantData.EATING);
        }
        if (animalType == ConstantData.ANIMALS.FLAMINGO) {
        	info = new Label(ConstantData.FLAMINGO + ConstantData.EATING);
        }
        root.getChildren().add(info);
        
        root.setSpacing(ConstantData.ALARM_WINDOW_SPACING);
		scene = new Scene(root, ConstantData.ALARM_WINDOW_WIDTH, ConstantData.ALARM_WINDOW_HEIGHT);
		
		closeWindow.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				alarm.close();
			}
		});
		
		alarm = new Stage();
		alarm.setResizable(false);
		alarm.setScene(scene);
		alarm.show();
	}
}