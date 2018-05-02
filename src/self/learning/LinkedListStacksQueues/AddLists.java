package self.learning.LinkedListStacksQueues;

public class AddLists {

    public void BuildAndRun()
    {
        LinkedList list1 = new LinkedList(new int[] { 9,9 });
        LinkedList list2 = new LinkedList(new int[] { 9,9,9,9 });

        LinkedListNode result;

        if(list1.length() > list2.length())
            result = addLists(list1.head, list2.head);
        else
            result = addLists(list2.head, list1.head);

        while(result != null)
        {
            System.out.print(result.val + "->");
            result = result.next;
        }

    }

    private LinkedListNode addLists(LinkedListNode first, LinkedListNode second)
    {
        int carry = 0;
        LinkedListNode result = first;
        LinkedListNode prev = null;

        while(first != null && second != null)
        {
            int sum = first.val + second.val + carry;
            first.val = sum % 10;
            carry = sum / 10;

            prev = first;
            first = first.next;
            second = second.next;
        }


        if(first != null)
        {
            while(first != null)
            {
                int sum = first.val + carry;
                carry = sum / 10;
                first.val = sum % 10;
                prev = first;
                first = first.next;
            }
        }

        if(carry > 0)
        {
            prev.next = new LinkedListNode(carry);
        }

        return result;

    }
}
