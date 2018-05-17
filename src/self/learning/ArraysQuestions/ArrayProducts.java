package self.learning.ArraysQuestions;

public class ArrayProducts
{
    public void compute(int[] arr)
    {
        if(arr.length == 0)
        {
            System.out.print("Empty array!");
            return;
        }

        if(arr.length == 1)
        {
            System.out.print("[0]");
            return;
        }

        int[] result = new int[arr.length];
        result[0] = 1;

        for(int i = 1; i < arr.length; i++)
        {
            result[i] = result[i-1] * arr[i-1];
        }

        int prod = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--)
        {
            result[i] = prod * result[i];
            prod *= arr[i];
        }

        //System.out.print(result);
        for(int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }

    }
}