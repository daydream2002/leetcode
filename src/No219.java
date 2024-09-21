import java.util.HashMap;

/**
 * @author wjh
 * @date 2024/9/21 15:00
 */
public class No219 {
    public static void main(String[] args) {
        boolean b = new Solution219().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 2);
        System.out.println(b);
    }
}

class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], i);
            else {
                if (i - map.get(nums[i]) <= k)
                    return true;
                else
                    map.put(nums[i], i);
            }
        }
        return false;
    }
}