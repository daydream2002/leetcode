import java.util.*;

public class No127 {
    public static void main(String[] args) {
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        int i = new Solution127().ladderLength("hit", "cog", wordList);
        System.out.println(i);
    }
}

class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        int length = 0;
        HashSet<String> hashSet = new HashSet<>(wordList);
        HashSet<String> set = new HashSet<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            for (int k = 0; k < size; k++) {
                String poll = queue.poll();
                if (poll.equals(endWord))
                    return length;
                for (int i = 0; i < poll.length(); i++) {
                    char[] charArray = poll.toCharArray();
                    for (int j = 0; j < 26; j++) {
                        charArray[i] = (char) ('a' + j);
                        String s = new String(charArray);
                        if (hashSet.contains(s) && !set.contains(s)) {
                            queue.add(s);
                            set.add(s);
                        }
                    }
                }
            }
        }
        return 0;
    }
}