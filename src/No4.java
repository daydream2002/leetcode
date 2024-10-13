/**
 * Author daydream
 * Description 寻找两个正序数组的中位数
 * Date 2024/10/11 10:03
 */
public class No4 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        double medianSortedArrays = new Solution4().findMedianSortedArrays(arr1, arr2);
        System.out.println(medianSortedArrays);
    }
}

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int l = length1 + length2;
        int mid = l / 2;
        double res;
        if (l % 2 == 0) {
            res = (getK(nums1, nums2, mid) + getK(nums1, nums2, mid + 1)) / 2.0;
        } else {
            res = getK(nums1, nums2, mid + 1);
        }
        return res;
    }

    int getK(int[] nums1, int[] nums2, int k) {
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 > nums1.length - 1)
                return nums2[index2 + k - 1];
            if (index2 > nums2.length - 1)
                return nums1[index1 + k - 1];
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int int1 = Math.min(index1 + k / 2 - 1, nums1.length - 1), int2 = Math.min(index2 + k / 2 - 1, nums2.length - 1);
            if (nums1[int1] < nums2[int2]) {
                k = k - (int1 - index1 + 1);
                index1 = int1 + 1;
            } else {
                k = k - (int2 - index2 + 1);
                index2 = int2 + 1;
            }
        }
    }
}