package self.learning.ArraysQuestions;

public class BinarySearchCount {

    public void BuildAndRun()
    {
        int[] arr = new int[]{2,3,4,5,5,5,5,5,5,5,5,6,7};
        int freq = countFrequency(arr, 7);

        System.out.println("Frequency = " + freq);
    }


    int countFrequency(int[] arr, int num)
    {
        int leftIndex = binarySearch(arr, num, 0, arr.length - 1, -1, true);
        int rightIndex = binarySearch(arr, num, 0, arr.length - 1, -1, false);

        //int leftIndex = BinarySearch(arr, num, true);
        //int rightIndex = BinarySearch(arr, num, false);

        if(leftIndex == -1 || rightIndex == -1)
            return -1;

        return rightIndex - leftIndex + 1;
    }

    int BinarySearch(int[] arr, int num, boolean searchLeft)
    {
        int beg = 0, end = arr.length - 1;
        int result = -1;
        while(beg <= end)
        {
            int mid = beg + (end - beg + 1) / 2;
            if(arr[mid] == num)
            {
                result = mid;
                if(searchLeft)
                    end = mid - 1;
                else
                    beg = mid + 1;
            }
            else if(num < arr[mid])
                end = mid - 1;
            else
                beg = mid + 1;
        }

        return result;
    }

    int binarySearch(int[] arr, int num, int beg, int end, int indexSoFar, boolean isLeftSide)
    {
        if(beg > end)
        {
            return indexSoFar;
        }

        int mid = beg + (end - beg + 1) / 2;

        if(arr[mid] < num)
        {
            return binarySearch(arr, num, mid + 1, end, mid + 1, isLeftSide);
        }
        else if(arr[mid] > num)
        {
            return binarySearch(arr, num, beg, mid - 1, mid - 1, isLeftSide);
        }
        else if(isLeftSide)
        {
            return binarySearch(arr, num, beg, mid - 1, mid, true);
        }
        else{
            return binarySearch(arr, num, mid + 1, end, mid, false);
        }

    }
}
