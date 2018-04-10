package self.learning.Trees;

import java.util.ArrayList;
import java.util.List;

public class TestMergeTrees {

    static TreeNode headmain;
    static TreeNode prev;

    public static TreeNode mergeTrees(TreeNode n1, TreeNode n2) {
        n1 = degenerate(n1, null);
        prev = null;
        n2 = degenerate(n2, null);
        merge(n1, n2);
        return balance(headmain);
    }

    static TreeNode degenerate(TreeNode root, TreeNode head)
    {
        if(root == null) return head;

        head = degenerate(root.left, head);
        if(prev == null){
            head = root;
        }else{
            prev.right = root;
        }
        prev = root;
        prev.left = null;
        head = degenerate(root.right, head);

        return head;
    }

    static void merge(TreeNode p1, TreeNode p2)
    {
        TreeNode current;

        if(p1.data < p2.data)
        {
            headmain = p1;
            p1 = p1.right;
        }
        else
        {
            headmain = p2;
            p2 = p2.right;
        }

        current = headmain;
        while(p1 != null && p2 != null)
        {
            if(p1.data < p2.data)
            {
                current.right = p1;
                p1 = p1.right;
            }
            else
            {
                current.right = p2;
                p2 = p2.right;
            }
            current = current.right;
        }
        if(p1 != null)
        {
            current.right = p1;
        }
        if(p2 != null)
        {
            current.right = p2;
        }
    }

    static TreeNode balance(TreeNode p)
    {
        TreeNode curret = p;
        List<Integer> list = new ArrayList<>();
        while(curret != null)
        {
            list.add(curret.data);
            curret = curret.right;
        }
        return balance(list, 0, list.size() - 1);
    }

    static TreeNode balance(List<Integer> list, int start, int end)
    {
        if(start > end)
            return null;

        int mid = start + (end - start) / 2;
        TreeNode leftChild = balance(list, start, mid -1 );
        TreeNode root = new TreeNode(list.get(mid));
        root.left = leftChild;
        TreeNode rightChild = balance(list, mid + 1, end);
        root.right = rightChild;
        return root;
    }
}
