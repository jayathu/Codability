package self.learning.ArraysQuestions;

public class IsPrime {

    public static void ComputeOptimized(int[] arr)
    {
        int max = getMax(arr);

        int[] isPrime = new int[max + 1];
        for(int i = 0; i < isPrime.length; i++)
        {
            isPrime[i] = 1;
        }

        for(int i = 2; i * i <= max; i++)
        {
            int start = i * i;
            for(int j = start; j <= max; j += i)
            {
                isPrime[j] = 0;
            }
        }

        for(int i = 0; i < arr.length; i++)
        {
            if(isPrime[arr[i]] == 1)
            {
                System.out.print(arr[i] + " ");
            }
        }
    }

    static int getMax(int[] arr)
    {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++)
        {
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    public static void Compute(int[] arr)
    {
        int[] isPrime = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
        {
            isPrime[i] = isPrime(arr[i]);
            System.out.print(isPrime[i]);
        }


    }

    //brute force
    static int isPrime(int n)
    {
        if(n == 2)
            return 1;

        int i = 2;
        while(i < n/2)
        {
            if(n % i == 0)
                return 0;
            i++;
        }

        return 1;
    }


}
