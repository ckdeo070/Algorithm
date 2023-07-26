class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
		int answer = 0, idx = 0, cnt1 = 0, cnt2 = 0;
        char f = ' ';
        
        while(idx != sb.length()) {
        	if(idx == 0) {
        		f = sb.charAt(0);
        		cnt1++;
        		idx++;
        	}
        	else {
        		if(f == sb.charAt(idx)) {
        			cnt1++;
        		}
        		else {
        			cnt2++;
        		}
        		idx++;
        		if(cnt1 == cnt2) {
        			sb.replace(0, idx, "");
        			idx = 0;
        			answer++;
        		}
        	}
        }
        if(sb.length() > 0) {
        	answer++;
        }
        return answer;
    }
}