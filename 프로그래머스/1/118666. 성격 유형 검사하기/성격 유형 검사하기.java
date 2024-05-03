import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String[][] type = new String[][] {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};
        HashMap<String, Integer> map = new HashMap<>();
        for (String [] subType : type) {
            map.put(subType[0], 0);
            map.put(subType[1], 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            int score = choices[i] - 4;
            String f = survey[i].substring(0, 1);
            String s = survey[i].substring(1, 2);
            if (score < 0) {
                map.put(f, map.get(f) - score);
            }
            if (score > 0) {
                map.put(s, map.get(s) + score);
            }
        }
        
        String answer = "";
        for (String[] t : type) {
            if (map.get(t[0]) >= map.get(t[1])) {
                answer += t[0];
            } else {
                answer += t[1];
            }
        }
        
        return answer;
    }
}