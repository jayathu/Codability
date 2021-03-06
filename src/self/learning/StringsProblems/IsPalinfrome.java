package self.learning.StringsProblems;

public class IsPalinfrome {

    public static boolean checkPalindrome(String s, int left, int right)
    {

        while(isAPunctuation(s.charAt(left))) {
            left++;
        }
        while(isAPunctuation(s.charAt(right))) {
            right--;
        }
        if(left > right)
            return true;
        else if(s.toLowerCase().charAt(left) == s.toLowerCase().charAt(right)){
            return  checkPalindrome(s, left + 1, right -1);
        }else return false;

    }

    public static boolean checkPalidromeIterative(String s)
    {
        int len = s. length();
        int left = 0, right = len - 1;
        while(left < right)
        {
            if(s.charAt(left) == s.charAt(right))
            {
                left++;
                right--;
            }
            else
                return false;
        }
        return true;
    }

    static boolean isAPunctuation(char c)
    {
        char[] punctuations = new char[]{'.', ',', '!', '-', ':', '\\', '"', ' '};

        boolean tf = false;
        for (char p:punctuations
             ) {
            if(p == c)
                tf = true;
        }

        return tf;
    }

}
