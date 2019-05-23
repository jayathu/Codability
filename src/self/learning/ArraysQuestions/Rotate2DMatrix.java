package self.learning.ArraysQuestions;

public class Rotate2DMatrix {

    public static void rotateImage(int[][] a) {

        int N = a.length;

        for(int layer = 0; layer < N; layer++)
        {
            for(int i = layer; i < N - layer - 1; i++)
            {
                int temp = a[layer][i];
                a[layer][i] = a[N-1-i][layer];
                a[N-1-i][layer] = a[N-1-layer][N-1-i];
                a[N-1-layer][N-1-i] = a[i][N-1-layer];
                a[i][N-1-layer] = temp;
            }
        }

        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
