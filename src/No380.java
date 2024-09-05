import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * Author daydream
 * Description
 * Date 2024/9/5 10:50
 */
public class No380 {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.remove(0); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        randomizedSet.remove(0); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        randomizedSet.insert(0); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        randomizedSet.remove(0); // 2 已在集合中，所以返回 false 。
        randomizedSet.insert(0); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。

        randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
    }
}

class RandomizedSet {
    HashMap<Integer, Integer> hashMap;
    ArrayList<Integer> list;

    public RandomizedSet() {
        hashMap = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }

    public boolean insert(int val) {
        if (hashMap.containsKey(val))
            return false;
        list.add(val);
        hashMap.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!hashMap.containsKey(val))
            return false;
        Integer integerIndex = hashMap.get(val);
        hashMap.put(list.getLast(), integerIndex);
        list.set(integerIndex, list.getLast());
        list.removeLast();
        hashMap.remove(val);
        return true;
    }

    public int getRandom() {
        int size = list.size();
        Random random = new Random();
        int i = random.nextInt(size);
        return list.get(i);
    }
}