package self.learning.Trees;

public class isBST {

    int index = 0;
    int visited = -1;

    public boolean isBST(TreeNode root, int size)
    {
        int[] array = new int[size];
        copyBST_Recurse(root, array);

        for(int i : array)
        {
            System.out.print(i + " ");
        }
        for(int i = 1; i < array.length; i++)
        {
            if(array[i] <= array[i-1]) {
                System.out.print("FALSE");
                return false;
            }
        }
        System.out.print("TRUE");
        return true;
    }
    void copyBST_Recurse(TreeNode root, int[] array)
    {
        if(root == null)
        {
            return;
        }
        copyBST_Recurse(root.left, array);
        array[index] = root.data;
        index++;
        copyBST_Recurse(root.right, array);
    }


    public boolean isBST_2(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        //is my left chile a BST?
        if(!isBST_2(root.left)) return false;
        if(root.data < visited)
        {
            return false;
        }
        visited = root.data;
        if(!isBST_2(root.right)) return false;

        return true;

    }

    public boolean isBST_3(TreeNode root, Integer min, Integer max)
    {
        if(root == null)
            return true;

        if(!isBST_3(root.left, min, root.data)) return false;

        if((min != null && root.data < min) || (max != null && root.data > max))
        {
            return false;
        }
       // visited = root.data;
        if(!isBST_3(root.right, root.data, max)) return false;

        return true;

    }
}
