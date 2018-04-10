package self.learning;

import java.util.ArrayList;

public class Solutions {

    static int[] min_stack(int[] operations) {

        ArrayList<Integer> results = new ArrayList<>();
        MinStack myStack = new MinStack();

        for(int i = 0; i < operations.length; i++)
        {
            if(operations[i] > 0)
            {
                myStack.push(operations[i]);
            }
            else if(operations[i] == 0)
            {
                results.add(myStack.getMin());
            }
            else
            {
                myStack.pop();
            }
        }

        int[] answers = new int[results.size()];
        for(int i = 0; i < results.size(); i++)
        {
            answers[i] = results.get(i).intValue();
        }

        return answers;

    }
}
