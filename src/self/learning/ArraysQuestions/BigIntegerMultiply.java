package self.learning.ArraysQuestions;

import java.util.HashSet;

public class BigIntegerMultiply {

    public static int[] multiply(int[] arr1, int[] arr2)
    {
        int m = arr1.length;
        int n = arr2.length;

        int carry = 0;
        int l = 0;
        int k = m + n - l;
        int[] result = new int[m + n];

        for(int i = m - 1; i >= 0; i--)
        {
            l++;
            k = m + n - l;
            for(int j = n - 1; j >= 0; j--)
            {
                int prod = (arr1[i] * arr2[j]) + result[k] + carry;
                carry = prod / 10;
                result[k] = prod % 10;
                k--;
            }
            result[k] = carry;
            carry = 0;
        }

        //result[k] = carry;

        for(int i = 0; i < result.length; i++)
        {
            System.out.print((result[i]));
        }

        return result;
    }
}
