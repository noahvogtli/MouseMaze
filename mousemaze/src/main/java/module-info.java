module maze {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens maze.view to javafx.fxml;
    exports maze.view;
}