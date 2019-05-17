package self.learning.StringsProblems;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class StringSolution {

    public void Execute(String s)
    {
       reverseVowels(s.toCharArray(), 0, s.length() - 1);
    }

    public void reverse(String s)
    {
        String reversedString = reverseRecurs(s.toCharArray(), 0, s.length() - 1);
        System.out.println(reversedString);
    }

   public void reverseWords(String s)
   {
       char[] arr = s.toCharArray();
       reverseIter(arr, 0, arr.length - 1);
       int i = 0, j = 0;
       while(j < arr.length )
       {
           if(arr[j] != ' ')
           {
               j++;
           }
           else{
               reverseIter(arr, i, j - 1);
               j++;
               i = j;
           }
       }
       s = String.valueOf(arr);
       System.out.println("\n" + s);
   }

    String reverse(char[] arr)
    {
        for(int i = 0; i < arr.length / 2; i++) {
            char c = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length - i - 1] = c;
        }

        return String.valueOf(arr);
    }

    void reverseVowels(char[] arr, int beg, int end)
    {
        if(beg > end) {
            System.out.println(arr);
            return;
        }

        while(!isVowel(arr[beg]))
            beg++;
        while(!isVowel(arr[end]))
            end--;

        char c = arr[beg];
        arr[beg] = arr[end];
        arr[end] = c;
        beg++;
        end--;

        reverseVowels(arr, beg, end);
    }

    boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    String reverseRecurs(char[] arr, int beg, int end)
    {
        if(beg > end) {
            return String.valueOf(arr);
        }


        char c = arr[beg];
        arr[beg] = arr[end];
        arr[end] = c;
        beg++;
        end--;
        return reverseRecurs(arr, beg, end);
    }

    public String reverseIter(char[] arr, int beg, int end)
    {
        while(beg < end)
        {
            char c = arr[beg];
            arr[beg] = arr[end];
            arr[end] = c;
            beg++;
            end--;
        }


        return String.valueOf(arr);

    }

    public static String move_letters_to_left_side_with_minimizing_memory_writes(String s) {
        /*
         * Write your code here.
         */

        int left = 0, right = 1;
        char[] arr = s.toCharArray();

        while(left < right && isAlphaNumeric(arr[left]))
        {
            left++;
        }

        while(left < right && right < arr.length)
        {
            while(right < arr.length && isNumeric(arr[right]))
            {
                right++;
            }

            arr[left] = arr[right];
            right++;
            left++;
        }

        return String.valueOf(arr);
    }

    static boolean isAlphaNumeric(char c)
    {
        return c < '0' || c > '9';
    }

    static boolean isNumeric(char c)
    {
        return c >= '0' && c <= '9';
    }


}
