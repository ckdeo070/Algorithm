import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String c : completion) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (String p : participant) {
            if (!map.containsKey(p)) {
                answer = p;
                break;
            }
            if (map.get(p) > 0) {
                map.put(p, map.get(p) - 1);
            } else {
                answer = p;
                break;
            }
        }
        
        return answer;
    }
}