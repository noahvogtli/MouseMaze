package maze.view;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class WinScreen
{
    public WinScreen()
    {

    }

    public Scene WinScene() {
        Label label = new Label("YOU WON");
        label.setFont(new Font("Arial", 75));
        label.setTextAlignment(TextAlignment.CENTER);
    
        VBox vbox1 = new VBox(label);
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setPadding(new Insets(100));
        vbox1.setPrefSize(1500, 800);
    
        Scene scene = new Scene(vbox1);
        return scene;
    }
    
}
