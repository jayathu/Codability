package self.learning.DynamicProgramming;

public class HouseRobbery {

    public static int maxStolenValue(int[] arrHouseValues)
    {
        int[] DP = new int[arrHouseValues.length];

        DP[0] = arrHouseValues[0];
        DP[1] = Math.max(DP[0], arrHouseValues[1]);

        for(int i = 2; i < arrHouseValues.length; i++)
        {
            DP[i] = Math.max(arrHouseValues[i] + DP[i-2], DP[i-1]);
        }

        return DP[arrHouseValues.length - 1];
    }
}
