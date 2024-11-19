/**
 * Author daydream
 * Description
 * Date 2024/11/19 21:20
 */
public class No700 {
    public static void main(String[] args) {

    }
}

class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        else if (root.val < val)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);
    }
}