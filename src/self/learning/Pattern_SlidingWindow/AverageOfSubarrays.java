package self.learning.Pattern_SlidingWindow;

import java.util.HashMap;

/*
Given an array, find the average of all subarrays of size ‘K’ in it.

 */
public class AverageOfSubarrays {

    public static double[] findMyAverages(int K, int[] arr)
    {
        double[] results = new double[arr.length - K + 1];
        double sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
            if(i >= K - 1)
            {
                results[i - K + 1] = sum / K;
                sum -= arr[i - K + 1];
            }
        }

        for(int i = 0; i < results.length; i++)
        {
            System.out.print(results[i] + ",");
        }
        return results;
    }
}
