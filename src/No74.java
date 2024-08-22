/**
 * @author wjh
 * @date 2024/7/21 下午7:37
 */
public class No74 {
    public static void main(String[] args) {
        Solution74 solution74 = new Solution74();
        int[][] matrix = {
                {1}
        };
        boolean i = solution74.searchMatrix(matrix, 2);
        System.out.println(i);
    }

}

class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] ints = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            ints[i] = matrix[i][0];
        }
        int i = binarySearch(ints, target);
        if (i < matrix.length && ints[i] == target)
            return true;
        else {
            if (i == 0)
                return false;
            int j = binarySearch(matrix[i - 1], target);
            if (matrix[i - 1].length > j && matrix[i - 1][j] == target)
                return true;
        }
        return false;
    }

    int binarySearch(int[] matrix, int target) {
        int length = matrix.length;
        int i = 0, j = length - 1, k = length / 2;
        while (i <= j) {
            if (target == matrix[k])
                return k;
            if (target > matrix[k])
                i = k + 1;
            if (target < matrix[k])
                j = k - 1;
            k = (i + j) / 2;
        }
        return i;
    }
}
