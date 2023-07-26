import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
		for(String p : completion) {
        	map.put(p, map.getOrDefault(p, 0)+1);
        }
		for(String p : participant) {
			if(map.get(p) == null || map.get(p) == 0) {
				return p;
			}
			map.put(p, map.get(p)-1);
		}
        return "";
    }
}