package self.learning;

public class CountBST {

    static long NumOfBST(int n)
    {
        long[] cache;

        if(n ==1)
            cache = new long[2];

        else cache = new long[n];
        return recurseCount(n, cache);
    }

    static long recurseCount(int n, long[] cache)
    {
        if(n == 0 || n == 1)
        {
            cache[n] = 1;
            return 1;
        }
        else{
            long sum = 0;
            long left_count = 0;
            long right_count = 0;
            for(int i = 1; i <= n; i ++)
            {
                if(cache[i-1] > 0)
                    left_count = cache[i-1];
                else {
                    left_count = recurseCount(i - 1, cache);
                    cache[i-1] = left_count;
                }
                if(cache[n-i] > 0)
                    right_count = cache[n-i];
                else{
                    right_count = recurseCount(n-i, cache);
                }

                sum += left_count * right_count;
            }
            return sum;
        }
    }

}
