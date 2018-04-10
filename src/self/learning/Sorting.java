package self.learning;

public class Sorting {

    static int[] QuickSort(int[] arr)
    {

        return QuickSortRecursive(arr, 0, arr.length-1 );

    }

    private static int[] QuickSortRecursive(int[] arr, int left, int right)
    {
        if(left < right)
        {
            int pivot = partition(arr, left, right);
            QuickSortRecursive(arr, left, pivot- 1);
            QuickSortRecursive(arr, pivot, right);

        }

        return arr;
    }

    private static int partition(int[] arr, int left, int right)
    {
        int tmp;
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left <= right) {
                tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        };
        return left;
    }

    static void QuickSort_2(int[] arr)
    {
        int[] sortedArray = QuickSortRecursive_2(arr, 0, arr.length - 1);

        for(int i: arr)
        {
            System.out.print(i + " ");
        }

    }
    private static int[] QuickSortRecursive_2(int[] arr, int start, int end)
    {
        if(start < end)
        {
            int pivot = partition_2(arr, start, end);
            QuickSortRecursive_2(arr, start, pivot - 1);
            QuickSortRecursive_2(arr, pivot + 1, end);
        }

        return arr;

    }
    private static int partition_2(int[] arr, int start, int end)
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
}
