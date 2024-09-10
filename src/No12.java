import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author daydream
 * Description
 * Date 2024/9/10 20:27
 */
public class No12 {
    public static void main(String[] args) {
        String s = new Solution12_2().intToRoman(3749);
        System.out.println(s);
    }
}

//暴力解
class Solution12 {
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        int[] ints = new int[4];
        for (int i = 0; i < 4; i++) {
            ints[3 - i] = num % 10;
            num = num / 10;
        }
        res.append("M".repeat(Math.max(0, ints[0])));
        if (ints[1] == 4)
            res.append("CD");
        else if (ints[1] == 9)
            res.append("CM");
        else if (ints[1] < 4) {
            res.append("C".repeat(Math.max(0, ints[1])));
        } else {
            res.append("D");
            res.append("C".repeat(ints[1] - 5));
        }

        if (ints[2] == 4)
            res.append("XL");
        else if (ints[2] == 9)
            res.append("XC");
        else if (ints[2] < 4) {
            res.append("X".repeat(ints[1]));
        } else {
            res.append("L");
            res.append("X".repeat(ints[2] - 5));
        }

        if (ints[3] == 4)
            res.append("IV");
        else if (ints[3] == 9)
            res.append("IX");
        else if (ints[3] < 4) {
            res.append("I".repeat(Math.max(0, ints[3])));
        } else {
            res.append("V");
            res.append("I".repeat(ints[3] - 5));
        }
        System.out.println(Arrays.toString(ints));
        return res.toString();
    }
}

//贪心算法
class Solution12_2 {
    public String intToRoman(int num) {
        String[] symbol = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] value = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            for (int i = value.length - 1; i >= 0; i--) {
                if (num - value[i] >= 0) {
                    num = num - value[i];
                    stringBuilder.append(symbol[i]);
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }
}