package self.learning.LinkedListStacksQueues;

/**
 * A simple way of implementing this is to think of this as a directed graph and then just do a BFS traversal,
 * keeping track of visited nodes in a set and enquing children nodes in the queue. Clone as you go and proceed to its children
 * (in this case, the children will be the nodes pointed to by the next and arbitrary pointers
 * This takes O(N) additional space
 *
 * The approach taken below is in place and doesn't require any additional memory!
 *
 */

class Node
{
    int val;
    Node next;
    Node arbitrary;
    Node(int v)
    {
        val = v;
        next = null;
        arbitrary = null;
    }

}

//clone a single linked list
public class CloneList {

    Node clone(Node head) {
        Node n = new Node(head.val);
        Node newHead = n;
        while (head.next != null) {
            n.next = new Node(head.next.val);
            n = n.next;
            head = head.next;
        }

        return newHead;
    }

    Node CloneDoublyLinkedList(Node head) {

        //Node newNode = new Node(head.val);
        Node curr = head;
        //Step 1: clone nodes in between original nodes
        while(curr != null)
        {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        //Step 2: link arbitrary pointers

        curr = head;
        while(curr != null)
        {
            curr.next.arbitrary = curr.arbitrary.next;
            curr = curr.next.next;
        }

        //Step 3: unlink original and new nodes

        curr = head;
        Node newHead = curr.next;
        Node newNode = newHead;
        while(newHead.next != null)
        {
            curr.next = curr.next.next;
            curr = curr.next;
            newHead.next = newHead.next.next;
            newHead = newHead.next;
        }

        return newNode;
    }
}


