package self.learning.ArraysQuestions;

public class TrappingRainWater {

    static int TotalAmount(int[] arr)
    {
        int[] left = getMaxFromLeft(arr);
        int[] right = getMaxFromRight(arr);
        int totalAmount = 0;

        for(int i = 0; i < arr.length; i++)
        {
            int min = Math.min(left[i], right[i]);
            totalAmount += min > arr[i] ? min - arr[i] : 0;
        }

        return totalAmount;
    }

    static int[] getMaxFromLeft(int[] arr)
    {
        int[] results = new int[arr.length];
        results[0] = 0;
        for(int i = 1; i < arr.length; i++)
        {
            results[i] = Math.max(results[i-1], arr[i-1]);
        }
        return results;
    }

    static int[] getMaxFromRight(int[] arr)
    {
        int[] results = new int[arr.length];
        results[arr.length - 1] = 0;
        for(int i = arr.length - 2; i >=0 ; i--)
        {
            results[i] = Math.max(results[i+1], arr[i+1]);
        }
        return results;
    }
}
