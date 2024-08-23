import java.util.HashMap;
import java.util.Map;

/**
 * Author daydream
 * Description
 * Date 2024/8/23
 */
public class No169 {
    public static void main(String[] args) {
        int i = new Solution168_2().majorityElement(new int[]{6, 5, 5});
        System.out.println(i);
    }
}

//使用hashmap
class Solution168 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (!hashMap.containsKey(num))
                hashMap.put(num, 1);
            else
                hashMap.put(num, hashMap.get(num) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() >= (nums.length + 1) / 2)
                return entry.getKey();
        }
        return -1;
    }
}

//摩尔投票
class Solution168_2 {
    public int majorityElement(int[] nums) {
        int count_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == count_num)
                count++;
            else {
                count--;
                if (count == 0) {
                    count_num = nums[i];
                    count = 1;
                }
            }
        }
        return count_num;
    }
}