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
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import maze.model.Maze;

public class MouseMazeGUI extends Application
{
    private static final int ROW_NUM = 45; // Number of ROWS
    private static final int COL_NUM = 27;
    private int LEVEL = 1;
    public GridPane gridPane = new GridPane();
    public Maze maze = new Maze("mousemaze/src/main/java/maze/data/Level"+LEVEL+".csv");
    private static String grass1 = "mousemaze/src/main/java/maze/data/art/Grass1.png";
    private static String grass2 = "mousemaze/src/main/java/maze/data/art/Grass2.png";
    private static String grass3 = "mousemaze/src/main/java/maze/data/art/Grass3.png";
    private static ArrayList<String> grasses = new ArrayList<>(Arrays.asList(grass1,grass2,grass3,grass2,grass3,grass2,grass3,grass2,grass3,grass2,grass3,grass2,grass3));
    private static String path1 = "mousemaze/src/main/java/maze/data/art/Path.png";
    private static String path2 = "mousemaze/src/main/java/maze/data/art/Path2.png";
    private static String path3 = "mousemaze/src/main/java/maze/data/art/Path3.png";
    private static String path4 = "mousemaze/src/main/java/maze/data/art/Path4.png";
    private static ArrayList<String> paths = new ArrayList<>(Arrays.asList(path1,path2,path3,path4));
    private static ImageView cheese = createImage("mousemaze/src/main/java/maze/data/art/Cheese.png");
    private static String bush1 = "mousemaze/src/main/java/maze/data/art/Bush.png";
    private static String bush2 = "mousemaze/src/main/java/maze/data/art/Bush2.png";
    private static String bush3 = "mousemaze/src/main/java/maze/data/art/Bush3.png";
    private static ArrayList<String> bushes = new ArrayList<>(Arrays.asList(bush1,bush2,bush3));
    private boolean gameWon = false;
    private WinScreen winScreen = new WinScreen();
    private File file = new File("mousemaze/src/main/java/maze/data/art/Mouse.png");
    private Image image = new Image(file.toURI().toString());
    private ImageView mouse = new ImageView(image);



    @Override
    public void start(Stage primaryStage) 
    {

        // Set up column constraints
        for (int i = 0; i < ROW_NUM; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100.0 / ROW_NUM);
            gridPane.getColumnConstraints().add(column);
        }

        // Set up row constraints
        for (int i = 0; i < COL_NUM; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / COL_NUM);
            gridPane.getRowConstraints().add(row);
        }

        primaryStage.setMaximized(true);
        setGridImage(maze);
        mouse.setTranslateX(-8);
        mouse.setTranslateY(-10);
        mouse.setScaleX(0.9);
        mouse.setScaleY(0.9);
        cheese.setScaleX(1.5);
        cheese.setScaleY(1.5);
        cheese.setTranslateY(-15);
        cheese.setTranslateX(-5);
        gridPane.add(mouse, 0, 1);

        Scene scene = new Scene(gridPane, 1500, 800);
        scene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            int column = GridPane.getColumnIndex(mouse);
            int row = GridPane.getRowIndex(mouse);
            Scene scene2 = winScreen.WinScene();

            switch (keyCode) {
                case UP:
                    if (row > 0) 
                    {
                        if(maze.getSymbol(GridPane.getColumnIndex(mouse), GridPane.getRowIndex(mouse) - 1).equals("P"))
                        {
                            GridPane.setRowIndex(mouse, row - 1);
                        }
                        else if(maze.getSymbol(GridPane.getColumnIndex(mouse), GridPane.getRowIndex(mouse) - 1).equals("C"))
                        {
                            Scene newScene = nextLevel();
                            primaryStage.setScene(newScene);
                        }
                        else
                        {
                            break;
                        }
                    }
                    break;
                case DOWN:
                    if (row < COL_NUM - 1) {
                        if(maze.getSymbol(GridPane.getColumnIndex(mouse), GridPane.getRowIndex(mouse) + 1).equals("P"))
                        {
                            GridPane.setRowIndex(mouse, row + 1);
                        }
                        else if(maze.getSymbol(GridPane.getColumnIndex(mouse), GridPane.getRowIndex(mouse) + 1).equals("C"))
                        {
                            Scene newScene = nextLevel();
                            primaryStage.setScene(newScene);
                        }
                        else
                        {
                            break;
                        }
                    }
                    break;
                case LEFT:
                    if (column > 0) 
                    {
                        if(maze.getSymbol(GridPane.getColumnIndex(mouse) - 1, GridPane.getRowIndex(mouse)).equals("P"))
                        {
                            setMouseLeft();
                            GridPane.setColumnIndex(mouse, column - 1);
                        }
                        else if(maze.getSymbol(GridPane.getColumnIndex(mouse) - 1, GridPane.getRowIndex(mouse)).equals("C"))
                        {
                            setMouseLeft();
                            Scene newScene = nextLevel();
                            primaryStage.setScene(newScene);
                        }
                        else
                        {
                            setMouseLeft();
                            break;
                        }
                    }
                    break;
                case RIGHT:
                        if(maze.getSymbol(GridPane.getColumnIndex(mouse) + 1, GridPane.getRowIndex(mouse)).equals("P"))
                        {
                            setMouseRight();
                            GridPane.setColumnIndex(mouse, column + 1);
                        }
                        else if(maze.getSymbol(GridPane.getColumnIndex(mouse) + 1, GridPane.getRowIndex(mouse)).equals("C"))
                        {
                            setMouseRight();
                            Scene newScene = nextLevel();
                            primaryStage.setScene(newScene);
                        }
                        else
                        {
                            setMouseRight();
                            break;
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

    public static int randomBush()
    {
        Random random = new Random();
        int randomInt = random.nextInt(bushes.size());
        return randomInt;
        
    }

    public void setGridImage(Maze maze)
    {
        int row;
        int col;
        maze.createBoard();
        for(row = 0; row < COL_NUM; row++)
        {
            for(col = 0; col < ROW_NUM; col++)
            {
                if(maze.getBoard()[row][col].equals("G"))
                {
                    gridPane.add(createImage(grasses.get(randomGrass())), col, row);
                }
                else if(maze.getBoard()[row][col].equals("P"))
                {
                    gridPane.add(createImage(paths.get(randomPath())), col, row);
                }
                else if(maze.getBoard()[row][col].equals("B"))
                {
                    gridPane.add(createImage(bushes.get(randomBush())), col, row);
                }
                else if(maze.getBoard()[row][col].equals("C"))
                {
                    gridPane.add(createImage(paths.get(randomPath())), col, row);
                    gridPane.add(cheese, col, row);
                }
            }
        }
    }

    public Scene nextLevel()
    {
        gameWon = true;
        LEVEL = LEVEL + 1;
        maze = new Maze("mousemaze/src/main/java/maze/data/Level"+LEVEL+".csv");
        gridPane.getChildren().clear();
        setGridImage(maze);
        gridPane.add(mouse, 0, 1);
        
        Scene newScene = new Scene(gridPane, 1500, 800);
        return newScene;
    }

    public void setMouseLeft()
    {
        File LeftFile = new File("mousemaze/src/main/java/maze/data/art/MouseLeft.png");
        Image left = new Image(LeftFile.toURI().toString());
        mouse.setImage(left);
    }

    public void setMouseRight()
    {
        File RightFile = new File("mousemaze/src/main/java/maze/data/art/Mouse.png");
        Image right = new Image(RightFile.toURI().toString());
        mouse.setImage(right);
    }
    
}
