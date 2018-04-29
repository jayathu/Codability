package self.learning.ArraysQuestions;

public class MinInSortedArray
{
    public int find(int[] arr, int num)
    {
        return find(arr, 0, arr.length-1, num );
    }

    private int find(int[] arr, int beg, int end, int num)
    {
        int mid = (beg + end) / 2;
        if(arr[mid] == num)
        {
            return mid;
        }
        if(beg > end)
        {
            return -1;
        }

        if(arr[mid] < arr[end]) //right arr is normal
        {
            if(num >= arr[mid] && num <= arr[end])
            {
                return find(arr, mid + 1, end, num);
            }
            else{
                return find(arr, beg, mid, num);
            }
        }
        else //left arr is normal
        {
            if (num <= arr[mid] && num >= arr[beg]) {
                return find(arr, beg, mid, num);
            } else {
                return find(arr, mid + 1, end, num);
            }
        }

    }
}
