package self.learning.Graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjMatrix implements Graph {

    private int numOfEdges;
    private int numOfVertices;
    private int[][] matrix;
    private boolean[] visited;

    public GraphAdjMatrix(int[] vertices)
    {
        matrix = new int[vertices.length][vertices.length];
        visited = new boolean[vertices.length];
        numOfVertices = vertices.length;
        numOfEdges = 0;
    }

    @Override
    public int getNumOfEdges() {
        return numOfEdges;
    }

    @Override
    public int getNumOfVertices() {
        return numOfVertices;
    }

    @Override
    public int first(int v) {
        if(validVertex(v))
        {
            for(int col = 0; col < matrix[0].length; col++)
            {
                if(matrix[v][col] > 0)
                    return matrix[v][col];
            }
        }

        return 0;
    }

    //next neighbor
    @Override
    public int next(int v, int w) {
        if(validVertex(v) && validVertex(w))
        {
            for(int col = w + 1; col < matrix[0].length; col++)
            {
                if(matrix[v][col] > 0)
                    return matrix[v][col];
            }
        }
        return 0;
    }

    @Override
    public void setEdge(int v1, int v2, int weight) {

        if(validVertex(v1) && validVertex(v2))
        {
            if(matrix[v1][v2] == 0)
                numOfEdges++;

            matrix[v1][v2] = weight;
        }
    }

    @Override
    public void delEdge(int v1, int v2) {

        if(validVertex(v1) && validVertex(v2) && matrix[v1][v2] > 0 )
        {
            matrix[v1][v2] = 0;
            numOfEdges--;
        }
    }

    @Override
    public boolean getVisitedStatus(int v) {

        return validVertex(v) && visited[v];
    }

    @Override
    public void setVisitedStatus(int v, boolean val) {

        if(validVertex(v))
        {
            visited[v] = val;
        }
    }

    @Override
    public int getWeight(int v1, int v2) {
        if(validVertex(v1) && validVertex(v2))
        {
            return matrix[v1][v2];
        }

        return 0;
    }

    @Override
    public List<Integer> neighbors(int v) {

        if(!validVertex(v))
            return null;

        List<Integer> neighbors = new ArrayList<>();
        for(int col = 0; col < numOfVertices; col++)
        {
            if(matrix[v][col] > 0)
                neighbors.add(matrix[v][col]);
        }
        return neighbors;
    }

    @Override
    public List<Integer> shortestPath(int v, int w) {
        return null;
    }

    @Override
    public void printAllPaths(int v, int w) {

    }

    @Override
    public List<Integer> dfs(int v, int w) {
        return null;
    }

    @Override
    public List<Integer> bfs(int v, int w) {
        return null;
    }

    boolean validVertex(int v)
    {
        return v >= 0 && v < numOfVertices;
    }
}
