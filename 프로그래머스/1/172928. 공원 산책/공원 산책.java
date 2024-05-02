import java.util.*;

class Solution {
    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int h = park.length;
        int w = park[0].length();
        int curX = 0, curY = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    curX = i;
                    curY = j;
                }
            }
        }
        
        for (String route : routes) {
            char op = route.charAt(0);
            int n = Integer.parseInt(route.substring(2));
            boolean isPosible = true;
            if (op == 'N') {
                for (int i = 1; i <= n; i++) {
                    if (curX - i < 0 || park[curX - i].charAt(curY) == 'X') {
                        isPosible = false;
                        break;
                    }
                }
                if (isPosible) {
                    curX -= n;
                }
            }
            if (op == 'S') {
                for (int i = 1; i <= n; i++) {
                    if (curX + i >= h || park[curX + i].charAt(curY) == 'X') {
                        isPosible = false;
                        break;
                    }
                }
                if (isPosible) {
                    curX += n;
                }
            }
            if (op == 'W') {
                for (int i = 1; i <= n; i++) {
                    if (curY - i < 0 || park[curX].charAt(curY - i) == 'X') {
                        isPosible = false;
                        break;
                    }
                }
                if (isPosible) {
                    curY -= n;
                }
            }
            if (op == 'E') {
                for (int i = 1; i <= n; i++) {
                    if (curY + i >= w || park[curX].charAt(curY + i) == 'X') {
                        isPosible = false;
                        break;
                    }
                }
                if (isPosible) {
                    curY += n;
                }
            }
        }
        
        answer[0] = curX;
        answer[1] = curY;
        return answer;
    }
}