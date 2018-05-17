package self.learning.ArraysQuestions;

/*
Given an array of positive and negative integers in no particular order, find the maximum size of a sub-array such that
the sum of all integers in the sum-array is maximum among the sums from all other subarrays.

Ex: [3 -2 5 -1] : Max Sum = 6: [3 -2 5], size = 3
    [-1 -8 -3 -9]: Max Sum = -1: [-1], size = 1 //will always be 1 if the array contains all negative values
    [1 9 2 3]: Max Sum = 15: [1 9 3 2], size = 4//will always be N if the array contains all positive values
 */
public class MaxSumSubArray {

    public void BuildAndRun()
    {
        int[] arr = {1, -3, 2, -5, 7, 6, -1, -4, 11, -23};
        computeBruteForce(arr);

        computeBruteForceImproves(arr);

        computeOptimized(arr);
    }

    //O(n^3)
    private void computeBruteForce(int[] arr)
    {
        int maxSum = Integer.MIN_VALUE;
        int size = 0;
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i; j < arr.length; j++)
            {
                int sum = 0;
                for(int k = i; k <= j; k++)
                {
                    sum += arr[k];
                    if(maxSum < sum)
                    {
                        maxSum = sum;
                        size = k - i + 1;
                    }
                }
            }
        }

        System.out.println("Max Sum = " + maxSum + " size = " + size);
    }

    //O(n^2)
    private void computeBruteForceImproves(int[] arr)
    {
        int maxSum = Integer.MIN_VALUE;
        int size = 0;
        for(int i = 0; i < arr.length; i++)
        {
            int sum = 0;
            for(int j = i; j < arr.length; j++)
            {
                sum += arr[j];
                if(maxSum < sum)
                {
                    maxSum = sum;
                    size = j - i + 1;
                }
            }
        }

        System.out.println("Max Sum = " + maxSum + " size = " + size);
    }

    //O(n)
    private void computeOptimized(int[] arr)
    {
        int maxSum = Integer.MIN_VALUE;
        int size = 0;
        int sum = 0;
        int begIndex = -1;
        for(int i = 0; i < arr.length; i++)
        {
            //this condition happens only when array starts with negative integers
            if(arr[i] < 0 && maxSum < arr[i])
            {
                maxSum = arr[i];
                size = 1;
            }else {
                sum += arr[i];
                if (maxSum < sum) {
                    begIndex = (begIndex == -1) ? i : begIndex;
                    maxSum = sum;
                    size = i - begIndex + 1;
                }
            }
        }

        if(begIndex == -1) {
            System.out.println("Max Sum = " + maxSum + " size = " + size);
            return;
        }
        for(int i = begIndex; i < arr.length-1; i++)
        {
            sum -= arr[i];
            if(maxSum < sum)
            {
                maxSum = sum;
                size -= i;
            }
        }

        System.out.println("Max Sum = " + maxSum + " size = " + size);
    }

}
