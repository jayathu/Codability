package self.learning.Graphs;

import java.util.*;

public class AlienDictionary {

    static StringBuilder sb = new StringBuilder();

    static void find_order(String[] words) {

        HashMap<Character, List<Character>> adjacencyList = new HashMap<>();

        for(int i = 0; i < words.length; i++)
        {
            for(int j = 0; j < words[i].length(); j++)
            {
                List<Character> list = new ArrayList<>();
                adjacencyList.put(words[i].charAt(j), list);
            }
        }
        //Build an adjacency list
        for(int i = 1; i < words.length; i++)
        {
            String s1 = words[i-1];
            String s2 = words[i];

            int len = s1.length() < s2.length() ? s1.length() : s2.length(); //len = 4

            for(int j = 0; j < len; j++)
            {
                if(s1.charAt(j) != s2.charAt(j))
                {
                    List<Character> list = adjacencyList.get(s2.charAt(j));
                    list.add(s1.charAt(j));
                    adjacencyList.put(s2.charAt(j), list);
                    break;
                }
            }
        }

        HashSet<Character> visited = new HashSet<>();

        for(Map.Entry<Character, List<Character>> entry : adjacencyList.entrySet())
        {
            topologicalSort(entry.getKey(), adjacencyList, visited);
        }

        System.out.println(sb.toString());
    }

    static void topologicalSort(Character character, HashMap<Character, List<Character>> adjacencyList, HashSet<Character> visited)
    {
        if(visited.contains(character))
            return;

        List<Character> neighbors = adjacencyList.get(character);

        if(neighbors == null)
        {
            visited.add(character);
            System.out.print(character + " ");
        }
        else {
            for (Character neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    topologicalSort(neighbor, adjacencyList, visited);
                }
            }
            visited.add(character);
            System.out.print(character + " ");
        }
        sb.append(character);
    }


}
