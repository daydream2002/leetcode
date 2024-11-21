/**
 * Author daydream
 * Description
 * Date 2024/11/20 19:09
 */
public class No701 {
    public static void main(String[] args) {
        TreeNode treeNode = new Solution701Three().insertIntoBST(TreeNode.init(new Integer[]{40, 20, 60, 10, 30, 50, 70}), 25);
        TreeNode.print(treeNode);
    }
}

//递归
class Solution701One {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        insert(root, val);
        return root;
    }

    void insert(TreeNode root, int val) {
        if (root.left == null && val < root.val) {
            root.left = new TreeNode(val);
            return;
        }
        if (root.right == null && val > root.val) {
            root.right = new TreeNode(val);
            return;
        }
        if (val > root.val)
            insert(root.right, val);
        else
            insert(root.left, val);
    }
}

//递归，优化版
class Solution701Two {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val > root.val)
            root.right = insertIntoBST(root.right, val);
        else
            root.left = insertIntoBST(root.left, val);
        return root;
    }
}

//迭代
class Solution701Three {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (val > cur.val) {
                pre = cur;
                cur = cur.right;
            } else {
                pre = cur;
                cur = cur.left;
            }
        }
        TreeNode treeNode = new TreeNode(val);
        if (val > pre.val)
            pre.right = treeNode;
        else
            pre.left = treeNode;
        return root;
    }
}