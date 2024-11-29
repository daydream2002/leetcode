import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2024/11/26 21:39
 */
public class No332 {
    public static void main(String[] args) {
//        List<List<String>> tickets = new ArrayList<>();
//        tickets.add(Arrays.asList("JFK", "ATL"));
//        tickets.add(Arrays.asList("ORD", "PHL"));
//        tickets.add(Arrays.asList("JFK", "ORD"));
//        tickets.add(Arrays.asList("PHX", "LAX"));
//        tickets.add(Arrays.asList("LAX", "JFK"));
//        tickets.add(Arrays.asList("PHL", "ATL"));
//        tickets.add(Arrays.asList("ATL", "PHX"));

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("EZE", "AXA"));
        tickets.add(Arrays.asList("TIA", "ANU"));
        tickets.add(Arrays.asList("ANU", "JFK"));
        tickets.add(Arrays.asList("JFK", "ANU"));
        tickets.add(Arrays.asList("ANU", "EZE"));
        tickets.add(Arrays.asList("TIA", "ANU"));
        tickets.add(Arrays.asList("AXA", "TIA"));
        tickets.add(Arrays.asList("TIA", "JFK"));
        tickets.add(Arrays.asList("ANU", "TIA"));
        tickets.add(Arrays.asList("JFK", "TIA"));

//        tickets.add(Arrays.asList("LHR", "SFO"));


        List<String> itinerary = new Solution332Two().findItinerary(tickets);
        System.out.println();
        System.out.println(itinerary);
    }
}

class Solution332One {
    List<String> res;
    List<String> list = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        boolean[] used = new boolean[tickets.size()];
        Arrays.fill(used, false);
        tickets.sort((o1, o2) -> o2.get(1).compareTo(o1.get(1)));
        list.add("JFK");
        dfs(tickets, used);
        return res;
    }

    boolean dfs(List<List<String>> tickets, boolean[] used) {
        if (tickets.size() + 1 == list.size()) {
            res = new ArrayList<>(list);
            return true;
        }
        //此处时间消耗太大，会导致超时
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).get(0).equals(list.getLast()) && !used[i]) {
                list.add(tickets.get(i).get(1));
                used[i] = true;
                if (dfs(tickets, used))
                    return true;
                used[i] = false;
                list.removeLast();
            }
        }
        return false;
    }
}

class Solution332Two {
    Map<String, Map<String, Integer>> map = new HashMap<>();
    List<String> res;
    List<String> list = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            if (map.containsKey(ticket.get(0))) {
                map.get(ticket.get(0)).put(ticket.get(1), map.get(ticket.get(0)).getOrDefault(ticket.get(1), 0) + 1);
            } else {
                Map<String, Integer> temp = new TreeMap<>();
                temp.put(ticket.get(1), 1);
                map.put(ticket.get(0), temp);
            }
        }
        list.add("JFK");
        dfs(tickets.size() + 1);
        return res;
    }

    boolean dfs(int size) {
        if (list.size() == size) {
            res = new ArrayList<>(list);
            return true;
        }
        if (map.containsKey(list.getLast())) {
            for (Map.Entry<String, Integer> entry : map.get(list.getLast()).entrySet()) {
                if (entry.getValue() > 0) {
                    list.add(entry.getKey());
                    entry.setValue(entry.getValue() - 1);
                    if (dfs(size))
                        return true;
                    entry.setValue(entry.getValue() + 1);
                    list.removeLast();
                }
            }
        }
        return false;
    }
}