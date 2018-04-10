package self.learning.ArraysQuestions;

public class DutchFlagPartition {

    public static void Sort(int[] A)
    {
        int runner = 0;
        int leftPartition = 0;
        int rightPartition = A.length - 1;

        System.out.println("Before sort\n");
        for (int i:A
                ) {
            System.out.print(i + " ");
        }

        while(runner <= rightPartition) {
            if(A[runner] == 1) {
                swap(A, runner, leftPartition);
                runner++;
                leftPartition++;
            }else if(A[runner] == 2)
            {
                runner++;
            }else{
                swap(A, runner, rightPartition);
                rightPartition--;
            }
        }

        System.out.println("After sort\n");
        for (int i:A
             ) {
            System.out.print(i + " ");
        }
    }

    static void swap(int[] A, int a, int b)
    {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
