/*
    Name: Damen DeBerry
    Class: CS4306 - Algorithm Analysis
    PA: Assignment 1 - Game of Life
 */
public class Board
{
    // Create a Board with Randomized Survivors
    public static int[][] createBoard()
    {
        // Initialize Board in a Two-Dimensional Array
        int[][] board = new int[5][5];

        // Iterate through the rows
        for (int row = 0; row < board.length; row++)
        {
            // Iterate through columns
            for (int column = 0; column < board[row].length; column++)
            {
                board[row][column] = (int)(Math.random() * 2);
            }
        }

        return board;
    }

    // Check Survivors within Generated Board
    public static int countSurvivors(int[][] board, int row, int column)
    {
        // Track count of living cells
        int livingCells = 0;

        // North Neighbor
        if (row - 1 >= 0)
        {
            livingCells += board[row - 1][column];
        }

        // Northeast Neighbor
        if (row - 1 >= 0 && column + 1 < board[0].length)
        {
            livingCells += board[row - 1][column + 1];
        }

        // East Neighbor
        if (column + 1 < board[0].length)
        {
            livingCells += board[row][column + 1];
        }

        // Southeast Neighbor
        if (row + 1 < board.length && column + 1 < board[0].length)
        {
            livingCells += board[row + 1][column + 1];
        }

        // South Neighbor
        if (row + 1 < board.length)
        {
            livingCells += board[row + 1][column];
        }

        // Southwest Neighbor
        if (row + 1 < board.length && column - 1 >= 0)
        {
            livingCells += board[row + 1][column - 1];
        }

        // West Neighbor
        if (column - 1 >= 0)
        {
            livingCells += board[row][column - 1];
        }

        // Northwest Neighbor
        if (row - 1 >= 0 && column - 1 >= 0)
        {
            livingCells += board[row - 1][column - 1];
        }

        return livingCells;
    }

    // Utilize Conway's Rules of Life
    public int conwayRule(int[][] board, int row, int column)
    {
        // Locate survivors nearby
        int survivors = countSurvivors(board, row, column);

        // Birth
        if (board[row][column] == 0 && survivors == 3)
        {
            return 1;
        }
        // Survival
        else if (board[row][column] == 1 && (survivors == 2 || survivors == 3))
        {
            return 1;
        }
        // Death
        else
        {
            return 0;
        }
    }

    // Generate the next board
    public int[][] generate(int[][] board)
    {
        int[][] newBoard = new int[5][5];

        // Iterate through rows
        for (int row = 0; row < board.length; row++)
        {
            // Iterate through columns
            for (int column = 0; column < board[row].length; column++)
            {
                // Utilize Rules of Life
                newBoard[row][column] = conwayRule(board, row, column);
            }
        }

        return newBoard;
    }

    // Print Board (Text-Based 2D-Array)
    public void print(int board[][])
    {
        for (int row = 0; row < board.length; row++)
        {
            for (int column = 0; column < board[row].length; column++)
            {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }
}
