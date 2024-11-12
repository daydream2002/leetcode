import java.util.ArrayList;
import java.util.List;

/**
 * Author daydream
 * Description
 * Date 2024/11/12 21:00
 */
public class No144 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init(new Integer[]{1, null, 2, 3});
        List<Integer> integers = new Solution144().preorderTraversal(root);
        System.out.println(integers);
    }
}

class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    void preorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}