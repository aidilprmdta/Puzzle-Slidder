package sample;

import javafx.application.Application;
<<<<<<< HEAD
import javafx.stage.Stage;
import sample.util.SceneManager;
import sample.util.AudioManager;
=======
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
>>>>>>> d1d606eef84e98a432d151b977b1ed0049c72a06

public class Main extends Application {

    @Override
<<<<<<< HEAD
    public void start(Stage stage) {
        SceneManager.init(stage);
//        AudioManager.playBGM("/audio/bgm.mp3");
        SceneManager.switchScene("view/main_menu.fxml", "Puzzle Slider");
        stage.show();
    }


=======
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

>>>>>>> d1d606eef84e98a432d151b977b1ed0049c72a06
    public static void main(String[] args) {
        launch();
    }
}
