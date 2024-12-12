/**
 * Author daydream
 * Description
 * Date 2024/12/12 20:52
 */
public class No509 {
}
class Solution509 {
    public int fib(int n) {
        if (n<2)
            return n;
        int[] arr = new int[n + 1];
        arr[0]=0;
        arr[1]=1;
        for (int i = 2; i < n; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}