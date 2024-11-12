import java.util.ArrayList;
import java.util.List;

/**
 * Author daydream
 * Description
 * Date 2024/11/12 21:09
 */
public class No94 {
}

class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}