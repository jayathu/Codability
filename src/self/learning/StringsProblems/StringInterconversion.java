package self.learning.StringsProblems;

public class StringInterconversion {

    public int stringToInt(String s)
    {
        char[] chars = s.toCharArray();
        int num = 0;
        for(int i = 0; i < chars.length; i++)
        {
            int a = chars[i] - '0';
            num = num * 10 + a;
        }

        System.out.print("s = " + s + " num = " + num );
        return num;
    }

    public String intToString(int num)
    {
        StringBuilder sb = new StringBuilder();
        int a = num;
        while(a > 0)
        {
            int i = (char)('0' + (a % 10));
            System.out.println(i);
            a = a / 10;
            sb.append(i);
        }

        String res = sb.reverse().toString();
        System.out.print(res);
        return res;
    }
}
