package self.learning.RealInterviewQuestions;

/*
Problem Statement: You're given an array of integers such that they initially appear in an increasing order and
then decreasing order. You can assume that the switch from increasing to descreasing happens only once in the entire array.
Find the tipping point: the index of the largest element in the array.

A few examples:
[4 5 7 9 8 2] --> Return index 2
[8 6 3 1] --> Return 0
[2 3 8 10] --> Return 3

 */
public class FindTippingPoint {

    public void BuildAndRun()
    {
        int[] arr = new int[]{1,3,8,12,15,3,1};

        int index = FindLargestIndex(arr, 0, arr.length - 1);
        int index2 = FindLargestIndex2(arr, 0, arr.length - 1);

        System.out.println(index);
        System.out.println(index2);
    }

    private int FindLargestIndex(int[] arr, int left, int right)
    {
        if(left == right) {
            return left;
        }

        int mid = (left + right) / 2;

        if(arr[mid] > arr[mid+1]) {
            return FindLargestIndex(arr, left, mid);
        }
        else {
            return FindLargestIndex(arr, mid + 1, right);
        }
    }

    private int FindLargestIndex2(int[] arr, int left, int right)
    {
        if(left == right) {
            return left;
        }

        int mid = (left + right) / 2;

        if(arr[mid] < arr[mid + 1]) {
            return FindLargestIndex(arr, mid + 1, right);
        }
        else {
            return FindLargestIndex(arr, left, mid);
        }
    }
}
