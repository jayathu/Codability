package self.learning;

public class FindIntersection {

    static LinkedListNode find(LinkedListNode node1, LinkedListNode node2)
    {
        int len1 = 0;
        int len2 = 0;
        LinkedListNode runner = node1;
        while(runner != null)
        {
            runner = runner.next;
            len1++;
        }

        runner = node2;
        while(runner != null)
        {
            runner = runner.next;
            len2++;
        }

        if(len1 > len2)
        {
            int diff = len1 - len2;
            while(diff != 0)
            {
                node1 = node1.next;
                diff--;
            }
        }else if(len2 > len1)
        {
            int diff = len2 - len1;
            while(diff != 0)
            {
                node2 = node2.next;
                diff--;
            }
        }

        while(node1 != node2)
        {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }
}
