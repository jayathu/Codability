package self.learning.LinkedListStacksQueues;
import java.util.*;

public class MatchingParanthesis {

    public void BuildAndRun()
    {
        String str = "[[[]]()]{}";

        boolean tf = hasMatchingParantheses(str);

        System.out.print(tf);
    }

    boolean hasMatchingParantheses(String strExpression) {

        Stack<Character> stack = new Stack<>();

        HashMap<Character, Character> matchingParen = new HashMap<>();

        matchingParen.put(')', '(');
        matchingParen.put('}', '{');
        matchingParen.put(']', '[');


        char[] arr = strExpression.toCharArray();

        for(char c : arr)
        {
            if(matchingParen.containsValue(c))
            {
                stack.push(c);
            }else if(matchingParen.containsKey(c))
            {
                if(stack.isEmpty()) return false;
                else{
                    char paren = stack.pop();
                    if (paren != matchingParen.get(c))
                        return false;
                }
            }
        }
        return true;
    }
}
