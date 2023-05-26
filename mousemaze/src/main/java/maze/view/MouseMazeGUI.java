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
        File mousefile = new File("ProjectMouseMaze/MouseMaze/mousemaze/src/main/java/maze/data/art/Mouse.png");
        Image mouse = new Image(mousefile.toURI().toString());
        ImageView mouseView = new ImageView(mouse);
        File pathfile = new File("ProjectMouseMaze/MouseMaze/mousemaze/src/main/java/maze/data/art/Path.png");
        Image path = new Image(pathfile.toURI().toString());
        ImageView pathView = new ImageView(path);
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
}
