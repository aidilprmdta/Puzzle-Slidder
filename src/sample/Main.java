package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.util.SceneManager;
import sample.util.AudioManager;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        SceneManager.init(stage);
//        AudioManager.playBGM("/audio/bgm.mp3");
        SceneManager.switchScene("view/main_menu.fxml", "Puzzle Slider");
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
