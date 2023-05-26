package maze.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUITest  extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Translate Example");

        Button button = new Button("Click me!");
        button.setLayoutX(50); // Set initial x-position
        button.setLayoutY(50); // Set initial y-position

        button.setOnAction(event -> {
            double newX = button.getLayoutX() + 10; // Move 10 units to the right
            double newY = button.getLayoutY() + 10; // Move 10 units down
            button.setLayoutX(newX);
            button.setLayoutY(newY);
        });

        Pane pane = new Pane(button);
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

