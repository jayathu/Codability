package self.learning.StringsProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromicWords {

    public static List<String> Find(String[] input)
    {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < input.length; i++)
        {
            map.put(input[i], i);
        }

        List<String> results = new ArrayList<>();

        for(int i = 0; i < input.length; i++)
        {
            if(isAPalindrome(input[i]))
            {
                if(map.containsKey(""))
                {
                    if(map.get("") != i)
                    {
                        results.add(input[i]);
                        results.add("");
                        return results;
                    }
                }
            }
            else
                {

                String reversedString = new StringBuilder(input[i]).reverse().toString();
                if(map.containsKey(reversedString))
                {
                    if(map.get(reversedString) != i)
                    {
                        results.add(input[i]);
                        results.add(reversedString);
                        return results;
                    }
                }
                else {
                    for (int k = 1; k < input[i].length(); k++) {
                        String left = input[i].substring(0, k);
                        String right = input[i].substring(k);

                        if (isAPalindrome(left)) {
                            String reversedRight = new StringBuilder(right).reverse().toString();
                            if (map.containsKey(reversedRight)) {
                                if (map.get(reversedRight) != i) {
                                    results.add(input[i]);
                                    results.add(reversedRight);
                                    //return results;
                                }
                            }
                        } if (isAPalindrome(right)) {
                            String reversedLeft = new StringBuilder(left).reverse().toString();
                            if (map.containsKey(reversedLeft)) {
                                if (map.get(reversedLeft) != i) {
                                    results.add(input[i]);
                                    results.add(reversedLeft);
                                    //return results;
                                }
                            }
                        }
                    }
                }
            }

        }

        return results;
    }

    static boolean isAPalindrome(String s)
    {
        int left = 0, right = s.length() - 1;

        while(left <= right)
        {
            if(s.charAt(left) != s.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
