package self.learning.Graphs;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

public class IslandProblem {

    static void CountIslands(int[][] grid)
    {
        int numRows = grid.length;
        int numCols = grid[0].length;

        boolean[][] visited = new boolean[numRows][numCols];

        int count = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(!visited[i][j] && grid[i][j] == 1)
                {
                    CountIslandsRecurse(grid, visited, i, j);
                    count++;
                }
            }
        }

        System.out.println("No of Islands = " + count);

    }

    static void CountIslandsRecurse(int[][] grid, boolean[][] visited, int row, int col)
    {
        if(visited[row][col])
            return;

        visited[row][col] = true;

        List<Cell> neighbors = getNeighbors(grid, row, col, visited);

        for (Cell cell : neighbors) {
            CountIslandsRecurse(grid, visited, cell.i, cell.j);
        }

    }

    static List<Cell> getNeighbors(int[][] grid, int row, int col, boolean[][] visited)
    {
        List<Cell> cells = new ArrayList<>();

        if(isValidCell(grid, row - 1, col ))
            cells.add(new Cell(row - 1, col));

        if(isValidCell(grid, row + 1, col ))
            cells.add(new Cell(row + 1, col));

        if(isValidCell(grid, row, col - 1 ))
            cells.add(new Cell(row, col - 1));

        if(isValidCell(grid, row, col + 1 ))
            cells.add(new Cell(row, col + 1));

        return cells;
    }

    static boolean isValidCell(int [][] grid, int rowIndex, int colIndex)
    {
        return rowIndex >= 0 && rowIndex < grid.length && colIndex >= 0 && colIndex < grid[0].length && grid[rowIndex][colIndex] == 1;
    }

    static class Cell
    {
        int i;
        int j;

        Cell(int a, int b)
        {
            i = a;
            j = b;
        }
    }


}
