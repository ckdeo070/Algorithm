class Solution {
    public int solution(int[] ingredient) {
        int answer = 0, idx = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ingredient.length; i++) {
        	sb.append(ingredient[i]);
        }
        
        while(idx < sb.length()-3) {
        	if(sb.substring(idx, idx+4).equals("1231")) {
        		answer++;
        		sb.replace(idx, idx+4, "");
        		if(idx < 3) {
        			idx = 0;
        		}
        		else {
        			idx -= 3;
        		}
        	}
            else {
        		idx++;
        	}
        }
        
        return answer;
    }
}