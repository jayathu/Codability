package self.learning.Sorting;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Heap {

    private int[] heapArray;
    private int size;
    private int capacity;


    public Heap(int capacity)
    {
        heapArray = new int[capacity];
        size = 0;
        Arrays.fill(heapArray, -1);
    }

    boolean isEmpty()
    {
        return size == 0;
    }

    boolean isFull()
    {
        return size == heapArray.length;
    }

    int parent(int i)
    {
        return (i-1) / 2;
    }

    int left(int i)
    {
        return 2*i + 1;
    }

    int right(int i)
    {
        return 2*i + 2;
    }

    public void insert(int value)
    {
        if(isFull())
            return;

        heapArray[size] = value;
        size++;
        reverse_heapify(size - 1);
    }

    public int getMin()
    {
        if(isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return heapArray[0];
    }

    public int deleteMin()
    {
        if(isEmpty())
            throw new NoSuchElementException("Underflow Exception");

        int keyMin = heapArray[0];
        heapArray[0] = heapArray[size - 1];
        heapArray[size - 1] = keyMin;
        size--;
        heapify(0);
        return keyMin;
    }

    private void reverse_heapify(int childIndex)
    {
        int temp = heapArray[childIndex];
        while(childIndex > 0 && temp < heapArray[parent(childIndex)])
        {
            heapArray[childIndex] = heapArray[parent(childIndex)];
            childIndex = parent(childIndex);
        }
        heapArray[childIndex] = temp;
    }

    //recursive method to heapify a subtree with a root at a given index
    //assumes that the subtrees are valid heaps.
    void heapify(int i)
    {
        int left = left(i);
        int right = right(i);

        int smallest = i;

        if(left < size && heapArray[left] < heapArray[i])
        {
            smallest = left;
        }
        if(right < size && heapArray[right] < heapArray[smallest])
        {
            smallest = right;
        }
        if(smallest != i)
        {
            int temp = heapArray[i];
            heapArray[i] = heapArray[smallest];
            heapArray[smallest] = temp;

            heapify(smallest);
        }
    }

    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for(int i = 0; i < size; i++)
        {
            System.out.print(heapArray[i] + " ");
        }

        System.out.println();
    }

    public static Heap BuildHeap(int[] arr)
    {
        Heap heap = new Heap(arr.length);

        for(int i = 0; i < arr.length; i++)
        {
            heap.insert(arr[i]);
        }
        return heap;
    }

    public static int[] Sort(int[] arr)
    {
        Heap heap = BuildHeap(arr);

        for(int i = 0; i < arr.length; i++)
        {
            heap.deleteMin();
        }

        return heap.heapArray;
    }
}
