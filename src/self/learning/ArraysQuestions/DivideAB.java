package self.learning.ArraysQuestions;

public class DivideAB {

    public static void divide(int a, int b)
    {
        if(b == 0) {
            System.out.print(a + "/" + b + " = UNDEFINED");
            System.out.println();
            return;
        }

        if(a == 0) {
            System.out.print(a + "/" + b + " = " + 0);
            System.out.println();
            return;
        }

        int abA = Math.abs(a);
        int abB = Math.abs(b);

        int count = 0;
        while(abA >= abB)
        {
            abA -= abB;
            count++;
        }

        if ((a < 0 && b > 0 ) || (a > 0 && b < 0))
        {
            count = 0 - count;
        }

        System.out.print(a + "/" + b + " = " + count);
        System.out.println();

        return;
    }
}
