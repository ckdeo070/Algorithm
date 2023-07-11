import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = s.length()-1; i >= 0; i--) {
        	stack.push(s.charAt(i));
        }
        int left = 0;
        int right = 0;
        while(!stack.isEmpty()) {
        	char c = stack.pop();
        	if(c == ')') {
        		left++;
        	}
        	else {
        		right++;
        	}
        	if(right-left < 0) {
        		return false;
        	}
        }
        if(right-left != 0) {
    		return false;
    	}
        return true;
    }
}