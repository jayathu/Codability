package self.learning.Graphs;

import com.sun.corba.se.impl.orbutil.graph.Graph;

public class GraphSolution {

    public static void BuildGraph()
    {
        GraphAdjList G = new GraphAdjList(new int[]{1,2,3,4,5,6,7});

        G.addEdge(1,2);
        G.addEdge(1,3);
        G.addEdge(2,4);
        //G.addEdge(3,4);
        G.addEdge(3,6);
        G.addEdge(4,5);
        G.addEdge(4,6);
        G.addEdge(5,7);
        G.addEdge(6,7);


        //G.dfs2(G);
        //G.dfs(1);
//        System.out.println();
//        G.bfs(1);
//        System.out.println();
//        G.printAllPaths(2,3);
//
//        G.shortestPath(2,3);


        GraphAdjList DAG = new GraphAdjList(new int[]{1,2,3,4,5,6});
        DAG.addEdge(1,2,2);
        DAG.addEdge(1,3,13);
        DAG.addEdge(2,4,16);
        DAG.addEdge(2,5,3);
        DAG.addEdge(3,2,1);
        DAG.addEdge(3,5,8);
        DAG.addEdge(4,5,11);
        DAG.addEdge(4,6,21);
        DAG.addEdge(5,6,1);

        //DAG.printAllPaths(1,6);

        //DAG.dijkstraShortestPath(1,6);

        int[][] grid = new int[][]{

                {0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0}
        };

        //IslandProblem.CountIslands(grid);

//        int val = KnightsTour.find_minimum_number_of_moves(2,2,1,1, 1, 1);
//        System.out.println("Number of jumps: " + val);

        //String[] words = new String[]{"cccw", "accc", "accw"};

        //WordLadder.string_transformation(words, "cccc", "cccc");

        //String[] words = new String[]{"baa", "abcd", "abca", "cab", "cad"};

        //AlienDictionary.find_order(words);

        //TransposeGraph.BuildAndRun();

        //SnakesAndLadder.BuildGameBoard();

        NearestGuard.BuildNearestGuard();

        /*
        * baa
abcd
abca
cab
cad*/

        GraphAdjList G1 = new GraphAdjList(new int[]{1,2,3,4,5});

//        G1.addEdge(1,3,1);
//        G1.addEdge(3,4,1);
//        G1.addEdge(4,2,1);
//        G1.addEdge(1,2,1);
//        G1.addEdge(2,5,1);
//        G1.addEdge(5,4,1);
//
//        System.out.println("Cycle Exists = " + G1.cycleExists(1));
        //G1.dfs(1);
    }
}

//               1
//             /   \
//            /     \
//           /       \
//          2         3
//           \       /
//            \     /
//             \   /
//               4
//             /   \
//            /     \
//           /       \
//          5         6
//           \       /
//            \     /
//             \   /
//               7