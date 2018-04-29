package self.learning.LinkedListStacksQueues;

public class LinkedListSolution {

    public void BuidAndRun()
    {
//        int[] arr = new int[]{1,2,3,4,5};
//        Node head = new Node(arr[0]);
//        Node node = head;
//        for(int i = 1; i < arr.length; i++)
//        {
//            node.next = new Node(arr[i]);
//            node = node.next;
//        }

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        one.arbitrary = three;
        one.next = two;

        two.arbitrary = one;
        two.next = three;

        three.arbitrary = five;
        three.next = four;

        four.arbitrary = three;
        four.next = five;

        five.arbitrary = two;

        PrintList(one);
        CloneList cloneList = new CloneList();
        //Node newNode = cloneList.clone(head);
        //PrintList(newNode);

        Node newNode = cloneList.CloneDoublyLinkedList(one);
        PrintList(newNode);

    }

    private void PrintList(Node head)
    {
        Node curr = head;
        while(curr != null)
        {
            if(curr.next != null) {
                System.out.println(curr.arbitrary.val + "<-" + curr.val + "->" + curr.next.val);
            }else
            {
                System.out.println(curr.arbitrary.val + "<-" + curr.val + "-> NULL");
            }


            curr = curr.next;
        }
    }
}
