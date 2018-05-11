package self.learning.Sandbox;
import java.util.*;

public class KSmallestElement {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest(final List<Integer> A, int B) {

        List<Integer> arr = new ArrayList<>();
        for(Integer num : A)
        {
            arr.add(num);
        }
        return quickSelect(arr, 0, arr.size() - 1, B-1);
    }

    private int quickSelect(List<Integer> arr, int start, int end, int B)
    {
        if(start > end)
            return -1;

        int pi = partition(arr, start, end);
        if(pi == B)
        {
            return arr.get(pi);
        }
        else if(pi > B)
        {
            return quickSelect(arr, start, pi-1, B);
        }
        else
        {
            return quickSelect(arr, pi + 1, end, B);
        }

    }
    private int partition(List<Integer> arr, int start, int end)
    {
        int pivotIndex = start;
        for(int i = start; i < end; i++)
        {
            if(arr.get(i) < arr.get(end))
            {
                int temp = arr.get(pivotIndex);
                arr.set(pivotIndex, arr.get(i));
                arr.set(i, temp);
                pivotIndex++;
            }
        }

        int temp = arr.get(pivotIndex);
        arr.set(pivotIndex, arr.get(end));
        arr.set(end,temp);
        return pivotIndex;
    }
}

