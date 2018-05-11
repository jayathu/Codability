package self.learning.Sandbox;
import java.util.*;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Example:
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveNumbers {

    public int longestConsecutive(final List<Integer> A) {

        HashMap<Integer, Boolean> map = new HashMap<>();
        for(Integer num : A)
        {
            map.put(num, true);
        }

        int max = Integer.MIN_VALUE;
        for(Integer key : map.keySet())
        {
            int prev = key - 1;
            int next = key + 1;

            int count = 1;
            while(map.containsKey(prev) && map.get(prev)) {
                count++;
                map.put(prev, false);
                prev--;
            }
            while(map.containsKey(next) && map.get(next)){
                count++;
                map.put(next, false);
                next++;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
