package sample.controller;

import javafx.application.Platform;
import sample.util.SceneManager;

public class MainMenuController {

    public void onStart() {
        SceneManager.switchScene("view/level_select.fxml", "Select Level");
    }

    public void onSettings() {
        SceneManager.switchScene("view/settings.fxml", "Settings");
    }

    public void onExit() {
        Platform.exit();
    }
}
