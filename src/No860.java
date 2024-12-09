import java.util.HashMap;

/**
 * Author daydream
 * Description
 * Date 2024/12/9 10:38
 */
public class No860 {
    public static void main(String[] args) {
        boolean b = new Solution860().lemonadeChange(new int[]{5, 5, 5, 5, 20, 20, 5, 5, 5, 5});
    }
}

class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0,twenty=20;
        for (int bill : bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                ten++;
                five--;
            } else {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five-=3;
                }
            }
            if (five < 0)
                return false;
        }
        return true;
    }
}