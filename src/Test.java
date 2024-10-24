import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Author daydream
 * Description
 * Date 2024/10/15 20:40
 */
public class Test {
    public static void main(String[] args) {
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (hashMap.containsKey(target - num))
                return new int[]{i, hashMap.get(target - num)};
            hashMap.put(num, i);
        }
        return new int[]{0, 0};
    }
}