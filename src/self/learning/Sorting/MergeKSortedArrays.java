package self.learning.Sorting;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    static int[] mergeArrays(int[][] arr)
    {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        int K = arr.length;
        int N = arr[0].length;

        int[] mergedArray = new int[K * N];

        int pointer = 0;

        for(int i = 0; i < K; i++)
        {
            queue.add(new Node(arr[i][0], i, 0));
        }

        while(pointer  <  N *  K)
        {
            Node min = queue.poll();
            mergedArray[pointer] = min.value;
            pointer++;
            if(min.col + 1 < N)
            {
                queue.add(new Node(arr[min.row][min.col + 1], min.row, min.col + 1));
            }
        }

        return mergedArray;
    }


    static void Print(int[] arr)
    {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for(int i = 0; i< arr.length; i++)
        {
            queue.add(new Node(arr[i], 0, 0));
        }

        while(!queue.isEmpty())
        {
            Node node = queue.peek();
            System.out.print(node.value + " ");
            queue.remove(node);
        }
    }


}

class Node implements Comparable<Node>
{
    int value;
    int row;
    int col;

    public Node(int v, int r, int c)
    {
        value = v;
        row = r;
        col = c;
    }


    @Override
    public int compareTo(Node o)
    {
        return Long.compare(this.value, o.value);
    }
}
