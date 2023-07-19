class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int c1 = 0, c2 = 0;
        for(int i = 0; i < goal.length; i++) {
        	int cnt = 0;
        	if(c1 < cards1.length && cards1[c1].equals(goal[i])) {
        		c1++;
        		cnt++;
        	}
        	else if(c2 < cards2.length && cards2[c2].equals(goal[i])) {
        		c2++;
        		cnt++;
        	}
        	if(cnt == 0) {
        		return "No";
        	}
        }
        
        return "Yes";
    }
}