package by.bsuir.extremum;

import by.bsuir.extremum.GUI.ResultWindow;
import by.bsuir.extremum.GUI.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    MainWindow window;

    @Override
    public void start(Stage primaryStage) {
        window = new MainWindow();
        window.setGridPaneParameters();
        window.fillGridpane();
        window.setAction(primaryStage);

        primaryStage.setScene(window.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}