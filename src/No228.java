import java.util.ArrayList;
import java.util.List;

/**
 * @author wjh
 * @date 2024/9/22 19:00
 */
public class No228 {
    public static void main(String[] args) {
        List<String> strings = new Solution228().summaryRanges(new int[]{1, 3});
    }
}

class Solution228 {
    public List<String> summaryRanges(int[] nums) {

        int l = 0, r = 0;
        ArrayList<String> list = new ArrayList<>();
        if (nums.length == 0)
            return list;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                r = i;
            } else {
                if (l == r) {
                    list.add(nums[r] + "");
                    l = l + 1;
                    r = l;
                } else {
                    list.add(nums[l] + "->" + nums[r]);
                    r = i;
                    l = i;
                }
            }
        }
        if (l == r)
            list.add(nums[r] + "");
        else
            list.add(nums[l] + "->" + nums[r]);
        System.out.println(list);
        return list;
    }
}