package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import sample.util.AudioManager;
import sample.util.SceneManager;

public class SettingsController {

    @FXML
    private Slider musicSlider, sfxSlider;

    @FXML
    public void initialize() {
        musicSlider.setValue(AudioManager.getMusicVolume());
        sfxSlider.setValue(AudioManager.getSfxVolume());

        musicSlider.valueProperty().addListener((obs, oldVal, newVal) ->
                AudioManager.setMusicVolume(newVal.doubleValue()));

        sfxSlider.valueProperty().addListener((obs, oldVal, newVal) ->
                AudioManager.setSfxVolume(newVal.doubleValue()));
    }

    public void onBack() {
        SceneManager.switchScene("view/main_menu.fxml", "Puzzle Slider");
    }
}
