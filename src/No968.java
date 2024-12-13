/**
 * Author daydream
 * Description
 * Date 2024/12/12 17:39
 */
public class No968 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init(new Integer[]{1, 2, 3, null, null, null, 4});
        int i = new Solution968().minCameraCover(root);
        System.out.println(i);
    }
}

class Solution968 {
    int count = 0;

    public int minCameraCover(TreeNode root) {
        int dfs = dfs(root);
        if (dfs == 0)
            count++;
        return count;
    }

    //2代表放监控,1代表被监控，0表示没有被监控也没有放监控
    int dfs(TreeNode root) {
        if (root == null)
            return 1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0) {
            count++;
            return 2;
        }
        else if (left == 1 && right == 1)
            return 0;
        else {
            return 1;
        }
    }
}