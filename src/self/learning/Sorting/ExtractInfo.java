package self.learning.Sorting;


import java.util.*;

public class ExtractInfo {

    public void process(String[] arr)
    {
        Map<String, Node> map = new HashMap<>();

        for(String s : arr)
        {
            int index = s.indexOf(' ');
            String key = s.substring(0, index);

            index++;

            while(index < s.length())
            {
                int left = index;
                while(index < s.length() && s.charAt(index) != ' ') index++;

                String str = s.substring(left, index);

                if(!map.containsKey(key))
                {
                    map.put(key, new Node(str, 1));
                }
                else{
                    Node n = map.get(key);
                    n.val = n.val.compareTo(str) > 0 ? n.val : str;
                    n.count++;
                }

                index ++;
            }
        }

        for(Map.Entry<String, Node> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + ":" + entry.getValue().count + "," + entry.getValue().val);
        }
    }

    class Node
    {
        String val;
        int count;

        Node(String s, int c)
        {
            val = s;
            count = c;
        }
    }
}
