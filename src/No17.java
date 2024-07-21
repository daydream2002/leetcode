import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wjh
 * @date 2024/7/6 下午8:50
 */
public class No17 {
    public static void main(String[] args) {
        String digits = "234";
        Solution_17 solution17 = new Solution_17();
        List<String> strings = solution17.letterCombinations(digits);
        System.out.println(strings);
    }
}

class Solution_17 {
    HashMap<Character, String> map = new HashMap<>();

    Solution_17() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<String>();
        List<String> res = new ArrayList<>();
        String ans = "";
        fun(digits, 0, ans, res);
        return res;
    }

    void fun(String digits, int index, String ans, List<String> res) {
        if (ans.length() == digits.length()) {
            res.add(ans);
            return;
        }
        String s = map.get(digits.charAt(index));
        for (int j = 0; j < s.length(); j++) {
            fun(digits, index + 1, ans+ s.charAt(j), res);
        }
    }
}