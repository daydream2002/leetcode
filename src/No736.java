import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Author daydream
 * Description
 * Date 2024/12/11 14:32
 */
public class No736 {
    public static void main(String[] args) {
        new Solution736().partitionLabels("ababcbacadefegdehijhklij");
    }
}

class Solution736 {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            map[charArray[i] - 'a'] = i;
        }
        int index = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            if (i > index) {
                index = map[charArray[i] - 'a'];
                list.add(i);
            } else
                index = Math.max(map[charArray[i] - 'a'], index);
        }
        list.add(s.length());
        for (int i = list.size() - 1; i >= 1; i--) {
            list.set(i, list.get(i) - list.get(i - 1));
        }
        return list;
    }
}