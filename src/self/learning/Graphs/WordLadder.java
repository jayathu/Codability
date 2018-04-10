package self.learning.Graphs;

import java.beans.IntrospectionException;
import java.util.*;

public class WordLadder {

    static String[] string_transformation(String[] words, String start, String stop) {

        Queue<Integer> queue = new ArrayDeque();
        HashMap<Integer, Integer> backRefs = new HashMap<>();
        boolean[] visited = new boolean[words.length + 1];

        HashMap<Integer, String> wordMap = new HashMap<>();
        for(int i = 0; i < words.length; i++)
        {
            wordMap.put(i, words[i]);
        }

        wordMap.put(words.length, stop);

        queue.add(-1);

        while(!queue.isEmpty())
        {
            int index = queue.remove();
            String currWord;

            if(index == -1)
                currWord = start;
            else
                currWord = wordMap.get(index);

            addNeighbors(currWord, index, wordMap, backRefs, visited, queue);

            if(index != -1 && currWord.equals(stop))
                break;

        }

        List<String> results = new ArrayList<>();
        int idx = wordMap.size() - 1;

        if(backRefs.get(idx) == null)
        {
            results.add("-1");
            for(String s : results)
            {
                System.out.print(s + " ");
            }
            return results.toArray(new String[results.size()]);
        }



        while(idx != -1)
        {
            String word = wordMap.get(idx);
            results.add(word);
            idx = backRefs.get(idx);
        }

        results.add(start);

        String[] resultStrings = new String[results.size()];
        for(int i = results.size() - 1; i >= 0; i--)
        {
            resultStrings[results.size() - i - 1] = results.get(i);
            System.out.print(resultStrings[results.size() - i - 1] + " ");
        }

        return results.toArray(new String[results.size()]);

    }

    static void addNeighbors(String word, int wordIndex, HashMap<Integer, String> wordMap,  HashMap<Integer, Integer> backRefs, boolean[] visited, Queue<Integer> queue)
    {
        for(int i = 0; i < wordMap.size(); i++)
        {
            if(!visited[i] && oneEditAway(word, wordMap.get(i)))
            {
                visited[i] = true;
                backRefs.put(i, wordIndex);
                queue.add(i);
            }
        }
    }

    static boolean oneEditAway(String s1, String s2)
    {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int diff = 0;

        for(int i = 0; i < s1.length(); i++)
        {
            if(arr1[i] != arr2[i])
            {
                if(diff == 1)
                    return false;

                diff++;
            }
        }

        return  diff == 1;
    }


}
