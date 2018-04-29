package self.learning.Trees;
import java.util.*;

public class BuildTree {

    public static TreeNode WithPostAndInOrder()
    {
        //int[] inOrder = new int[]{2,5,6,7,8,9,12,1,2,11,14,13};
        int[] inOrder = new int[]{18,20,15,10,30,2};
        //int[] postOrder = new int[]{14,13,1,2,9,12,11,6,7,2,5,8};

        int[] postOrder = new int[]{2,30,15,18,20,10};


        HashMap<Integer, Integer> inOrderMap = BuildMapOfInOrder(inOrder);

        return WithPostAndInOrderRecurse(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1, inOrderMap);

    }

    private static TreeNode WithPostAndInOrderRecurse(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd, HashMap<Integer, Integer> map)
    {
        if(inStart > inEnd || postStart > postEnd)
            return null;

        TreeNode root = new TreeNode(postOrder[postEnd]);

        int index = 0;
        for(int i = inStart; i <= inEnd; i++)
        {
            if(inOrder[i] == root.data)
            {
                index = i;
                break;
            }
        }

        //int index = map.get(postOrder[postEnd]);
        int len = index - inStart;

        root.left = WithPostAndInOrderRecurse(inOrder, inStart, index - 1, postOrder, postEnd - len, postEnd - 1, map);
        root.right = WithPostAndInOrderRecurse(inOrder, index + 1, inEnd, postOrder, postStart, postEnd - len - 1, map);
        return root;
    }

    private static HashMap<Integer, Integer> BuildMapOfInOrder(int[] inOrder)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inOrder.length; i++)
        {
            map.put(inOrder[i], i);
        }

        return map;
    }
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
