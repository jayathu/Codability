package self.learning.Graphs;

import org.omg.CORBA.INTERNAL;

import javax.jws.Oneway;
import java.util.*;

class Vertex<T>
{
    int val;
    Map<Vertex, Integer> neighbors;

    Vertex(int v)
    {
        val = v;
        neighbors = new HashMap<>();
    }
}

class CostNode implements Comparable<CostNode>
{
    int val;
    int cost;

    CostNode(int v, int c)
    {
        val = v;
        cost = c;
    }

    @Override
    public int compareTo(CostNode o)
    {
        return Long.compare(this.val, o.val);
    }
}

public class GraphAdjList {

    private Map<Integer, Vertex> adjacencyList;

    public GraphAdjList(int[] values) {
        adjacencyList = new HashMap<>();
        for(int val : values) {
            adjacencyList.put(val, new Vertex<>(val));
        }
    }

    public void addEdge(int v1, int v2, int weight) {

        Vertex vertex2 = adjacencyList.get(v2);
        Map neighbors = adjacencyList.get(v1).neighbors;
        neighbors.put(vertex2, weight);
    }

    public void addEdge(int v1, int v2) {

        Vertex vertex1 = adjacencyList.get(v1);
        Vertex vertex2 = adjacencyList.get(v2);
        Map<Vertex, Integer> neighborsOfv1 = adjacencyList.get(v1).neighbors;
        Map<Vertex, Integer> neighborsOfv2 = adjacencyList.get(v2).neighbors;

        neighborsOfv1.put(vertex2, 1);
        neighborsOfv2.put(vertex1, 1);

    }

    public void dijkstraShortestPath(int v, int w)
    {
        PriorityQueue<CostNode> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> backrefs = new HashMap<>();
        backrefs.put(v, null);
        pq.add(new CostNode(v, 0));
        Set<Integer> exhaustedSet = new HashSet<>();
        HashMap<Integer,Integer> distanceMap = new HashMap<>();
        for(int vertex : adjacencyList.keySet())
        {
            distanceMap.put(vertex, Integer.MAX_VALUE);
        }
        distanceMap.put(v, 0);


        while(!pq.isEmpty())
        {
            int vertex = pq.poll().val;
            exhaustedSet.add(vertex);
            int distance = distanceMap.get(vertex);

            Map<Vertex, Integer> neighbors = adjacencyList.get(vertex).neighbors;

            for(Map.Entry<Vertex, Integer> neighbour : neighbors.entrySet()){

                int val = (int) neighbour.getKey().val;
                Integer weight = neighbour.getValue();

                if(exhaustedSet.contains(val))
                    continue;

                int neighbour_dist = distanceMap.get(val);
                int new_dist = distance + weight;

                if(new_dist < neighbour_dist)
                {
                    distanceMap.put(val, new_dist);
                    pq.add(new CostNode(val, new_dist));
                    backrefs.put(val, vertex);
                }
            }
        }

        //backtracking on backrefs
        Integer curr = w;
        List<Integer> path = new ArrayList<>();
        while(curr != null)
        {
            path.add(curr);
            curr = backrefs.get(curr);
        }

        //print in reverse
        for(int i = path.size() - 1; i >= 0; i--)
        {
            System.out.print(path.get(i) + " ," );
        }
    }



    //modification of bfs
    public void shortestPath(int v, int w) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        HashMap<Integer, Integer> backref = new HashMap<>();
        backref.put(v, null);
        boolean destinationFound = false;

        while (!queue.isEmpty()) {
            Integer node = queue.remove();

            Map<Vertex, Integer> neighbors = adjacencyList.get(node).neighbors;
            for (Vertex neighbor : neighbors.keySet()) {
                if (!backref.containsKey(neighbor.val)) {
                    backref.put(neighbor.val, node);
                    queue.add(neighbor.val);

                    if (neighbor.val == w) {
                        destinationFound = true;
                        break;
                    }
                }
            }

            if (destinationFound)
                break;
        }

        Integer curr = w;
        List<Integer> path = new ArrayList<>();
        while (curr != null) {
            path.add(curr);
            curr = backref.get(curr);
        }

        //print in reverse
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ,");
        }
    }

    public void printAllPaths(int v, int w) {

        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int val : adjacencyList.keySet()) {
            visited.put(val, false);
        }

        List<Integer> path = new ArrayList<>();
        path.add(v);

        printAllPathsRecurse(v, w, path, visited);

    }

    private void printAllPathsRecurse(int v, int w, List<Integer> path, HashMap<Integer, Boolean> visited) {

        visited.put(v, true);

        if (v == w) {
            System.out.println(path);
        }

        Map<Vertex, Integer> neighbours = adjacencyList.get(v).neighbors;

        for (Vertex neighbor : neighbours.keySet()) {
            if (!visited.get(neighbor.val)) {
                path.add(neighbor.val);
                printAllPathsRecurse(neighbor.val, w, path, visited);
                path.remove(neighbor.val);
            }
        }

        visited.put(v, false);

    }

    enum status { UNVISITED, VISITING, VISITED };

    public boolean cycleExists(int v)
    {
        HashMap<Integer, status> visitStatus =  new HashMap<>();
        for(Vertex vertex : adjacencyList.values())
        {
            visitStatus.put(vertex.val, status.UNVISITED);
        }


        return cycleExistsRecurse(v, visitStatus);
    }

    private boolean cycleExistsRecurse(int v, HashMap<Integer, status> visitStatus) {
        if (visitStatus.get(v) == status.VISITING)
            return true;
        else {
            Map<Vertex, Integer> neighbours = adjacencyList.get(v).neighbors;
            for (Vertex neighbour : neighbours.keySet()) {
                {
                    visitStatus.put(v, status.VISITING);
                    if (visitStatus.get(neighbour) != status.VISITED) {
                        return cycleExistsRecurse(neighbour.val, visitStatus);
                    }
                }
            }
            visitStatus.put(v, status.VISITED);
            return false;
        }
    }


    public void dfs(int v) {

        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (Vertex vertex : adjacencyList.values()) {
            visited.put(vertex.val, false);
        }

        dfs(v, visited);
    }

    private void dfs(int v, HashMap<Integer, Boolean> visited) {
        System.out.print(v + " ");
        visited.put(v, true);

        Map<Vertex, Integer> neighbours = adjacencyList.get(v).neighbors;

        for (Vertex neighbour : neighbours.keySet()) {

            if (!visited.get(neighbour.val)) {
                dfs(neighbour.val, visited);
            }
        }
    }

    public void dfs2(GraphAdjList G)
    {
        HashSet<Vertex> visitedSet = new HashSet<>();
        for(Vertex vertex : G.adjacencyList.values())
        {
            if(!visitedSet.contains(vertex))
                _dfs2Recurse(vertex, visitedSet);
        }
    }

    private void _dfs2Recurse(Vertex vertex, HashSet<Vertex> visitedSet)
    {
        if(visitedSet.contains(vertex))
            return;

        System.out.print(vertex.val + " ");
        visitedSet.add(vertex);

        Set set = vertex.neighbors.keySet();
        for(Object neighbor : set)
        {
            Vertex v = (Vertex)neighbor;
            _dfs2Recurse(v, visitedSet);
        }
    }

    public void bfs(int v) {

        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (Vertex vertex : adjacencyList.values()) {
            visited.put(vertex.val, false);
        }

        bfs(v, visited);

    }

    private void bfs(int v, HashMap<Integer, Boolean> visited) {
        Queue<Integer> q = new ArrayDeque();

        q.add(v);

        while (!q.isEmpty()) {
            int vertex = q.remove();
            if (!visited.get(vertex)) {
                System.out.print(vertex + " ");
                visited.put(vertex, true);
            }

            Map<Vertex, Integer> neighbours = adjacencyList.get(vertex).neighbors;
            for (Vertex neighbour : neighbours.keySet()) {
                {
                    if (!visited.get(neighbour.val))
                        q.add(neighbour.val);
                }

            }
        }
    }
}
