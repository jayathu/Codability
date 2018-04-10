package self.learning.Trees;

public class BalancedBST {

    public static TreeNode build(int[] arr)
    {
        return build(arr, 0, arr.length - 1);
    }

    static TreeNode build(int[] arr, int beg, int end)
    {
        if(beg > end)
        {
            return null;
        }

        int mid = (beg + end) / 2;

        TreeNode root = new TreeNode(arr[mid]);
        root.left = build(arr, beg, mid-1);
        root.right = build(arr, mid + 1, end);

        return root;
    }
}
