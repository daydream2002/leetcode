import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author daydream
 * Description
 * Date 2024/11/18 15:54
 */
public class No513 {
    public static void main(String[] args) {
        int bottomLeftValue = new Solution513Two().findBottomLeftValue(TreeNode.init(new Integer[]{2, 1, 3}));
        System.out.println(bottomLeftValue);
    }
}

//bfs
class Solution513One {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0)
                    res = poll.val;
                if (poll.left != null)
                    queue.offer(poll.left);
                if (poll.right != null)
                    queue.offer(poll.right);
            }
        }
        return res;
    }
}

//dfs
class Solution513Two {
    public int findBottomLeftValue(TreeNode root) {
        int[] res = new int[2];
        dfs(root, 1, res);
        return res[1];
    }

    void dfs(TreeNode root, int depth, int[] res) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (depth > res[0]) {
                res[0] = depth;
                res[1] = root.val;
            }
        }
        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
    }
}