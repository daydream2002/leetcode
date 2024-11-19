/**
 * Author daydream
 * Description
 * Date 2024/11/18 15:24
 */
public class No100 {
}

class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (!(p != null && q != null) || p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}