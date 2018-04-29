package self.learning.Graphs;
import java.util.*;

/*
* Input:                 Output:
 3                      7 2
 1 5 2
 2 4 7
 3 6 9

The basins, labeled with A’s and B’s, are:
 A A B
 A A B
 A A A
-----------------------------------------
Input:                  Output:
 1                       1
 10

There is only one basin in this case.
The basin, labeled with A’s is:
 A
-----------------------------------------
Input:                  Output:
 5                       11 7 7
 1 0 2 5 8
 2 3 4 7 9
 3 5 7 8 9
 1 2 5 4 3
 3 3 5 2 1

The basins, labeled with A’s, B’s, and C’s, are:
 A A A A A
 A A A A A
 B B A C C
 B B B C C
 B B C C C
-----------------------------------------
Input:                  Output:
 4                       7 5 4
 0 2 1 3
 2 1 0 4
 3 3 3 3
 5 5 2 1

The basins, labeled with A’s, B’s, and C’s, are:
 A A B B
 A B B B
 A B B C
 A C C C
*
*
* */
public class RainfallChallenge {

    static  boolean[][] visited;
    //static int[][] parent ;
    static Map<Cell, Integer> basins = new HashMap<>();
    static Map<Integer, Cell> cells = new HashMap<>();

    static class Cell
    {
        int val;
        int row;
        int col;
        Cell parent;

        Cell(int val, int r, int c)
        {
            this.val = val;
            row = r;
            col = c;
            parent = this;
        }
    }

    static void BuildRainfallChallenge() {
        int[][] elevation_map = new int[][]{
                {1, 5, 2},
                {2, 4, 7},
                {3, 6, 9}
        };

        elevation_map = new int[][] {
                {1, 0, 2, 5, 8},
                {2, 3, 4, 7, 9},
                {3, 5, 7, 8, 9},
                {1, 2, 5, 4, 3},
                {3, 3, 5, 2, 1}
        };

        calculate_sizes_of_basins(elevation_map);
    }

//    static int getIndex(int row, int col, int M, int N)
//    {
            //index = (numOfCols * rowIndex) + colIndex;
//        return N * row + col;
//    }

    static int[] calculate_sizes_of_basins(int[][] elevation_map) {

        visited = new boolean[elevation_map.length][elevation_map[0].length];

        for(int i = 0; i < elevation_map.length; i++)
        {
            for(int j = 0; j < elevation_map[0].length; j++)
            {
                int index = elevation_map[0].length * i + j;
                cells.put(index, new Cell(elevation_map[i][j], i,j));
            }
        }

        for(Cell cell : cells.values())
        {
            cell.parent = findParent(cell, elevation_map);
            updateBasin(basins, cell.parent);
        }

        for(int i = 0; i < elevation_map.length; i++)
        {
            for(int j = 0; j < elevation_map[0].length; j++)
            {
                int index = elevation_map[0].length * i + j;
                Cell cell = cells.get(index);

                System.out.print(cell.parent.val + " ");
            }

            System.out.println();
        }

        int[] result = new int[basins.size()];
        int index = 0;
        for(Integer val : basins.values())
        {
            result[index] = val;
            index++;
        }

        Arrays.sort(result);

        return result;
    }

    static void updateBasin(Map<Cell, Integer> basin, Cell parent)
    {
        if(basin.containsKey(parent))
        {
            basin.put(parent, basin.get(parent) + 1);
        }
        else
        {
            basin.put(parent, 1);
        }
    }

    static Cell findParent(Cell cell, int[][] elevation_map)
    {
        if(visited[cell.row][cell.col])
            return cell.parent;

        Cell minCell = findMinCell(cell, elevation_map);

        if(minCell == cell)
        {
            visited[minCell.row][minCell.col] = true;
            return minCell;
        }
        else{
            //visited[cell.row][cell.col] = true;
            cell.parent = findParent(minCell, elevation_map);
            visited[cell.row][cell.col] = true;

        }
        return cell.parent;
    }

    static Cell findMinCell(Cell cell, int[][] elevation_map)
    {
        Cell minCell = cell;

        int N = elevation_map.length;
        int M = elevation_map[0].length;

        int row = cell.row - 1;
        int col = cell.col;

        if(row >= 0 && row < N && col >= 0 && col < M)
        {
            if(elevation_map[row][col] < elevation_map[minCell.row][minCell.col]) {

                int index = elevation_map[0].length * row + col;
                minCell = cells.get(index);
            }
        }

        row = cell.row;
        col = cell.col + 1;

        if(row >= 0 && row < N && col >= 0 && col < M)
        {
            if(elevation_map[row][col] < elevation_map[minCell.row][minCell.col]) {

                int index = elevation_map[0].length * row + col;
                minCell = cells.get(index);
            }
        }

        row = cell.row + 1;
        col = cell.col;

        if(row >= 0 && row < N && col >= 0 && col < M)
        {
            if(elevation_map[row][col] < elevation_map[minCell.row][minCell.col]) {

                int index = elevation_map[0].length * row + col;
                minCell = cells.get(index);
            }
        }

        row = cell.row;
        col = cell.col - 1;

        if(row >= 0 && row < N && col >= 0 && col < M)
        {
            if(elevation_map[row][col] < elevation_map[minCell.row][minCell.col]) {

                int index = elevation_map[0].length * row + col;
                minCell = cells.get(index);
            }
        }

        return minCell;

    }

}
