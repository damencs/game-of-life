import java.text.SimpleDateFormat;
import java.util.Date;

/*
    Name: Damen DeBerry
    Class: CS4306 - Algorithm Analysis
    PA: Assignment 1 - Game of Life

    Problem Description:
        • Life is played on a grid of square cells. A cell can be live or dead.
        • A live cell is shown by putting a marker (1) on its square.
        • A dead cell is shown by leaving a marker (0) on its square.
        • Each cell in the grid has a neighborhood consisting of the eight cells in every direction including diagonals.
        • Cells on the four edges of the grid have fewer than eight neighbors, of course.

    Rules of the game:
        To apply one step of the rules, you have to count the number of live neighbors for each cell.
        What happens next depends on this number
            • A dead cell with exactly three live neighbors becomes a live cell (birth).
            • A live cell with two or three live neighbors stays alive (survival).
            • In all other cases, a cell dies or remains dead (overcrowding or loneliness).
            Note: The number of live neighbors is always based on the cells before the rule was applied.
            In other words, you must first find all of the cells that change before changing any of them.

    Data Structure:
        Two-dimensional array/Vector

    Sample Input:
        The program can be run on a 5x5 and 10x10 array for simplicity.
        You should simulate up to the 50th generation (10, 20, ..., 50).
        The input should contain the initial values of the cells.
        0 0 0 0 0
        0 1 0 0 0
        0 0 1 0 0
        0 0 0 1 0
        0 0 0 0 0

    Sample output:
        The output should be displayed in text mode.
        The system time should be output in milliseconds.
 */
public class GameOfLife
{
    public static void main(String[] args)
    {
        // Initialize a new Board Handler Object
        Board boardHandler = new Board();

        // Create a new randomized board
        //int board[][] = boardHandler.createBoard();

        // Initial Assignment or Custom Board if Desired to be used.
        int board[][] =
                {
                    {1,1,0,1,0},
                    {1,1,0,0,0},
                    {1,1,0,1,1},
                    {1,1,1,0,1},
                    {0,0,0,1,1}
                };

        // Acquire Current System Time
        long startingTime = System.currentTimeMillis();

        // Display Starting Board Generation
        System.out.println("Initial Generation:");
        boardHandler.print(board);

        // Iterate through future Board Generations and Display
        for (int generations = 2; generations <= 1000000; generations++)
        {
            // Generate the next board
            board = boardHandler.generate(board);

            // Display out for every 10th-generation
            if (generations % 10 == 0)
            {
                System.out.println("\nGeneration #" + generations);
                boardHandler.print(board);
            }
        }

        // Display Operation Completion Time
        System.out.println("\nOperation Completed in: " + (System.currentTimeMillis() - startingTime) + "ms");
    }
}