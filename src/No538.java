/**
 * Author daydream
 * Description
 * Date 2024/11/22 21:26
 */
public class No538 {
    public static void main(String[] args) {
        TreeNode treeNode = new Solution538().convertBST(TreeNode.init(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8}));
        TreeNode.print(treeNode);
    }
}

class Solution538 {
    int count = 0;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
    void convert(TreeNode root) {
        if (root==null)
            return;
        convert(root.right);
        count = root.val + count;
        root.val = count;
        convert(root.left);
    }
}