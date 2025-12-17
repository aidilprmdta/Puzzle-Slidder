package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(
                FXMLLoader.load(getClass().getResource("/view/layout.fxml")),
                400, 500
        );

        scene.getStylesheets().add(
                getClass().getResource("/style/style.css").toExternalForm()
        );

        stage.setTitle("Puzzle Slider");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
