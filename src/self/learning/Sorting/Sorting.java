package self.learning.Sorting;

import java.util.ArrayList;
import java.util.List;

public class Sorting {

    public void BuildAndRun (int[] arr)
    {
        int[] result = QuickSortRecursive(arr, 0, arr.length-1 );
        for(int n : result)
        {
            System.out.print(n + " ");
        }

    }

    private int[] QuickSortRecursive(int[] arr, int left, int right)
    {
        if(left < right)
        {
            int pivot = lomutosPartition(arr, left, right);
            //int pivot = hoaresPartition(arr, left, right);
            QuickSortRecursive(arr, left, pivot- 1);
            QuickSortRecursive(arr, pivot + 1, right);

        }
        return arr;
    }


    private int lomutosPartition(int[] arr, int start, int end)
    {
        int pivotIndex = start;
        for(int i = start; i < end; i++)
        {
            if(arr[i] < arr[end])
            {
                int temp = arr[pivotIndex];
                arr[pivotIndex] = arr[i];
                arr[i] = temp;
                pivotIndex++;
            }
        }

        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[end];
        arr[end] = temp;
        return pivotIndex;
    }

    private int hoaresPartition(int[] arr, int start, int end)
    {
        int pivot = arr[start];
        int left = start + 1;
        int right = end;

        while(left < right)
        {
            while(arr[left] < pivot && left < end) left ++;

            while(arr[right] > pivot && right > start) right --;

            if(left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        int temp = arr[start];
        arr[start] = arr[right];
        arr[right] = temp;

        return right;
    }
}
