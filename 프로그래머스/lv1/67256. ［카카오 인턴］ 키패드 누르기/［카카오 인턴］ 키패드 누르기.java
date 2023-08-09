class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int l_x = 0, l_y = 3, r_x = 2, r_y = 3;
        int x, y;
        for(int i = 0; i < numbers.length; i++) {
        	int num = numbers[i];
        	String S = "";
        	y = (num-1) / 3;
        	x = num - (3 * y) - 1;
        	if(num == 1 || num == 4 || num == 7) {
        		S = "L";
        	}
        	else if(num == 3 || num == 6 || num == 9) {
        		S = "R";
        	}
        	else if(num == 2 || num == 5 || num == 8 || num == 0) {
        		if(num == 0) {
        			y = 3;
        			x = 1;
        		}
        		if(distance(x, y, l_x, l_y) < distance(x, y, r_x, r_y)) {
        			S = "L";
        		}
        		else if(distance(x, y, l_x, l_y) > distance(x, y, r_x, r_y)) {
        			S = "R";
        		}
        		else {
        			if(hand.equals("right")) {
        				S = "R";
        			}
        			else {
        				S = "L";
        			}
        		}
        	}
        	if(S.equals("R")) {
        		r_x = x;
    			r_y = y;
        	}
        	else {
        		l_x = x;
    			l_y = y;
        	}
        	answer += S;
        }
       
        
        
        return answer;
    }
	
	public static int distance(int x, int y, int t_x, int t_y) {
		return Math.abs(x - t_x) + Math.abs(y - t_y);
	}
}