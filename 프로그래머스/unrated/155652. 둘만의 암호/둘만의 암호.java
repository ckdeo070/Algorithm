class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        int[] alpha = new int[26];
        for(int i = 0; i < skip.length(); i++) {
        	alpha[skip.charAt(i)-97]++;
        }
        for(int i = 0; i < s.length(); i++) {
        	int cnt = 0;
        	int start = s.charAt(i) - 97;
        	while(cnt != index) {
        		if(start == 25) {
        			start = -1;
        		}
        		if(alpha[start + 1] == 0) {
        			cnt++;
        			start++;
        		}
        		else {
        			start++;
        		}
        	}
        	answer += (char)(start+97);
        }
        return answer;
    }
}