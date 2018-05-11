package self.learning.Sandbox;
import java.util.*;

public class UniquePerms {

        public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

            ArrayList<ArrayList<Integer>> results = new ArrayList<>();

            results = permuteRecurse(A, 0, results);
             for(ArrayList<Integer> res : results)
             {
                 System.out.println(res);
             }
            return results;
        }

        private ArrayList<ArrayList<Integer>> permuteRecurse(ArrayList<Integer> A, int index,
                                                             ArrayList<ArrayList<Integer>> results)
        {
            if(index == A.size())
            {
                ArrayList<Integer> res = new ArrayList<>();
                for(int i = 0; i < A.size(); i++){
                    res.add(A.get(i));
                }
                results.add(res);

                return results;
            }

            for(int i = index; i < A.size(); i++)
            {
               boolean done = false;
               for(int k = index; k < i; k++)
               {
                   if(A.get(k) == A.get(i))
                   {
                       done = true;
                       break;
                   }
               }
                if(!done)
                {
                    swap(A, i, index);
                    permuteRecurse(A, index+1, results);
                    swap(A, i, index);
                }
            }

            return results;
        }

        private void swap(ArrayList<Integer> A, int i, int j)
        {
            int temp = A.get(i);
            A.set(i, A.get(j));
            A.set(j, temp);
        }
}
