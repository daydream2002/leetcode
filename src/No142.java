import java.util.ArrayList;
import java.util.Collections;

/**
 * Author daydream
 * Description
 * Date 2024/10/9 20:08
 */
public class No142 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};
        int res = new Solution142().maxPathSum(TreeNode.init(arr));
        System.out.println(res);
    }
}

class Solution142 {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        preOrder(root);
        return res;
    }

    int preOrder(TreeNode root) {
        if (root == null)
            return 0;
        int left = preOrder(root.left);
        int right = preOrder(root.right);
        //把根节点的左右边路径加上根节点
        res = Math.max(res, Math.max(left, 0) + Math.max(right, 0) + root.val);
        //返回值为根节点加上左节点或者右节点总的值，保证树不会分叉
        return Math.max(Math.max(left, 0), Math.max(right, 0)) + root.val;
    }
}


