/**
 * Author daydream
 * Description
 * Date 2024/9/6 16:28
 */
public class No134 {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int i = new Solution134().canCompleteCircuit(gas, cost);
        System.out.println(i);
    }
}

class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length, i = 0, gasCount, costCount;
        while (i < length) {
            int count = 0;
            gasCount = 0;
            costCount = 0;
            while (count < length) {
                int j = (i + count) % length;
                gasCount += gas[j];
                costCount += cost[j];
                if (gasCount < costCount)
                    break;
                count++;
            }
            if (count == length) {
                return i;
            } else {
                i = i + count + 1;
            }
        }
        return -1;
    }
}