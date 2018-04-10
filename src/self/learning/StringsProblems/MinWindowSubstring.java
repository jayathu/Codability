package self.learning.StringsProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindowSubstring {

    public static String MinWindow(String strText, String strCharacters)
    {

        Map<Character, Integer> freqMap =  new HashMap<>();

        for(char c : strCharacters.toCharArray())
        {
            if(freqMap.containsKey(c))
            {
                freqMap.put(c, freqMap.get(c) + 1);
            }
            else
                freqMap.put(c, 1);
        }

        Map<Character, Integer> map = new HashMap<>();

        int  left = 0, right = 0;
        int minLeft = 0, minRight = 0;
        int minLenth = Integer.MAX_VALUE;

        while(left <= right && right < strText.length())
        {
            while(right < strText.length() && !controls(map, freqMap))
            {
                Character c = strText.charAt(right);
                if(freqMap.containsKey(c))
                {
                    addChar(map, c);
                }
                right ++;
            }

            while(left < right && controls(map, freqMap))
            {
                Character c = strText.charAt(left);
                if(freqMap.containsKey(c))
                {
                    removeChar(map, c);
                }

                left++;
            }

            if(minLenth > right - left)
            {
                minLenth = right - left + 1;
                minLeft = left;
                minRight = right;
            }
        }

        return strText.substring(minLeft-1, minRight);

    }

    static boolean controls(Map<Character, Integer> map, Map<Character, Integer> freqMap)
    {
        for(Map.Entry<Character, Integer> entry : freqMap.entrySet())
        {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if(!map.containsKey(key) || map.get(key) < value) {
                return false;
            }
        }

        return true;
    }

    static void addChar(Map<Character, Integer> map, char c)
    {
        if(map.containsKey(c))
        {
            map.put(c, map.get(c) + 1);
        }
        else{
            map.put(c, 1);
        }
    }

    static void removeChar(Map<Character, Integer> map, char c)
    {
        if(map.containsKey(c))
        {
            if(map.get(c) > 1)
            {
                map.put(c, map.get(c) - 1);
            }
            else{
                map.remove(c);
            }
        }
    }


}
