package self.learning.Trees;



public class UpsideDownTree {

    static TreeNode prev;
    public static TreeNode head;

    //upside down flip
    public static TreeNode flip(TreeNode node)
    {
        if(node != null) {
            flip(node.left);
            if (prev == null) {
                head = node;
            } else {
                prev.right = node;
                prev.left = node.right;
            }
            prev = node;
            node.left = null;
            node.right = null;
        }
        return head;

    }

    //upside down flip - i think this is much more readable
    public static TreeNode flip2(TreeNode node)
    {
        if(node == null)
            return node;

        if(node.left == null && node.right == null) {

            return node;
        }

        TreeNode head = flip2(node.left);

        node.left.left = node.right;
        node.left.right = node;
        node.left = null;
        node.right = null;

        return head;

    }

    /*Node newRoot = FlipTree(root.Left);

    root.Left.Left = root.Right;
    root.Left.Right = root;
    root.Left = NULL;
    root.Right = NULL;
    * */

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
