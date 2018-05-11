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
                //if(temp == Integer.MAX_VALUE) continue;
                nCoins = Math.min(nCoins, 1 + temp);
            }
        }
        return nCoins;
    }

    static int min = Integer.MAX_VALUE;

    public static int minCoins2(int amount, int[] coins)
    {
        if(amount == 0)
            return 0;


        for(int i = 0; i < coins.length; i++)
        {
            if(amount - coins[i] >= 0)
            {
                min = Math.min(min, minCoins2(amount - coins[i], coins) + 1);
            }
        }

        return min;
    }

    public static int getMinimumChange_DP(int[] coins, int amount)
    {
        int[] DP = new int[amount + 1];
        DP[0] = 0;
        for(int change = 1; change <= amount; change++) {
            int nCoins = Integer.MAX_VALUE;
            for(int coin = 0; coin < coins.length; coin++) {
                if(coins[coin] <= change) {
                    int temp = DP[change - coins[coin]];
                    if(temp == Integer.MAX_VALUE) continue;
                    nCoins = Math.min(nCoins, 1 + temp);
                }
            }
            DP[change] = nCoins;
        }
        findCoinSetsRecurse(amount, DP[amount], DP, coins, new ArrayList<>());
        return DP[amount];
    }

    static void findCoinSetsRecurse(int amount, int minCoin, int[] DP, int[] coins, List<Integer> coinList)
    {
        if(minCoin == 0) {
            for(Integer coin : coinList) {
                System.out.print(coin + " ");
            }
            System.out.println();
            coinList.clear();
        }
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                if (DP[amount - coins[i]] == minCoin - 1) {
                    coinList.add(coins[i]);
                    findCoinSetsRecurse(amount - coins[i], minCoin - 1, DP, coins, coinList);
                }
            }
        }
    }
}
