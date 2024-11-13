import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2024/11/9 09:39
 */
public class No239 {
    public static void main(String[] args) {
        int[] ints = new Solution239Two().maxSlidingWindow(new int[]{1, -1, 0, 0}, 3);
        System.out.println(Arrays.toString(ints));
    }
}

//优先队列
class Solution239One {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < k; i++) {
            queue.add(new int[]{i, nums[i]});
            if (max < nums[i])
                max = nums[i];
        }
        res[index++] = queue.peek()[1];
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{i, nums[i]});
            //如果当前最大值不在滑动窗口内则移除
            while (queue.peek()[0] <= i - k)
                queue.poll();
            res[index++] = queue.peek()[1];
        }
        return res;
    }
}

//单调队列
class Solution239Two {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
        }
        res[index++] = nums[deque.getFirst()];
        //核心思想，把无效数去掉，加入最新的入队元素，并保证当前所有的有效元素为降序排列
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            res[index++] = nums[deque.getFirst()];
        }
        return res;
    }
}
