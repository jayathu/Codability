package self.learning.DynamicProgramming;

public class EditDistance {

    public int findMinEdits(String s1, String s2)
    {
        int M = s1.length();
        int N = s2.length();
        int[][] DP = new int[M + 1][N + 1];

        for(int i = 0; i <= M; i++)
        {
            DP[i][0] = i;
        }
        for(int j = 0; j <= N; j++)
        {
            DP[0][j] = j;
        }

        for(int i = 1; i <= M; i++)
        {
            for(int j = 1; j <= N; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    DP[i][j] = DP[i-1][j-1];
                }
                else
                {
                    DP[i][j] = 1 + min(DP[i-1][j], DP[i][j-1], DP[i-1][j-1]);
                }
            }
        }

        return DP[M][N];
    }

    private int min(int x, int y, int z)
    {
        return Math.min(x, Math.min(y, z));
    }
}
