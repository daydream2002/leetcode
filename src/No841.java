import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class No841 {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1),
                        Arrays.asList(2),
                        Arrays.asList(3),
                        Arrays.asList()
                )
        );
        boolean b = new Solution841().canVisitAllRooms(rooms);
        System.out.println(b);
    }
}

class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> set = new HashSet<>();
        dfs(rooms, 0, set);
        return set.size() == rooms.size();
    }

    void dfs(List<List<Integer>> rooms, int key, HashSet<Integer> set) {
        if (set.contains(key))
            return;
        set.add(key);
        for (Integer keys : rooms.get(key)) {
            dfs(rooms, keys, set);
        }
    }
}