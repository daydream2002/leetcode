import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2025/2/23 16:43
 */
public class No649 {
    public static void main(String[] args) {
        new Solution649().predictPartyVictory("RRDDD");
    }
}

class Solution649 {
    public String predictPartyVictory(String senate) {
        boolean R = true, D = true;
        int flag = 0;// 前面D多>0
        char[] senateArr = senate.toCharArray();
        while (R && D) {
            R = false;
            D = false;
            for (int i = 0; i < senateArr.length; i++) {
                if (senateArr[i] == 'R') {
                    if (flag > 0)
                        senateArr[i] = ' ';
                    else
                        R = true;
                    flag--;
                }
                if (senateArr[i] == 'D') {
                    if (flag < 0)
                        senateArr[i] = ' ';
                    else
                        D = true;
                    flag++;
                }
            }
            System.out.println(senateArr);
        }
        return R ? "Radiant" : "Dire";
    }
}