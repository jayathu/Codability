package self.learning.Recursion;

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

    static int maxWeight(int [][] weights)
    {
        return maxWeightRecurse(weights, 0, 0);
    }

    public static void buildAndRun()
    {
        int[][] weights = new int[][]{
                                        { 2, 1, 40 },
                                        { 4, 5, 6 },
                                        { 3, 1, 2 }
                                    };

        //System.out.print("Max weight = " + maxWeight(weights));

        System.out.println("Max Weight = " + maxWeightDP(weights));
    }

    static int maxWeightRecurse(int[][] weights, int row, int col)
    {
        int M = weights.length;
        int N = weights[0].length;

        if(row == M - 1 && col == N - 1){
            return weights[row][col];
        }
        if(row >= N || col >= M)
        {
            return 0;
        }
        return Math.max(maxWeightRecurse(weights, row + 1, col), maxWeightRecurse(weights, row, col + 1)) + weights[row][col];
    }

    static int maxWeightDP(int[][] weights)
    {
        int M = weights.length;
        int N = weights[0].length;

        int[][] DP = new int[M][N];

        for(int row = M - 1; row >= 0; row --)
        {
            for(int col = N - 1; col >= 0; col --)
            {
                if(row == M - 1 && col == N - 1) {
                    DP[row][col] = weights[row][col];
                }
                else if(row == M - 1)
                {
                    DP[row][col] = weights[row][col] + DP[row][col+1];
                }
                else if(col == N - 1)
                {
                    DP[row][col] = weights[row][col] + DP[row + 1][col];
                }
                else {
                    DP[row][col] = weights[row][col] + Math.max(DP[row+1][col], DP[row][col+1]);
                }
            }
        }

        for(int i = 0; i < DP.length; i++)
        {
            for(int j = 0; j < DP[0].length; j++)
            {
                System.out.print(DP[i][j] + " ");
            }
            System.out.println();
        }

        return DP[0][0];
    }
}
