import java.lang.constant.PackageDesc;
import java.text.ListFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wjh
 * @date 2024/7/21 下午4:36
 */
public class No131 {
    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
        System.out.println(solution131.partition("aab"));
    }
}

class Solution131 {
    List<List<String>> res = new ArrayList<>();
    List<String> huiWen = new ArrayList<>();

    public List<List<String>> partition(String s) {
        ArrayList<String> strings = new ArrayList<>();
        fun(s, strings);
        return res;
    }

    void fun(String s, List<String> partition) {
        if (Objects.equals(s, "")) {
            res.add(new ArrayList<>(partition));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String substring = s.substring(0, i);
            if (isHuiWen(substring)) {
                partition.add(substring);
                fun(s.substring(i), partition);
                partition.removeLast();
            }
        }

    }

    boolean isHuiWen(String s) {
        if (huiWen.contains(s))
            return true;
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length / 2; i++) {
            if (charArray[i] != charArray[length - i - 1])
                return false;
        }
        huiWen.add(s);
        return true;
    }
}