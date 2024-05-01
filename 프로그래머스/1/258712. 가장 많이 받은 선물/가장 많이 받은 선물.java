import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        for (String friend : friends) {
            map.put(friend, index);
            index++;
        }
        
        int len = friends.length;
        int[][] giftRecord = new int [len][len];
        
        for (String s : gifts) {
            String[] g = s.split(" ");
            int row = map.get(g[0]);
            int col = map.get(g[1]);
            giftRecord[row][col]++;
        }
        
        int[] giftIndex = new int[len];
        for (int i = 0; i < len; i++) {
            int send = 0;
            int recv = 0;
            for (int j = 0; j < len; j++) {
                send += giftRecord[i][j];
                recv += giftRecord[j][i];
            }
            giftIndex[i] = send - recv;
        }
        
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(giftRecord[i][j] > giftRecord[j][i]) {
                    result[i]++;
                } else if (giftRecord[i][j] == giftRecord[j][i]) {
                    if (giftIndex[i] > giftIndex[j]) {
                        result[i]++;
                    }
                }
            }
        }
        
        for (int num : result) {
            if (answer < num) {
                answer = num;
            }
        }
        
        return answer;
    }
}