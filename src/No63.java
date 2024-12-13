/**
 * Author daydream
 * Description
 * Date 2024/12/13 17:29
 */
public class No63 {
}

//dp动态规划
class Solution63One {
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
                else
                    dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }
}
//空间优化版的dp
class Solution63Two {
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