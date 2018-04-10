package self.learning;

public class ReverseKNodes {

    static void ReverseKNodesLL()
    {
        LinkedList list = new LinkedList();
        list.makeList(new int[]{1,2,3,4,5,6, 7, 8});
        list.Print();

        LinkedListNode next = list.head;
        LinkedListNode tail = list.head;
        LinkedListNode head = list.head;
        LinkedListNode oldTail;

        int i = 0;

        boolean firstTime = true;

        while(next != null)
        {
            while(i < 3 && next != null)
            {
                next = next.next;
                i++;
            }

            i = 0;
                oldTail = tail;
                tail = head;
                if(firstTime) {
                    firstTime = false;
                    list.head = reverse(head, next);
                    head = list.head;
                }
                else{
                    head = reverse(head, next);
                }
                oldTail.next = head;
                tail.next = next;
                head = next;
            }

            list.Print();
    }

    static LinkedListNode reverse(LinkedListNode beg, LinkedListNode end)
    {
        LinkedListNode prev = null;
        LinkedListNode current = beg;
        LinkedListNode next;

        LinkedListNode tail = beg;
        while(current !=  end)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }


        return prev; //return the new head;
    }

    static LinkedListNode zip(LinkedListNode head)
    {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedListNode list1 = head;
        LinkedListNode list2 = reverse(slow.next, null);
        slow.next = null;


        //now merge two lists
        while(list2 != null)
        {
            LinkedListNode next1 = list1.next;
            LinkedListNode next2 = list2.next;
            list1.next = list2;
            list2.next = next1;
            list1 = next1;
            list2 = next2;
        }

        LinkedList list = new LinkedList();
        list.head = head;
        list.Print();

        return  head;
    }
}
