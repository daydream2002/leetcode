import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Author daydream
 * Description
 * Date 2024/11/19 17:05
 */
public class No654 {
    public static void main(String[] args) {
        TreeNode root = new Solution654().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        TreeNode.print(root);
    }
}

class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[maxIndex] < nums[i])
                maxIndex = i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        if (nums.length == 1)
            return root;
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
        return root;
    }
}