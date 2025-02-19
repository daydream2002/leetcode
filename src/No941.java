/**
 * Author daydream
 * Description
 * Date 2025/2/15 15:49
 */
public class No941 {
    public static void main(String[] args) {
        Solution941 solution941 = new Solution941();
        boolean b = solution941.validMountainArray(new int[]{0, 2, 3, 4, 5, 2, 1, 0});
        System.out.println(b);
    }
}

class Solution941 {
    public boolean validMountainArray(int[] arr) {
        if (arr.length <= 2)
            return false;
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[i + 1])
                left++;
            else
                break;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i - 1] > arr[i])
                right--;
            else
                break;
        }
        return left == right&&left!=0&&right!=arr.length-1;
    }
}