package self.learning.Graphs;

import java.util.*;

public class KnightsTour {

    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col)
    {
        if(start_row == end_row && start_col == end_col)
            return 0;

        int[][] distance = new int[rows][cols];

        Queue<Cell> queue = new ArrayDeque();
        Cell cell = new Cell(start_row, start_col);
        queue.add(cell);

        while(!queue.isEmpty()) {
            Cell currentCell = queue.remove();

            List<Cell> neighbors = getNeighbors(rows, cols, currentCell.row, currentCell.col, distance);
            for (Cell neighbor : neighbors) {
                queue.add(neighbor);
                distance[neighbor.row][neighbor.col] = 1 + distance[currentCell.row][currentCell.col];
                if (neighbor.row == end_row && neighbor.col == end_col) {

                    return distance[neighbor.row][neighbor.col];
                }

            }
        }
        return -1;

    }

    static List<Cell> getNeighbors(int rows, int cols, int row, int col, int[][] distance)
    {
        List<Cell> neighbors = new ArrayList<>();
        int[][] shift = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1,-2} };

        for(int[] index : shift)
        {
            int r = row + index[0];
            int c = col + index[1];

            if(isValid(rows, cols, r, c, distance))
            {
                neighbors.add(new Cell(r, c));
            }
        }
//        if(isValid(rows, cols, row - 2, col - 1, distance))
//            neighbors.add(new Cell(row - 2, col - 1));
//
//        if(isValid(rows, cols, row - 2, col + 1, distance))
//            neighbors.add(new Cell(row - 2, col + 1));
//
//        if(isValid(rows, cols, row - 1, col + 2, distance))
//            neighbors.add(new Cell(row - 1, col + 2));
//
//        if(isValid(rows, cols, row + 1, col + 2, distance))
//            neighbors.add(new Cell(row + 1, col + 2));
//
//        if(isValid(rows, cols, row + 2, col + 1, distance))
//            neighbors.add(new Cell(row + 2, col + 1));
//
//        if(isValid(rows, cols, row +  2, col - 1, distance))
//            neighbors.add(new Cell(row + 2, col - 1));
//
//        if(isValid(rows, cols, row + 1, col - 2, distance))
//            neighbors.add(new Cell(row + 1, col - 2));
//
//        if(isValid(rows, cols, row - 1 , col - 2, distance))
//            neighbors.add(new Cell(row - 1, col - 2));
        return neighbors;
    }

    static boolean isValid(int rows, int cols, int row, int col, int[][] distance)
    {
        return (row >= 0 && row < rows && col >= 0 && col < cols && distance[row][col] == 0);
    }

    static class Cell
    {
        int row;
        int col;

        Cell(int i, int j)
        {
            row = i; col = j;
        }
    }
}
