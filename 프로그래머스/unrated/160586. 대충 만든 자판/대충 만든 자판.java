class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int l = targets.length;
        int[] answer = new int[l];
        int[] alpha = new int[26];
        for(int i = 0; i < keymap.length; i++) {
        	for(int j = 0; j < keymap[i].length(); j++) {
        		int index = keymap[i].charAt(j) - 65;
        		if(alpha[index] == 0) {
        			alpha[index] = j+1;
        		}
        		else {
        			if(alpha[index] > j+1) {
        				alpha[index] = j+1;
        			}
        		}
        	}
        }
        
        for(int i = 0; i < l; i++) {
        	int sum = 0;
        	for(int j = 0; j < targets[i].length(); j++) {
        		int index = targets[i].charAt(j)-65;
        		if(alpha[index] == 0) {
        			sum = -1;
        			break;
        		}
        		else {
        			sum += alpha[index];
        		}
        	}
        	answer[i] = sum;
        }
        
        return answer;
    }
}