package self.learning.MathProblems;
import java.util.*;

public class RearrangeArray {

    public void arrange(int[] A) {

        print(A);
        int n = A.length;
        for (int i = 0; i < n; i++)
        {
            int val = ((A[A[i]] % A.length) * A.length);
            A[i] = A[i] + val;
        }
        for (int i = 0; i < n; i++)
        {
            A[i] = A[i] / A.length;
        }

        print(A);
    }

    private void print(int[] A)
    {
        System.out.println();
        for(int num : A)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
