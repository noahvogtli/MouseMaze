module maze {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens maze to javafx.fxml;
    exports maze;
}