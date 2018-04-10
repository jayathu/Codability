package self.learning.Trees;

import java.util.Stack;

public class TreeTraversal {

    static public void PrintUnivalCount(TreeNode root, int val)
    {
        CountUnival(root);
        System.out.println(sum);
    }
    static int sum = 0;

    static boolean CountUnival(TreeNode root)
    {
        if(root == null)
            return true;

        //a leaf will always be a unival tree. So count it!
        if(root.left == null && root.right == null)
        {
            sum += 1;
            return true;
        }
        boolean left = CountUnival(root.left);
        boolean right = CountUnival(root.right);

        //either left or right returned false at some point. So no point inspecting anything above them
        if(left != right) {
            return false;
        }
        else if(left == true) //this means both left and right returned true => so far the've been maintaining unival properties.
            //so now, we need to check if they continue to maintain this property along with the root.
            //They would, only if they all share the same value!
        {
            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;
            //a leaf node always maintains unival property. That's what I'm checking here
            if(leftNode != null && rightNode != null)
            {
                if(root.data == root.left.data && root.data == root.right.data)
                {
                    sum += 1;
                    return true;
                }
            }
            else if(leftNode != null)
            {
                if(root.data == leftNode.data)
                {
                    sum += 1;
                    return true;
                }
            }else if(rightNode != null)
            {
                if(root.data == rightNode.data)
                {
                    sum += 1;
                    return true;
                }
            }

        }
        return false;
    }

    static TreeNode Tree2List(TreeNode root)
    {
        if(root == null)
        {
            return null;
        }
        TreeNode leftList = Tree2List(root.left);
        TreeNode rightList = Tree2List(root.right);

        root.left = root;
        root.right = root;

        leftList = append(leftList, root);
        leftList = append(leftList, rightList);
        return leftList;
    }

    public static void PrintTree2List(TreeNode root)
    {
        TreeNode head = Tree2List(root);
        TreeNode current = head;
        while(true)
        {
            System.out.print(current.data + " ");
            current = current.right;
            if(current == head)
                break;
        }
    }

    static TreeNode append(TreeNode a, TreeNode b)
    {
        if(a == null) return b;
        if(b == null) return a;

        TreeNode aLast = a.left;
        TreeNode bLast = b.left;

        join(aLast, b);
        join(bLast, a);

        return a;
    }

    static void join(TreeNode a, TreeNode b)
    {
        a.right = b;
        b.left = a;
    }

    public static void PrintAllPaths(TreeNode root)
    {
        int height = root.height();
        int[] arr = new int[height];
        PrintPaths(root, 0, arr);
    }

    static void PrintPaths(TreeNode root, int i, int[] arr)
    {
        if(root == null) {
            return;
        }

        arr[i] = root.data;
        if(root.left == null && root.right == null)
        {
            for(int j = 0; j <= i; j++)
            {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
            return;
        }

        PrintPaths(root.left, i + 1, arr);
        PrintPaths(root.right, i + 1, arr);
    }

    public static void PostOrderIterative(TreeNode root)
    {
        Stack s = new Stack();
        while(root != null)
        {
            if(root.right != null)
            {
                s.push(root.right);
            }
            s.push(root);
            root = root.left;
        }

        while(!s.empty())
        {
            TreeNode node1 = (TreeNode)s.pop();
            if(node1.right != null && !s.empty() && node1.right == s.peek())
            {
                root = (TreeNode)s.pop();
                s.push(node1);
            }
            else{
                System.out.print(node1.data + " ");
            }
            while(root != null)
            {
                if(root.right != null)
                {
                    s.push(root.right);
                }
                s.push(root);
                root = root.left;
            }

        }
    }
}
