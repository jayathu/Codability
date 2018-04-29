package self.learning.Graphs;

import java.util.*;

public class LongestPathDAG {

    /*
    	For the weighted graph:
    	1. The number of nodes is <name>_nodes.
    	2. The number of edges is <name>_edges.
    	3. An edge exists between <name>_from[i] to <name>_to[i] and the weight of the edge is <name>_weight[i].
    */

    static class Vertex
    {
        Integer val;
        Map<Vertex, Integer> neighbors;

        Vertex(int v)
        {
            val = v;
            neighbors = new HashMap<>();
        }
    }

    static class Node
    {
        Integer from;
        int weight;

        Node(Integer from, int weight)
        {
            this.from = from;
            this.weight = weight;
        }
    }

    static void BuildDAG()
    {
//        int[] dag_from   = new int[]{1,1,1,3};
//        int[] dag_to     = new int[]{2,3,4,4};
//        int[] dag_weight = new int[]{2,2,4,3};

//        int[] dag_from   = new int[]{1,1,2,3,4,4,5,6};
//        int[] dag_to     = new int[]{2,3,4,4,5,6,7,7};
//        int[] dag_weight = new int[]{1,3,5,2,2,4,3,0};

        int[] dag_from   = new int[]{5,4,3,2,5,5,3};
        int[] dag_to     = new int[]{4,3,2,1,1,3,1};
        int[] dag_weight = new int[]{1,1,1,1,3,3,1};

        find_longest_path(7, dag_from, dag_to, dag_weight, 5, 1);

    }
    static void find_longest_path(int dag_nodes, int[] dag_from, int[] dag_to, int[] dag_weight, int from_node, int to_node)
    {

        HashMap<Integer, Vertex> graph = new HashMap<>();

        for(int i = 0; i < dag_nodes; i++)
        {
            Vertex v = graph.get(dag_from[i]);

            if(v == null)
            {
                v = new Vertex(dag_from[i]);
            }

            if(dag_to != null && i < dag_to.length) {
                v.neighbors.put(new Vertex(dag_to[i]), dag_weight[i]);
                graph.put(dag_from[i], v);

                if (!graph.containsKey(dag_to[i])) {
                    graph.put(dag_to[i], new Vertex(dag_to[i]));
                }
            }
            else
            {
                graph.put(dag_from[i], v);
            }

        }

        for(Integer key : graph.keySet())
        {
            System.out.print(key + " - ");
            Vertex v = graph.get(key);
            for(Map.Entry<Vertex, Integer> entry : v.neighbors.entrySet())
            {
                System.out.print("(" + entry.getKey().val + ":" + entry.getValue() + ")  ");
            }
            System.out.println();
        }

        HashMap<Integer, Node> backRefs = new HashMap<>();
        for(Integer val : graph.keySet())
        {
            backRefs.put(val, new Node(null, 0));
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(from_node);
        HashSet<Integer> exhausted = new HashSet<>();

        while(!queue.isEmpty())
        {
            Integer node = queue.remove();

            Map<Vertex, Integer> neighbors = graph.get(node).neighbors;

            for(Vertex neighbor : neighbors.keySet())
            {
                if(neighbor.val != to_node && !exhausted.contains(neighbor.val))
                {
                    queue.add(neighbor.val);
                }

                //update their weights

                int currentWeight = backRefs.get(neighbor.val).weight;
                int newWeight = backRefs.get(node).weight + graph.get(node).neighbors.get(neighbor);

                if(newWeight > currentWeight)
                {
                    Node n = backRefs.get(neighbor.val);
                    if(n == null) {
                        backRefs.put(neighbor.val, new Node(node, newWeight));
                    }
                    else{
                        n.from = node;
                        n.weight = newWeight;
                        backRefs.put(neighbor.val, n);
                    }
                }
            }

            exhausted.add(node);
        }

        ArrayList<Integer> result = new ArrayList<>();
        System.out.println("Longest Distance = " + backRefs.get(to_node).weight + "\n");

        Integer curr = to_node;

        while(curr != from_node)
        {
            result.add(curr);
            Node node = backRefs.get(curr);
            curr = node.from;
        }

        result.add(from_node);


        int[] arr = new int[result.size()];

        for(int i = result.size() - 1; i >= 0; i--)
        {
            int index = result.size() - i - 1;
            arr[index] = result.get(i);
            System.out.print(arr[index] + " ");
        }



    }
}
