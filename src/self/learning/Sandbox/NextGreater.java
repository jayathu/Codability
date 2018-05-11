package self.learning.Sandbox;
import java.util.*;

public class NextGreater {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {

        //2 4 3 2 1
        ArrayList<Integer> results = new ArrayList<>();
        int i = 0, j = 0;
        for(i = 0; i < A.size(); i++)
        {
            for(j = i + 1; j < A.size(); j++)
            {
                if(A.get(j) > A.get(i))
                {
                    results.add(A.get(j));
                    break;
                }
            }
            if(j == A.size())
            {
                results.add(-1);
            }
        }

        return results;
    }
}

