package self.learning.Sandbox;

public class NutsAndBoltsSandbox {

    //Nuts: [2,4,1,6,5,9,3]
    //Bolts: [9,3,4,1,5,2,6]

    public void Sort()
    {
        int[] nuts = new int[]{2,4,1,6,5,9,3};
        int[] bolts = new int[]{9,3,4,1,5,2,6};

        recursiveSort(nuts, bolts, 0, nuts.length-1);

        print(nuts);
        print(bolts);
    }

    private void recursiveSort(int[] nuts, int[] bolts, int start, int end)
    {
        if(start < end)
        {
            int pivotIndex = partition(nuts, start, end, bolts[end]);
            partition(bolts, start, end, nuts[pivotIndex]);

            recursiveSort(nuts, bolts, start, pivotIndex - 1);
            recursiveSort(nuts, bolts, pivotIndex + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end, int pivot)
    {
        int pivotIndex = start;
        for(int i = start; i < end; i++ )
        {
            if(arr[i] < pivot)
            {
                swap(arr, i, pivotIndex);
                pivotIndex++;
            }
            else if(arr[i] == pivot)
            {
                swap(arr, i, end);
                i--;
            }
        }

        swap(arr, pivotIndex, end);
        return pivotIndex;
    }

    private void print(int[] arr)
    {
        for(int n : arr)
        {
            System.out.print(n + " ");
        }

        System.out.println();
    }

    private void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
