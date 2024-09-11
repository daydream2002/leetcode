import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/9/4 20:21
 */
public class No274 {
    public static void main(String[] args) {
        int[] ints = {10};
        int i = new Solution274_1().hIndex(ints);
        System.out.println(i);
    }
}

//排序
class Solution274_1 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        for (int h = 1; h <= citations.length; h++) {
            if (citations[citations.length - h] >= h) {
                res = h;
            }
        }
        return res;
    }
}
//数组计数法

class Solution274_2 {
    public int hIndex(int[] citations) {
        int[] res = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > citations.length) {
                res[citations.length]++;
            } else {
                res[citations[i]]++;
            }
        }
        int count = 0;
        //i相当于h
        for (int i = res.length - 1; i >= 0; i--) {
            count = count + res[i];
            //count篇论文的应用数量大于h
            if (count >= i)
                return i;
        }
        return -1;
    }
}