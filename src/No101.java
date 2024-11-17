/**
 * Author daydream
 * Description
 * Date 2024/11/17 18:52
 */
public class No101 {
    public static void main(String[] args) {
        boolean symmetric = new Solution101().isSymmetric(TreeNode.init(new Integer[]{1,2,2,null,3,null,3}));
        System.out.println(symmetric);
    }
}

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return fun(root.left, root.right);
    }

    boolean fun(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if ((left == null && right != null) || (left != null && right == null) || left.val != right.val)
            return false;
        boolean l = fun(left.left, right.right);
        boolean r = fun(left.right, right.left);
        return l & r;
    }
}