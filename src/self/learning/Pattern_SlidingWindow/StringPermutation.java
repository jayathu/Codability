package self.learning.Pattern_SlidingWindow;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;
import java.util.List;

public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        int left = 0;
        char[] arr = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
        }
        for (int right = 0; right < arr.length; right++) {
            if (map.containsKey(arr[right])) {
                map.put(arr[right], map.get(arr[right]) - 1);
                if (map.get(arr[right]) == 0) {
                    map.remove(arr[right]);
                }
            } else {
                map.clear();
                for (int i = 0; i < pattern.length(); i++) {
                    map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
                }
            }
            if (map.size() == 0)
                return true;
        }
        return false;
    }

    public static HashMap<List<Integer>, List<String>> find_pairs(String[][] studentCoursePairs)
    {
        HashMap<List<Integer>, List<String>> results = new HashMap<>();

        HashMap<Integer, List<String>> tempMap = new HashMap<>();

        System.out.print(studentCoursePairs.length);
        System.out.print(studentCoursePairs[0].length);


        return results;

    }
}

