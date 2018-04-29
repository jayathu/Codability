package self.learning.Trees;

public class TreeReconstruction {

    /*

    This is from Elements of Programming Interviews p-140
    It's a variant of Build Tree using InOrder and PreOrder Traversal Results
    Let A be an array of n distinct integers. Let the index of the maximum element of A be m.
    Define the MAX-TREE of A to be the binary tree on the entries of A in which:
     - the root contains the maximum element of A,
     - the child is the MAX-TREE on A[0, m-1] and
     - the right child is the MAX-TREE on A[m+1, n-1].

    Design an O(n) algorithm for building the max-tree of A

    */

    public static TreeNode BuildMaxTree(int[] arr)
    {
        return BuildMaxTreeRecursive(arr, 0, arr.length - 1);
    }

    static TreeNode BuildMaxTreeRecursive(int[] arr, int start, int end)
    {
        if(start > end)
            return null;

        int index = getMaxIndex(arr, start, end);
        TreeNode root = new TreeNode(arr[index]);
        root.left = BuildMaxTreeRecursive(arr, start, index-1);
        root.right = BuildMaxTreeRecursive(arr, index+1, end);

        return root;

    }

    static int getMaxIndex(int[] arr, int start, int end)
    {
        int maxIndex = start;

        for(int i = start; i <= end; i++)
        {
            if(arr[i] > arr[maxIndex])
                maxIndex = i;
        }

        return maxIndex;
    }


}
