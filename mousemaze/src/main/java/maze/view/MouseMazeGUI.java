package maze.view;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.css.Size;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import maze.model.Maze;

public class MouseMazeGUI extends Application
{
    private static final int GRID_SIZE = 50; // GridPane size
    public GridPane gridPane = new GridPane();
    public Maze maze = new Maze("mousemaze/src/main/java/maze/data/Level1.csv");
    private static String grass1 = "mousemaze/src/main/java/maze/data/art/Grass1.png";
    private static String grass2 = "mousemaze/src/main/java/maze/data/art/Grass2.png";
    private static ArrayList<String> grasses = new ArrayList<>(Arrays.asList(grass1,grass2));
    private static String path1 = "mousemaze/src/main/java/maze/data/art/Path.png";
    private static String path2 = "mousemaze/src/main/java/maze/data/art/Path_2.png";
    private static ArrayList<String> paths = new ArrayList<>(Arrays.asList(path1,path2));


    @Override
    public void start(Stage primaryStage) {
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();
        // Set up row and column constraints
        for (int i = 0; i < GRID_SIZE; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setMaxWidth(screenWidth / 50);
            // column.setPercentWidth(100.0 / GRID_SIZE);
            gridPane.getColumnConstraints().add(column);

            RowConstraints row = new RowConstraints();
            // row.setPercentHeight(100.0 / GRID_SIZE);
            row.setMaxHeight(screenHeight / 60);
            gridPane.getRowConstraints().add(row);
        }

        setGridImage(maze);
        File file = new File("mousemaze/src/main/java/maze/data/art/Mouse.png");
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(image);
        gridPane.add(imageView, 0, 0);

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
                    if (row < GRID_SIZE - 1) {
                        GridPane.setRowIndex(imageView, row + 1);
                    }
                    break;
                case LEFT:
                    if (column > 0) {
                        GridPane.setColumnIndex(imageView, column - 1);
                    }
                    break;
                case RIGHT:
                    if (column < GRID_SIZE - 1) {
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
        primaryStage.setTitle("Mouse Maze");
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

    public static int randomGrass()
    {
        Random random = new Random();
        int randomInt = random.nextInt(grasses.size());
        return randomInt;
        
    }

    public static int randomPath()
    {
        Random random = new Random();
        int randomInt = random.nextInt(paths.size());
        return randomInt;
        
    }

    public void setGridImage(Maze maze)
    {
        int row;
        int col;
        maze.createBoard();
        for(row = 0; row < GRID_SIZE; row++)
        {
            for(col = 0; col < GRID_SIZE; col++)
            {
                if(maze.getBoard()[col][row].equals("G"))
                {
                    gridPane.add(createImage(grasses.get(randomGrass())), col, row);
                }
                else if(maze.getBoard()[col][row].equals("P"))
                {
                    gridPane.add(createImage(paths.get(randomPath())), col, row);
                }
            }
        }
    }
     
}
