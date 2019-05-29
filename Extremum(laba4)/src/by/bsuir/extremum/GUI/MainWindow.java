package by.bsuir.extremum.GUI;

import by.bsuir.extremum.calculations.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainWindow {
    private GridPane gridpane;
    private Scene scene;
    private ExtremumSearch exSearch;

    private Button findExtremums;
    private Button addPoint;
    private Label info;
    private Label xInput;
    private Label yInput;
    private TextField x;
    private TextField y;

    public MainWindow() {
        gridpane = new GridPane();
        scene = new Scene(gridpane, ConstantData.MAIN_WINDOW_WIDTH, ConstantData.MAIN_WINDOW_HEIGHT);

        addPoint = new Button(ConstantData.ADD_POINT);
        findExtremums = new Button(ConstantData.FIND_LOCAL_EXTREMES);
        info = new Label(ConstantData.INFO_INPUT_NUMBERS);
        xInput = new Label(ConstantData.INPUT_X);
        yInput = new Label(ConstantData.INPUT_Y);

        x = new TextField();
        y = new TextField();

        exSearch = new ExtremumSearch();
    }

    public void setGridPaneParameters() {
        gridpane.setPadding(new Insets(ConstantData.MAIN_WINDOW_INSETS));
        gridpane.setHgap(ConstantData.MAIN_WINDOW_HGAP);
        gridpane.setVgap(ConstantData.MAIN_WINDOW_VGAP);
    }

    public void fillGridPane() {
        gridpane.add(info, 0, 0, 2, 1);
        gridpane.add(xInput, 0, 1);
        gridpane.add(x, 1, 1);
        gridpane.add(yInput, 0, 2);
        gridpane.add(y, 1, 2);
        gridpane.add(addPoint, 3, 1, 1, 2);
        gridpane.add(findExtremums, 1, 3, 2, 1);
    }

    public Scene getScene() {
        return scene;
    }

    public void setInfoLabelText(String text) {
        info.setText(text);
    }

    public void setAction(Stage primaryStage) {
        addPoint.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    exSearch.addToMap(x.getText(), y.getText());
                    setInfoLabelText(ConstantData.INFO_INPUT_NUMBERS);
                } catch (NumberFormatException e) {
                    setInfoLabelText(ConstantData.INFO_INPUT_INVALID);
                }
            }
        });

        findExtremums.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    exSearch.findExtremes();
                    ResultWindow resWin = new ResultWindow();
                    resWin.displayWindow(primaryStage);
                    setInfoLabelText(ConstantData.INFO_INPUT_NUMBERS);
                } catch (NullPointerException e) {
                    setInfoLabelText(ConstantData.INFO_INPUT_ZERO);
                } catch (ArrayIndexOutOfBoundsException e) {
                    setInfoLabelText(ConstantData.INFO_INPUT_ONE);
                }
            }
        });
    }
}