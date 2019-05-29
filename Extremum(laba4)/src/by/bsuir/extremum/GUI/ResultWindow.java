package by.bsuir.extremum.GUI;

import by.bsuir.extremum.calculations.ExtremumSearch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;
import java.util.TreeMap;

public class ResultWindow {
    private ScrollPane root;
    private GridPane gridPane;
    private Label localMax;
    private Label localMin;
    private Label result;

    private Scene secondScene;
    private Stage newWindow;

    public void displayWindow(Stage primaryStage) {
        root = new ScrollPane();
        gridPane = new GridPane();
        localMax = new Label(ConstantData.RESULT_WINDOW_LOCAL_MAX);
        localMin = new Label(ConstantData.RESULT_WINDOW_LOCAL_MIN);

        root.setContent(gridPane);
        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        root.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        gridPane.setPadding(new Insets(ConstantData.MAIN_WINDOW_INSETS));
        gridPane.setVgap(ConstantData.RESULT_WINDOW_VGAP);
        gridPane.setHgap(ConstantData.RESULT_WINDOW_HGAP);

        gridPane.add(localMax, 0, 0);
        gridPane.add(localMin, 1, 0);

        ExtremumSearch exSearch = new ExtremumSearch();
        TreeMap<Integer, Integer> localMaximums = exSearch.getLocalMaximums();
        TreeMap<Integer, Integer> localMinimums = exSearch.getLocalMinimums();
        Integer maxesX[] = localMaximums.keySet().toArray(new Integer[localMaximums.size()]);
        Integer maxesY[] = localMaximums.values().toArray(new Integer[localMaximums.size()]);

        for(int i = 0; i < localMaximums.size(); i ++) {
            int row  = i + 1;
            result = new Label();
            Integer pointY = localMaximums.get(i);
            result.setText("X: " + maxesX[i] + " Y: " + maxesY[i]);
            gridPane.add(result, 0, row);
        }

        Integer minimumsX[] = localMinimums.keySet().toArray(new Integer[localMinimums.size()]);
        Integer minimumsY[] = localMinimums.values().toArray(new Integer[localMinimums.size()]);
        for(int i = 0; i < localMinimums.size(); i ++) {
            int row  = i + 1;
            result = new Label();
            Integer pointY = localMinimums.get(i);
            result.setText("X: " + minimumsX[i] + " Y: " + minimumsY[i]);
            gridPane.add(result, 1, row);
        }

        secondScene = new Scene(root, ConstantData.RESULT_WINDOW_WIDTH, ConstantData.RESULT_WINDOW_HEIGHT);

        newWindow = new Stage();
        newWindow.setTitle(ConstantData.RESULT_WINDOW_TITLE);
        newWindow.setScene(secondScene);
        newWindow.initOwner(primaryStage);
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.show();
    }
}