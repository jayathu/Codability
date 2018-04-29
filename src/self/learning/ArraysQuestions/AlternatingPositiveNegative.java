package self.learning.ArraysQuestions;

public class AlternatingPositiveNegative {

    public void rearrange(int[] arr)
    {
        int[] s = new int[3];
        for(int i = 0; i < arr.length; i++)
        {
            int j = 0;
            while(j + 2 < arr.length)
            {
                s[0] = (arr[j] >= 0) ? 1 : -1;
                s[1] = (arr[j + 1] >= 0) ? 1 : -1;
                s[2] = (arr[j + 2] >= 0) ? 1 : -1;

                if(s[0] == s[1] && s[1] != s[2])
                {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j+2];
                    arr[j+2] = temp;
                }
                j++;
            }
        }

        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
