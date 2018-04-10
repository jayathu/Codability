package self.learning.Graphs;


import java.util.*;


class Node
{
    Integer val;
    Vector<Node> neighbours = new Vector<Node>(0);

    Node(Integer _val)
    {
        val = _val;
        neighbours.clear();
    }
}
public class TransposeGraph {

    static Node build_other_graph(Node node)
    {
        HashSet<Integer> visited = new HashSet<>();

        return buildRecurse(node, visited);
    }

    static Node buildRecurse(Node node, HashSet<Integer> visited)
    {
        if(visited.contains(node.val))
            return node;

        for(Node neighbor : node.neighbours)
        {
            if(!visited.contains(neighbor))
            {
                buildRecurse(neighbor, visited);
            }
            visited.add(node.val);

            neighbor.neighbours.add(node);
            node.neighbours.remove(neighbor);
        }

        return node;
    }

    static void BuildAndRun()
    {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node.neighbours.add(node2);
        node2.neighbours.add(node3);
        node3.neighbours.add(node);

        Node res = build_other_graph(node);

        System.out.println("Done");
    }
}
