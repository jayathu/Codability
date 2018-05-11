package self.learning.Sandbox;
import java.util.*;

public class NQueens {

    ArrayList<Integer[]> results = new ArrayList<>();

    public void Place(int N)
    {
        Integer[] colBuffer = new Integer[N];

        for(int row = 0; row < N; row ++)
        {
            placeRecurse(row, N, colBuffer);
            //colBuffer = resetBuffer(colBuffer);
        }

        printResults();
    }

    private Integer[] resetBuffer(Integer[] colBuffer)
    {
        for(int i = 0; i < colBuffer.length; i++)
        {
            colBuffer[i] = 0;
        }

        return colBuffer;
    }
    private void placeRecurse(int row, int N, Integer[] colBuffer)
    {
        if(row == N)
        {
            results.add(colBuffer.clone());
            return;
        }

        for(int col = 0; col < N; col++)
        {
            if(canPlace(row, col, colBuffer))
            {
                colBuffer[row] = col;
                placeRecurse(row + 1, N, colBuffer);
            }
        }
    }

    private boolean canPlace(int row, int col, Integer[] colBuffer)
    {
        for(int i = 0; i < row; i++)
        {
            int prevCol = colBuffer[i];
            //int prevRow = i;

            if(col == prevCol)
                return false;

            int rowDist = Math.abs(row - i);
            int colDist = Math.abs(col - prevCol);

            if(rowDist == colDist)
                return false;
        }

        return true;
    }

    private void printResults()
    {
        for(Integer[] buffer : results)
        {
            for(Integer col : buffer)
            {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
