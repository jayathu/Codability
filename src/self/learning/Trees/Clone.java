package self.learning.Trees;

public class Clone {

    public static TreeNode clone(TreeNode root)
    {
        if(root == null)
        {
            return root;
        }
        TreeNode cRoot = new TreeNode(root.data);
        cRoot.left = clone(root.left);
        cRoot.right = clone(root.right);
        return cRoot;
    }

    public static TreeNode flip(TreeNode root)
    {
        if(root == null)
        {
            return root;
        }

        TreeNode leftTree = root.left;
        root.left = root.right;
        root.right = leftTree;

        flip(root.left);
        flip(root.right);

        return root;
    }
}
