package self.learning.Graphs;

import java.util.*;

class Vertex<T>
{
    Integer val;
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
        Map<Vertex, Integer> neighborsOfv1 = vertex1.neighbors;
        Map<Vertex, Integer> neighborsOfv2 = vertex2.neighbors;

        neighborsOfv1.put(vertex2, 1);
        neighborsOfv2.put(vertex1, 1);

    }

    public void printGraph()
    {
        for(Integer key : adjacencyList.keySet())
        {

            System.out.print(key + " - ");
            Vertex v = adjacencyList.get(key);

            Set<Map.Entry> entries = v.neighbors.entrySet();
            for(Map.Entry<Vertex, Integer> entry : entries)
            {
                System.out.print(entry.getKey().val + "," + entry.getValue());
            }
            System.out.println();
        }

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

                int val;
                val = neighbour.getKey().val;
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

    //its a DFS traversal - BFS don't make sense!
    public void printAllPaths(int v, int w) {

        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        path.add(v);
        printAllPathsRecurse(v, w, path, visited);

    }

    private void printAllPathsRecurse(int v, int w, List<Integer> path, Set<Integer> visited) {

        if (v == w) {
            System.out.println(path);
        }
        visited.add(v);
        Collection<Vertex> neighbors = adjacencyList.get(v).neighbors.keySet();

        for (Vertex neighbor : neighbors) {
            if (!visited.contains(neighbor.val)) {
                path.add(neighbor.val);
                printAllPathsRecurse(neighbor.val, w, path, visited);
                path.remove(neighbor.val);
            }
        }
        visited.remove(v);
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
        visitStatus.put(v, status.VISITING);
        Map<Vertex, Integer> neighbours = adjacencyList.get(v).neighbors;
        for (Vertex neighbour : neighbours.keySet()) {
            {
                if (visitStatus.get(neighbour) != status.VISITED) {
                    return cycleExistsRecurse(neighbour.val, visitStatus);
                }
            }
        }
        visitStatus.put(v, status.VISITED);
        return false;
    }

    public void TopologicalSort(List<Integer> listOfVertices)
    {
        Set<Integer> visited = new HashSet<>();
        List<Integer> sortedList = new ArrayList<>();
        for(Integer i : listOfVertices)
        {
            //sortedSet.add(i);
            Vertex v = adjacencyList.get(i);
            topoligicalRecurse(v, visited, sortedList);
        }

        //print sortedSet in reverse order;

        Collections.reverse(sortedList);
        for(Integer i : sortedList)
        {
            System.out.print(i + " ");
        }
    }

    private void topoligicalRecurse(Vertex v,  Set<Integer> visited, List<Integer> sortedList)
    {
        if(visited.contains(v.val))
            return;

        Collection<Vertex> neighbors = v.neighbors.keySet();
        if(neighbors == null || neighbors.isEmpty())
        {
            visited.add(v.val);
            sortedList.add(v.val);
            return;
        }

        for(Vertex n : neighbors)
        {
            topoligicalRecurse(n, visited, sortedList);
        }

        visited.add(v.val);
        sortedList.add(v.val);
    }


    public void cloneGraphMain(int v)
    {
        HashMap<Integer, Vertex> cloneMap = new HashMap<>();

        for(Vertex vertex : adjacencyList.values()) {
            System.out.print(vertex.val + ":");
            Collection<Vertex> neighbors = vertex.neighbors.keySet();
            for (Vertex neighbor : neighbors) {
                System.out.print(neighbor.val + ",");
            }
            System.out.println();
        }

        cloneGraph(adjacencyList.get(v), cloneMap);

        for(Vertex vertex : cloneMap.values()) {
            System.out.print(vertex.val + ":");
            Collection<Vertex> neighbors = vertex.neighbors.keySet();
            for (Vertex neighbor : neighbors) {
                System.out.print(neighbor.val + ",");
            }
            System.out.println();
        }
    }
    private Vertex cloneGraph(Vertex v, HashMap<Integer, Vertex> cloneMap)
    {
        if(cloneMap.containsValue(v))
            return v;

        Vertex clone = new Vertex(v.val);
        cloneMap.put(v.val, clone);
        Collection<Vertex> neighbors = adjacencyList.get(v.val).neighbors.keySet();
        for(Vertex n : neighbors)
        {
            clone.neighbors.put(cloneGraph(n, cloneMap), 1);
        }


        return clone;
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

        Set<Integer> visited = new HashSet<>();
        bfs(v, visited);

    }

    private void bfs(int v, Set<Integer> visited) {
        Queue<Integer> q = new ArrayDeque();

        q.add(v);

        while (!q.isEmpty()) {
            int vertex = q.remove();
            if(visited.contains(vertex))
                continue;

            System.out.print(vertex + " ");
            visited.add(vertex);

            Map<Vertex, Integer> neighbours = adjacencyList.get(vertex).neighbors;
            for (Vertex neighbour : neighbours.keySet()) {
                    if (!visited.contains(neighbour.val))
                        q.add(neighbour.val);
            }
        }
    }
}
