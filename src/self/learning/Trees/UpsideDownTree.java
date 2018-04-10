package self.learning.Trees;



public class UpsideDownTree {

    static TreeNode prev;
    public static TreeNode head;

    public static TreeNode flip(TreeNode node)
    {
        if(node == null)
            return head;

        flip(node.left);
        if(prev == null)
        {
            head = node;
        }
        else{
            prev.right = node;
            prev.left = node.right;
        }
        prev = node;
        node.left = null;
        node.right = null;
        return head;

    }

    public static TreeNode FlipTree (TreeNode root )
    {
        if (root == null)
            return null;

        // Working base condition
        if( root.left == null && root.right == null)
        {
            return root.left;
        }

        TreeNode newRoot = FlipTree(root.left);

        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;

        return newRoot;
    }
}
