package self.learning.Recursion;

import java.util.ArrayList;

public class PalindromeDecomposition {

    static void GenerateAllSubstrings(String s)
    {
        ArrayList<String> decompositions = new ArrayList<>();

        decompositions = GenerateSubstringsRecurse(decompositions, new StringBuffer(s), s.length(), 0, "");

        String[] results = decompositions.toArray(new String[decompositions.size()]);

        for (String res: results
             ) {
         System.out.println(res);
        }

    }

    static boolean isAPalindrome(StringBuffer s, int left, int right)
    {
        while(left < right)
        {
            if(s.charAt(left) != s.charAt(right))
            {
                return false;
            }
            left++;
            right --;
        }

        return true;
    }

    static ArrayList<String> GenerateSubstringsRecurse(ArrayList<String> decompositions, StringBuffer s, int len, int pos, String decomposedString)
    {
        if(pos == len)
        {
            decompositions.add(decomposedString.toString());
            return decompositions;

        }else {
            for (int i = pos; i < len; i++) {

                String tmp = s.substring(pos, i + 1);

                if(isAPalindrome(s, pos, i)) {
                    if (pos == 0) {

                        GenerateSubstringsRecurse(decompositions, s, len, i + 1, tmp);

                    } else {

                        GenerateSubstringsRecurse(decompositions, s, len, i + 1, decomposedString+"|" + tmp);
                    }
                }
            }
        }

        return decompositions;
    }
}
