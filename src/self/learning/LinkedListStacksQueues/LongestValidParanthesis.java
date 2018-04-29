package self.learning.LinkedListStacksQueues;

import java.util.Stack;

public class LongestValidParanthesis {

    static int GetLongest(String input)
    {
        char[] chars = input.toCharArray();

        int valid_from = 0;
        int max_len = 0;

        Stack stack = new Stack<>();

        for(int i = 0; i < chars.length; i++)
        {
            if(chars[i] == '(')
            {
                stack.push(i);
            }
            else
            {
                if(stack.isEmpty())
                {
                    valid_from = i + 1;
                }
                else
                {
                    stack.pop();
                    if(stack.isEmpty())
                    {
                        max_len = Math.max(max_len, i - valid_from + 1);
                    }
                    else
                    {
                        max_len = Math.max(max_len, i - (int)stack.peek());
                    }
                }
            }
        }

        return max_len;
    }
}
