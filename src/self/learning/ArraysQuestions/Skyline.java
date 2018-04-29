package self.learning.ArraysQuestions;

import java.util.*;

public class Skyline {

    static class Point implements Comparable<Point> {
        int x;
        int height;
        boolean isStart;
        int index;

        public Point(int x, int height, boolean isStart, int index) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
            this.index = index;
        }

        @Override
        public int compareTo(Point o) {
            //first compare by x.
            //If they are same then use this logic
            //if two starts are compared then higher height building should be picked first
            //if two ends are compared then lower height building should be picked first
            //if one start and end is compared then start should appear before end
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
            }
        }
    }

    public static void BuildAndRunSkyline()
    {
        int[][] buildings = new int[][]{
                {1,11,5},
                {2,6,7},
                {3,13,9},
                {12,7,16},
                {14,3,25},
                {19,18,22},
                {23,13,29},
                {24,4,28},
        };

        find_skyline(buildings);
    }
    static int[][] find_skyline(int[][] buildings) {

        Point[] points = new Point[2 * buildings.length];

        for(int i = 0; i < buildings.length; i++)
        {
            points[2*i] = new Point(buildings[i][0], buildings[i][1], true, i + 1);
            points[2*i + 1] = new Point(buildings[i][2], buildings[i][1], false, i + 1);
        }

        System.out.println("Before Sorting\n" );
        for(Point p : points) {
            char c = p.isStart ? 'S' : 'E';
            System.out.print("( " + c + p.index + " " + p.x + "," + p.height + " )");
        }

        System.out.println("After Sorting\n" );
        Arrays.sort(points);
        for(Point p : points) {
            char c = p.isStart ? 'S' : 'E';
            System.out.print("( " + c + p.index + " " + p.x + "," + p.height + " )");
        }


        TreeMap<Integer, Integer> map = new TreeMap<>();
        HashMap<Integer, Integer> results = new HashMap<>();

        Integer maxHeightSoFar = 0;
        map.put(0, 0);
        for(Point p : points)
        {
            if(p.isStart) {
                map.put(p.index, p.height);
                if(map.lastEntry().getValue() > maxHeightSoFar) {
                    maxHeightSoFar = map.lastEntry().getValue();
                    results.put(p.x, maxHeightSoFar);
                }
            }
            else {
                map.remove(p.index);
                if(!map.lastEntry().getValue().equals(maxHeightSoFar)) {
                    maxHeightSoFar = map.lastEntry().getValue();
                    results.put(p.x, maxHeightSoFar);
                }
            }

        }

        int[][] arr = new int[results.size()][2];
        int count = 0;

        System.out.println("\n\n");
        for(Map.Entry<Integer, Integer> entry : results.entrySet())
        {
            arr[count][0] = entry.getKey();
            arr[count][1] = entry.getValue();
            count++;
            System.out.print("(" + entry.getKey() + "," + entry.getValue() + ") ");
        }

        return arr;
    }
}
