public class No657 {
}

class Solution657 {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'R')
                x++;
            if (c == 'L')
                x--;
            if (c == 'U')
                y++;
            if (c == 'D')
                y--;
        }
        return x == 0 && y == 0;
    }
}