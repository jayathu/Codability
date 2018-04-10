package self.learning.Trees;

class EvalNode
{
    boolean isBST;
    int min;
    int max;
    int size;

    EvalNode()
    {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        size = 0;
        isBST = false;
    }
}
public class LargestBST {

    public static int find(TreeNode root)
    {
        return findRecurse(root).size;
    }

    static EvalNode findRecurse(TreeNode root)
    {
        EvalNode evalNode = new EvalNode();

        if(root == null)
        {
            evalNode.isBST = true;
            return evalNode;
        }

        EvalNode left = findRecurse(root.left);
        EvalNode right = findRecurse(root.right);
        evalNode.min = Math.min(left.min, root.data);
        evalNode.max = Math.max(right.max, root.data);

        if(left.isBST && right.isBST  && left.max <= root.data && right.min >= root.data)
        {
            evalNode.size = left.size + right.size + 1;
            evalNode.isBST = true;
        }
        else
        {
            evalNode.isBST = false;
            evalNode.size = Math.max(left.size, right.size);
        }

        return evalNode;
    }

}
