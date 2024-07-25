import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @Author daydream
 * @Description
 * @Date 2024/7/25
 */
public class No394 {
    public static void main(String[] args) {
        Solution394 solution394 = new Solution394();
        String s = solution394.decodeString("3[a]");
        System.out.println(s);
    }

}

class Solution394 {
    public String decodeString(String s) {
        Deque<Integer> num = new ArrayDeque<>();
        Deque<String> str = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if ('0' <= c && c <= '9') {
                int index = i;
                while (true) {
                    index = index + 1;
                    if ('0' > charArray[index] || '9' < charArray[index])
                        break;
                }
                num.push(Integer.valueOf(s.substring(i, index)));
                i = index-1;
            } else {
                str.push(String.valueOf(c));
                if (c == ']') {
                    str.pop();
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String pop = str.pop();
                        if (pop.equals("["))
                            break;
                        sb.insert(0, pop);
                    }
                    int repeat = num.pop();
                    String string = sb.toString();
                    for (int j = 0; j < repeat - 1; j++) {
                        sb.append(string);
                    }
                    str.push(sb.toString());
                }
            }
        }
        while (!str.isEmpty()) {
            stringBuilder.insert(0, str.pop());
        }
        return stringBuilder.toString();
    }
}