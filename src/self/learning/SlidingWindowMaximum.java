package self.learning;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SlidingWindowMaximum {

    static int[] getMaxInWindow(int[] arr, int k)
    {
        ArrayDeque deque = new ArrayDeque();
        ArrayList<Integer> results = new ArrayList();

        for(int i = 0; i < arr.length; i++)
        {
            //remove elements outside of the window (older ones are in the front
            while(!deque.isEmpty() && (int)deque.getFirst() == i - k)
            {
                deque.removeFirst();
            }

            //remove elements in the queue that are smaller than the new element
            while(!deque.isEmpty() && arr[(int)deque.getLast()] <= arr[i])
            {
                deque.removeLast();
            }

            deque.addLast(i);

            //max is always at the front of the deque
            //add them only after the window has moved at least ones to the right

            if(i >= k - 1)
            {
                results.add(arr[(int)deque.getFirst()]);
            }
        }

        int[] res = new int[results.size()];
        for(int i = 0; i < results.size(); i++)
        {
            res[i] = results.get(i);
        }

        return res;

    }

    static int[] trackAllMax(int[] arr, int w)
    {
        int[] results = new int[arr.length - w + 1];
        Deque q = new ArrayDeque();
        for(int i = 0; i < arr.length; i++)
        {
            while(!q.isEmpty() && arr[(int)q.peekLast()] < arr[i])
            {
                q.removeLast();
            }
            q.addLast(i);

            if(i >= w - 1)
            {
                if((int)q.peekFirst() < i - w + 1)
                {
                    q.removeFirst();
                }

                results[i - w + 1] = arr[(int)q.getFirst()];
            }
        }

        return results;
    }
}
