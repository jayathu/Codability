package self.learning.LinkedListStacksQueues;

import java.util.HashMap;

class DoubleLinkedList
{
    Integer key; //key into the hashmap for O(1) access
    Integer value;
    DoubleLinkedList prev;
    DoubleLinkedList next;
}

public class LRUCache {

    private HashMap<Integer, DoubleLinkedList> hashMap;

    private DoubleLinkedList head;
    private DoubleLinkedList tail;

    private int size;

    public LRUCache(int size)
    {
        this.size = size;
        hashMap = new HashMap<>();
    }


    /*
    Basic CRUD operations:
    void SET(int key, int value)
    {
        if cache is full
            call evict
        add <key, value> to hashmap
        add node to head in list
    }

    //void GET(int key)
    //void DELETE(int key)
    //void evict()

    */
    public boolean get(int i)
    {
        boolean tf = false;
        //cache has room
        if(!cacheIsFull())
        {
            if(hashMap.containsKey(i))
            {
                tf = true;
            }
            else
            {
                //add node to tail of the list
                DoubleLinkedList node = new DoubleLinkedList();
                node.key = i;
                if(head == null && tail == null) {
                    head = tail = node;
                }
                else {
                    tail.next = node;
                    tail = node;
                }
                hashMap.put(i, node);

                size++;
                tf = false;
            }

        }
        //cache is full
        else
        {
            if(hashMap.containsKey(i))
            {
                DoubleLinkedList node = hashMap.get(i);
                moveNodeToFront(node);
                tf = true;
            }
            else
            {
                int key = tail.key;
                //evict
                tail.prev.next = null;
                tail.prev = null;
                tail = tail.prev;

                hashMap.remove(key);

                DoubleLinkedList node = new DoubleLinkedList();
                node.key = i;
                node.next = head;
                node.prev = null;
                head.prev = node;
                head = node;

                hashMap.put(key, node);
                size++;
                tf = false;
            }
        }

        System.out.println(tf);
        display();

        return tf;


    }

    private void moveNodeToFront(DoubleLinkedList node)
    {
        if(node.next != null && node.prev != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }
        else if(node == tail) {
            node.prev.next = null;
            tail = node.prev;
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        }

    }

    private boolean cacheIsFull()
    {
        return size == 5;
    }

    public void display()
    {
        DoubleLinkedList current = head;
        while(current != null)
        {
            System.out.print(current.key + " ");
            current = current.next;
        }
        System.out.println();
    }


}
