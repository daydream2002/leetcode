import java.util.ArrayList;

/**
 * @author wjh
 * @date 2024/9/12 11:25
 */
public class No6 {
    public static void main(String[] args) {
        String convert = new Solution6_2().convert("AB", 1);
        System.out.println(convert);
    }
}

class Solution6 {
    public String convert(String s, int numRows) {
        char[] charArray = s.toCharArray();
        StringBuilder res = new StringBuilder();
        ArrayList<ArrayList<Character>> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }
        int index = 0;
        while (index < charArray.length) {
            for (int i = 0; i < numRows; i++) {
                if (index < charArray.length)
                    list.get(i).add(charArray[index++]);
            }
            for (int j = numRows - 2; j > 0; j--) {
                if (index < charArray.length)
                    list.get(j).add(charArray[index++]);
            }
        }
        for (ArrayList<Character> characters : list) {
            for (Character character : characters) {
                res.append(character);
            }
        }
        return res.toString();
    }
}

class Solution6_2 {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        char[] charArray = s.toCharArray();
        StringBuilder res = new StringBuilder();
        ArrayList<ArrayList<Character>> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }
        int index = 0, flag = 1, row = 0;
        while (index < charArray.length) {
            list.get(row).add(charArray[index++]);
            row = row + flag;
            if (row == 0 || row == numRows - 1)
                flag = -flag;
        }
        for (ArrayList<Character> characters : list) {
            for (Character character : characters) {
                res.append(character);
            }
        }
        return res.toString();
    }
}