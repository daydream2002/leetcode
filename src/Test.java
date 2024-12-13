import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2024/10/15 20:40
 */
import java.util.*;

class Test {
    public static void main(String[] args) {
        int[][] array = {
                {0},
                {1}
        };
        int res = new Solution().uniquePathsWithObstacles(array);
        System.out.println(res);
    }
}

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            else
                dp[i] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[j] = 0;
                else if (j != 0)
                    dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }
}