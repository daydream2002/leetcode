import java.util.Arrays;
import java.util.HashMap;

public class No1365 {
    public static void main(String[] args) {
        Solution1365 solution = new Solution1365();
        int[] nums = {8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(nums)));
    }

}

class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums.length];
        int[] array = Arrays.copyOf(nums, nums.length);
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i]))
                map.put(array[i], i);
        }
        for (int i = 0; i < array.length; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }
}