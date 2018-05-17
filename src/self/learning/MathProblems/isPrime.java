package self.learning.MathProblems;
import javafx.collections.transformation.SortedList;

import java.util.*;

public class isPrime {

    public int isPrime(int A) {
        if (A == 1) return 0;

        int upperLimit = (int)(Math.sqrt(A));
        for (int i = 2; i <= upperLimit; i++) {
            if (A % i == 0) return 0;
        }

        //An alternate way of looping
//        for(int i = 2; i * i <= A; i++){
//
//        }

        return 1;
    }
}
