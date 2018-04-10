package self.learning;

public class CountPaths {

    static int NumberOfPaths(int[][]grid)
    {
       return CountPathsRecurse(grid, 0, 0);
    }

    private static int CountPathsRecurse(int[][]grid, int row, int col)
    {
        int M = grid.length;
        int N = grid[0].length;

        if(row == M - 1 || col == N - 1)
        {
            return 1;
        }
        if(row >= M || col >= N)
        {
            return 0;
        }

        return CountPathsRecurse(grid, row, col + 1) + CountPathsRecurse(grid, row + 1, col);
    }
}
