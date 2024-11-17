import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author daydream
 * Description
 * Date 2024/11/14 15:38
 */
public class No637 {
}

//bfs,广度优先遍历
class Solution637One {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Double d = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                d = d + poll.val;
                if (poll.left != null)
                    queue.offer(poll.left);
                if (poll.right != null)
                    queue.offer(poll.right);
            }
            list.add(d / size);
        }
        return list;
    }
}

//dfs,深度优先遍历
class Solution637Two {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Double> count = new ArrayList<>();
        dfs(root.right, 0, num, count);
        for (int i = 0; i < num.size(); i++) {
            count.set(i, count.get(i) / num.get(i));
        }
        return count;
    }

    void dfs(TreeNode root, int depth, ArrayList<Integer> num, ArrayList<Double> count) {
        if (root == null)
            return;
        if (num.size() < depth) {
            num.add(1);
            count.add(root.val+0.0);
        } else {
            num.set(depth, num.get(depth) + 1);
            count.set(depth, count.get(depth) + root.val);
        }
        dfs(root.left, depth + 1, num, count);
        dfs(root.right, depth + 1, num, count);
    }
}