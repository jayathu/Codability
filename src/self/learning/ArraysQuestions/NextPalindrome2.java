package self.learning.ArraysQuestions;

public class NextPalindrome2 {

    public long findNextPalindrome(long n)
    {
        if(isAllNine(n))
        {
            return n + 2;
        }

        if(n >= 0 && n < 9)
        {
            return n + 1;
        }


        StringBuilder sb = longToString(n);
        boolean isOddLength = sb.length() % 2 == 1;

        int leftIndex = isOddLength ? (sb.length() - 1)/2 - 1 : (sb.length() - 1)/2;
        int rightIndex = isOddLength ? leftIndex + 2 : leftIndex + 1;

        while(leftIndex >= 0 && rightIndex < sb.length() && sb.charAt(leftIndex) == sb.charAt(rightIndex))
        {
            leftIndex--;
            rightIndex++;
        }

        if(leftIndex < 0 || rightIndex > sb.length()) {
            return n;
        }else if(sb.charAt(leftIndex) > sb.charAt(rightIndex))
        {
            reverseCopy(sb, leftIndex, rightIndex);
        }
        else{
            long num;
            if(isOddLength)
            {
                num = stringToLong(sb.substring(0, leftIndex + 2));
            }
            else
            {
                num = stringToLong(sb.substring(0, leftIndex + 1));
            }

            num += 1;
            StringBuilder sbLeft = longToString(num);
            int index = isOddLength ? leftIndex + 2 : leftIndex + 1;
            sb.replace(0, index, sbLeft.toString());
            reverseCopy(sb, leftIndex, rightIndex);
        }

        return stringToLong(sb.toString());
    }

    void reverseCopy(StringBuilder sb, int leftIndex, int rightIndex)
    {
        while(leftIndex >= 0 && rightIndex < sb.length())
        {
            sb.setCharAt(rightIndex, sb.charAt(leftIndex));
            rightIndex++;
            leftIndex--;
        }
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
