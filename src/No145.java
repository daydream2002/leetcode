import java.util.ArrayList;
import java.util.List;

/**
 * Author daydream
 * Description
 * Date 2024/11/12 21:07
 */
public class No145 {
}

class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    void postorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }
}