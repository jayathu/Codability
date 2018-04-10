package self.learning.ArraysQuestions;

public class RotatedPalindrome {

    public static boolean Check(String str)
    {
        char[] arr = str.toCharArray();
        int i = 0;
        while(i < arr.length)
        {
            if(isPalindrome(arr, 0, arr.length - 1)) {
                System.out.println("Found " + String.valueOf(arr));
                return true;
            }
            char c = arr[0];
            for(int k = 0; k < arr.length - 1; k++) {
                arr[k] = arr[k + 1];
            }
            arr[arr.length - 1] = c;
            i++;
        }
        System.out.println("Not Found");
        return false;
    }

    public static boolean CheckOptimised(String str)
    {
        char[] arr = str.toCharArray();
        int N = arr.length;
        for(int i = 0; i < N; i++)
        {
            int left = i;
            int right = i;
            if(N % 2 == 0)
            {
                right = next(N, i);
            }

            boolean valid = true;
            for(int j = 0; j < N/2; j++)
            {
                if(arr[left] != arr[right])
                {
                    valid = false;
                }
                else
                {
                    left = prev(N, left);
                    right = next(N, right);
                }
            }

            if(valid == true)
            {
                return true;
            }
        }

        return false;

    }

    static int next(int N, int i)
    {
        return (i + 1) % N;
    }

    static int prev(int N, int i)
    {
        return (i - 1 + N) % N;
    }

    static boolean isPalindrome(char[] arr, int start, int end)
    {
        while(start <= end)
        {
            if(arr[start] != arr[end])
                return false;
            start++;
            end--;
        }
        return true;
    }


}
