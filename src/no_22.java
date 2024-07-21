import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author daydream
 * @Description
 * @Date 2024/7/16
 */
public class no_22 {
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        List<String> strings = solution22.generateParenthesis(3);
        System.out.println(strings);
    }
}
//解法一动态规划法
class Solution22 {
    public List<String> generateParenthesis(int n) {
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        arrayList.add(new ArrayList<>());
        arrayList.add(new ArrayList<>(List.of("()")));
        for (int i = 2; i <= n; i++) {
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                ArrayList<String> list1 = arrayList.get(j);
                ArrayList<String> list2 = arrayList.get(i - j - 1);
                for (String s1 : list1) {
                    for (String s2 : list2) {
                        list.add("(" + s1 + ")" + s2);
                    }
                }
                if (j == 0) {
                    for (String s2 : list2) {
                        list.add("(" + ")" + s2);
                    }
                }
                if (j == i - 1) {
                    for (String s1 : list1) {
                        list.add("(" + s1 + ")");
                    }
                }
            }
            arrayList.add(list);
        }
        return arrayList.getLast();
    }
}