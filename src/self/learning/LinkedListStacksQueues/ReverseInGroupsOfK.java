package self.learning.LinkedListStacksQueues;
import java.util.*;


public class ReverseInGroupsOfK {

    class LLNode
    {
        LinkedListNode head;
        LinkedListNode tail;

        LLNode reverse(int k)
        {
            LinkedListNode prev = null;
            LinkedListNode curr = head;
            while(curr != null && k > 0)
            {
                LinkedListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                k--;
            }
            return this;
        }
    }

    public LinkedListNode reverse(LinkedListNode head, int k)
    {
        List<LLNode> list = new ArrayList<>();
        LinkedListNode node = head;
        while(node != null)
        {
            int k1 = k;
            LLNode llNode = new LLNode();
            llNode.head = node;
            while(node.next != null && k1 > 1)
            {
                node = node.next;
                k1--;
            }

            llNode.tail = node;
            list.add(llNode);
            node = node.next;
        }

        head = list.get(0).tail;
        list.get(0).reverse(k);
        for(int i = 1; i < list.size(); i++)
        {
            list.get(i).reverse(k);
            list.get(i-1).head.next = list.get(i).tail;
        }

        return head;
    }

    public void BuildAndRun()
    {
        LinkedList linkedList = new LinkedList(new int[]{1,2,3,4});
        LinkedListNode node = reverse(linkedList.head, 3);

        LinkedListNode curr = node;
        while(curr != null)
        {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}
