package self.learning.Pramp;


import javax.lang.model.type.PrimitiveType;
import java.util.ArrayList;
import java.util.List;

public class SalesPath {

    private static class Node
    {
        int key;
        Node[] children;

        public Node(int cost)
        {
            this.key = cost;
            children = null;
        }

        public Node(int cost, int[] childrenCost)
        {
            this.key = cost;
            AddChildren(childrenCost);
        }

        public void AddChildren(int[] childrenCost)
        {
            this.children = new Node[childrenCost.length];
            for(int i = 0; i < childrenCost.length; i++)
            {
                children[i] = new Node(childrenCost[i]);
            }
        }
    }

    static void PrintPaths(Node root, List<Integer> values)
    {
        values.add(root.key);
        if(root.children == null)
        {
            for(Integer value : values)
            {
                System.out.print(value + " , ");
            }
            System.out.println();
        }
        else
        {
            for(Node child : root.children)
            {
                PrintPaths(child, values);
            }
        }
        values.remove(values.size() - 1);
    }

    static int cheapestCost(Node root)
    {
        return cheapestCostRecurse(root, 0);
    }

    static int minCost = Integer.MAX_VALUE;

    static int cheapestCostRecurse(Node root, int cost)
    {
        if(root.children == null)
        {
            minCost = Math.min(minCost, cost + root.key);
            return minCost;
        }

        else {
            for (int i = 0; i < root.children.length; i++) {
                cheapestCostRecurse(root.children[i], cost + root.key);
            }
        }

        return minCost;

    }

    static int cheapestCost2(Node root)
    {
        int min = Integer.MAX_VALUE;

        if(root == null)
            return 0;

        if(root.children == null)
        {
            return root.key;
        }
        else
            {
            for (Node child : root.children) {
                min = Math.min(min, root.key + cheapestCost2(child));
            }
        }
        return min;
    }


    public static void MakeSalesPathAndPrintCheapestCost()
    {

//        Node root = new Node(0);
//        Node c1 = new Node(1);
//        Node c2 = new Node(3);
//        Node c3 = new Node(5);
//
//        root.children = new Node[]{c1, c2, c3};
//
//        Node c11 = new Node(10);
//        c1.children = new Node[]{c11};
//
//        Node c111 = new Node(-10);
//        Node c112 = new Node(0);
//        c11.children = new Node[]{c111, c112};
//
//        Node c21 = new Node(2);
//        c2.children = new Node[]{c21};
//
//        Node c31 = new Node(3);
//        c3.children = new Node[]{c31};


        Node root = new Node(0, new int[]{1,3,5});

        root.children[0].AddChildren(new int[]{4});

        root.children[1].AddChildren(new int[]{2,0});
        root.children[1].children[0].AddChildren(new int[]{1});
        root.children[1].children[0].children[0].AddChildren(new int[]{8});

        root.children[1].children[1].AddChildren(new int[]{10});

        root.children[2].AddChildren(new int[]{1,5});

        System.out.println("Cheapest Cost = " + cheapestCost(root) + "\n");

        System.out.println("Cheapest Cost 2 = " + cheapestCost2(root) + "\n");

        PrintPaths(root, new ArrayList<>());

    }
}
