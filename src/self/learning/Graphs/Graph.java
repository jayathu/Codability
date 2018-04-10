package self.learning.Graphs;

import java.util.List;

public interface Graph {

    int getNumOfEdges();
    int getNumOfVertices();
    int first(int v);
    int next(int v, int w);
    void setEdge(int v1, int v2, int weight);
    void delEdge(int v1, int v2);
    boolean getVisitedStatus(int v);
    void setVisitedStatus(int v, boolean val);
    int getWeight(int v1, int v2);
    List<Integer> neighbors(int v);

    List<Integer> shortestPath(int v, int w);
    void printAllPaths(int v, int w);
    List<Integer> dfs(int v, int w);
    List<Integer> bfs(int v, int w);
}
