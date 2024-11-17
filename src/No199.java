import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author daydream
 * Description
 * Date 2024/11/14 15:34
 */
public class No199 {
}

class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode poll = null;
            for (int i = 0; i < size; i++) {
                poll = queue.poll();
                if (poll.left != null)
                    queue.offer(poll.left);
                if (poll.right != null)
                    queue.offer(poll.right);

            }
            res.add(poll.val);
        }
        return res;
    }
}