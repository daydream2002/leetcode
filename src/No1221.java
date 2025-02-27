public class No1221 {
    public static void main(String[] args) {
        int i = new Solution1221().balancedStringSplit("RLRRRLLRLL");
        System.out.println(i);
    }
}

class Solution1221 {
    public int balancedStringSplit(String s) {
        int l = 0, r = 0, res = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'R')
                l++;
            else
                r++;
            if (l == r)
                res++;
        }
        return res;
    }
}