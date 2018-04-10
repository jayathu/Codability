package self.learning;

//Given an array of N-elements, find an element of rank K (Kth smallest element)

public class RankOfK {

    static int find(int[] arr, int k)
    {
        return findRecurse(arr, k, 0, arr.length - 1);
    }

    private static int findRecurse(int[] arr, int k, int left, int right)
    {
        int pivotIndex = partition_2(arr, left, right);
        if(pivotIndex == k)
        {
            for(int i : arr)
            {
                System.out.print(i + " ");
            }
            return arr[pivotIndex];
        }
        else if(pivotIndex > k)
        {
            return findRecurse(arr, k, left, pivotIndex - 1);
        }
        else
        {
            return findRecurse(arr, k, pivotIndex + 1 , right);
        }
    }


    private static int partition(int[] arr, int left, int right)
    {
        int pivotIndex = (left + right)/2;

        while(left <= right)
        {
            while(arr[left] < arr[pivotIndex]) left++;
            while(arr[right] > arr[pivotIndex]) right--;
            if(left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left - 1;
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
