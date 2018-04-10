package self.learning.DynamicProgramming;

public class CoinPlay {

    public static int compute_recursive(int[] coins, int i, int j)
    {
        if(i == j)
            return coins[i];

        if(i + 1 == j)
            return Math.max(coins[i], coins[j]);

        if(i > j)
            return Integer.MAX_VALUE;

        int value1 = compute_recursive(coins, i+2, j);
        int value2 = compute_recursive(coins, i+1, j-2);
        int value3 = compute_recursive(coins, i, j-2);

        return Math.max((coins[i] + Math.min(value1, value2)), coins[j] + Math.min(value2, value3));
    }

    public static int compute_DP(int[] coins)
    {
        int[][] DP = new int[coins.length][coins.length];

        for(int gap = 0; gap <coins.length; gap++)
        {
            for(int i = 0; i < coins.length - gap; i++)
            {
                int j = i + gap;

                if(j == i)
                {
                    DP[i][j] = coins[i];
                }
                else if(j + 1 == i)
                {
                    DP[i][j] = Math.max(coins[i], coins[j]);
                }
                else
                {
                    int value1 = (i + 2 < coins.length) ? DP[i+2][j] : 0;
                    int value2 = (i + 1 < coins.length && j - 1 >= 0) ? DP[i+1][j-1] : 0;
                    int value3 = (j - 2 >= 0) ? DP[i][j-2] : 0;

                    DP[i][j] = Math.max((coins[i] + Math.min(value1, value2)),
                                        coins[j] + Math.min(value2, value3));
                }
            }
        }
        return DP[0][coins.length-1];
    }
}
