package self.learning.Sandbox;

public class Subtract {

    class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
    private ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode subtract(ListNode A) {

        if(A.next == null)
        {
            return A;
        }

        ListNode first = A;
        ListNode second = A;
        boolean oddNodes = false;

        while(second != null && second.next != null)
        {
            first = first.next;
            second = second.next.next;
        }

        if(second != null)
        {
            first = first.next;
            oddNodes = true;
        }

        second = reverse(first);
        first = A;
        ListNode head = null;
        ListNode secondHead = second;

        ListNode prev = null;
        while(second != null)
        {
            first.val = second.val - first.val;
            if(head == null)
            {
                head = first;
            }
            prev = first;
            first = first.next;
            second = second.next;
        }

        if(oddNodes){
            first.next = reverse(secondHead);
        }
        else{
            prev.next = reverse(secondHead);
        }
        return head;
    }
}

