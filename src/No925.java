public class No925 {
    public static void main(String[] args) {
        Solution925 solution = new Solution925();
        String name = "kikcxmvzi";
        String typed = "kiikcxxmmvvzz";
        System.out.println(solution.isLongPressedName(name, typed));
    }
}

class Solution925 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        if (name.charAt(0) != typed.charAt(0)) {
            return false;
        }
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else {
                while (j < typed.length() - 1 && typed.charAt(j) == typed.charAt(j - 1)) {
                    j++;
                }
                if (name.charAt(i) != typed.charAt(j)) {
                    return false;
                }
            }
        }
        while (j < typed.length() && typed.charAt(j) == typed.charAt(j - 1)) {
            j++;
        }
        return i == name.length() && j == typed.length();
    }
}