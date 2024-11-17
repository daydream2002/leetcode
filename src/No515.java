import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2024/11/17 10:11
 */
public class No515 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init(new Integer[]{1, 3, 2, 5, 3, null, 9});
        List<Integer> list = new Solution515Two().largestValues(root);
        System.out.println(list);
    }
}

//bfs广度优先遍历
class Solution515One {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int Max = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                if (pop.val > Max)
                    Max = pop.val;
                if (pop.left != null)
                    queue.offer(pop.left);
                if (pop.right != null)
                    queue.offer(pop.right);
            }
            res.add(Max);
        }
        return res;
    }
}

//dfs深度优先遍历
class Solution515Two {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null)
            return;
        if (res.size() <= depth)
            res.add(root.val);
        else {
            if (res.get(depth) < root.val)
                res.set(depth, root.val);
        }
        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
    }
}