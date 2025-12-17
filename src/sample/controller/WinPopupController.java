package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.model.ScoreResult;
import sample.util.SceneManager;

public class WinPopupController {

    @FXML
    private Label moveLabel, timeLabel, starLabel;

    @FXML
    public void initialize() {

        moveLabel.setText("Moves: " + ScoreResult.getMoves());

        int sec = ScoreResult.getSeconds();
        int min = sec / 60;
        int s = sec % 60;
        timeLabel.setText(String.format("Time: %02d:%02d", min, s));

        starLabel.setText("★".repeat(ScoreResult.getStars()));
    }

    public void onContinue() {
        SceneManager.switchScene("view/level_select.fxml", "Select Level");
    }

    public void onReplay() {
        SceneManager.switchScene("view/game.fxml", "Puzzle Game");
    }

    public void onExit() {
        SceneManager.switchScene("view/main_menu.fxml", "Puzzle Slider");
    }
}
