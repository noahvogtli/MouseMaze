package maze.view;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MouseMazeGUI extends Application
{
    private GridPane pane;

    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        ImageView mouseView = createImage("mousemaze/src/main/java/maze/data/art/Mouse.png");
        ImageView pathView = createImage("mousemaze/src/main/java/maze/data/art/Path.png");
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(pathView,mouseView);
        pane = new GridPane();
        pane.setPrefSize(500,500);
        pane.getChildren().addAll(stackPane);
        Scene scene = new Scene(pane);
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
