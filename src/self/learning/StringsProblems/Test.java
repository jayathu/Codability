package self.learning.StringsProblems;

public class Test {

    public static String reverse_ordering_of_words(String s) {
        /*
         * Write your code here.
         */

        int beg = 0, end = 0;
        char[] arr = s.toCharArray();

        reverse(arr, 0, arr.length - 1);
        while(end < arr.length )
        {
            while(arr[end] != ' ')
                end++;

            reverse(arr, beg, end - 1);
            end++;
            beg = end;
        }

        reverse(arr, beg, end - 1);

        return arr.toString();
    }

    static void reverse(char[] arr, int beg, int end)
    {
        while(beg < end)
        {
            char tmp = arr[beg];
            arr[beg] = arr[end];
            arr[end] = tmp;

            beg++;
            end--;
        }

    }

}
