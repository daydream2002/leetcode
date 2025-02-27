public class No463 {
}

class Solution463 {
    public int islandPerimeter(int[][] grid) {
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1)
                    for (int k = 0; k < 4; k++) {
                        int x = i + direction[k][0];
                        int y = i + direction[k][1];
                        if (x < 0 || y < 0 || x == grid.length || y == grid.length || grid[x][y] == 0)
                            res++;
                    }
            }
        }
        return res;
    }
}