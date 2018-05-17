package self.learning.ArraysQuestions;

/*
Practice basic conversion from 2D matrix to 1D array and vice versa
 */
public class Convert1D2D {

    public void BuildAndRun()
    {
        int[][] matrix = new int[][]{
                {0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24}
        };

        print(matrix);
        int[] arr = convertFrom2Dto1D(matrix);
        print(arr);

        int[][] rMatrix = convertFrom1Dto2D(arr, matrix[0].length);
        print(rMatrix);

    }

    private int[][] convertFrom1Dto2D(int[] arr, int numOfCols)
    {
        int M = arr.length / numOfCols;
        int N = numOfCols;

        int[][] matrix = new int[M][N];

        for(int i = 0; i < arr.length; i++)
        {
            int row = i / N;
            int col = i % N;
            matrix[row][col] = arr[i];
        }
        return matrix;
    }

    private int[] convertFrom2Dto1D(int[][] matrix)
    {
        int M = matrix.length;
        int N = matrix[0].length;

        int[] arr = new int[M * N];

        for(int i = 0; i < M; i ++)
        {
            for(int j = 0; j < N; j++)
            {
                arr[i * N + j] = matrix[i][j];
            }
        }

        return arr;
    }

    private void print(int[][] matrix)
    {
        int M = matrix.length;
        int N = matrix[0].length;

        for(int i = 0; i < M; i ++)
        {
            for(int j = 0; j < N; j++)
            {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private void print(int[] arr)
    {
        System.out.println("1D Array: ");
        for(int num : arr)
        {
            System.out.print(num + " ");
        }
    }

}
