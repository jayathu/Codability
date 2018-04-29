package self.learning.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergeTrees {

    public TreeNode headmain;
    private TreeNode prev;

    public void mergeBST(TreeNode p1, TreeNode p2)
    {
        //p1 = degenerate(p1, null);
        //p2 = degenerate(p2, null);

        p1.print();
        p2.print();

        prev = null;
        p1 = degenerate(p1,null);
        //p1.print();

        prev = null;
        p2 = degenerate(p2,null);
        //p2.print();

        merge(p1,p2);
        //PrintTree();

        TreeNode n = balance(headmain);
        n.print();
    }


    TreeNode degenerate(TreeNode root, TreeNode head)
    {
        if(root == null)
            return head;
        head = degenerate(root.left, head);
        if(prev == null) {
            head = root;
        }else{
            prev.right = root;
        }
        prev = root;
        prev.left = null;
        head = degenerate(root.right, head);
        return head;
    }

//    TreeNode degenerateWithStack(TreeNode root)
//    {
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode head = null;
//        TreeNode curr = null;
//        while(root != null) {
//            stack.push(root);
//            root = root.left;
//        }
//
//        while(!stack.isEmpty())
//        {
//            TreeNode n = stack.pop();
//            if(head == null)
//            {
//                head = n;
//            }
//            else{
//
//            }
//            if(n.right != null)
//            {
//                stack.push(n.right);
//            }
//
//            while(n.left != null)
//            {
//
//            }
//        }
//    }

    void PrintTree()
    {
        TreeNode current = headmain;
        while(current != null)
        {
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    void merge(TreeNode p1, TreeNode p2)
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

    TreeNode balance(TreeNode p)
    {
        //int size = 0;
        TreeNode curret = p;
        List<Integer> list = new ArrayList<>();
        while(curret != null)
        {

            list.add(curret.data);
            curret = curret.right;
            //size++;
        }

        return balance(list, 0, list.size()-1);
    }

    TreeNode balance(List<Integer> list, int start, int end)
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
//    TreeNode balance(TreeNode p, int beg, int end)
//    {
//        if(beg > end)
//            return null;
//        int mid = beg + (end - beg)/2;
//        TreeNode left = balance(p, beg, mid - 1);
//        TreeNode parent = p;
//        p.left = left;
//        p = p.right;
//        parent.right = balance(p, mid+1, end);
//        return parent;
//
//    }


}
