import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author daydream
 * @Description
 * @Date 2024/8/2
 */
public class No295 {
    public static void main(String[] args) {
        MedianFinder2 medianFinder = new MedianFinder2();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
    }
}

class MedianFinder1 {
    List<Integer> list;

    public MedianFinder1() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        int j = list.size() - 1, i = 0;
        while (i <= j) {
            int k = (i + j) / 2;
            if (list.get(k) > num)
                j = k - 1;
            else
                i = k + 1;

        }
        list.add(i, num);
        System.out.println(list);
    }

    public double findMedian() {
        int size = list.size();
        double ans;
        if (size % 2 == 0) {
            ans = (list.get(size / 2) + list.get(size / 2 - 1)) / 2.0;
        } else {
            ans = list.get(size / 2) + 0.0;
        }
        return ans;
    }
}

class MedianFinder2 {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder2() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if (minHeap.size() == maxHeap.size()) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return minHeap.peek();
        }
    }
}