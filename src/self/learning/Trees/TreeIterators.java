package self.learning.Trees;

import java.util.Stack;

public class TreeIterators {

    Stack<TreeNode> s;

    public TreeIterators(TreeNode root)
    {
        s = new Stack();
        pushAll(root);
    }

    public boolean hasNext()
    {
        return !s.isEmpty();
    }

    public TreeNode next()
    {
        if(hasNext())
        {
            TreeNode node = s.pop();
            pushAll(node.right);
            return node;
        }
        return null;
    }

    void pushAll(TreeNode root)
    {
        for(; root != null; root = root.left)
        {
            s.push(root);
        }
    }


}
