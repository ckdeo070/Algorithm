class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int start = section[0]+m;
        for(int i = 1; i < section.length; i++) {
        	if(start <= section[i]) {
        		start = section[i] + m;
        		answer++;
        	}
        }
        return answer;
    }
}