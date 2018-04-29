package self.learning.Sorting;

public class NutsAndBolts {

    static void SortNutsAndBolts(int[] Nuts, int[] Bolts)
    {
        int start = 0; int end = Nuts.length-1;

        SortNutsAndBoltsRecurse(Nuts, Bolts, start, end);

        for (int nut:Nuts
             ) {
            System.out.print(nut + " ");
        }

        System.out.println();

        for (int bolt:Bolts
                ) {
            System.out.print(bolt + " ");
        }

    }

    static void SortNutsAndBoltsRecurse(int[] Nuts, int[] Bolts, int start, int end)
    {
        if(start < end)
        {
            int pivot = partition(Bolts, start, end, Nuts[end]);
            partition(Nuts, start, end, Bolts[pivot]);

            SortNutsAndBoltsRecurse(Nuts, Bolts, start, pivot-1);
            SortNutsAndBoltsRecurse(Nuts, Bolts, pivot + 1, end);

        }
    }

    static int partition(int[] arr, int start, int end, int pivot)
    {
        int pivotIndex = start;
        for(int i = start; i < end; i++)
        {
            if(arr[i] < pivot)
            {
                swap(arr, i, pivotIndex);
                pivotIndex++;
            }else if(arr[i] == pivot)
            {
                swap(arr, i, end);
                i--;
            }
        }
        swap(arr, pivotIndex, end);

        return pivotIndex;
    }


    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
