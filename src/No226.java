/**
 * Author daydream
 * Description
 * Date 2024/11/17 14:53
 */
public class No226 {
    public static void main(String[] args) {
        TreeNode treeNode = new Solution226Two().invertTree(TreeNode.init(new Integer[]{4, 2, 7, 1, 3, 6, 9}));
        System.out.println(treeNode);
    }
}

class Solution226One {
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    void reverse(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        reverse(root.left);
        reverse(root.right);
    }
}

class Solution226Two {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}