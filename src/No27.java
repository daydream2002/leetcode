/**
 * Author daydream
 * Description
 * Date 2024/10/14 21:05
 */
public class No27 {
    public static void main(String[] args) {
        int i = new Solution27One().removeElement(new int[]{4, 5}, 5);
        System.out.println(i);
    }
}

//先把元素置为-1,再对元素次序进行交换
class Solution27One {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length - 1, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = -1;
                count++;
            }
        }
        while (l < r) {
            if (nums[l] == -1) {
                while (nums[r] == -1 && r > 0)
                    r--;
                if (r == nums.length - count - 1)
                    return nums.length - count;
                swap(nums, l, r);
                l++;
                r--;
            } else {
                l++;
            }
        }
        return nums.length - count;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//双指针
class Solution27Two {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != val) {
                nums[l] = nums[r];
                l++;
                r++;
            } else
                r++;
        }
        return l;
    }
}
//双指针
class Solution27Three {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == val) {
                nums[l] = nums[r--];
            } else {
                l++;
            }
        }
        return l;
    }
}