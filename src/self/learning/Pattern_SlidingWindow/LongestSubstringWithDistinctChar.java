package self.learning.Pattern_SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithDistinctChar {

    public static int findLength(String str, int k) {
        
        char[] a = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = Integer.MIN_VALUE;
        for(int right = 0; right < a.length; right++)
        {
            map.put(a[right], map.getOrDefault(a[right], 0) + 1);
            while(map.size() > k)
            {
                map.put(a[left], map.get(a[left]) - 1);
                if(map.get(a[left]) == 0)
                {
                    map.remove((a[left]));
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
