package self.learning.Trees;

public class KthSmallest {

    static int i = 0;

    public static void get(TreeNode root, int k)
    {
        if(root == null)
        {
            return;
        }
        get(root.left, k);
        if(k != i)
        {
            i++;
            if(k == i) {
                System.out.print(root.data + " ");
            }
            else {
                get(root.right, k);
            }
        }

    }

    static int secondLargest = 0;
    public static int findSecondLargest(TreeNode root)
    {
        if(root.right != null) {
            return findSecondLargest(root.right);
        }
        return root.data;
    }

}

