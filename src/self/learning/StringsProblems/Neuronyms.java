package self.learning.StringsProblems;

import java.util.ArrayList;
import java.util.List;

public class Neuronyms {

    public static void GenerateFor(String str)
    {
        List<String> list = new ArrayList<>();

        int n = str.length();
        for(int count = 2; count <= n-2; count++)
        {
            for(int i = 1; i < n - count; i++)
            {
                String s = str.substring(0, i) + count + str.substring(i + count);
                list.add(s);
            }
        }

        for(String s : list)
        {
            System.out.println(s);
        }
    }
}
