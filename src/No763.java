import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author daydream
 * @Description
 * @Date 2024/8/6
 */

public class No763 {
    public static void main(String[] args) {
        String s = "qiejxqfnqceocmy";
        Solution763_2 solution763 = new Solution763_2();
        List<Integer> res = solution763.partitionLabels(s);
        System.out.println(res);
    }
}

class Solution763 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> partitionLabels(String s) {
        char[] charArray = s.toCharArray();
        int num = 0;
        while (true) {
            if (res.isEmpty()) {
                num = fun(charArray, num);
                System.out.println(num);
                if (num == charArray.length - 1)
                    return res;
            } else {
                num = fun(charArray, num + 1);
                System.out.println(num);
                if (num == charArray.length - 1)
                    return res;
            }
        }
    }

    int fun(char[] charArray, int left) {
        HashSet<Character> hashSet = new HashSet<>();
        int right = 0;
        for (int i = left; i < charArray.length; i++) {
            if (charArray[i] == charArray[left]) {
                right = i;
            }
        }
        while (true) {
            int lastIndex = 0;
            for (int i = left; i <= right; i++) {
                hashSet.add(charArray[i]);
            }
            for (int i = left; i < charArray.length; i++) {
                if (hashSet.contains(charArray[i])) {
                    lastIndex = i;
                }
            }
            if (lastIndex == right)
                break;
            else
                right = lastIndex;
        }
        if (res.isEmpty()) {
            res.add(right + 1);
        } else {
            res.add(right - left + 1);
        }
        return right;
    }
}

//使用字典保存每个字母的最后出现位置
class Solution763_2 {
    public List<Integer> partitionLabels(String s) {
        char[] charArray = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        int[] lastIndex = new int[26];
        for (int i = 0; i < charArray.length; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }
        int left = 0, right = 0;
        for (int i = 0; i < charArray.length; i++) {
            right = Math.max(right, lastIndex[charArray[i] - 'a']);
            if (i == right) {
                res.add(right - left + 1);
                left = right + 1;
            }
        }
        return res;
    }
}