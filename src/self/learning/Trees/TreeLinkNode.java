package self.learning.Trees;

public class TreeLinkNode {

    int data;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode sibling;

    TreeLinkNode(int val)
    {
        data = val;
        left = right = sibling = null;
    }

    public TreeLinkNode(TreeNode treeNode)
    {
        data = treeNode.data;
        if(treeNode.left != null)
        {
            left = new TreeLinkNode(treeNode.left);
        }
        if(treeNode.right != null)
        {
            right = new TreeLinkNode(treeNode.right);
        }
        sibling = null;
    }

    public void print()
    {
        printRecurse(this);
    }

    void printRecurse(TreeLinkNode root)
    {
        if(root != null)
        {
            System.out.print(root.data + " ");
            printRecurse(root.left);
            printRecurse(root.right);
        }
        return;
    }

    public void linkSiblings()
    {
        TreeLinkNode current = this;
        TreeLinkNode levelHead = new TreeLinkNode(0);

        while(current != null)
        {
            TreeLinkNode needle = levelHead;

            while(current != null)
            {
                if(current.left != null)
                {
                    needle.sibling = current.left;
                    needle = needle.sibling;
                }
                if(current.right != null)
                {
                    needle.sibling = current.right;
                    needle = needle.sibling;
                }
                current = current.sibling;
            }

            current = levelHead.sibling;
            levelHead.sibling = null;
        }

    }

    public static void printSiblings(TreeLinkNode root)
    {
        while(root != null)
        {
            TreeLinkNode head = root;
            while(head != null)
            {
                System.out.print(head.data + "->");
                head = head.sibling;
            }
            root = root.left;
            System.out.println();
        }

    }

}


