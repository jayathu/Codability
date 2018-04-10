package self.learning.ArraysQuestions;

public class NextPalindromicNum {

    public long FindNextPalindrome(long n)
    {

        if(isAllNine(n))
        {
            return n + 2;
        }

        //if its  single digit other than 9 then simply increment and return the number
        if(n / 10 == 0)
        {
            return n + 1;
        }

        StringBuilder stringNum = longToString(n);

        //set left and right as follows:
        int len = stringNum.length();
        int offset = (len - 1) % 2;
        int left = (len - 1) / 2;
        int right = left + offset;

        //find the index where there's a mismatch
        while(left >= 0 && stringNum.charAt(left) == stringNum.charAt(right))
        {
            left--;
            right++;
        }

        //if none found, then its a palindromic number
        if(left < 0)
        {
            //reset left and right pointers to adjacent to each other. If odd digits, left is at the middle and right is next to middle.
            left = (len - 1) / 2;
            right = left + 1;
            return incrementAndMirrorLeftToRight(stringNum, left, right);
        }
        else {
            long leftNum = stringToLong(stringNum.substring(left, left + 1));
            long rightNum = stringToLong(stringNum.substring(right, right + 1));

            left = (len - 1) / 2;
            right = left + 1;

            if(leftNum > rightNum)
            {
                return mirrorLeftToRight(stringNum, left, right);
            }
            else
            {

                return incrementAndMirrorLeftToRight(stringNum, left, right);
            }
        }

    }

    long incrementAndMirrorLeftToRight(StringBuilder sb, int left, int right)
    {

        String str = sb.substring(0, right);
        long num = stringToLong(str);
        num += 1;
        StringBuilder sb1 = longToString(num);
        sb.replace(0, right, sb1.toString());

        return mirrorLeftToRight(sb, left, right);

    }

    //left always points to the middle, so if sb has odd digits, then move left by -1.
    long mirrorLeftToRight(StringBuilder sb, int left, int right)
    {
        if(sb.length() % 2 != 0)
            left = left - 1;

        while(left >= 0)
        {
            sb.setCharAt(right, sb.charAt(left));
            left--;
            right++;
        }

        return stringToLong(sb.toString());
    }

    long stringToLong(String str)
    {
        long value = 0;
        for(int i = 0; i < str.length(); i++)
        {
            value = value * 10 + (str.charAt(i) - '0');
        }

        return value;
    }

    StringBuilder longToString(long num)
    {
        StringBuilder sb = new StringBuilder();
        while( num > 0)
        {
            sb.append((char)('0' + (num % 10)));
            num = num / 10;
        }

        return sb.reverse();
    }

    boolean isAllNine(long num)
    {
        if(num == 0) return false;

        while(num > 0)
        {
            if(num % 10 != 9)
            {
                return false;
            }
            num = num / 10;
        }
        return true;
    }




}
