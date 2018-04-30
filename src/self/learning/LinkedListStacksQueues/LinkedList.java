package self.learning.LinkedListStacksQueues;

class LinkedListNode
{
    int val;
    LinkedListNode next;

    LinkedListNode(int v)
    {
        val = v;
        next = null;
    }

    LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode tail, int val)
    {
        LinkedListNode temp = new LinkedListNode(val);
        if(tail != null)
        {
            tail.next = temp;
        }
        return temp;
    }

}

public class LinkedList {

    public LinkedListNode head;

    public LinkedList() {}

    public LinkedList(int[] arr)
    {
        head = new LinkedListNode(arr[0]);

        LinkedListNode node = head;
        for(int i = 1; i < arr.length; i++)
        {
            node.next = new LinkedListNode(arr[i]);
            node = node.next;
        }
    }

    LinkedList(LinkedListNode node)
    {
        head = node;
    }

    LinkedListNode makeList(int[] array)
    {
        head = new LinkedListNode(array[0]);
        LinkedListNode start = head;

        for(int i = 1; i < array.length; i++)
        {
            start = insertEnd(array[i]);
        }

        return head;
    }

    void Print()
    {
        LinkedListNode start = head;
        System.out.println();
        while(start != null)
        {
            System.out.print(start.val + "--->");
            start = start.next;
        }
        System.out.print("NULL");

    }

    LinkedListNode insertEnd(int val)
    {
        LinkedListNode node = new LinkedListNode(val);
        LinkedListNode current = head;
        while(current.next != null)
        {
            current = current.next;
        }
        current.next = node;


        return node;
    }


}
