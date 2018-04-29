package self.learning.Graphs;

import java.util.*;

public class Practice1 {


    HashMap<Integer, String> wordMap;
    Queue<Integer> queue;
    HashSet<Integer> visited;
    HashMap<Integer, Integer> backRefs;

    void BuildAndRun()
    {
        String[] words = new String[] {"BAT", "CAT", "HAT", "BAD", "HAD"};

        String[] wordLadder = string_transformation(words, "BET", "HAS");

        for(String s : wordLadder)
        {
            System.out.print(s + " ");
        }
    }

    String[] string_transformation(String[] words, String start, String stop) {

        wordMap = new HashMap<>();
        queue = new ArrayDeque<>();
        visited = new HashSet<>();
        backRefs = new HashMap<>();

        for(int i = 0; i < words.length; i++)
        {
            wordMap.put(i, words[i]);
        }
        wordMap.put(words.length, stop);

        Integer index = -1;
        queue.add(index);
        while(!queue.isEmpty())
        {
            index = queue.remove();
            String curr;
            if(index == -1)
            {
                curr = start;
            }
            else
            {
                curr = wordMap.get(index);
            }

            addNeighbors(curr, index);

            if(curr.equals(stop))
            {
                break;
            }
        }

        List<String> wordLadder = new ArrayList<>();

        while(index != -1)
        {
            wordLadder.add(wordMap.get(index));
            index = backRefs.get(index);
        }

        wordLadder.add(start);
        Collections.reverse(wordLadder);
        return wordLadder.toArray(new String[wordLadder.size()]);

    }

    void addNeighbors(String curr, int index)
    {
        for(int i = 0; i < wordMap.size(); i++)
        {
            if(!visited.contains(i) && oneEditAway(curr, wordMap.get(i)))
            {
                visited.add(i);
                queue.add(i);
                backRefs.put(i, index);
            }
        }
    }

    boolean oneEditAway(String s1, String s2)
    {
        int diff = 0;
        for(int i = 0; i < s1.length(); i++)
        {
            if(i < s2.length() && s1.charAt(i) != s2.charAt(i))
            {
                diff++;
                if(diff > 1)
                    return false;
            }
        }

       return diff == 1;
    }
}
