import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author daydream
 * Description
 * Date 2024/11/12 21:00
 */
public class No144 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init(new Integer[]{1, null, 2, 3});
        List<Integer> integers = new Solution144One().preorderTraversal(root);
        System.out.println(integers);
    }
}

//递归
class Solution144One {
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

//迭代
class Solution144Two {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.right != null)
                stack.push(pop.right);
            if (pop.left != null)
                stack.push(pop.left);
        }
        return list;
    }
}