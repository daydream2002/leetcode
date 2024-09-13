import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wjh
 * @date 2024/9/11 15:31
 */
public class No151 {
    public static void main(String[] args) {
        String theSkyIsBlue = new Solution151_3().reverseWords("the sky is blue");
        System.out.println(theSkyIsBlue);
    }
}

class Solution151 {
    public String reverseWords(String s) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                stringBuilder.append(c);
            } else {
                if (!stringBuilder.isEmpty()) {
                    list.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            }

        }
        if (!stringBuilder.isEmpty())
            list.add(stringBuilder.toString());
        return String.join(" ", list.reversed());
    }
}

//双指针
class Solution151_2 {
    public String reverseWords(String s) {
        int l = 0, r = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                r = i;
                for (int j = r; j >= 0; j--) {
                    if (s.charAt(j) == ' ') {
                        l = j;
                        break;
                    }
                    if (j == 0) {
                        l = -1;
                    }
                }
                i = l;
                stringBuilder.append(s, l + 1, r + 1).append(' ');
            }
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        return stringBuilder.toString();
    }
}

//利用语言特性
class Solution151_3 {
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        List<String> list = Arrays.asList(split);
        return String.join(" ", list.reversed());
    }
}