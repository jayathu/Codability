package self.learning.ArraysQuestions;

public class SimpleEncoding {

    public static void encode(String s)
    {

        StringBuilder sb = new StringBuilder();

        char[] arr = s.toCharArray();
        char[] res = new char[arr.length];
        int index = 0;
        int i = 0, j = 1, count = 1;
        while(i < arr.length)
        {
            count = 1;
            while(j < arr.length && arr[j] == arr[i])
            {
                j++; count++;
            }
            if(count > 1)
            {
                res[index] = Character.forDigit(count, 10);
                res[index + 1] = arr[i];
                index += 2;
            }
            else
            {
                res[index] = arr[i];
                index ++;
            }
            i = j;
            j++;
        }

        if(i < arr.length)
        {
            res[index] = arr[i];
        }

        System.out.println(res);
    }


}
