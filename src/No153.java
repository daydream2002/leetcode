/**
 * @Author daydream
 * @Description
 * @Date 2024/7/23
 */
public class No153 {
    public static void main(String[] args) {
        Solution153 solution153 = new Solution153();
        int[] ints = {5, 1, 2, 3, 4};
        int min = solution153.findMin(ints);
        System.out.println("ans=" + min);
    }
}

class Solution153 {
    public int findMin(int[] nums) {
        //有序直接返回最小元素
        if (nums[nums.length - 1] >= nums[0])
            return nums[0];
        int i = 0, j = nums.length - 1, k = 0;
        while (i <= j) {
            k = (i + j + 1) / 2;
            if (nums[k - 1] > nums[k])
                break;
            //判断右边是否有序
            if (nums[nums.length - 1] >= nums[k]) {
                j = k - 1;
            } else {
                i = k + 1;
            }
        }
        return nums[k];
    }
}