package self.learning.Sorting;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class GroupNumbers {

    static int[] Group(int[] arr)
    {
        int left = 0, right = arr.length - 1;

        while(left < right)
        {
            while(arr[left] % 2 == 0 && left < arr.length - 1) left++;
            while(arr[right] % 2 != 0 && right > 0) right--;

            if(left < right)
            {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }


        return arr;
    }

    //return K largest elements
    static int[] topK(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i++)
        {
            pq.add(arr[i]);
        }

        int index = k;
        while(index < arr.length)
        {
            if(arr[index] > pq.peek())
            {
                pq.poll();
                pq.add(arr[index]);
            }
           index++;
        }

        int[] kLargest = new int[k];
        for(int i = 0; i < k; i++)
        {
            kLargest[i] = pq.poll();
        }

        return kLargest;
    }

    static int[] topK_withDuplicates(int[] arr, int k) {

        TreeSet<Integer> treeSet = new TreeSet<>();

        for(int i = 0; i < arr.length; i++)
        {
            treeSet.add(arr[i]);
            if(treeSet.size() > k)
            {
                treeSet.pollFirst();
            }
        }

        int[] topK = new int[treeSet.size()];
        for(int i = 0; i < topK.length; i++)
        {
            topK[i] = treeSet.pollFirst();
        }

        return topK;
    }
}
