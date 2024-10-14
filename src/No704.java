/**
 * Author daydream
 * Description
 * Date 2024/10/14 20:47
 */
public class No704 {
    public static void main(String[] args) {
        int search = new Solution704().search(new int[]{2}, 2);
        System.out.println(search);
    }
}

class Solution704 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int k = l + (r - l) / 2;
            if (nums[k] == target)
                return k;
            if (nums[k] < target)
                l = k + 1;
            else
                r = k - 1;
        }
        return -1;
    }
}