import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author daydream
 * Description
 * Date 2024/11/12 21:07
 */
public class No145 {
}

class Solution145One {
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

class Solution145Two {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.left != null)
                stack.push(pop.left);
            if (pop.right != null)
                stack.push(pop.right);
            list.add(pop.val);
        }
        return list.reversed();
    }
}