package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import sample.model.LevelConfig;
import sample.util.SceneManager;

public class LevelSelectController {

    @FXML
    private GridPane levelGrid;

    @FXML
    public void initialize() {
        createLevelButtons();
    }

    private void createLevelButtons() {

        int level = 1;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                Button btn = new Button("Level " + level);
                btn.setPrefSize(120, 60);

                final int selectedLevel = level;

                btn.setOnAction(e -> {
                    LevelConfig.setLevel(selectedLevel);
                    SceneManager.switchScene("view/game.fxml", "Puzzle Game");
                });

                levelGrid.add(btn, col, row);
                level++;
            }
        }
    }

    public void onBack() {
        SceneManager.switchScene("view/main_menu.fxml", "Puzzle Slider");
    }
}
