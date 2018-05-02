package self.learning.Pramp;

/*
Implement a function meetingPlanner that given the availability, slotsA and slotsB, of two people and a meeting duration dur,
returns the earliest time slot that works for both of them and is of duration dur.
If there is no common time slot that satisfies the duration requirement, return null.

In your implementation assume that the time slots in a person’s availability are disjointed, i.e, time slots in a person’s availability don’t overlap.
Further assume that the slots are sorted by slots’ start time.

Implement an efficient solution and analyze its time and space complexities.

Test Case #1
Input: [[7,12]], [[2,11]], 5,
Expected: [],
Actual: []

Test Case #2
Input: [[6,12]], [[2,11]], 5,
Expected: [6,11],
Actual: [6, 11]

Test Case #3
Input: [[1,10]], [[2,3],[5,7]], 2,
Expected: [5,7],
Actual: [5, 7]

Test Case #4
Input: [[0,5],[50,70],[120,125]], [[0,50]], 8,
Expected: [],
Actual: []

Test Case #5
Input: [[10,50],[60,120],[140,210]], [[0,15],[60,70]], 8,
Expected: [60,68],
Actual: [60, 68]

Test Case #6
Input: [[10,50],[60,120],[140,210]], [[0,15],[60,72]], 12,
Expected: [60,72],
Actual: [60, 72]

 */

public class TimePlanner {

    public int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {

        int i = 0, j = 0;

        while(i < slotsA.length && j < slotsB.length)
        {
            int maxStart = Math.max(slotsA[i][0], slotsB[j][0]);
            int minEnd = Math.max(slotsA[i][1], slotsB[j][1]);

            if(minEnd - maxStart >= dur)
            {
                return new int[]{maxStart, maxStart + dur};
            }

            if(slotsA[i][1] < slotsB[j][1])
                i++;
            else j++;
        }

        return new int[]{};
    }

}
