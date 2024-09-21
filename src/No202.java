import java.util.HashSet;

/**
 * @author wjh
 * @date 2024/9/21 11:07
 */
public class No202 {
    public static void main(String[] args) {
        boolean happy = new Solution202().isHappy(2);
        System.out.println(happy);
    }
}

class Solution202 {
    public boolean isHappy(int n) {
        String string = Integer.toString(n);
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        do {
            set.add(count);
            count = 0;
            for (int i = 0; i < string.length(); i++) {
                int num = string.charAt(i) - '0';
                count += num * num;
            }
            string = Integer.toString(count);
            if (count == 1)
                return true;
        } while (!set.contains(count));
        return false;
    }
}