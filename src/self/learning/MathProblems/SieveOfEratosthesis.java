package self.learning.MathProblems;

/*
Given a number N, print all primes upto N
 */
public class SieveOfEratosthesis {

    public void printAllPrimes(int N)
    {
        boolean[] primes = new boolean[N + 1];

        for(int i = 2; i <= N; i++)
        {
            primes[i] = true;
        }

        for(int i = 2; i <= N; i++)
        {
            int start = i * i;
            for(int j = start; j <= N; j += i)
            {
                primes[j] = false;
            }
        }

        for(int i = 0; i <= N; i++)
        {
            if(primes[i])
            {
                System.out.print(i + " ");
            }
        }
    }

    private boolean isPrime(int num)
    {
        if(num == 0 || num == 1) return false;
        if(num == 2) return true;

        for(int i = 2; i <= Math.sqrt(num); i++)
        {
            if(num % i == 0)
                return false;
        }

        return true;
    }

}
