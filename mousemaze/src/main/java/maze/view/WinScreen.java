package maze.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WinScreen extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        Label label = new Label("YOU WON");
        Scene scene = new Scene(label);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
