/**
 * Author daydream
 * Description
 * Date 2024/11/22 14:36
 */
public class No538 {
    public static void main(String[] args) {
        TreeNode treeNode = new Solution538().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        TreeNode.print(treeNode);
    }
}

class Solution538 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return insert(nums, 0, nums.length);
    }

    TreeNode insert(int[] nums, int l, int r) {
        if (l >= r)
            return null;
        int mid = (l + r ) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = insert(nums, l, mid);
        root.right = insert(nums, mid + 1, r);
        return root;
    }
}