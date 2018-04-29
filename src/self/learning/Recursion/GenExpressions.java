package self.learning.Recursion;

import java.util.ArrayList;

public class GenExpressions {

    static String[] generate_all_expressions(String s, long target) {

        ArrayList<String> allExpressions = new ArrayList<>();
        allExpressions = generate_recurse(allExpressions, s, "", target, 0, 0, 0);
        return allExpressions.toArray(new String[allExpressions.size()]);
    }

    static long stringToLong(String input)
    {
        long value = 0;
        for(int i = 0; i < input.length(); i++)
        {
           value = value * 10 + (input.charAt(i) - '0');
        }

        return value;
    }

    private static ArrayList<String> generate_recurse(ArrayList<String> allExpressions, String input, String expressionSoFar,
                                             long target, long valueSoFar, long valueAfterRecentAddtion, int position )

    {
        if(position == input.length())
        {
            if(valueSoFar == target)
            {
                allExpressions.add(expressionSoFar);
                return allExpressions;
            }
        }
            for(int i = position; i < input.length(); i++)
            {
                String noToAddAsString = input.substring(position, i + 1);
                System.out.println(noToAddAsString);
                long valueToAdd = stringToLong(noToAddAsString);

                if(position == 0)
                {
                    generate_recurse(allExpressions, input, noToAddAsString, target, valueToAdd, valueToAdd, i + 1);
                }
                else
                {
                    generate_recurse(allExpressions, input, expressionSoFar + "+" + noToAddAsString,
                            target, valueSoFar + valueToAdd, valueToAdd, i + 1);

                    generate_recurse(allExpressions, input, expressionSoFar + "*" + noToAddAsString,
                            target, ((valueSoFar - valueAfterRecentAddtion) + (valueToAdd * valueAfterRecentAddtion)),
                            valueAfterRecentAddtion * valueToAdd , i + 1);
                }
            }

            return allExpressions;
    }

    static void GenerateAllString(String s, int pos, String newString)
    {
        if(pos == s.length())
        {
            System.out.println(newString);
        }
        else
        {
            for(int i = pos; i < s.length(); i++)
            {
                String s2 = s.substring(pos, i + 1);
                if(pos == 0)
                {
                    GenerateAllString(s, i + 1, s2);
                }
                else {
                    GenerateAllString(s, i + 1, newString + "+" + s2);
                    GenerateAllString(s, i + 1, newString + "*" + s2);
                }
            }
        }
    }

}
