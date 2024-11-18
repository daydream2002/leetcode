import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/11/18 21:25
 */
public class No106 {
    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder  = {9,15,7,20,3};
        TreeNode treeNode = new Solution106().buildTree(inorder, postorder);
        TreeNode.print(treeNode);
    }
}

class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        int nodeVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(nodeVal);
        if (inorder.length == 1)
            return root;
        int[] inorderLeft = new int[0];
        int[] inorderRight = new int[0];
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == nodeVal) {
                inorderLeft = Arrays.copyOfRange(inorder, 0, i);
                inorderRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
            }
        }
        int[] postorderLeft = Arrays.copyOfRange(postorder, 0, inorderLeft.length);
        int[] postorderRight = Arrays.copyOfRange(postorder, inorderLeft.length, postorder.length - 1);
        root.left = buildTree(inorderLeft, postorderLeft);
        root.right = buildTree(inorderRight, postorderRight);
        return root;
    }
}