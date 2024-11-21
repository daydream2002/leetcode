/**
 * Author daydream
 * Description
 * Date 2024/11/21 22:15
 */
public class No450 {
    public static void main(String[] args) {
        TreeNode treeNode = new Solution450().deleteNode(TreeNode.init(new Integer[]{5, 3, 6, 2, 4, null, 7}), 3);
        TreeNode.print(treeNode);
    }
}

/*
 * 共三种情况：
 * 1.有左子树没有右子树，左子树替代目标节点
 * 2.有右子树没有左子树，右子树替代目标节点
 * 3.左右子树都存在，左子树放在右子树的最左节点,右子树替代原目标*/
class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key)
            if (root.left == null && root.right == null)
                root = null;
            else if (root.left == null)
                root = root.right;
            else if (root.right == null)
                root = root.left;
            else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root.left = null;
                root = root.right;
            }
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);
        return root;
    }
}