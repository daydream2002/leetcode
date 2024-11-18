import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/11/18 21:50
 */
public class No105 {
    public static void main(String[] args) {

        int[] inorder = {3, 9, 20, 15, 7};
        int[] postorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = new Solution105().buildTree(inorder, postorder);
        TreeNode.print(treeNode);
    }
}

class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl > pr)
            return null;
        TreeNode root = new TreeNode(preorder[pl]);
        if (pl == pr)
            return root;
        int inorderIndex = 0;
        for (int i = il; i <= ir; i++) {
            if (inorder[i] == preorder[pl]) {
                inorderIndex = i;
            }
        }
        root.left = build(preorder, pl + 1, pl + inorderIndex - il, inorder, il, inorderIndex - 1);
        root.right = build(preorder, pl + inorderIndex - il + 1, pr, inorder, inorderIndex + 1, inorder.length - 1);
        return root;
    }
}