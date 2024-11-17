import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author daydream
 * Description
 * Date 2024/11/12 21:09
 */
public class No94 {
}

//递归
class Solution94One {
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

//非递归
class Solution94Two {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                cur = pop.right;
            }
        }
        return list;
    }
}