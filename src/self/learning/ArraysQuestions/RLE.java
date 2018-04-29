package self.learning.ArraysQuestions;

public class RLE
{
    //BAAA55 -> B3A25

    public String encode(String s)
    {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i = 0, j = 1;
        while(i < arr.length)
        {
            int count = 1;
            while(j < arr.length && arr[i] == arr[j])
            {
                j++;
                count++;
            }

            if(count > 1)
            {
                sb.append(count);
                sb.append(arr[i]);
            }
            else{
                sb.append(arr[i]);
            }

            if(sb.length() > s.length())
            {
                break;
            }

            i = j;
            j = i + 1;
        }

        return sb.length() < s.length() ? sb.toString() : s;
    }

    public String decode(String s)
    {
        char[] arr = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        int i = 0, j = 0;
        while(i < arr.length)
        {
            if(!isDigit(arr[i])){
                sb.append(arr[i]);
                i++;
                j++;
            }
            else
            {
                int digit = 0;
                while(j < arr.length && isDigit(arr[j]))
                {
                    digit = digit * 10 + (arr[j] - '0');
                    j++;
                }
                while(digit > 1)
                {
                    sb.append(arr[j]);
                    digit--;
                }

                i = j;

            }
        }

        return sb.toString();
    }

    private boolean getBit(int num, int i)
    {
        return ((num & (1 << i)) != 0);
    }

    private int setBit(int num, int i)
    {
        return num | (1 << i);
    }

    private boolean isDigit(char c)
    {
        return c >= '0' && c <= '9';
    }

}