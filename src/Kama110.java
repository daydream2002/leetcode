import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2025/1/16 16:45
 */
public class Kama110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String beginStr = sc.next();
        String endStr = sc.next();
        ArrayList<String> strList = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            strList.add(sc.next());
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginStr);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                String curStr = queue.poll();
                if (isValid(curStr, endStr)) {
                    System.out.println(res + 1);
                    return;
                }
                for (String str : strList) {
                    if (!visited.contains(str) && isValid(curStr, str)) {
                        queue.add(str);
                        visited.add(str);
                    }
                }
            }
        }
        System.out.println(0);
    }

    static boolean isValid(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
