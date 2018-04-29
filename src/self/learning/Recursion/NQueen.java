package self.learning.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueen {

    static void PlaceQueen(int N)
    {
        ArrayList<Integer[]> results = new ArrayList<>();
        Integer[] visitedCols = new Integer[N];

        for(int row = 0; row < N; row++) {
            results = PlaceQueenRecurse(N, row, visitedCols, results);
        }

        String[][] allResults = new String[results.size()][];

        for(int i = 0; i < results.size(); i++){

            String[] result = new String[results.get(i).length];

            for(int j = 0; j < results.get(i).length ; j++){

                char[] chars = generateString(results.get(i)[j], N);
                result[j] = String.valueOf(chars);//Arrays.toString(generateString(results.get(i)[j], N));
            }

            allResults[i] = result;
        }

        PrintResults(allResults);
    }

    static void PrintResults(String[][] allResults)
    {

        for (String[] list : allResults
                ) {
            for (String s: list
                    ) {

                System.out.print(s);
            }
            System.out.println();

        }

    }

    static ArrayList<Integer[]> PlaceQueenRecurse(int N, int row, Integer[] colBuffer, ArrayList<Integer[]> results)
    {
        if(row == N)
        {
            results.add(colBuffer.clone());

        }else {
            for (int col = 0; col < N; col++) {
                if (isValidCell(row, col, colBuffer)) {
                    colBuffer[row] = col; //place the queen
                    PlaceQueenRecurse(N, row + 1, colBuffer, results);
                }
            }
        }

        return results;
    }

    static char[] generateString(int col, int N)
    {
        char[] chars = new char[N];
        for(int i = 0; i < chars.length; i++) {
            if(i == col)
                chars[i] = 'q';
            else chars[i] ='-';
        }
        return chars;
    }

    static boolean isValidCell(int row, int col, Integer[] buffer)
    {
        for(int i = 0; i < row; i++)
        {
            int prevCol = buffer[i];

            if(col == prevCol)
                return false;

            int prevRow = i;

            int rowDist = Math.abs(row - prevRow);
            int colDist = Math.abs(col - prevCol);

            if(rowDist == colDist)
            {
                return false;
            }
        }

        return true;
    }


}
