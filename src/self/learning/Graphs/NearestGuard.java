package self.learning.Graphs;

import java.util.*;

public class NearestGuard {

    static class Cell
    {
        int row;
        int col;
        int distance;

        Cell(int r, int c, int d)
        {
            row = r;
            col = c;
            distance = d;
        }
    }

    static void BuildNearestGuard()
    {
        char[][] inputMatrix = new char[][]{
                {'O', 'O', 'O', 'O', 'G'},
                {'O', 'W', 'W', 'O', 'O'},
                {'O', 'O', 'O', 'W', 'O'},
                {'G', 'W', 'W', 'W', 'O'},
                {'O', 'O', 'O', 'O', 'G'}
        };

        find_shortest_distance_from_a_guard(inputMatrix);
    }

    static void find_shortest_distance_from_a_guard(char[][] grid) {


        int[][] output = new int[grid.length][grid[0].length];
        Queue<Cell> queue = new ArrayDeque<>();

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 'G')
                {
                    queue.add(new Cell(i,j, 0));
                }
                else
                {
                    output[i][j] = -1;
                }
            }
        }

        while(!queue.isEmpty())
        {
            Cell cell = queue.remove();

            List<Cell> neighbors = getNeighbors(grid, cell.row, cell.col, output);

            for(Cell c : neighbors)
            {
                output[c.row][c.col] = cell.distance + 1;
                c.distance = cell.distance + 1;
                queue.add(c);
            }

        }

        int[] res = new int[output.length * output[0].length];

        for(int i = 0; i < output.length; i++)
        {
            for(int j = 0; j < output[0].length; j++) {
                int index = i * output[0].length + j;
                //THIS IS COMPLETELY INCORRECT: int index = (i + 1) * (j + 1) - 1;
                //System.out.print(index + " ");
                res[index] = output[i][j];

                if (res[index] >= 0) {
                    System.out.print(" " + res[index] + " ");
                } else {
                    System.out.print(res[index] + " ");
                }
            }
            System.out.println();
        }
    }

    static List<Cell> getNeighbors(char[][] grid, int row, int col, int[][] output)
    {
        List<Cell> list = new ArrayList<>();

        int r, c;

        r = row - 1; c = col;

        if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 'O' && output[r][c] == -1)
        {
            list.add(new Cell(r, c, 0));
        }

        r = row + 1; c = col;

        if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 'O' && output[r][c] == -1)
        {
            list.add(new Cell(r, c, 0));
        }

        r = row; c = col - 1;

        if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 'O' && output[r][c] == -1)
        {
            list.add(new Cell(r, c, 0));
        }

        r = row; c = col + 1;

        if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 'O' && output[r][c] == -1)
        {
            list.add(new Cell(r, c, 0));
        }

        return list;

    }

}
