package self.learning.StringsProblems;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;

public class LongestSubWithUnique {

    public static String longestSub2(String str)
    {
        char[] arr = str.toCharArray();
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        String res = "";

        while(right < arr.length)
        {
            while(right < arr.length && map.size() <= 2)
            {
                Integer count = map.get(arr[right]);
                if(count == null)
                {
                    count = 0;
                }
                map.put(arr[right], count + 1);
                right++;
            }

            String newStr = (right == arr.length) ? str.substring(left, right) : str.substring(left, right - 1 );
            res = res.length() < newStr.length() ? newStr : res;
            while(left < right && map.size() > 2)
            {
                Integer count = map.get(arr[left]);
                if(count == 1)
                {
                    map.remove(arr[left]);
                }
                else
                {
                    map.put(arr[left], count - 1);
                }
                left++;
            }
        }
        System.out.println(res);
        return res;

    }
    //This code is much simpler because I add the character to the hashmap regardless
    //THEN I check if the size > 2, and if so, keep removing elements at the left index until size == 2

    public static String longestSub_improved(String strText)
    {
        int left = 0, right;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        String res = "";
        boolean flag = false;

        for(right = 0; right < strText.length(); right++)
        {
            char ch = strText.charAt(right);
            if(freqMap.containsKey(strText.charAt(right)))
            {
                freqMap.put(ch, freqMap.get(ch) + 1);
            }
            else
            {
                freqMap.put(ch, 1);
            }

            if(freqMap.size() > 2)
            {
                res = longest(res, strText.substring(left, right));
                while(freqMap.size() > 2)
                {
                    char c = strText.charAt(left);
                    int count = freqMap.get(c);

                    if(count > 1)
                    {
                        freqMap.put(c, count - 1);
                    }
                    else
                    {
                        freqMap.remove(c);
                    }
                    left++;
                }
            }
        }
        if(freqMap.size() == 2)
            flag = true;
        if(flag) {
            res = longest(res, strText.substring(left, right));
        }

        System.out.println(res);

        return res;

    }

    //All code below is my first draft, ugly modularization - not needed
    //Key diff is I was defensively checking for hashmap size before adding to it
    static HashMap<Character, Integer> freqMap = new HashMap<>();
    static int size = 0;
    static boolean flag = false;

    public static String longestSub(String strText)
    {
        char[] arr = strText.toCharArray();

        int left = 0, right = 1;
        String res = strText.substring(left, right);
        insertIntoMap(arr[left]);

        while(left < right && right < arr.length)
        {

            while(right < arr.length && canInsertIntoMap(arr[right]))
            {
                insertIntoMap(arr[right]);
                right++;
            }
            res = longest(res, strText.substring(left, right));
            while(canRemoveFromMap())
            {
                removeFromMap(arr[left]);
                left++;
            }
        }

        res = longest(res, strText.substring(left, right));

        if(!flag)
            return "";
        return res;
    }

    static boolean canInsertIntoMap(char ch)
    {
        if(freqMap.containsKey(ch))
            return true;
        else if(freqMap.size() < 2)
            return true;
        return false;
    }

    static void insertIntoMap(char ch)
    {
        if(freqMap.containsKey(ch))
        {
            Integer count = freqMap.get(ch);
            freqMap.put(ch, count + 1);
        }
        else
        {
            freqMap.put(ch, 1);
        }
        size++;
        if(freqMap.size() >= 2)
            flag = true;
    }

    static String longest(String s1, String s2)
    {
        return s1.length() > s2.length() ? s1 : s2;

    }

    static boolean canRemoveFromMap()
    {
        if(freqMap.size() > 1 )
        {
            return true;
        }
        return false;
    }

    static void removeFromMap(char c)
    {
        if(freqMap.containsKey(c))
        {
            Integer count = freqMap.get(c);
            if(count >= 2)
            {
                freqMap.put(c, count - 1);
            }
            else{
                freqMap.remove(c);
            }
            size--;
        }
    }
}
