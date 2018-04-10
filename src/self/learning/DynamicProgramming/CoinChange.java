package self.learning.DynamicProgramming;

import com.sun.javafx.scene.control.skin.DatePickerContent;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {

    static int nCoins = Integer.MAX_VALUE;
    public static int getMinimumChange(int[] coins, int amount)
    {
        if(amount == 0)
            return 0;

        for(int i = 0; i < coins.length; i++)
        {
            if(coins[i] <= amount) {
                int temp = getMinimumChange(coins, amount - coins[i]);
                if(temp == Integer.MAX_VALUE) continue;
                nCoins = Math.min(nCoins, 1 + temp);
            }
        }
        return nCoins;
    }

    public static int getMinimumChange_DP(int[] coins, int amount)
    {
        int[] DP = new int[amount + 1];
        DP[0] = 0;
        int[] CoinsDP = new int[amount + 1];
        CoinsDP[0] = -1;

        for(int change = 1; change <= amount; change++)
        {
            int nCoins = Integer.MAX_VALUE;
            for(int coin = 0; coin < coins.length; coin++)
            {
                if(coins[coin] <= change)
                {
                    int temp = DP[change - coins[coin]];
                    if(temp == Integer.MAX_VALUE) continue;
                    if(nCoins >= 1 + temp)
                    {
                        CoinsDP[change] = coin; //last coin picked
                    }
                    nCoins = Math.min(nCoins, 1 + temp);

                }
            }
            DP[change] = nCoins;
        }


        List<Integer> chosenCoins = new ArrayList<>();
        printCoins(DP, CoinsDP, coins, amount, chosenCoins);
        return DP[amount];
    }


    static void printCoins(int[] DP, int[] DPCoins, int[] coins, int amount, List<Integer> chosenCoins)
    {
        if(amount == 0)
        {
            for(Integer coin : chosenCoins)
            {
              System.out.print(coin + " ");
            }

            System.out.println();

            return;
        }
        else {
           chosenCoins.add(coins[DPCoins[amount]]);

           printCoins(DP, DPCoins, coins, amount - coins[DPCoins[amount]], chosenCoins);
        }
    }
}
