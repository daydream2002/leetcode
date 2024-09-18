import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/9/18 15:34
 */
public class No167 {
    public static void main(String[] args) {
        int[] res = new Solution167().twoSum(new int[]{2, 3, 4}, 6);
        System.out.println(Arrays.toString(res));
    }
}

//双指针
class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (numbers[i] + numbers[j] != target) {
            int sum = numbers[i] + numbers[j];
            if (sum < target)
                i++;
            else if (sum > target)
                j--;
        }
        return new int[]{i + 1, j + 1};
    }
}