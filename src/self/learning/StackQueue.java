package self.learning;

import java.util.Stack;

public class StackQueue {

    public static LinkedListNode implement_queue(LinkedListNode operations) {

        StackQueueInner q = new StackQueueInner();
        LinkedListNode head = operations;
        LinkedListNode results = null;
        LinkedListNode resultHead = null;

        while(head != null)
        {
            if(head.val >= 0)
            {
                q.enqueue(head.val);
            }
            else {

                int val = q.dequeue();
                if(results == null)
                {
                    results = makeNode(val);
                    resultHead = results;
                }
                else{
                    results.next = makeNode(val);
                    results = results.next;
                }
            }

            head = head.next;
        }

        return resultHead;

    }

    static LinkedListNode makeNode(int val)
    {
        return new LinkedListNode(val);
    }

    static class StackQueueInner
    {
        Stack s1;
        Stack s2;

        StackQueueInner()
        {
            s1 = new Stack();
            s2 = new Stack();
        }

        void enqueue(int val)
        {
            s1.push(val);
        }

        int dequeue()
        {
            while(!s1.isEmpty())
            {
                s2.push(s1.pop());
            }

            int val = -1;
            if(!s2.isEmpty()){
                val = (int)s2.pop();
            }
            while(!s2.isEmpty())
            {
                s1.push(s2.pop());
            }
            return val;
        }

    }

}
