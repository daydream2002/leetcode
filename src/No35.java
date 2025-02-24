/**
 * Author daydream
 * Description
 * Date 2025/2/16 13:07
 */
public class No35 {
    public static void main(String[] args) {
        int i = new Solution35().searchInsert(new int[]{1, 3, 5, 6}, 2);
        System.out.println(i);
    }
}

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] > target)
                r = mid - 1;
            else if (nums[mid] < target) {
                l = mid + 1;
            } else return mid;
        }
        return l;
    }
}