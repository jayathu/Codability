package self.learning.Sorting;

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
            //int pivot = lomutosPartition(arr, left, right);
            int pivot = hoaresPartition2(arr, left, right);
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

    private void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
    considering pivot as the first element in the subarray
    pivot index will always be where right pointer lands in the end. Why?
    if you notice a bit closely with how left and right moves, right pointer always stops at a smaller element than the pivot.
    and because the pivot is the first element, which is bigger than the right pointer, it makes sense to swap these two.
    Left pointer always stops at a bigger element than the pivot. It doesn't make sense to swap left and first element.
    Think about this a bit deeply!


    Similarly, if you consider pivot as the last element in the subarray,
    pivot index will ALWAYS be where left pointer lands in the end.
    Since left pointer lands with a higher element than the pivot, it makes sense to move this to the right of the pivot i.e. swap these two!

    */
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
                swap(arr, left, right);
            }
        }
        swap(arr, start, right);
        return right;
    }

    //considering pivot as the last element in the subarray
    private int hoaresPartition2(int[] arr, int start, int end)
    {
        int pivot = arr[end];
        int left = start;
        int right = end - 1;

        while(left < right)
        {
            while(arr[left] < pivot && left < end) left ++;
            while(arr[right] > pivot && right > start) right --;
            if(left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, end, left);
        return left;
    }
}
