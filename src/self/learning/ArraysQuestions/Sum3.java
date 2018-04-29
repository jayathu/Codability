package self.learning.ArraysQuestions;

import java.util.Arrays;

public class Sum3 {

    //Brute Force
    static void Print3Sum(int[] arr)
    {
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i + 1; j < arr.length; j++)
            {
                for(int k = j+1; k < arr.length; k++)
                {
                    if(arr[i] + arr[j] + arr[k] == 0)
                        System.out.print("\n" + arr[i] + " , " + arr[j] + " , " + arr[k] + "\n");
                }
            }
        }
    }

    static void Print3Sum_Optimal(int[] arr)
    {

        Arrays.sort(arr);
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            sum = arr[i];
            int left = i + 1;
            int right = arr.length - 1;
            while(left < right)
            {
                int remainingSum = arr[left] + arr[right];
                if(remainingSum == -sum)
                {
                    System.out.print("\n" + arr[i] + " , " + arr[left] + " , " + arr[right] + "\n");
                    left++;
                }else if(remainingSum > -sum)
                {
                    right--;
                }
                else left++;
            }
        }
    }
}
