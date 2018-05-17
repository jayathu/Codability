package self.learning.DynamicProgramming;
import java.util.*;

public class PartitionSum {

    public static void BuildAndRun()
    {
        //int[] arr = new int[]{4,1,-3,-1,3};
        int[] arr = new int[]{-11,6,-5,1,4,3};
        balanced_partition(arr);
    }
    public static void balanced_partition(int[] arr)
    {
        List<Integer> results = new ArrayList<>();
        List<List<Integer>> allResults = new ArrayList<>();
        int sum = 0;

        for(int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
        }


        //boolean tf = balanced_partition_recurse2(arr, sum/2, 0, results );

        //System.out.print(tf);

        findPartition(arr);
    }

    static boolean balanced_partition_recurse(int[] arr, int sum, int index, List<Integer> list)
    {
        if(index == arr.length && sum != 0)
        {
            return false;
        }

        if(sum == 0) {
            System.out.print(list);
            return true;
        }

        for(int i = index; i < arr.length; i++)
        {
            list.add(arr[i]);
            balanced_partition_recurse(arr, sum - arr[i], i + 1, list);
            list.remove(list.size() - 1);
        }
        return false;
    }

    static boolean balanced_partition_recurse2(int[] arr, int sum, int index, List<Integer> list)
    {
        if(index == arr.length && sum != 0)
        {
            return false;
        }
        if(sum == 0)
        {
            return true;
        }

        return balanced_partition_recurse2(arr, sum, index + 1, list) ||
                balanced_partition_recurse2(arr, sum - arr[index], index + 1, list);
    }

    // Returns true if arr[] can be partitioned in two subsets of
    // equal sum, otherwise false
    static boolean findPartition (int arr[])
    {
        int n = arr.length;
        int sum = 0;
        int i, j;

        // Caculcate sun of all elements
        for (i = 0; i < n; i++)
            sum += arr[i];

        if (sum%2 != 0)
            return false;

        boolean part[][]=new boolean[sum/2+1][n+1];

        // initialize top row as true
        for (i = 0; i <= n; i++)
            part[0][i] = true;

        // initialize leftmost column, except part[0][0], as 0
        for (i = 1; i <= sum/2; i++)
            part[i][0] = false;

        // Fill the partition table in botton up manner
        for (i = 1; i <= sum/2; i++)
        {
            for (j = 1; j <= n; j++)
            {
                part[i][j] = part[i][j-1];
                if (i >= arr[j-1])
                    part[i][j] = part[i][j] ||
                            part[i - arr[j-1]][j-1];
            }
        }

        // uncomment this part to print table
        for (i = 0; i <= sum/2; i++)
        {
            for (j = 0; j <= n; j++)
                System.out.print(part[i][j]);
            System.out.println();
        }

        return part[sum/2][n];
    }

}
