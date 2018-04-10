package self.learning;


import java.util.HashMap;
import java.util.Map;

public class ExtractInfo {

    static void PrintPairs(String[] input)
    {
        HashMap<String, Node> hashMap = new HashMap<>();

        for(int i = 0; i < input.length; i++)
        {
            String key = input[i].substring(0, 4);
            String value = input[i].substring(5,input[i].length());

            if(hashMap.containsKey(key))
            {
                Node node = hashMap.get(key);
                if(value.compareTo(node.value) > 0)
                {
                    node.value = value;
                }
                hashMap.get(key).count += 1;
            }
            else{
                hashMap.put(key, new Node(1, value));
            }
        }

        String[] output = new String[hashMap.size()];
        int k = 0;
        for (Map.Entry<String, Node> pair:hashMap.entrySet())
        {
            output[k] = pair.getKey() + ": " + pair.getValue().count + pair.getValue().value;
            System.out.println(output[k]);
        }

    }

    static class Node
    {
        int count;
        String value;

        Node(int c, String v)
        {
            count = c;
            value = v;
        }
    }
}
