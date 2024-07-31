import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Author daydream
 * @Description
 * @Date 2024/7/31
 */
public class No215 {
    public static void main(String[] args) {
        Solution215_2 solution215 = new Solution215_2();
        int[] a = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kthLargest = solution215.findKthLargest(a, 4);
        System.out.println(Arrays.toString(a));
        System.out.println(kthLargest);
    }
}

//利用已有的堆
class Solution215_1 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            heap.add(num);
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = heap.poll();
        }
        return ans;
    }
}
//快排算法
class Solution215_2 {
    public int findKthLargest(int[] nums, int k) {
        qSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    void qSort(int[] nums, int i, int j) {
        if (i < j) {
            int k = partition(nums, i, j);
            qSort(nums, i, k - 1);
            qSort(nums, k + 1, j);
        }
    }

    int partition(int[] nums, int i, int j) {
        Random random = new Random();
        int p = random.nextInt(j - i + 1) + i;
        int temp = nums[p];
        nums[p] = nums[i];
        nums[i] = temp;
        int pivot = nums[i];
        while (i < j) {
            while (nums[j] >= pivot && i < j)
                j--;
            nums[i] = nums[j];
            while (nums[i] <= pivot && i < j)
                i++;
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }

}