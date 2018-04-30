package self.learning.Sandbox;

public class Dutch
{
    /*
    [3  3  2  1  2  1  1  3]
    [3  3  2  1  2  1  1  3]

     */
    //assume the numbers are from [1,2,3]
    public void Sort(int[] arr)
    {
        int frontPtr = 0;
        int backPtr = arr.length - 1;

        for(int i = 0; i < backPtr; i++)
        {
            if(arr[i] == 1)
            {
                swap(arr, i, frontPtr);
                frontPtr++;
            }
            else if(arr[i] == 3)
            {
                swap(arr, i, backPtr);
                backPtr--;
                i --;
            }
        }

        print(arr);
    }

    private void print(int[] arr)
    {
        for(int n : arr)
        {
            System.out.print(n + " ");
        }
    }

    private void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
