package self.learning.LinkedListStacksQueues;

public class SwapKthNode {


    static LinkedListNode swapNodes(LinkedListNode head, int k)
    {
        LinkedListNode start = head;
        LinkedListNode end = head;
        LinkedListNode prevStart = null;
        LinkedListNode prevEnd = null;
        int count = 1;

        while(start != null && count < k)
        {
            prevStart = start;
            start = start.next;
            count++;
        }

        LinkedListNode trail = start;
        while(trail.next != null) {
            trail = trail.next;
            prevEnd = end;
            end = end.next;
        }

        //perform swaps

        if(start == end)
        {
            //nothing to swap
            return head;
        }

        //check if prevStart has advanced at least once during earlier scan.
        // If not, then k must be 1, in which case, we just swap head and end
        if(prevStart != null) {
            prevStart.next = end;
        }
        else{
            head = end;
        }

        //similarly, if prevEnd hasn't advanced at least once, that means k = n
        //in that case, head is start.
        if(prevEnd != null) {
            prevEnd.next = start;
        }else{
            head = start;
        }

        //Swap next pointers of start and end nodes.
        LinkedListNode temp = end.next;
        end.next = start.next;
        start.next = temp;

        start = head;

        return head;
    }
}
