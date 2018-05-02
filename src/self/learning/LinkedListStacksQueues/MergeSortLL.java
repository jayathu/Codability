package self.learning.LinkedListStacksQueues;

public class MergeSortLL {

    public void BuildAndRun()
    {
        LinkedList list = new LinkedList(new int[]{12,1,34,33,20,3,7});
        printList(mergeSort(list.head));
    }

    public LinkedListNode mergeSort(LinkedListNode head)
    {
        if(head == null || head.next == null) {
            return head;
        } else {
            LinkedListNode second = split(head);
            LinkedListNode first  = mergeSort(head);
            second = mergeSort(second);
            return mergeLists(first, second);
        }
    }

    public LinkedListNode split(LinkedListNode node)
    {
        LinkedListNode slow = node;
        LinkedListNode fast = node;
        LinkedListNode prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        return slow;
    }

    private void printList(LinkedListNode head)
    {
        System.out.println();
        LinkedListNode node = head;
        while(node != null)
        {
            System.out.print(node.val + "->");
            node = node.next;
        }

        System.out.println();
    }

    private LinkedListNode mergeLists(LinkedListNode n1, LinkedListNode n2)
    {
        LinkedListNode n = null;
        LinkedListNode head = null;

        while(n1 != null && n2 != null)
        {
            LinkedListNode p;
            if(n1.val < n2.val) {
                p = n1;
                n1 = n1.next;
            }
            else if(n1.val > n2.val) {
                p = n2;
                n2 = n2.next;
            }
            else{
                p = n1;
                n1 = n1.next;
                n2 = n2.next;
            }
            if(head == null) {
                head = p;
                n = p;
            }
            else{
                n.next = p;
                n = n.next;
            }
        }

        //check for any remaining nodes
        if(n1 == null)
        {
            while(n2 != null)
            {
                n .next = n2;
                n2 = n2.next;
                n = n.next;
            }
        }
        if(n2 == null)
        {
            while(n1 != null)
            {
                n.next = n1;
                n1 = n1.next;
                n = n.next;
            }
        }
        return head;
    }
}
