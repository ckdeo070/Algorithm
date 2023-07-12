class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for(int i = 0; i <= t.length()-p.length(); i++) {
        	if(compare(t.substring(i, i+p.length()), p)) {
        		answer++;
        	}
        }
        
        return answer;
    }
	
	public boolean compare(String num1, String num2) {
		for(int i = 0; i < num1.length(); i++) {
			if(num1.charAt(i) > num2.charAt(i)) {
				return false;
			}
			else if (num1.charAt(i) < num2.charAt(i)){
				return true;
			}
		}
		return true;
	}
}