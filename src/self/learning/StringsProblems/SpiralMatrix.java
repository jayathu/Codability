package self.learning.StringsProblems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void print(char[][] matrix)
    {
        int rIndex = 0, cIndex = 0;
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        List<Character> list = new ArrayList<>();

        for(int i = 0; i < numRows; i++)
        {
            for(int j = 0; j < numCols; j++)
            {
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
            System.out.println();
        }
        while(rIndex <= numRows / 2 && cIndex <= numCols / 2)
        {
            int rBeg = rIndex;
            int cBeg = cIndex;
            int rEnd = numRows - rBeg - 1;
            int cEnd = numCols - cBeg - 1;

            if(rBeg <= rEnd)
            {
                for(int col = cBeg; col <= cEnd; col++)
                {
                    list.add(matrix[rBeg][col]);
                }
            }

            if(cBeg <= cEnd)
            {
                for(int row = rBeg + 1; row <= rEnd; row++)
                {
                    list.add(matrix[row][cEnd]);
                }
            }

            if(rBeg < rEnd)
            {
                for(int col = cEnd - 1; col >= cBeg; col --)
                {
                    list.add(matrix[rEnd][col]);
                }
            }

            if(cBeg < cEnd)
            {
                for(int row = rEnd - 1; row > rBeg; row--)
                {
                    list.add(matrix[row][cBeg]);
                }
            }

            rIndex++;
            cIndex++;
        }

        for(Character c : list)
        {
            System.out.print(" " + c);
        }
    }
}
