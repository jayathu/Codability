package self.learning.StringsProblems;

public class LookAndSay {

    public static void GenerateTill(int n)
    {
        String s = "1";
        System.out.println(s);
        for(int i = 0; i < n; i++)
        {
            s = compute(s);
            System.out.println(s);
        }
    }

    private static String compute(String s)
    {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while(i < s.length())
        {
            char c = s.charAt(i);
            int count = 0;
            while(j < s.length() && c == s.charAt(j))
            {
                count++;
                j++;
            }

            sb.append(count);
            sb.append(c);
            i = j;
        }

        return sb.toString();
    }
}
