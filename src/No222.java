import java.util.LinkedList;
import java.util.Queue;

/**
 * Author daydream
 * Description
 * Date 2024/11/17 19:12
 */
public class No222 {
}

class Solution222One {
    int count = 0;

    public int countNodes(TreeNode root) {
        dfs(root);
        return count;
    }

    void dfs(TreeNode root) {
        if (root == null)
            return;
        count++;
        dfs(root.left);
        dfs(root.right);
    }
}

class Solution222Two {
    public int countNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            count = count + size;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null)
                    queue.offer(poll.left);
                if (poll.right != null)
                    queue.offer(poll.right);
            }
        }
        return count;
    }
}