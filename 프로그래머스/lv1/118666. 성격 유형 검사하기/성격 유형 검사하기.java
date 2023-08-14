import java.util.HashMap;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
        
        for(int i = 0; i < survey.length; i++) {
        	String t = "";
        	int score = choices[i];
        	if(score < 4) {
        		t = survey[i].substring(0, 1);
        		map.replace(t, map.get(t)+Math.abs(score - 4));
        	}
        	else if(score > 4) {
        		t = survey[i].substring(1, 2);
        		map.replace(t, map.get(t)+Math.abs(score - 4));
        	}
        }
        
        if(map.get("R") >= map.get("T")) {
        	answer += "R";
        }
        else {
        	answer += "T";
        }
        if(map.get("C") >= map.get("F")) {
        	answer += "C";
        }
        else {
        	answer += "F";
        }
        if(map.get("J") >= map.get("M")) {
        	answer += "J";
        }
        else {
        	answer += "M";
        }
        if(map.get("A") >= map.get("N")) {
        	answer += "A";
        }
        else {
        	answer += "N";
        }
        
        return answer;
    }
}