package self.learning.DynamicProgramming;

import com.sun.webkit.dom.DOMWindowImpl;

import java.util.*;

public class WordBreak {

    public static boolean compute(String s, int startIndex, Set<String> dict)
    {
        if(startIndex >= s.length())
        {
            return true;
        }
        else
        {
            for(int i = startIndex + 1; i <= s.length(); i++)
            {
                System.out.println("startIndex = " + startIndex + ": i = " + i);
                if(dict.contains(s.substring(startIndex, i)) &&
                        compute(s, i, dict)) {

                    return true;
                }
            }
        }
        return false;
    }

    public static boolean DPCompute(String s, Set<String> dict)
    {
        boolean[] DP = new boolean[s.length() + 1];
        DP[0] = true;
        HashMap<Integer, List<String>> DPWORDS = new HashMap<>();
        DPWORDS.put(0,new ArrayList<>());

        for(int i = 0; i <= s.length(); i++)
        {
            for(int j = i + 1; j <= s.length(); j++)
            {
                if(dict.contains(s.substring(i,j)) && DP[i])
                {
                    DP[j] = true;
                    //System.out.println(i + "," + j + " : " + s.substring(i,j));
                    //i = j-1;
                }
                if(dict.contains(s.substring(i,j)) && DPWORDS.containsKey(i))
                {
                    if(DPWORDS.containsKey(j))
                    {
                        List<String> values = DPWORDS.get(j);
                        values.add(s.substring(i,j));
                        DPWORDS.put(j, values);
                    }
                    else {
                        List<String> values = new ArrayList<>();
                        values.add(s.substring(i,j));
                        DPWORDS.put(j, values);
                    }
                }
            }
        }

        for(Map.Entry<Integer, List<String>> entry : DPWORDS.entrySet())
        {
            System.out.print(entry.getKey() + ":");
            for(String value : entry.getValue()) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        ArrayList<String> results = new ArrayList<>();

        if(DPWORDS.containsKey(s.length())) {
            backtrack(DPWORDS, s.length(), "", results);
            for (String v : results) {
                System.out.println(v);
            }
        }
        return DP[s.length()];
    }

    static void getWords(String s, boolean[] dpTable)
    {
        int i = s.length();
        int j = s.length();
        while(i > 0)
        {
            while(!dpTable[j-1] && j > 0)
            {
                j--;
            }
            System.out.println(s.substring(j+1,i));
            i = j;
        }

    }

    static void backtrack(HashMap<Integer, List<String>> dpTable, int index, String word, List<String> results)
    {
        if(index <= 0)
        {
            System.out.println(word);
            results.add(word);
        }
        for(String s : dpTable.get(index))
        {
            if(word == "")
                backtrack(dpTable, index - s.length(), s, results);
            else
                backtrack(dpTable, index - s.length(), s + " " + word, results);
        }
    }

}
