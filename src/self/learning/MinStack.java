package self.learning;

import java.util.Stack;


public class MinStack extends Stack<Integer>{

    private Stack<Integer> minStack;

    public MinStack()
    {
        minStack = new Stack<>();
    }

    public void push(int value)
    {
        if(minStack.isEmpty() || minStack.peek() > value)
        {
            minStack.push(value);
        }

        super.push(value);

    }

    public Integer pop()
    {
        Integer value = super.pop();
        if(minStack.peek() == value)
        {
            minStack.pop();
        }
        return value;
    }

    public Integer getMin()
    {
        if(minStack.isEmpty())
        {
            return -1;
        }
        return minStack.peek();
    }

}