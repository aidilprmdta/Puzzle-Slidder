package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class PuzzleController {

    private static final int SIZE = 4;

    @FXML
    private GridPane gridPane;

    @FXML
    private Label moveLabel;

    @FXML
    private Button shuffleBtn, resetBtn;

    private Button[][] tiles = new Button[SIZE][SIZE];
    private int emptyRow = SIZE - 1;
    private int emptyCol = SIZE - 1;
    private int moveCount = 0;

    @FXML
    public void initialize() {
        initBoard();
    }

    private void initBoard() {
        int number = 1;

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {

                if (row == SIZE - 1 && col == SIZE - 1) {
                    tiles[row][col] = null; // empty tile
                    continue;
                }

                Button tile = new Button(String.valueOf(number++));
                tile.getStyleClass().add("tile");

                tiles[row][col] = tile;
                gridPane.add(tile, col, row);
            }
        }
    }

    private int getRow(Button btn) {
        return GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
    }

    private int getCol(Button btn) {
        return GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);
    }

    private void animateMove(Button tile, int targetRow, int targetCol) {

        int currentRow = getRow(tile);
        int currentCol = getCol(tile);

        double deltaX = (targetCol - currentCol) * 88; // tile + gap
        double deltaY = (targetRow - currentRow) * 88;

        TranslateTransition tt = new TranslateTransition(Duration.millis(180), tile);
        tt.setByX(deltaX);
        tt.setByY(deltaY);

        tt.setOnFinished(e -> {
            tile.setTranslateX(0);
            tile.setTranslateY(0);

            GridPane.setRowIndex(tile, targetRow);
            GridPane.setColumnIndex(tile, targetCol);
        });

        tt.play();
    }

    private boolean isValidMove(int tileRow, int tileCol) {
        int distance = Math.abs(tileRow - emptyRow)
                + Math.abs(tileCol - emptyCol);
        return distance == 1;
    }

    private void moveTile(Button tile) {

        int tileRow = getRow(tile);
        int tileCol = getCol(tile);

        if (!isValidMove(tileRow, tileCol)) {
            return; // move tidak sah → stop
        }

        // Simpan posisi empty
        int targetRow = emptyRow;
        int targetCol = emptyCol;

        // Update data array DULU
        tiles[emptyRow][emptyCol] = tile;
        tiles[tileRow][tileCol] = null;

        emptyRow = tileRow;
        emptyCol = tileCol;

        // Baru animasi
        animateMove(tile, targetRow, targetCol);

        moveCount++;
        moveLabel.setText("Moves: " + moveCount);

    }

}

