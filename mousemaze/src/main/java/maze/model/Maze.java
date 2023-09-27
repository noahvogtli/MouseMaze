package maze.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 * This maze class represents a physical maze board using a 2d array
 * 
 * @author Noah Vogtli
 * @version 1.0
 */

public class Maze 
{
    /**
     * @param BOARD_DIMENSION dimension of the board
     * @param board 2d array representation of the maze board
     * @param filename string representation of the filename of the level
     */
    
    private final int BOARD_DIMENSION = 50;
    private String[][] board;
    private String filename;

    public Maze(String filename)
    {
        board = new String[BOARD_DIMENSION][BOARD_DIMENSION];
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
    
    public String[][] getBoard() {
        return board;
    }

    public String[][] createBoard()
    {
        board = new String[BOARD_DIMENSION][BOARD_DIMENSION];
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) 
        {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null && row < BOARD_DIMENSION) 
            {
                String[] linesplit = line.split(",");
                for (int i = 0; i < linesplit.length && i < BOARD_DIMENSION; i++) 
                {
                    board[row][i] = linesplit[i];
                }
                row++;
            }
        
            } catch (Exception e) {
                System.out.println("File not found");
            }

            return board;
        }

    @Override
    public String toString() 
    {
        String boardString = ""; 
        for (String[] row : board) {
          boardString+=Arrays.toString(row)+"\n";
        }
        return boardString;
    }

    public String getSymbol(int row, int col)
    {
        return board[col][row];
    }

    
    
    
    public static void main(String[] args) 
    {
        Maze maze = new Maze("mousemaze/src/main/java/maze/data/Level1.csv");
        maze.createBoard();
        
        System.out.println(maze.toString());
    }
}

