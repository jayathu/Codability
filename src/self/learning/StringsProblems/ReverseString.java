package self.learning.StringsProblems;

public class ReverseString {

    public static void PrintReverse(String s)
    {
        //String reverse = printReverseUtil(s.toCharArray());

        char[] arr = s.toCharArray();
        //System.out.println(arr);

        printReverseUtil(arr);

        System.out.println(arr);
    }

    static void printReverseUtil(char[] arr)
    {
        int beg = 0, end = 0;

        reverseString(arr, 0, arr.length - 1);
        while(end < arr.length)
        {
            while(end < arr.length && arr[end] != ' ')
                end++;

            if(end < arr.length)
            {
                reverseString(arr, beg, end - 1);
            }
            end++;
            beg = end;

        }

        reverseString(arr, beg, end);
    }

    static void reverseString(char[] arr, int beg, int end)
    {
        while(beg < end)
        {
            char temp = arr[beg];
            arr[beg] = arr[end];
            arr[end] = temp;
            beg++;
            end--;
        }


    }


}
