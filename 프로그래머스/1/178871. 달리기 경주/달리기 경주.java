import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<Integer, String> rank = new HashMap<>();
        HashMap<String, Integer> position = new HashMap<>();
        int len = players.length;
        for (int i = 0; i < len; i++) {
            rank.put(i, players[i]);
            position.put(players[i], i);
        }
        
        for (String call : callings) {
            int cur = position.get(call);
            int next = cur - 1;
            String nextPlayer = rank.get(next);
            String curPlayer = rank.get(cur);
            
            rank.put(next, curPlayer);
            rank.put(cur, nextPlayer);
            position.put(curPlayer, next);
            position.put(nextPlayer, cur);
        }
        
        String[] result = new String[len];
        for (int i = 0; i < len; i++) {
            result[i] = rank.get(i);
        }
        
        return result;
    }
}