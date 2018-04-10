package self.learning.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class KAryTreeNode
{
    int val;
    KAryTreeNode[] children;

    KAryTreeNode(int v)
    {
        val = v;
    }

    void print()
    {
        List<Integer> values = new ArrayList<>();
        print(values);
    }

    private void print(List<Integer> values)
    {
        values.add(this.val);
        if(this.children == null)
        {
            for(Integer i : values)
            {
                System.out.print(i + "->");
            }
            System.out.println();
        }else {

            for (KAryTreeNode node : children) {
                node.print(values);
            }

        }
        values.remove(values.size()-1);
    }
}

public class HeightOfKAry {

    static int max = Integer.MIN_VALUE;

    public static void getHeight(KAryTreeNode root)
    {
        int n = getHeight(root, 0);
        System.out.println(n);
    }

    static int getHeight(KAryTreeNode root, int level)
    {
        if(root.children == null)
        {
            return level;

        }else{
            for(KAryTreeNode child: root.children)
            {
                level++;
                max = Math.max(max, getHeight(child, level));
                level--;
            }
        }
        return max;
    }

    public static KAryTreeNode buildKAryTree()
    {
        KAryTreeNode root = new KAryTreeNode(15);
        root.children = new KAryTreeNode[3];
        for(int i = 0; i < root.children.length; i++)
        {
            root.children[i] = new KAryTreeNode(i + 1);
        }

        root.children[0].children = new KAryTreeNode[2];
        root.children[0].children[0] = new KAryTreeNode(4);
        root.children[0].children[1] = new KAryTreeNode(5);

        root.children[0].children[1].children = new KAryTreeNode[1];
        root.children[0].children[1].children[0] = new KAryTreeNode(6);

        root.children[0].children[1].children[0].children = new KAryTreeNode[1];
        root.children[0].children[1].children[0].children[0] = new KAryTreeNode(9);

        root.children[1].children = new KAryTreeNode[1];
        root.children[1].children[0] = new KAryTreeNode(7);

        root.children[2].children = new KAryTreeNode[1];
        root.children[2].children[0] = new KAryTreeNode(8);

        root.print();
        return root;
    }
}
