package self.learning.ArraysQuestions;
import java.util.*;

public class SumZero
{
    public void print(int[] arr)
    {
        Map<Integer, Integer> map = new HashMap<>();

        //map.put(arr[0], 0);
        //map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            sum += arr[i];

            if(arr[i] == 0)
            {
                print(arr, i, i);
                break;
            }
            else if(sum == 0){

                print(arr, 0, i);
                break;
            }
            else if(map.containsKey(sum)){
                print(arr, map.get(sum)+1, i);
                break;
            }
            else{
                map.put(arr[i], i);
            }
        }
    }

    private void print(int[] arr, int index1, int index2)
    {
        for(int i = index1; i <= index2; i++)
        {
            System.out.print(arr[i] + " ");
        }

        List<Integer> list = new ArrayList<>();
    }
}