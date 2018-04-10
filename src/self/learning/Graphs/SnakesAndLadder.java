package self.learning.Graphs;

import java.util.*;

public class SnakesAndLadder {

    static void BuildGameBoard()
    {
        int[][] Board = new int[][]{
                {-1, -1, -1, -1},
                {-1, -1, 13, -1},
                {17, -1, -1, -1},
                {-1, 3, -1, -1},
                {-1, -1, 1, -1}
        };

        int res = find_min_no_of_dice_throws(Board);

        System.out.println("Result = " + res);
    }

    static class Cell
    {
        int distance;
        int vertex;

        Cell(int d, int v)
        {
            distance = d;
            vertex = v;
        }
    }
    static int find_min_no_of_dice_throws(int[][] board) {

        int N = board.length * board[0].length;
        boolean[] visited = new boolean[N];
        int[] arr = new int[N];

        int nRows = board.length;
        int nCols = board[0].length;

        for(int row = 0; row < nRows; row++)
        {
            for(int col = 0; col < nCols; col++)
            {
                int index = (row + 1) * (col + 1) - 1;
                arr[index] = board[row][col];

                System.out.print(arr[index] + " ");
            }
            System.out.println();
        }

        Cell cell = new Cell(0, 0);

        Queue<Cell> queue = new ArrayDeque<>();

        queue.add(cell);

        while(!queue.isEmpty())
        {
            cell = queue.remove();

            if(cell.vertex == N - 1)
                break;

            for(int i = cell.vertex + 1; i <= cell.vertex + 6; i++)
            {
                if(!visited[i])
                {
                    int dist = 1 + cell.distance;
                    int vertex = arr[i] == -1 ? i : arr[i];

                    queue.add(new Cell(dist, vertex));
                    visited[i] = true;
                }
            }
        }
        return  cell.distance;
    }
}
