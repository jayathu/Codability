package self.learning.Trees;

public class BuildTree {

    public static void WithPreAndInOrder()
    {
        int[] preOrder = new int[]{10,20,18,15,30,2};
        int[] inOrder = new int[]{18,20,15,10,30,2};

        TreeNode root = WithPreAndInOrderRecurse(preOrder, 0, preOrder.length - 1,
                                                inOrder, 0, inOrder.length - 1);

        root.print();

    }

    static TreeNode WithPreAndInOrderRecurse(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd)
    {
        if(inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preOrder[preStart]);

        int rootIndex = 0;
        for(int i = inStart; i <= inEnd; i++)
        {
            if(inOrder[i] == root.data)
            {
                rootIndex = i;
                break;
            }
        }

        int len = rootIndex - inStart;
        root.left = WithPreAndInOrderRecurse(preOrder, preStart + 1, preStart + len,
                                            inOrder, inStart, rootIndex - 1);
        root.right = WithPreAndInOrderRecurse(preOrder, preStart + len + 1, preEnd,
                                                inOrder, rootIndex + 1, inEnd);

        return root;
    }
}
