package self.learning.DynamicProgramming;

import self.learning.Trees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KnightsTour {


    public static long numPhoneNumbers_Main(int startdigit, int phonenumberlength) {

        HashMap<Integer, Integer[]> map = new HashMap<>();

        map.put(0, new Integer[]{ 6,4 });
        map.put(1, new Integer[]{ 8,6 });
        map.put(2, new Integer[]{ 9,7 });
        map.put(3, new Integer[]{ 4,8 });
        map.put(4, new Integer[]{ 9,3,0 });
        map.put(6, new Integer[]{ 7,1,0 });
        map.put(7, new Integer[]{ 2,6 });
        map.put(8, new Integer[]{ 3,1 });
        map.put(9, new Integer[]{ 2,4 });

        return numPhoneNumbers_dp(startdigit, phonenumberlength, map);

    }

    static long numPhoneNumbers(int startdigit, int phonenumberlength, HashMap<Integer, Integer[]> map) {

        if(startdigit == 5)
            return 0;
        if(phonenumberlength == 1)
            return 1;

        long num = 0;
        for(Integer digit : map.get(startdigit))
        {
            num += numPhoneNumbers(digit, phonenumberlength - 1, map);
        }

        return num;
    }

    public static long numPhoneNumbers_dp(int startdigit, int phonenumberlength, HashMap<Integer, Integer[]> map)
    {
        long[][] DP = new long[10][phonenumberlength + 1];

        for(int i = 0; i < 10; i++)
        {
            DP[i][0] = 0;
            DP[i][1] = 1;
        }

        for(int len = 0; len <= phonenumberlength; len++)
        {
            DP[5][len] = 0;
        }

        for (int len = 2; len <= phonenumberlength; len++)
        {

            for(int digit = 0; digit < 10; digit++)
            {
                if(digit == 5) continue;
                for(Integer num : map.get(digit))
                {
                    DP[digit][len] += DP[num][len-1];
                }
            }
        }

        return DP[startdigit][phonenumberlength];


    }

}
