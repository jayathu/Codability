package self.learning.DynamicProgramming;

public class CountWays {

    public static int countWaysToClimb(int[] steps, int n)
    {
        int[] DP = new int[n + 1];
        DP[0] = 1;
        for(int stairs = 1; stairs <= n; stairs++)
        {
            int nWays = Integer.MAX_VALUE;
            for(int i = 0; i < steps.length; i++)
            {
                if(steps[i] <= stairs)
                {
                    int temp = DP[stairs - steps[i]];
                    if(temp == Integer.MAX_VALUE) continue;
                    nWays = (nWays == Integer.MAX_VALUE) ? temp : nWays + temp;
                }
            }
            DP[stairs] = nWays;
        }


        return (DP[n] == Integer.MAX_VALUE) ? 0 : DP[n];
    }
}
