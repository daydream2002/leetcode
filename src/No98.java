/**
 * Author daydream
 * Description
 * Date 2024/11/19 21:26
 */
public class No98 {
    public static void main(String[] args) {
        boolean validBST = new Solution98().isValidBST(TreeNode.init(new Integer[]{2,2,2}));
        System.out.println(validBST);
    }
}

class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean valid(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        return valid(root.right, root.val, max) && valid(root.left, min, root.val);
    }
}