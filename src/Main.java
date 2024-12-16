import com.sun.source.tree.WhileLoopTree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String str = sc.nextLine();
        str=sc.nextLine();
        HashSet<Character> set = new HashSet<>();
        int[] map = new int[26];
        for (int length = str.length()-1; length >= 0; length--) {
            if (map[str.charAt(length)-'a'] == 0)
                map[str.charAt(length)-'a'] = length;
        }
        int left = 0;
        int res = Integer.MIN_VALUE;
        int i = 0;
        while (i < str.length()) {
            set.add(str.charAt(i));
            if (set.size() == 4) {
                res = Math.max(res, i - left);
                int temp = str.length();
                char stemp = 0;
                for (Character c : set) {
                    if (map[c - 'a'] < temp) {
                        temp = map[c - 'a'];
                        stemp = c;
                    }
                }
                set.remove(stemp);
                left = temp+1;
            }
            i++;
        }
        res = Math.max(res, str.length()-1 - left);
        System.out.println(res);
    }
}