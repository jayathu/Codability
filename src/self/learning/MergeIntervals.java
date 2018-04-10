package self.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Merge overlapping intervals (Google phone screen )
public class MergeIntervals {

//    Intervals[] intervals = new Intervals[]{
//                                    new Intervals(1,5),
//                                    new Intervals(10,15),
//                                    new Intervals(4,6),
//                                    new Intervals(2,4)
//                                };

    static Intervals[] merge(Intervals[] intervals)
    {
        Arrays.sort(intervals);
        List<Intervals> list = new ArrayList<>();

        int first = 0, i = 0;
        while(i < intervals.length)
        {
            while(i < intervals.length - 1 && intervals[i].end >= intervals[i + 1].start)
            {
                i++;
            }

            list.add(merge(intervals, first, i));
            i++;
            first = i;
        }

        return list.toArray(new Intervals[list.size()]);

    }

    static Intervals merge(Intervals[] intervalsArr, int first, int last)
    {
        Intervals intervals = intervalsArr[first];
        for(int i = first; i <= last; i++ ) {
            intervals.start = Math.max(intervals.start, intervalsArr[i].start);
            intervals.end = Math.min(intervals.end, intervalsArr[i].end);
        }

        return intervals;

    }

    static void print(Intervals[] intervals)
    {
        for (Intervals intervals1 : intervals)
        {
            print(intervals1);
        }

    }

    static void print(Intervals intervals)
    {
        System.out.println("(" + intervals.start + "," + intervals.end + ")");
    }
}


class Intervals implements Comparable<Intervals>
{
    int start;
    int end;

    Intervals(int s, int e)
    {
        start = s;
        end = e;
    }

    public int compareTo(Intervals o)
    {
        return Integer.compare(start, o.start);
    }
}
