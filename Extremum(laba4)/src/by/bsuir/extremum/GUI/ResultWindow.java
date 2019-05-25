package by.bsuir.extremum.GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ResultWindow {
    private GridPane root;
    private Label localMax;
    private Label localMin;
    private Label valueMax;
    private Label valueMin;

    private Scene secondScene;
    private Stage newWindow;

    public void displayWindow(Stage primaryStage) {
        root = new GridPane();
        localMax = new Label(ConstantData.RESULT_WINDOW_LOCAL_MAX);
        localMin = new Label(ConstantData.RESULT_WINDOW_LOCAL_MIN);
        valueMax = new Label();
        valueMin = new Label();
        root.setPadding(new Insets(ConstantData.MAIN_WINDOW_INSETS));
        root.setVgap(ConstantData.RESULT_WINDOW_VGAP);
        root.setHgap(ConstantData.RESULT_WINDOW_HGAP);

        root.add(localMax, 0, 0);
        root.add(localMin, 0, 1);
        root.add(valueMax, 1, 0);
        root.add(valueMin, 1, 1);

        secondScene = new Scene(root, ConstantData.RESULT_WINDOW_WIDTH, ConstantData.RESULT_WINDOW_HEIGHT);

        newWindow = new Stage();
        newWindow.setTitle(ConstantData.RESULT_WINDOW_TITLE);
        newWindow.setScene(secondScene);
        newWindow.initOwner(primaryStage);
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.show();
    }

    public void setResult(Integer max, Integer min) {
        valueMax.setText(max.toString());
        valueMax.setText(min.toString());
    }
}