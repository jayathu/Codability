package self.learning.Sandbox;
import java.util.*;

public class PrettyPrint {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {

        int size = A * 2 - 1;
        int[][] matrix = new int[size][size];

        for(int layer = A; layer > 0; layer--)
        {
            int offset = A - layer;
            for(int i = offset; i < size - offset; i++)
            {
                matrix[offset][i] = layer;
                matrix[i][size - 1 - offset] = layer;
                matrix[size - 1 - offset][i] = layer;
                matrix[i][offset] = layer;
            }
        }

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++)
        {
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = 0; j < matrix[0].length; j++)
            {
                row.add(matrix[i][j]);
            }
            results.add(row);
        }

        return results;
    }
}
