import java.util.ArrayList;
import java.util.List;

public class No129 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init(new Integer[]{4, 9, 0, 5, 1});
        int i = new Solution129Two().sumNumbers(root);
        System.out.println(i);
    }
}

class Solution129One {
    List<Integer> list = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        dfs(root, "");
        int res = 0;
        for (Integer i : list) {
            res = i + res;
        }
        return res;
    }

    void dfs(TreeNode root, String path) {
        if (root == null)
            return;
        path = path + root.val;
        if (root.left == null && root.right == null) {
            list.add(Integer.parseInt(path));
        } else {
            dfs(root.left, path);
            dfs(root.right, path);
        }
    }
}

class Solution129Two {
    StringBuilder sb = new StringBuilder();
    int res = 0;

    public int sumNumbers(TreeNode root) {
        backtrack(root);
        return res;
    }

    void backtrack(TreeNode root) {
        if (root == null)
            return;
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res += Integer.parseInt(sb.toString());
        } else {
            backtrack(root.left);
            backtrack(root.right);
        }
        sb.delete(sb.length() - 1, sb.length());
    }
}