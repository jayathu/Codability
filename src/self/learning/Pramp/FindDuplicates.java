package self.learning.Pramp;
import java.util.*;

/*
Given two sorted arrays arr1 and arr2 of numbers, implement a function findDuplicates that returns an array of all numbers that are both in arr1 and arr2.
Note that the output array should be sorted in an ascending order.

Let N and M be the lengths of arr1 and arr2, respectively.
Solve for two cases and analyze the time & space complexities of your solutions:
Case #1: M ≈ N - the array lengths are approximately the same
Case #2: M ≫ N - arr2 is much bigger than arr1.

 */
public class FindDuplicates {

    //case when M >> N
    //M: [1,3,4,5,7,8,9,14,17,22,25,28,32,33]
    //N: [2,3,8,25,32];
    static int[] findDuplicatesLarge(int[] arr1, int[] arr2)
    {
        //arr1 >> arr2
        int start = 0, end = arr1.length - 1;
        List<Integer> output = new ArrayList<>();
        for(int i = 0; i < arr2.length; i++)
        {
            int index = binarySearch(arr1, start, end, arr2[i]);
            if(index != -1)
            {
                output.add(arr2[i]);
                start = index + 1;
            }
        }

        int[] result = new int[output.size()];
        for(int i = 0; i < result.length; i++)
        {
            result[i] = output.get(i);
        }
        return result;
    }

    //[1,3,4,5,7,8]
    static int binarySearch(int[] arr, int start, int end, int num)
    {
        if(start > end)
            return -1;

        int mid = (start + end) / 2;
        if(arr[mid] == num)
            return mid;
        if(arr[mid] > num)
        {
            return binarySearch(arr, start, mid - 1, num);
        }
        else
        {
            return binarySearch(arr, mid + 1, end, num);
        }
    }
    static int[] findDuplicates(int[] arr1, int[] arr2) {
        int first = 0, second = 0;
        List<Integer> output = new ArrayList<>();
        while(first < arr1.length && second < arr2.length)
        {
            if(arr1[first] < arr2[second])
                first++;
            else if(arr1[first] > arr2[second])
                second++;
            else{
                output.add(arr1[first]);
                first++;
                second++;
            }
        }

        int[] result = new int[output.size()];
        for(int i = 0; i < result.length; i++)
        {
            result[i] = output.get(i);
        }
        return result;
    }

    public static void main(String[] args) {

        //M: [1,3,4,5,7,8,9,14,17,22,25,28,32,33]
        //N: [2,3,8,25,32];
        int[] arr1 = new int[]{1,3,4,5,7,8,9,14,17,22,25,28,32,33};
        int[] arr2 = new int[]{2,3,8,25,32};

        int[] result = findDuplicatesLarge(arr1, arr2);

        for(int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }

}
