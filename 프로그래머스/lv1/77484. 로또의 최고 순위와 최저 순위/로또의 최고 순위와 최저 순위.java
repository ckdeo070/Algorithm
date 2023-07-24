import java.util.HashSet;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0, same = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : win_nums) {
        	set.add(num);
        }
        for(int num : lottos) {
        	if(set.contains(num)) {
        		same++;
        	}
        	if(num == 0) {
        		zero++;
        	}
        }
        int total = same + zero;
        if(total <= 1) {
        	answer[0] = 6;
        }
        else {
        	answer[0] = 7 - total;
        }
        if(same <= 1) {
        	answer[1] = 6;
        }
        else {
        	answer[1] = 7 - same;
        }
        
        return answer;
    }
}