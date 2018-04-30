package self.learning.Sorting;
import java.util.*;
/*
2 Approaches:

Approach 1: Using Heaps
Appraoch 2: Quick Select Algorithm
 */

class Point //implements Comparable<Point>
{
    int x;
    int y;

    Point(int i, int j)
    {
        x = i;
        y = j;
    }

    static int distance(Point p1, Point p2)
    {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    public String toString()
    {
        return "[" + x + "," + y + "]";
    }

}
public class NearestNeighbors {


    public void BuildAndRun()
    {
        int[][] points = new int[][]{ {5,5}, {2,4}, {1, 1}, {2,2}, {3,2} };
        Point[] pointsArr = new Point[points.length];

        Point p = new Point(2, 3);
        for(int i = 0; i < points.length; i++)
        {
            pointsArr[i] = new Point(points[i][0], points[i][1]);
        }

        //findNearest(pointsArr, p, 3);

        findNearest_QuickSelect(pointsArr, p, 3);
    }

    //this takes the heap approach --> time complexity: O(NLogN)
    private void findNearest(Point[] points, Point p, int k)
    {
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(k, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(Point.distance(p, o1), Point.distance(p, o2));
//                int distance = Point.distance(p, o1) - Point.distance(p, o2);
//                if(distance < 0)
//                    return -1;
//                else if(distance > 0)
//                    return 1;
//                else return 0;
            }
        });

        for(Point point : points)
        {
            if(priorityQueue.size() >= k)
            {
                priorityQueue.poll();
            }

            priorityQueue.add(point);
        }

        for(Point point : priorityQueue){
            System.out.println(point.toString());
        }
    }

    class PointWithDistanceToP implements Comparable<PointWithDistanceToP>
    {
        Point p;
        int distance;

        PointWithDistanceToP(int i, int j, int distance)
        {
            p = new Point(i,j);
            this.distance = distance;
        }

        public int compareTo(PointWithDistanceToP other)
        {
            return Integer.compare(this.distance, other.distance);
        }
    }

    private void findNearest_QuickSelect(Point[] points, Point p, int k)
    {
        PointWithDistanceToP[] pointWithDistanceToPS = new PointWithDistanceToP[points.length];
        for(int i = 0; i < points.length; i++)
        {
            pointWithDistanceToPS[i] = new PointWithDistanceToP(points[i].x, points[i].y, Point.distance(p, points[i]));
        }

        System.out.println("Before Sorting");
        for(PointWithDistanceToP obj : pointWithDistanceToPS)
        {
            System.out.println(obj.p.toString() + " Dist: " + obj.distance);
        }

        QuickSelect(pointWithDistanceToPS, k);

        System.out.println("After Sorting");
        //for(PointWithDistanceToP obj : pointWithDistanceToPS)
        for(int i = 0; i < k; i++)
        {
            PointWithDistanceToP obj = pointWithDistanceToPS[i];
            System.out.println(obj.p.toString());
            System.out.println(obj.p.toString() + " Dist: " + obj.distance);
        }

    }

    private void QuickSelect(PointWithDistanceToP[] pointWithDistanceToP, int k)
    {
        QuickSelectRecurse(pointWithDistanceToP, 0, pointWithDistanceToP.length - 1, k);
    }

    private void QuickSelectRecurse(PointWithDistanceToP[] arr, int start, int end, int k)
    {
       int pivotIndex = partition(arr, start, end);
       if(pivotIndex == k)
       {
           return;
       }
       else if(pivotIndex < k)
       {
           QuickSelectRecurse(arr, pivotIndex + 1, end, k);
       }
       else
       {
           QuickSelectRecurse(arr, start,pivotIndex - 1, k);
       }
    }

    //lomuto's partitioning
    //TODO: Try this with Hoare's partitioning as well
    private int partition(PointWithDistanceToP[] arr, int start, int end)
    {
        int pivotIndex = start;
        for(int i = start; i < end; i++)
        {
            if(arr[i].compareTo(arr[end]) < 0)
            {
                swap(arr, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(arr, pivotIndex, end);
        return pivotIndex;
    }

    private void swap(PointWithDistanceToP[] arr, int i, int j)
    {
        PointWithDistanceToP temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
