import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2024/10/15 20:40
 */
import java.util.*;

class Test {
    public static void main(String[] args) {
        int[] gas = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};
        int i = new Solution().canCompleteCircuit(gas, cost);
        System.out.println(i);
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasCount = 0;
        int minGas = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            gasCount = gasCount + gas[i] - cost[i];
            minGas = Math.min(minGas, gasCount);
        }
        if (minGas >= 0)
            return 0;
        if (gasCount < 0)
            return -1;
        for (int i = 1; i < gas.length; i++) {
            gasCount = 0;
            for (int j = i; j < i + gas.length; j++) {
                gasCount = gasCount + gas[j % gas.length] - cost[j % gas.length];
                if (gasCount < 0) {
                    i = j;
                    break;
                } else if (j == i + gas.length - 1)
                    return i;
            }
        }
        return -1;
    }
}