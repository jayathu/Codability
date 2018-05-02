package self.learning.LinkedListStacksQueues;

public class AlternateNodeSplit {

    public void BuildAndRun()
    {
        LinkedList list = new LinkedList(new int[]{1,2,3,4,5});

        splitAlternate(list);

    }

    private void splitAlternate(LinkedList list)
    {
        if(list.head == null)
            return;

        if(list.head.next == null)
        {
            list.Print();
            return;
        }

        LinkedListNode first = list.head;
        LinkedListNode second = first.next;
        LinkedListNode firstHead = first;
        LinkedListNode secondHead = second;

        while(first != null && second != null)
        {
            first.next = first.next.next;
            if(second.next != null) {
                second.next = second.next.next;
            }
            first = first.next;
            second = second.next;
        }

        System.out.println();
        while(firstHead != null)
        {
            System.out.print(firstHead.val + "->");
            firstHead = firstHead.next;
        }

        System.out.println();

        while(secondHead != null)
        {
            System.out.print(secondHead.val + "->");
            secondHead = secondHead.next;
        }

    }
}
