import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2024/11/19 22:13
 */
public class No501 {
}

class Solution501 {
    int max = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        inOrder(root, map);
        ArrayList<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max)
                res.add(entry.getKey());
        }
        int[] ints = new int[res.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i]= res.get(i);
        }
        return ints;
    }

    void inOrder(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null)
            return;
        inOrder(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        max = Math.max(map.get(root.val), max);
        inOrder(root.right, map);
    }
}