package maze.view;

import java.io.File;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MouseMazeGUI extends Application
{
    private Pane pane;

    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        ImageView mouseView = createImage("mousemaze/src/main/java/maze/data/art/Mouse.png");
        ImageView pathView = createImage("mousemaze/src/main/java/maze/data/art/Path.png");
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(mouseView);
        pane = new Pane();
        pane.setMaxSize(1920, 1080);
        pane.setPrefSize(800, 800);
        pane.getChildren().addAll(stackPane);
        Scene scene = new Scene(pane);
        scene.setOnKeyPressed(e -> {
                if ( e.getCode() == KeyCode.RIGHT) {
                    stackPane.setLayoutX(stackPane.getLayoutX() + 25);
                } else if (e.getCode() == KeyCode.LEFT) {
                    stackPane.setLayoutX(stackPane.getLayoutX() - 25);
                } else if (e.getCode() == KeyCode.UP) {
                    stackPane.setLayoutY(stackPane.getLayoutY() - 25);
                } else if (e.getCode() == KeyCode.DOWN) {
                    stackPane.setLayoutY(stackPane.getLayoutY() + 25);
                }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static ImageView createImage(String path)
    {
        File file = new File(path);
        Image image = new Image(file.toURI().toString());
        ImageView view = new ImageView(image);
        return view;
    }
     
}
