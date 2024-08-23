import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author daydream
 * Description
 * Date 2024/8/23
 */
public class No136 {
    public static void main(String[] args) {
        int i = new Solution136().singleNumber(new int[]{2, 2, 1});
        System.out.println(i);
    }
}

//使用hashmap空间复杂度o(n)
class Solution136 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i]))
                hashMap.remove(nums[i]);
            else
                hashMap.put(nums[i], 1);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = hashMap.entrySet();
        Integer res = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : entrySet) {
            res = integerIntegerEntry.getKey();
            System.out.println(res);
        }
        return res;
    }
}

//异或运算
class Solution136_2 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}