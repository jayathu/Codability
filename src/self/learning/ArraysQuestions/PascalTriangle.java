package self.learning.ArraysQuestions;

public class PascalTriangle {

    public static void Print(int n)
    {
        long[] buffer = new long[n + 1];
        for(int i = 0; i <= n; i++)
        {
            PrintFor(i, buffer);
            System.out.println();
        }
    }

    static void PrintFor(int n, long[] buffer)
    {
        long nFact = factorial(n, buffer);

        for(int k = 0; k <= n; k++) {

            long iFact = factorial(k, buffer);

            long nMinusiFact = factorial(n - k, buffer);

            System.out.print(" " + nFact / (nMinusiFact * iFact) + " ");
        }

    }

    static long factorial(int n, long[] buffer)
    {
        if(n == 0 || n == 1)
        {
            return 1;
        }
        else if (buffer[n] == 0)
        {
            buffer[n] = n * factorial(n-1, buffer);
        }
        return buffer[n];

    }


    public static void PrintOptimal(int n)
    {
        for(int k = 1; k <= n; k++) {
            int result = 1;
            for (int i = 1; i <= k; i++) {
                result = result * (k - i) / (i);
                System.out.print(" " + result + " ");
            }
            System.out.println();
        }

    }
    /*
    C(n,k+1) = C(n,k) * (n-k) / (k+1)
    */
}
