import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Author daydream
 * Description
 * Date 2024/11/17 19:43
 */
public class No257 {
    public static void main(String[] args) {
        new Solution257().binaryTreePaths(TreeNode.init(new Integer[]{1, 2, 3, null, 5}));
    }
}

class Solution257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<List<TreeNode>> resList = new ArrayList<>();
        dfs(root, new ArrayList<>(), resList);
        ArrayList<String> res = new ArrayList<>();
        for (List<TreeNode> treeNodes : resList) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < treeNodes.size(); i++) {
                sb.append(treeNodes.get(i).val);
                if (i != treeNodes.size() - 1)
                    sb.append("->");
            }
            res.add(sb.toString());
        }
        return res;
    }

    void dfs(TreeNode root, List<TreeNode> list, List<List<TreeNode>> resList) {
        if (root == null) {
            return;
        }
        list.add(root);
        if (root.left == null && root.right == null)
            resList.add(list);
        dfs(root.left, new ArrayList<>(list), resList);
        dfs(root.right, new ArrayList<>(list), resList);
    }
}