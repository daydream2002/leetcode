import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author daydream
 * @Date 2024/7/5
 */
public class No78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution_78 solution78 = new Solution_78();
        List<List<Integer>> subsets = solution78.subsets(nums);
        System.out.println(subsets);


//        solution78.subsets(new int[]{1, 2});
    }
}

class Solution_78 {

    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        int max = (int) (Math.pow(2, length) - 1);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            int[] binary = getBinary(i, length);
            ArrayList<Integer> integers = new ArrayList<>();
            for (int j = 0; j < binary.length; j++) {
                if (binary[j] == 1)
                    integers.add(nums[j]);
            }
            ans.add(integers);
        }
        return ans;
    }

    int[] getBinary(int number, int length) {
        int[] ints = new int[length];
        String binaryString = Integer.toBinaryString(number);
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            ints[i + length - binaryString.length()] = binaryString.charAt(i) - '0';
        }
        return ints;
    }
}