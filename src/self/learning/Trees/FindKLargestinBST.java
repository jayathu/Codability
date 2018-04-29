package self.learning.Trees;
import java.util.*;

public class FindKLargestinBST {

    public static void find(TreeNode root, int k)
    {
        List<Integer> kLargestElements = new ArrayList<>();
        findHelper(root, k, kLargestElements);

        //return kLargestElements.toArray(new int[kLargestElements.size()]);

        System.out.println(k + " largest elements are: \n");
        for(int ele : kLargestElements)
        {
            System.out.print(ele + " ");
        }
    }

    private static void findHelper(TreeNode root, int k, List<Integer> list)
    {
        if(root == null || list.size() == k)
            return;

        findHelper(root.right, k, list);

        if(list.size() < k) {
            list.add(root.data);
            findHelper(root.left, k, list);
        }
    }
}
