package self.learning.Trees;

import java.util.*;

public class SuccessorinBST {

    private HashMap<Integer, TreeNode> map;

    public SuccessorinBST(TreeNode root)
    {
        map = new HashMap<>();
        mapNodes(root);
    }

    public TreeNode getNode(int val)
    {
        return map.get(val);
    }

    private void mapNodes(TreeNode node)
    {
        if(node == null)
            return;

        map.put(node.data, node);
        mapNodes(node.left);
        mapNodes(node.right);

    }

    public TreeNode FindSuccessor(TreeNode root, TreeNode node)
    {
       TreeNode current = root;
       TreeNode successor = root;
       while(current != null)
       {
           if(current.data > node.data)
           {
               successor = current;
               current = current.left;
           }else{
               current = current.right;
           }
       }

       return successor;
    }

}
