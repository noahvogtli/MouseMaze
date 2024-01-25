package maze.view;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUITest extends Application 
{
    private static final int GRID_WIDTH = 45; // GridPane size
    private static final int GRID_HEIGHT = 27;

    @Override
    public void start(Stage primaryStage) 
    {
        GridPane gridPane = new GridPane();
        File file = new File("mousemaze/src/main/java/maze/data/art/Mouse.png");
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(image);
        gridPane.add(imageView, 0, 0);

        // Set up row and column constraints
        for (int i = 0; i < GRID_HEIGHT; i++) 
        {
            for (int n = 0; n < GRID_WIDTH; n++)
            {
                ColumnConstraints column = new ColumnConstraints();
                column.setPercentWidth(100.0 / GRID_HEIGHT);
                gridPane.getColumnConstraints().add(column);

                RowConstraints row = new RowConstraints();
                row.setPercentHeight(100.0 / GRID_WIDTH);
                gridPane.getRowConstraints().add(row);
            }
        }

        Scene scene = new Scene(gridPane, 1500, 800);
        scene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            int column = GridPane.getColumnIndex(imageView);
            int row = GridPane.getRowIndex(imageView);

            switch (keyCode) {
                case UP:
                    if (row > 0) {
                        GridPane.setRowIndex(imageView, row - 1);
                    }
                    break;
                case DOWN:
                    if (row < GRID_WIDTH - 1) {
                        GridPane.setRowIndex(imageView, row + 1);
                    }
                    break;
                case LEFT:
                    if (column > 0) {
                        GridPane.setColumnIndex(imageView, column - 1);
                    }
                    break;
                case RIGHT:
                    if (column < GRID_HEIGHT - 1) {
                        GridPane.setColumnIndex(imageView, column + 1);
                    }
                    break;
                default:
                    break;
            }
        });

        // Set focus on the scene to capture key events
        scene.getRoot().requestFocus();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Image Move App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


