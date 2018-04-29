package self.learning.Trees;

public class LCAInBST {

    //this assumes that both nodes are present in the tree!

    public static TreeNode find(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null)
            return null;

        if(p.data < q.data)
            return finDRecurse(root, p, q);
        else
            return finDRecurse(root, q, p);

    }

    private static TreeNode finDRecurse(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null ||root == p || root == q)
            return root;

        while(root.data < p.data && root.data < q.data)
            root = root.right;

        while(root.data > p.data && root.data > q.data)
            root = root.left;

        return root;
    }
}
