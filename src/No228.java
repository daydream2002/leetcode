import java.util.List;

/**
 * @author wjh
 * @date 2024/9/22 19:00
 */
public class No228 {
}

class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        int l = 0, r = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1)
                r = r + 1;
            else{

            }
        }
    }
}