import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int j = 0; j < moves.length; j++) {
        	int num = moves[j];
	        for(int i = 0; i < board.length; i++) {
	        	int doll = board[i][num-1];
	        	board[i][num-1] = 0;
	        	if(doll != 0) {
	        		if(!stack.isEmpty()) {
	        			if(stack.peek() == doll) {
	        				stack.pop();
	        				answer += 2;
	        			}
	        			else {
	        				stack.push(doll);
	        			}
	        		}
	        		else {
	        			stack.push(doll);
	        		}
        			break;
	        	}
	        }
        }
        return answer;
    }
}