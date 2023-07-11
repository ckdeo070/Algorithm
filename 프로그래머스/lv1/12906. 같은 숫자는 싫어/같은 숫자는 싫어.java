import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();
        int temp = -1;
        for(int i = 0; i < arr.length; i++) {
        	int num = arr[i];
        	if(temp == num) {
        		continue;
        	}
        	else {
        		queue.add(num);
        		temp = num;
        	}
        }
        int size = queue.size();
        int[] answer = new int[size];
        for(int i = 0; i < size; i++) {
        	answer[i] = queue.poll();
        }
        
        return answer;
    }
}